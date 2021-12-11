package testClean;

import activities.contactManager.ContactListScreen;
import activities.contactManager.CreateContactScreen;
import activities.contactManager.UpdateDialog;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import sesion.Session;

import java.net.MalformedURLException;

public class ContactManagerTest {

    UpdateDialog updateDialog= new UpdateDialog();
    ContactListScreen contactListScreen= new ContactListScreen();
    CreateContactScreen createContactScreen= new CreateContactScreen();
    @Test
    public void createContact() throws MalformedURLException {
        String contactName="AAARRREMOVE21";

        if (updateDialog.okButton.isControlDisplayed())
            updateDialog.okButton.click();

        contactListScreen.addContactButton.click();
        createContactScreen.nameTextBox.setValue(contactName);
        createContactScreen.emailTextBox.setValue("test@test.com");
        createContactScreen.phoneTextBox.setValue("777889898");
        createContactScreen.saveButton.click();

        Assert.assertTrue("ERROR, contacto no fue creado",
                contactListScreen.isDisplayedContact(contactName));
    }

    @After
    public void after() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
