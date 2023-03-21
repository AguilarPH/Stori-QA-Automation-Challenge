package steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class BaseSteps {
    WebDriver driver;

    Actions customActions;

    JavascriptExecutor js;

    public BaseSteps(String browser) {
        setDriver(browser);
        customActions = new Actions(this.driver);
        js = (JavascriptExecutor) this.driver;
    }

    public BaseSteps() {}

    public WebDriver getDriver() {
        return this.driver;

    }

    private void setDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                System.setProperty("webdriver.chrome.driver", "/Users/pa0822/Documents/My Learning/RahulShettyAcademy_AutomationPractice/chromedriver");
                this.driver = new ChromeDriver();
                System.out.println("Driver set to: Chrome");
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/pa0822/Documents/Java Training/IDE Project/Project1/geckodriver_");
                System.out.println("Driver set to: Firefox");
                driver = new FirefoxDriver();
                break;

            default:
                System.out.println("Web Driver was not found in directory");
        }
    }

    public void waitForElement(WebElement webElement, int seconds) {

//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
//        wait.until(ExpectedConditions.visibilityOf(webElement));

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
        .withTimeout(Duration.ofSeconds(seconds)).
                pollingEvery(Duration.ofMillis(200)).
                ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
