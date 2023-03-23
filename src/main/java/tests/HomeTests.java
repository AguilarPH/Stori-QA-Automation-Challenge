package tests;

import dev.failsafe.internal.util.Assert;
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

    public HomeTests(WebDriver driver) {
        this.driver = driver;
        elementSteps = new ElementSteps(driver);
        navigationSteps = new NavigationSteps(driver);
        homePage = PageFactory.initElements(driver, HomePage.class);
        raulShettyHome = PageFactory.initElements(driver, RaulShettyHome.class);

    }


    public void controlTest() {

//  Step 1:
        navigationSteps.navigateToURL("https://rahulshettyacademy.com/AutomationPractice/");

//  Step 2:
        suggestionBoxTest();

//  Step 3:
        dropDownTest();

//  Step 4:
//        switchWindowTest();

//  Step5:
        switchTabTest();

//  Step 6:
        switchToAlertTest();

        switchToAlertAndConfirmTest();

//  Step 7:
        webTableTest();

//  Step 8:
        webTableFixedHeaderTests();

//  Step 9:
//        iFrameTest();

    }

    public void suggestionBoxTest() {
        elementSteps.clickuggessionBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countries = elementSteps.sendKeysSuggessionBox("Me");
        elementSteps.selectSuggessionBoxAutocomplete(countries, "Mexico");
    }

    public void dropDownTest() {
        List<WebElement> dropdownOpts = elementSteps.clickDropDown();
        dropdownOpts.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dropdownOpts.get(3).click();
    }

    public void switchWindowTest(){
        String originTab = navigationSteps.getTabHandle();
        driver.manage().window().maximize();
    }

    public void switchTabTest() {
        String originTab = navigationSteps.getTabHandle();
        elementSteps.clickSwitchTabBtn();

        navigationSteps.scrollToBottom();
        System.out.printf("\n%s\n", raulShettyHome.getJoinNowBtn().getText());
//        navigationSteps.scrollToElement(raulShettyHome.getViewAllBtn());

        navigationSteps.switchToTab(originTab);
    }

    public void switchToAlertTest() {
        elementSteps.sendKeysSwToAlertText("Stori Card");
        String alertMsg =  elementSteps.clickSwToAlertBtn();
        System.out.printf("\nAlert message: %s\n", alertMsg);
    }

    public void switchToAlertAndConfirmTest() {
        elementSteps.sendKeysSwToAlertText("Stori Card");
        String cfrmAlertMsg = elementSteps.clickSwToAlertCfrmBtn();
        System.out.printf("\nAlert message: %s\n", cfrmAlertMsg);

        Assert.isTrue(cfrmAlertMsg.equals("Hello Stori Card, Are you sure you want to confirm?"),
                "Alert text: " + cfrmAlertMsg + " does not match with expected text: " +
                        "'Hello Stori Card, Are you sure you want to confirm?'");

    }

    public void webTableTest() {
        List<List<WebElement>> courses = elementSteps.getWebTableChilds();
        courses.remove(0);
        List<WebElement> courses25 = new ArrayList<>();
        courses.forEach(row -> {if (Integer.parseInt(row.get(2).getText()) == 25) courses25.add(row.get(1) ); });
        System.out.printf("\nAvailable courses for $25: %d\n", courses25.size());
        courses25.forEach(course -> System.out.printf("- %s\n", course.getText()));
    }

    public void webTableFixedHeaderTests() {
        List<List<WebElement>> employees = elementSteps.getFixedTableChildren();
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
