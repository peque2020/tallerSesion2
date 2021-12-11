package activities.contactManager;

import controlAppium.Button;
import controlAppium.Label;
import org.openqa.selenium.By;

public class ContactListScreen {

    public Button addContactButton = new Button(By.id("com.example.android.contactmanager:id/addContactButton"));

    public ContactListScreen(){}

    public boolean isDisplayedContact(String nameContact){
        Label contact = new Label(By.xpath("//android.widget.TextView[@text='"+nameContact+"']"));
        return contact.isControlDisplayed();
    }
}
