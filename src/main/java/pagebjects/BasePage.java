package pagebjects;

import org.openqa.selenium.WebDriver;
import steps.BaseSteps;

public class BasePage extends BaseSteps {

    protected WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
    }
}
