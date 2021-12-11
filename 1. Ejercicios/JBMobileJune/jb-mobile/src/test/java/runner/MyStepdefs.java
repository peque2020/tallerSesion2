package runner;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class MyStepdefs {

    /*
    * {int} --> admite cualquier valor numerico
    * {string} --> admite cualquier cadena entre comillas "hola que tal"
    * {}  --> admite cualquier valor
    * {float} --> admite valores float 5.2
    * {word} --> admite una sola palabra
    */

    @Given("tengo un usuario en facebook")
    public void tengoUnUsuarioEnFacebook() {
        
    }

    @When("llenar la caja de texto email con mi celular {int}")
    public void llenarLaCajaDeTextoEmailConMiCelular(int numeroCelular) {
        System.out.println("llenar la caja de texto email con mi celular: " + numeroCelular);
    }

    @And("llenar la caja de texto password con {}")
    public void llenarLaCajaDeTextoPasswordConPSswRd(String password) {
        System.out.println("llenar la caja de texto password con: " + password);
    }

    @Then("yo deberia de ingresar a la aplicacion")
    public void yoDeberiaDeIngresarALaAplicacion() {
        System.out.println("yo deberia de ingresar a la aplicacion");
    }

    @Then("yo no deberia de ingresar con pwd incorrecto")
    public void yoNoDeberiaDeIngresarConPwdIncorrecto() {
    }

    //*********************************************************

    @Given("que yo tengo una lista de usuarios")
    public void queYoTengoUnaListaDeUsuarios(List<String> usuarios) {
        for (String user: usuarios
             ) {
            System.out.println("USER : "+ user);

        }
    }

    @When("yo defino password en comun con el valor {string}")
    public void yoDefinoPasswordEnComunConElValor(String pwd) {
        System.out.println("PASSWORD : "+pwd);
    }

    @And("yo utilizo los campos de:")
    public void yoUtilizoLosCamposDe(List<Campos> campos) {
        for (Campos c : campos
        ) {
            System.out.println("c: "+c);
        }
    }

    @DataTableType()
    public Campos convert(Map<String ,String> entry){
        return new Campos(entry.get("user"),entry.get("pwd"));
    }

    @And("yo utilizo los valores:")
    public void yoUtilizoLosValores(Map<String ,String> entry) {
        System.out.println("*******");
        for (String key: entry.keySet()
        ) {
            System.out.println("campo: "+key+"  valor: "+entry.get(key));
        }

    }
}
