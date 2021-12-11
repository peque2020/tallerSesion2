package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MyStepContact {

    private AppiumDriver driver;

    @Given("que tengo la aplicacion ContactManager")
    public void queTengoLaAplicacionContactManager() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Eli");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        capabilities.setCapability("platformName", "Android");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @And("hago click en boton OK si existe el update dialog")
    public void hagoClickEnBotonOKSiExisteElUpdateDialog() {
        //click ok button-dialog
        // si existe el dialog
        if (driver.findElements(By.id("android:id/button1")).size() == 1)
            driver.findElement(By.id("android:id/button1")).click();
    }

    @When("hago click en el boton {string}")
    public void hagoClickEnElBoton(String nameButton) {
        if (nameButton.equals("addContact")) {
            driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        } else {
            //click Save button
            driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
        }
    }

    @And("seteo las cajas de texto con:")
    public void seteoLasCajasDeTextoCon(Map<String, String> datos) {
        for ( String nombreControl: datos.keySet()) {
            if (nombreControl.equals("nameContact")){
                driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys(datos.get(nombreControl));
            }else if(nombreControl.equals("numberContact")) {
                driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys(datos.get(nombreControl));
            }else{
                driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys(datos.get(nombreControl));
            }
        }

    }

    @Then("el contacto {string} deberia ser creado")
    public void elContactoDeberiaSerCreado(String expectedContactName) throws InterruptedException {
        Thread.sleep(2000);

        //enfocado a un control especifico
        WebDriverWait explicitWait= new WebDriverWait(driver,10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='"+expectedContactName+"']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='"+expectedContactName+"']")));

        //verificar el contacto es mostrato en la primera pantalla
        Assert.assertTrue("ERROR! el contacto no fue creado",driver.findElement(By.xpath("//android.widget.TextView[@text='"+expectedContactName+"']")).isDisplayed());

    }

    @And("seteo la caja de texto {string} con {string}")
    public void seteoLaCajaDeTextoCon(String nameControl, String valor) {
        if (nameControl.equals("nameContact")){
            driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys(valor);
        }else if(nameControl.equals("numberContact")) {
            driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys(valor);
        }else{
            driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys(valor);
        }
    }

    @And("defino las cajas de texto con:")
    public void definoLasCajasDeTextoCon(List<Contact> contact) {
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys(contact.get(0).getNameContact());
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys(contact.get(0).getNumberContact());
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys(contact.get(0).getEmailContact());
    }

    @DataTableType()
    public Contact convert(Map<String ,String> entry){
        return new Contact(entry.get("nameContact"),entry.get("numberContact"),entry.get("emailContact"));
    }
}
