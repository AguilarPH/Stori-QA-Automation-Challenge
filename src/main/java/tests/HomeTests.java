package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagebjects.HomePage;
import pagebjects.RaulShettyHome;
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
//        switchTabTest();

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
    @Test(description = "Send 'Me' to Suggession Class textbox, from the displayed autocomplete list, select 'Mexico'",
        groups = "homePageTests")
    public void suggestionBoxTest() {
        elementSteps.clickuggessionBox();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countries = elementSteps.sendKeysSuggessionBox("Me");
        elementSteps.selectSuggessionBoxAutocomplete(countries, "Mexico");
    }

    @Test(description = "Click on Dropdown element to display its options, select 'Option2', wait 5 seconds and select 'Option 3'",
        groups = "homePageTests")
    public void dropDownTest() {
        List<WebElement> dropdownOpts = elementSteps.clickDropDown();
        dropdownOpts.get(2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        dropdownOpts.get(3).click();
    }

    @Test(description = "Click the Switch Window button, switch focus to the new window and look for " +
                "'30 day money back guarantee' text, close window and get focus back to Home Page",
        groups = "switchWindowTests", enabled = false)
    public void switchWindowTest(){
        String originTab = navigationSteps.getTabHandle();
        driver.manage().window().maximize();
    }

    @Test(description = "Click Switch Tab button, switch focus to new tab and scroll until the " +
            "View All Courses button, take screenshot, get focus back to original tab",
        groups = "switchWindowTests", enabled = false)
    public void switchTabTest() {
        String originTab = navigationSteps.getTabHandle();
        elementSteps.clickSwitchTabBtn();

        System.out.println(raulShettyHome.getJoinNowBtn().getText());
//        navigationSteps.scrollToElement(raulShettyHome.getViewAllBtn());
    }

    @Test(description = "Enter message to Switch To Alert textbox, click Alert button, " +
            "print the alert text and click its Ok button",
        groups = "alertsTests")
    public void switchToAlertTest() {
        elementSteps.sendKeysSwToAlertText("Stori Card");
        String alertMsg =  elementSteps.clickSwToAlertBtn();
        System.out.printf("\nAlert message: %s\n", alertMsg);
    }

    @Test(description = "Enter message to Switch To Alert textbox, click Confirm button, " +
            "print the alert text and verify it against expected text print the alert text, click its Ok button",
            groups = "alertsTests")
    public void switchToAlertAndConfirmTest() {
        elementSteps.sendKeysSwToAlertText("Stori Card");
        String cfrmAlertMsg = elementSteps.clickSwToAlertCfrmBtn();
        System.out.printf("\nAlert message: %s\n", cfrmAlertMsg);
        Assert.assertTrue(cfrmAlertMsg.equals("Hello Stori Card, Are you sure you want to confirm?"),
                "Alert text: " + cfrmAlertMsg + " does not match with expected text: " +
                        "'Hello Stori Card, Are you sure you want to confirm?'");
//        Assert.assertEquals(cfrmAlertMsg,"Hello Stori Card, Are you sure you want to confirm?",
//                "Alert text: " + cfrmAlertMsg + " does not match with expected text: " +
//                        "'Hello Stori Card, Are you sure you want to confirm?'");
    }

    @Test(description = "Check the Web Table rows, print the quantity of rows with price of 25," +
            "print the name of courses with this price",
        groups = "tableTests")
    public void webTableTest() {
        List<List<WebElement>> courses = elementSteps.getWebTableChilds();
        courses.remove(0);
        List<WebElement> courses25 = new ArrayList<>();
        courses.forEach(row -> {if (Integer.parseInt(row.get(2).getText()) == 25) courses25.add(row.get(1) ); });
        System.out.printf("\nAvailable courses for $25: %d\n", courses25.size());
        courses25.forEach(course -> System.out.printf("- %s\n", course.getText()));
    }

    @Test(description = "Check the Web Table Fixed Header rows, print the name value of every Engineer found",
            groups = "tableTests")
    public void webTableFixedHeaderTests() {
        List<List<WebElement>> employees = elementSteps.getFixedTableChildren();
        List<WebElement> engineers = new ArrayList<>();
        employees.forEach(row -> {if (row.get(1).getText().equals("Engineer")) engineers.add(row.get(0)); });
        System.out.printf("\nEngineers: \n");
        engineers.forEach(engineer -> System.out.println(engineer.getText()));
    }

    @Test(description = "Scroll until iFrame Example is displayed in screen, switch focus to iFrame and look for " +
            "'His mentorship is most after in the software testing community with long waiting period.' text in the" +
            "bullet list and print it",
        groups = "switchFrameTest")
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
