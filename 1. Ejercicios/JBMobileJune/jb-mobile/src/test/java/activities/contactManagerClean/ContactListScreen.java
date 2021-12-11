package activities.contactManagerClean;

import controlAppium.Button;
import controlAppium.Label;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class ContactListScreen {

    public Map<String,Button> buttonMap= new HashMap<>();
    public ContactListScreen(){
        buttonMap.put("addContact",new Button(By.id("com.example.android.contactmanager:id/addContactButton")));
    }

    public boolean isDisplayedContact(String nameContact){
        Label contact = new Label(By.xpath("//android.widget.TextView[@text='"+nameContact+"']"));
        return contact.isControlDisplayed();
    }
}
