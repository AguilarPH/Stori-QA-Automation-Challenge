package steps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseSteps {
    private WebDriver driver;

    private static BaseSteps instance;

    private BaseSteps(){}

    static {
        try {
            instance = new BaseSteps();
        } catch (Exception e){
            throw new RuntimeException("Exception occurred in creating BaseSteps instance");
        }
    }

    public static BaseSteps getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return this.driver;

    }
    @Parameters("webDriver")
@BeforeTest
    public void setDriver(String browserName) {
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

        Wait<WebDriver> wait = new FluentWait<>(getDriver())
        .withTimeout(Duration.ofSeconds(seconds)).
                pollingEvery(Duration.ofMillis(200)).
                ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void takeScreenshot() {
        File scrSht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrSht, new File("./scrshots.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

@AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
