package devices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Android implements IDevice{
    @Override
    public AppiumDriver create() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Eli");
        capabilities.setCapability("platformVersion","9");
//        capabilities.setCapability("appPackage","com.android.calculator2");
//        capabilities.setCapability("appActivity",".Calculator");
        capabilities.setCapability("appPackage","com.example.android.contactmanager");
        capabilities.setCapability("appActivity",".ContactManager");
        capabilities.setCapability("platformName","Android");

        AppiumDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }
}
