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

public class AppiumBasicXpath {

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
        //  --- pasos ---
        //click 9 button
        driver.findElement(By.xpath("//android.widget.Button[@text='9']")).click();
        //click + button
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']")).click();
        // click 5 button
        driver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
        // click = button
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']")).click();
        // --- verificaciones ---
        Thread.sleep(2000);
        // Get resultado y comparar
        String expectedResult="14";
        String actualResult=  driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']")).getText();
        Assert.assertEquals("ERROR!! la suma es incorrecta",expectedResult,actualResult);

    }

    @After
    public void closeConnection() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

}
