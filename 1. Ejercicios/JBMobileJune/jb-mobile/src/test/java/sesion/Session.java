package sesion;

import devices.FactoryDevices;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class Session {

    // Singleton 1) tener un atributo del mismo tipo de la clase
    private static Session instance=null;
    private AppiumDriver driver;

    // 2) tener el constructor privado
    private Session() throws MalformedURLException {
        driver= FactoryDevices.make(FactoryDevices.DevicesType.ANDROID).create();
        // CAMPO PARA CAMBIAR EN CASO DESEE ANDROID O CLOUD

    }

    // 3) tener un metodo publico para recuperar la instancia unica
    public static Session getInstance() throws MalformedURLException {
        if(instance==null){
            instance= new Session();
        }
        return instance;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void closeSession(){
        driver.quit();
        instance=null;
    }
}
