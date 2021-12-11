package activities.contactManager;

import controlAppium.Button;
import controlAppium.TextBox;
import org.openqa.selenium.By;

public class CreateContactScreen {

    public TextBox nameTextBox = new TextBox(By.id("com.example.android.contactmanager:id/contactNameEditText"));
    public TextBox phoneTextBox= new TextBox(By.id("com.example.android.contactmanager:id/contactPhoneEditText"));
    public TextBox emailTextBox = new TextBox(By.id("com.example.android.contactmanager:id/contactEmailEditText"));
    public Button saveButton = new Button(By.id("com.example.android.contactmanager:id/contactSaveButton"));

    public CreateContactScreen(){}

}
