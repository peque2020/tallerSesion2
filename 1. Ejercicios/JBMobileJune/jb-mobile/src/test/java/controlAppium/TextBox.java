package controlAppium;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TextBox  extends ControlAppium{

    public TextBox (By locator){
        super(locator);
    }

    public void setValue(String value) throws MalformedURLException {
        this.findControl();
        this.controlAppium.sendKeys(value);
    }
}
