package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyStepCalc {

    private AppiumDriver driver;
    @Given("tengo abierta la calculadora")
    public void tengoAbiertaLaCalculadora() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Eli");
        capabilities.setCapability("platformVersion","9");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @When("presiono el boton {int}")
    public void presionoElBoton(int botonNumerico) {
        switch (botonNumerico) {
            case 9:
                driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();
                break;
            case 5:
                driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();
                break;
        }
    }

    @And("presiono el boton {string}")
    public void presionoElBoton(String botonOperacion) {
        switch (botonOperacion) {
            case "suma":
                driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
                break;
            case "igual":
                driver.findElement(By.id("com.android.calculator2:id/eq")).click();
                break;
        }
    }

    @Then("el resultado deberia ser {int}")
    public void elResultadoDeberiaSer(int expectedResult) throws InterruptedException {
        Thread.sleep(2000);
        // Get resultado y comparar
        String actualResult=  driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
        Assert.assertEquals("ERROR!! la suma es incorrecta",String.valueOf(expectedResult),actualResult);
    }
}
