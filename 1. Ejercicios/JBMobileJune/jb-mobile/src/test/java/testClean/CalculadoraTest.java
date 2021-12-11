package testClean;

import activities.calculadora.MainScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import sesion.Session;

import java.net.MalformedURLException;

public class CalculadoraTest {

    MainScreen mainScreen=new MainScreen();

    @Test
    public void suma() throws MalformedURLException {
        mainScreen.fiveButton.click();
        mainScreen.plusButton.click();
        mainScreen.nineButton.click();
        mainScreen.equalButton.click();
        mainScreen.resultLabel.click();

        Assert.assertEquals("ERROR! la suma es incorrecta",
                "14",
                mainScreen.resultLabel.getText());
    }

    @After
    public void after() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
