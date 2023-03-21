package steps;

import org.openqa.selenium.WebDriver;

public class NavigationSteps{

    WebDriver driver;

    public NavigationSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void switchToTab(String title) {
        driver.switchTo().window(title);
    }
    public String getTabHandle() {
        return driver.getWindowHandle();
    }

    public void closeTab() {
        driver.close();
    }

}
