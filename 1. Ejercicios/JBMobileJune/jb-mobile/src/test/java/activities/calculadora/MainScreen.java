package activities.calculadora;

import controlAppium.Button;
import controlAppium.Label;
import org.openqa.selenium.By;

public class MainScreen {

    public Button plusButton= new Button(By.id("com.android.calculator2:id/op_add"));
    public Button equalButton= new Button(By.id("com.android.calculator2:id/eq"));
    public Button fiveButton= new Button(By.id("com.android.calculator2:id/digit_5"));
    public Button nineButton= new Button(By.id("com.android.calculator2:id/digit_9"));
    public Label resultLabel= new Label(By.id("com.android.calculator2:id/formula"));

    public MainScreen(){}
}
