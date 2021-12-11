package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasic {

    private AppiumDriver driver;


    @Before
    public void setUpConnection() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","JBTest");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("platformName","Android");

        driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @Test
    public void verifyTheAditionInTheCalculator() throws InterruptedException {
        //----Pasos----
        //clic 9 button
        driver.findElement(By.id("com.android.calculator2:id/digit_9")).click();

        //clic + button
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();

        //clic 5 button
        driver.findElement(By.id("com.android.calculator2:id/digit_5")).click();

        //clic = button
        driver.findElement(By.id("com.android.calculator2:id/eq")).click();

        //----Verificaciones----
        Thread.sleep(2000);

        //Get resultado y comparar
        String expectedResult="14";
        String actualResult=  driver.findElement(By.id("com.android.calculator2:id/result")).getText();
        Assert.assertEquals("ERROR!! la suma es incorrecta",expectedResult,actualResult);
    }

    @After
    public void closeConnection() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

}
