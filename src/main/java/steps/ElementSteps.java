package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pagebjects.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementSteps extends BaseSteps{

    WebDriver driver;
    HomePage homePage;

    public ElementSteps(WebDriver driver) {
        this.driver = driver;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    public void clickuggessionBox() {
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
        homePage.getswitchWindowBtn().click();

    }

    public void clickSwitchTabBtn() {
        homePage.getSwitchTabBtn().click();
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

    public List<List<WebElement>> getTableExampleChilds() {
        List<List<WebElement>> courses = new ArrayList<>();
        List<WebElement> children = homePage.getTableExample().findElements(By.xpath("./child::tr"));

        System.out.println(children.size());

        children.forEach(course -> {
            List<WebElement> fields = course.findElements(By.xpath("./child::td"));
            courses.add(fields);
        });

        return courses;
    }

}
