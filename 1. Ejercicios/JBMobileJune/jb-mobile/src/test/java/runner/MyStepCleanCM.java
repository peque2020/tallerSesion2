package runner;

import activities.contactManager.ContactListScreen;
import activities.contactManager.CreateContactScreen;
import activities.contactManager.UpdateDialog;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.net.MalformedURLException;

public class MyStepCleanCM {
    UpdateDialog updateDialog= new UpdateDialog();
    ContactListScreen contactListScreen= new ContactListScreen();
    CreateContactScreen createContactScreen= new CreateContactScreen();

    @Given("I have the contact manager app")
    public void iHaveTheContactManagerApp() {
    }

    @And("I click on {string} button in update dialog if exist")
    public void iClickOnButtonInUpdateDialogIfExist(String nameButton) throws MalformedURLException {
        if (updateDialog.okButton.isControlDisplayed())
            updateDialog.okButton.click();

    }

    @When("I click on {string} button list contact")
    public void iClickOnButtonListContact(String nameButton) throws MalformedURLException {
        contactListScreen.addContactButton.click();
    }

    @And("I set {string} in {string} textbox")
    public void iSetInTextbox(String value, String nameControl) throws MalformedURLException {
        switch (nameControl){
            case "nameContact":
                createContactScreen.nameTextBox.setValue(value);
                break;
            case "emailContact":
                createContactScreen.emailTextBox.setValue(value);
                break;
            case "phoneContact":
                createContactScreen.phoneTextBox.setValue(value);
                break;
        }
    }

    @And("I click on {string} button")
    public void iClickOnButton(String nameButton) throws MalformedURLException {
        createContactScreen.saveButton.click();
    }

    @Then("the contact {string} should be created")
    public void theContactShouldBeCreated(String expectedContactName) {
        Assert.assertTrue("ERROR, contacto no fue creado",
                contactListScreen.isDisplayedContact(expectedContactName));
    }
}