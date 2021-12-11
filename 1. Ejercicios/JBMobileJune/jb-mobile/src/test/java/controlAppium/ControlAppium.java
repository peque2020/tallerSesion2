package controlAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sesion.Session;

import java.net.MalformedURLException;

public class ControlAppium {

    protected WebElement controlAppium;
    protected By locator;

    public ControlAppium(By locator){
        this.locator=locator;
    }

    protected void findControl() throws MalformedURLException {
        this.controlAppium= Session.getInstance().getDriver().findElement(this.locator);
        //explicit wait si quisieramos
    }

    public void click() throws MalformedURLException {
        this.findControl();;
        this.controlAppium.click();
    }

    public String getText() throws MalformedURLException {
        this.findControl();;
        return this.controlAppium.getText();
    }

    public boolean isControlDisplayed(){

        try {
            this.findControl();
            return this.controlAppium.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
