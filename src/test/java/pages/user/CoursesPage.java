package pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

import java.util.List;

public class CoursesPage extends PageBase {

//    public CoursesPage(WebDriver driver) {
//        super(driver);
//    }
    WebDriver driver;
    Wait wait;

    public CoursesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new Wait(driver);
    } // Это проблема для логина и апи

    @FindBy(xpath = "//button[normalize-space()='Discover more']")
    protected WebElement discoverMoreButton;

    @FindBy(xpath = "//div[@class=\"list-action-wrapper\"]")
    protected WebElement allCourses;

    @FindBy(xpath = "//h1[normalize-space()='Our courses']")
    protected WebElement ourCoursesTitle;

    public boolean clickOnDiscoverMoreButtonIfItIsAvailable() {
        //wait.forVisibility(allCourses);
        boolean discoverMoreButtonIsAvailable = discoverMoreButton.isDisplayed();
        int oldCountOfLinks = driver.findElements(By.xpath("//div[@class='list-action-wrapper']")).size();
        boolean flag;
        if (discoverMoreButtonIsAvailable) {
            waitForLoadingDiscoverMoreButton();
            clickOnDiscoverMoreButton();
            int newCountOfLinks = driver.findElements(By.xpath("//div[@class='list-action-wrapper']")).size();
            if (newCountOfLinks > oldCountOfLinks) {
                flag = true;
                clickOnDiscoverMoreButtonIfItIsAvailable();
            } else {
                flag = false;
            }
        } else {
            flag = true;
        }
        return flag;
    }

    public void waitForLoadingDiscoverMoreButton() {
        wait = new Wait(driver);
        wait.forVisibility(discoverMoreButton);
    }

    public void waitForLoadingCourses() {
        wait = new Wait(driver);
        wait.forVisibility(allCourses);
    }

    public void clickOnDiscoverMoreButton() {
        discoverMoreButton.click();
    }


}
