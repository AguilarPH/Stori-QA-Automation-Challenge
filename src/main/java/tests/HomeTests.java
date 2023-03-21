package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pagebjects.HomePage;
import steps.ElementSteps;
import steps.NavigationSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomeTests{

    WebDriver driver;
    NavigationSteps navigationSteps;
    ElementSteps elementSteps;
    HomePage homePage;
    CustomAssertions customAssertions = new CustomAssertions();

    public HomeTests(WebDriver driver) {
        this.driver = driver;
        elementSteps = new ElementSteps(driver);
        navigationSteps = new NavigationSteps(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);

        navigationSteps.navigateToURL("https://rahulshettyacademy.com/AutomationPractice/");
    }


    public void controlTest() {

        elementSteps.clickuggessionBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countries = elementSteps.sendKeysSuggessionBox("Me");
        elementSteps.selectSuggessionBoxAutocomplete(countries, "Mexico");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> dropdownOpts = elementSteps.clickDropDown();
        dropdownOpts.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dropdownOpts.get(3).click();

        String originTab = navigationSteps.getTabHandle();

//        elementSteps.clickSwitchWindowBtn();
//        elementSteps.clickSwitchTabBtn();

        elementSteps.sendKeysSwToAlertText("Stori Card");
        String alertMsg =  elementSteps.clickSwToAlertBtn();
        System.out.printf("Alert message: %s\n", alertMsg);

        elementSteps.sendKeysSwToAlertText("Stori Card");
        String cfrmAlertMsg = elementSteps.clickSwToAlertCfrmBtn();
        CustomAssertions.isTextEqual("Hello Stori Card, Are you sure you want to confirm?", cfrmAlertMsg);

        List<List<WebElement>> courses = elementSteps.getTableExampleChilds();
        courses.remove(0);
        System.out.println(courses.get(0).size());
        List<WebElement> courses25 = new ArrayList<>();
        courses.forEach(row -> {if (Integer.parseInt(row.get(2).getText()) == 25) courses25.add(row.get(1) ); });
        System.out.printf("Available courses for $25: %d\n", courses25.size());
        courses25.forEach(course -> System.out.printf("- %s\n", course.getText()));


    }

    public void qaClickAcademyTest(){
        driver.manage().window().maximize();
    }
}
