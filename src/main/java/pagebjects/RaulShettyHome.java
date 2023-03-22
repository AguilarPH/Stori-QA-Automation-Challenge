package pagebjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RaulShettyHome extends BasePage{
    WebDriver driver;

    public RaulShettyHome(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement joinNowBtn(){

//        WebElement byXpath = driver.findElement(By.xpath("a[@href='https://courses.rahulshettyacademy.com/sign_up']"));
        WebElement byCSS = driver.findElement(By.cssSelector("a:contains('JOIN NOW')"));
        return byCSS;
    }
    public WebElement getJoinNowBtn(){
        return joinNowBtn();
    }

    private WebElement viewAllBtn(){
        WebElement byCSS = driver.findElement(By.cssSelector("a.btn btn-primary view-all-courses-btn"));
        return byCSS;
    }
    public WebElement getViewAllBtn(){
        return viewAllBtn();
    }
}
