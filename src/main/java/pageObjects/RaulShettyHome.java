package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RaulShettyHome{
    WebDriver driver;

    public RaulShettyHome(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement joinNowBtn(){

        WebElement byXpath = driver.findElement(By.xpath("//a[@class='btn btn-theme btn-sm btn-min-block']"));
//        WebElement byCSS = driver.findElement(By.cssSelector("a:contains('JOIN NOW')"));
        return byXpath;
    }
    public WebElement getJoinNowBtn(){
        return joinNowBtn();
    }

    private WebElement coursesSection() {
        WebElement byClass = driver.findElement(By.className("courses-section"));
        WebElement byCSS = driver.findElement(By.cssSelector("section.courses-section"));
        return byCSS;
    }

    public WebElement getCoursesSection() {
        return coursesSection();
    }

    private WebElement viewAllBtn(){
        WebElement byXpath = driver.findElement(By.xpath("//a[@class='btn btn-primary view-all-courses-btn']"));
//        WebElement byCSS = driver.findElement(By.cssSelector("a.'btn btn-primary view-all-courses-btn'"));
        return byXpath;
    }
    public WebElement getViewAllBtn(){
        return viewAllBtn();
    }
}
