package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ContactManager {

    private AppiumDriver driver;


    @Before
    public void setUpConnection() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Eli");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.example.android.contactmanager");
        capabilities.setCapability("appActivity",".basicAppium.ContactManager");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCreateContact() throws InterruptedException {

        //clic ok button-dialog
        //si existe el dialog
        if (driver.findElements(By.id("android:id/button1")).size()==1)
            driver.findElement(By.id("android:id/button1")).click();

        // Clic addContact button
        // Action + Donde Action Elemento + DOnde el elemento
        // Clic on Login Button in Login modal (Ejemplo)
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();

        //set ContactName
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("AAAREMOVEJB");

        //set ContactPhone
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("777777");

        //set contactEmail
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("eeecccggg@gmail.com");

        //Clic Save button
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();

        // evitar el uso de tiempo quemados - Thread.sleep
        Thread.sleep(2000);

        //enfocado a un control especifico
        WebDriverWait explicitWait= new WebDriverWait(driver,10);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='AAAREMOVEJB']")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='AAAREMOVEJB']")));

        //verificar el contacto es mostrato en la primera pantalla
        Assert.assertTrue("ERROR! el contacto no fue creado",driver.findElement(By.xpath("//android.widget.TextView[@text='AAAREMOVEJB']")).isDisplayed());

        //Evento Swipe
        TouchAction action = new TouchAction(driver);

        WebElement initialControl = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"false\"])[13]"));
        WebElement finalControl = driver.findElement(By.xpath("(//android.widget.TextView[@content-desc=\"false\"])[1]"));

        int initialControlX = initialControl.getLocation().getX();
        int initialControlY = initialControl.getLocation().getY();

        int finalControlX = finalControl.getLocation().getX();
        int finalControlY = finalControl.getLocation().getY();

        action.press(PointOption.point(initialControlX, initialControlY)).
                waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).
                moveTo(PointOption.point(finalControlX, finalControlY)).
                release().perform();

    }

    @After
    public void closeConnection() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

}
