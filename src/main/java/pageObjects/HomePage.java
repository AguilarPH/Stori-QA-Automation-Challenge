package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement suggessionBox(){
//        WebElement byXpath = driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']"));
        WebElement byXpath = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
        return byXpath;
    }

    public WebElement getSuggesionBox() {
        return suggessionBox();
    }

    private WebElement suggessionBoxAutocomplete() {
        WebElement byXpath = driver.findElement(By.xpath("//ul[@id='ui-id-1']"));
        return byXpath;
    }

    public WebElement getSuggessionBoxAutocomplete() {
        return suggessionBoxAutocomplete();
    }

    private WebElement dropdown(){
        WebElement byXpathName = driver.findElement(By.xpath(
                "//select[@name='dropdown-class-example']"));
//        WebElement byXpath = driver.findElement(By.xpath(
//        "//legend[contains(text(), 'Checkbox Example')]//following-sibling::select"));
        return byXpathName;
    }

    public WebElement getDropdown(){
        return dropdown();
    }

    private WebElement switchWindowBtn() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//*[contains(text(), 'Switch Window Example')]//following-sibling::button"));
        return byXpath;
    }

    public WebElement getswitchWindowBtn() {
        return switchWindowBtn();
    }

    private WebElement switchTabBtn() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//legend[contains(text(), 'Switch Tab Example')]//following-sibling::a"));
        WebElement byCSS = driver.findElement(By.cssSelector("a#opentab"));
        return byCSS;
    }
    public WebElement getSwitchTabBtn() {
        return switchTabBtn();
    }

    private WebElement swToAlertText() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//legend[contains(text(), 'Switch To Alert Example')]" +
                        "//following-sibling::input[@type='text']"));
        WebElement byCSS = driver.findElement(By.cssSelector("input#name"));
        return byXpath;
    }

    public WebElement getSwToAlertText() {
        return swToAlertText();
    }

    private WebElement swToAlertBtn() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//legend[contains(text(), 'Switch To Alert Example')]" +
                        "//following-sibling::input[2]"));
        WebElement byCSS = driver.findElement(By.cssSelector("input#alertbtn"));
        return byXpath;
    }

    public WebElement getSwToAlertBtn() {
        return swToAlertBtn();
    }

    private WebElement swToAlertCfrmBtn() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//legend[contains(text(), 'Switch To Alert Example')]" +
                        "//following-sibling::input[3]"));
        WebElement byCSS = driver.findElement(By.cssSelector("input#confirmbtn"));
        return byCSS;
    }

    public WebElement getSwToAlertCfrmBtn() {
        return swToAlertCfrmBtn();
    }

    private WebElement webTable() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//legend[contains(text(), 'Web Table Example')]" +
                        "//following-sibling::table//child::tbody"));
        return byXpath;
    }

    public WebElement getWebTable() {
        return webTable();
    }

    private WebElement fixedTable() {
        WebElement byXpath = driver.findElement(By.xpath(
                "//th[contains(text(), 'Position')]/parent::tr/parent::thead/ancestor::div[@class='tableFixHead']" +
                        "//child::tbody"));
//        table[@id='product']

        return byXpath;
    }

    public WebElement getFixedTable() {
        return fixedTable();
    }

    private WebElement iframe() {
        WebElement byXpath = driver.findElement(By.xpath("//*[@id='courses-iframe']"));
        return byXpath;
    }

    public WebElement getIframe() {
        return iframe();
    }
    public class IframeElements {

        private WebElement bulletList() {
            WebElement byXpath = driver.findElement(By.xpath("//div[@class='row clearfix']"));
            return byXpath;
        }

        public WebElement getBulletList() {
            return bulletList();
        }
    }

}
