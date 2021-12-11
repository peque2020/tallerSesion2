package activities.contactManagerClean;

import controlAppium.Button;
import controlAppium.TextBox;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class CreateContactScreen {

    public Map<String,Button> buttonMap= new HashMap<>();
    public Map<String,TextBox> textBoxMap= new HashMap<>();

    public CreateContactScreen(){

        buttonMap.put("save",new Button(By.id("com.example.android.contactmanager:id/contactSaveButton")));
        textBoxMap.put("nameContact",new TextBox(By.id("com.example.android.contactmanager:id/contactNameEditText")));
        textBoxMap.put("phoneContact",new TextBox(By.id("com.example.android.contactmanager:id/contactPhoneEditText")));
        textBoxMap.put("emailContact",new TextBox(By.id("com.example.android.contactmanager:id/contactEmailEditText")));
    }
}
