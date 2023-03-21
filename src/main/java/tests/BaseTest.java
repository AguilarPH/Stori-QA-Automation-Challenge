package tests;

import org.openqa.selenium.WebDriver;
import steps.BaseSteps;

public class BaseTest extends BaseSteps{
    public WebDriver driver;

    public BaseTest(){
        this.driver = getDriver();
    }

}
