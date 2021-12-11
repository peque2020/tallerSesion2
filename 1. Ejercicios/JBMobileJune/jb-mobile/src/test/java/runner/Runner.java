package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import sesion.Session;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
public class Runner {
    // HOOKS
    // acciones antes y despues de los scenarios

    @Before
    public void hookBeforeScenario2(){
        // abrir app
        System.out.println("HOOK BEFORE .............");
    }

    @After
    public void hookAfterScenario(Scenario scenario) throws MalformedURLException {
        // screenshot
        if (scenario.isFailed()){
            byte[] screen=Session.getInstance().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screen,"image/png","Movile Image ScreenShot");
        }

        System.out.println("HOOK AFTER .............");
        Session.getInstance().closeSession();
    }

}
