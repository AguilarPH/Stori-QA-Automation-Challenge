package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationSteps extends BaseSteps{

    WebDriver driver;

    public NavigationSteps(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
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

    public void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToBottom(){
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void closeTab() {
        driver.close();
    }

}
