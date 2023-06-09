package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.RaulShettyHome;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementSteps{

    WebDriver driver;
    HomePage homePage;

    RaulShettyHome raulShettyHome;

    public ElementSteps(WebDriver driver) {

        this.driver = driver;
        homePage = new HomePage(this.driver);
//        homePage = PageFactory.initElements(getDriver(), HomePage.class);
        raulShettyHome = PageFactory.initElements(this.driver, RaulShettyHome.class);
    }

    public void clickSuggessionBox() {
        homePage.getSuggesionBox().click();

    }

    public List<WebElement> sendKeysSuggessionBox(String txt) {
        homePage.getSuggesionBox().sendKeys(txt);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countries = homePage.getSuggessionBoxAutocomplete().findElements(By.xpath("./child::*"));

        return countries;
    }

    public void selectSuggessionBoxAutocomplete(List<WebElement> countries, String txt) {

        if(homePage.getSuggessionBoxAutocomplete().isEnabled()) {
            for (WebElement country : countries) {
                if (country.getText().equals(txt)) {
                    country.click();
                }
            }
        }else {
            System.out.println("Autocomplete not available");
        }


    }

    public List<WebElement> clickDropDown() {
        homePage.getDropdown().click();
        List<WebElement> dropdownOpts = homePage.getDropdown().findElements(By.xpath("./child::*"));

        return dropdownOpts;
    }

    public void clickSwitchWindowBtn() {
        List<String> currentWindows = new ArrayList<>();
        List<String> newWindows = new ArrayList<>();

        currentWindows.addAll(driver.getWindowHandles());

        homePage.getswitchWindowBtn().click();
        newWindows.addAll(driver.getWindowHandles());
        newWindows.removeAll(currentWindows);
        driver.switchTo().window(newWindows.get(0));

    }

    public void clickSwitchTabBtn() {
        List<String> currentWindows = new ArrayList<>();
        List<String> newWindows = new ArrayList<>();
//        int openWindows = driver.getWindowHandles().size();
        currentWindows.addAll(driver.getWindowHandles());

        homePage.getSwitchTabBtn().click();
        newWindows.addAll(driver.getWindowHandles());
        newWindows.removeAll(currentWindows);
        driver.switchTo().window(newWindows.get(0));

    }

    public void sendKeysSwToAlertText(String name) {
//        homePage.getSwitchToAlertText().click();
        homePage.getSwToAlertText().sendKeys(name);
    }

    public String clickSwToAlertBtn() {
        homePage.getSwToAlertBtn().click();

        String alertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        return alertMsg;
    }

    public String clickSwToAlertCfrmBtn() {
        homePage.getSwToAlertCfrmBtn().click();

        String cfrmAlertMsg = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        return cfrmAlertMsg;
    }

    public List<List<WebElement>> getWebTableChilds() {
        List<List<WebElement>> courses = new ArrayList<>();
        List<WebElement> children = homePage.getWebTable().findElements(By.xpath("./child::tr"));

        children.forEach(course -> {
            List<WebElement> fields = course.findElements(By.xpath("./child::td"));
            courses.add(fields);
        });

        return courses;
    }

    public List<List<WebElement>> getFixedTableChildren() {
        List<List<WebElement>> employees = new ArrayList<>();
        List<WebElement> records = homePage.getFixedTable().findElements(By.xpath("./child::tr"));

        records.forEach(record -> {
            List<WebElement> fields = record.findElements(By.xpath("./child::td"));
            employees.add(fields);
        });

        return employees;
    }

    public List<WebElement> getIframeBulletList(){
        HomePage.IframeElements iframeElements = homePage.new IframeElements();
        List<WebElement> bullets = new ArrayList<>();
        bullets.addAll(iframeElements.getBulletList().findElements(By.xpath("//child::ul[@class='list-style-two']/child::li")));

        return bullets;
    }

}
