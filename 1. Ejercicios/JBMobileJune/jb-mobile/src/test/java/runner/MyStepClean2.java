package runner;

import activities.contactManagerClean.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;

public class MyStepClean2 {
    UpdateDialog updateDialog= new UpdateDialog();
    ContactListScreen contactListScreen= new ContactListScreen();
    CreateContactScreen createContactScreen= new CreateContactScreen();

    @Given("have the contact manager app")
    public void haveTheContactManagerApp() {
    }

    @And("click on {string} button in update dialog if exist")
    public void clickOnButtonInUpdateDialogIfExist(String nameControl) throws MalformedURLException {
        if (updateDialog.buttonMap.get(nameControl).isControlDisplayed())
            updateDialog.buttonMap.get(nameControl).click();
    }

    @When("click on {string} button list contact")
    public void clickOnButtonListContact(String nameButton) throws MalformedURLException {
        contactListScreen.buttonMap.get(nameButton).click();
    }

    @And("set {string} in {string} textbox")
    public void setInTextbox(String value, String controlName) throws MalformedURLException {
        createContactScreen.textBoxMap.get(controlName).setValue(value);
    }

    @And("click on {string} button")
    public void clickOnButton(String controlName) throws MalformedURLException {
        createContactScreen.buttonMap.get(controlName).click();
    }

    @Then("contact {string} should be created")
    public void theContactShouldBeCreated(String expectedContactName) {
        Assert.assertTrue("ERROR, contacto no fue creado",
                contactListScreen.isDisplayedContact(expectedContactName));
    }
}