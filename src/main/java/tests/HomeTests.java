package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;
import pageObjects.RaulShettyHome;
import steps.ElementSteps;
import steps.NavigationSteps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomeTests extends BaseTest{

    WebDriver driver;
    NavigationSteps navigationSteps;
    ElementSteps elementSteps;
    HomePage homePage;
    RaulShettyHome raulShettyHome;
    CustomAssertions customAssertions = new CustomAssertions();

    public HomeTests(WebDriver driver) {
        this.driver = driver;
        elementSteps = new ElementSteps(this.driver);
        navigationSteps = new NavigationSteps(this.driver);
        homePage = PageFactory.initElements(getDriver(), HomePage.class);
        raulShettyHome = PageFactory.initElements(getDriver(), RaulShettyHome.class);


        navigationSteps.navigateToURL("https://rahulshettyacademy.com/AutomationPractice/");
    }


    public void controlTest() {

//  Step 2:
        suggestionBoxText();

//  Step 3:
        dropdownTest();

//  Step 4:
//        elementSteps.clickSwitchWindowBtn();

//  Step5:
//        switchTabTest();

//  Step 6:
        alertTest();

//  Step 7:
        webTableTest();

//  Step 8:
        fixedHeaderTableTest();

//  Step 9:
//        iFrameTest();

    }

    public void suggestionBoxText() {
        elementSteps.clickuggessionBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countries = elementSteps.sendKeysSuggessionBox("Me");
        elementSteps.selectSuggessionBoxAutocomplete(countries, "Mexico");
    }

    public void dropdownTest() {
        List<WebElement> dropdownOpts = elementSteps.clickDropDown();
        dropdownOpts.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dropdownOpts.get(3).click();
    }

    public void qaClickAcademyTest(){
        driver.manage().window().maximize();
    }

    public void switchTabTest() {
        String originTab = navigationSteps.getTabHandle();
        elementSteps.clickSwitchTabBtn();
        System.out.println(driver.manage().window().getSize());
        System.out.println(raulShettyHome.getJoinNowBtn().getLocation());

        System.out.println(raulShettyHome.getViewAllBtn().getText());
        navigationSteps.scrollToElement(raulShettyHome.getViewAllBtn());

//        navigationSteps.closeTab();
//        navigationSteps.switchToTab(originTab);

    }

    public void alertTest() {
        elementSteps.sendKeysSwToAlertText("Stori Card");
        String alertMsg =  elementSteps.clickSwToAlertBtn();
        System.out.printf("\nAlert message: %s\n", alertMsg);

        elementSteps.sendKeysSwToAlertText("Stori Card");
        String cfrmAlertMsg = elementSteps.clickSwToAlertCfrmBtn();

        CustomAssertions.isTextEqual("Hello Stori Card, Are you sure you want to confirm?", cfrmAlertMsg);
    }

    public void confirmAlertTest() {
        elementSteps.sendKeysSwToAlertText("Stori Card");
        String cfrmAlertMsg = elementSteps.clickSwToAlertCfrmBtn();

        CustomAssertions.isTextEqual("Hello Stori Card, Are you sure you want to confirm?", cfrmAlertMsg);
    }

    public void webTableTest() {
        List<List<WebElement>> courses = elementSteps.getWebTableChilds();
        courses.remove(0);
//        System.out.println(courses.get(0).size());
        List<WebElement> courses25 = new ArrayList<>();
        courses.forEach(row -> {if (Integer.parseInt(row.get(2).getText()) == 25) courses25.add(row.get(1) ); });
        System.out.printf("\nAvailable courses for $25: %d\n", courses25.size());
        courses25.forEach(course -> System.out.printf("- %s\n", course.getText()));
    }

    public void fixedHeaderTableTest() {
        List<List<WebElement>> employees = elementSteps.getFixedTableChildren();
        System.out.println("Employees: " + employees.get(0).get(1).getText());
        List<WebElement> engineers = new ArrayList<>();
        employees.forEach(row -> {if (row.get(1).getText().equals("Engineer")) engineers.add(row.get(0)); });
        System.out.printf("\nEngineers: \n");
        engineers.forEach(engineer -> System.out.println(engineer.getText()));
    }

    public void iFrameTest(){
        String blueText =
                "His mentorship program is most after in the software testing community with long waiting period.";
        navigationSteps.scrollToElement(homePage.getIframe());
        driver.switchTo().frame(homePage.getIframe());

        List<WebElement> bulletList = elementSteps.getIframeBulletList();

        bulletList.forEach
                (bullet -> {if(bullet.getText().equals(blueText)) System.out.printf("\n%s\n", bullet.getText());});

    }

}
