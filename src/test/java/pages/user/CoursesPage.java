package pages.user;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class CoursesPage extends PageBase {
    WebDriver driver;
    Wait wait;

    public CoursesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new Wait(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Discover more']")
    protected WebElement discoverMoreButton;

    @FindBy(xpath = "//div[@class=\"list-action-wrapper\"]")
    protected WebElement allCourses;

    @FindBy(xpath = "//input[@id=':r0:']")
    protected WebElement searchInput;

    String allCoursesOnThePage = "//div[@class='list-action-wrapper']";

    public boolean clickOnDiscoverMoreButtonIfItIsAvailable() {
        boolean discoverMoreButtonIsAvailable = discoverMoreButton.isDisplayed();
        int oldCountOCourses = driver.findElements(By.xpath(allCoursesOnThePage)).size();
        boolean flag = true;
        if (discoverMoreButtonIsAvailable) {
            clickOnDiscoverMoreButton();
            waitForLoadingCourses();
            int newCountOfCourses = driver.findElements(By.xpath(allCoursesOnThePage)).size();
            if (newCountOfCourses > oldCountOCourses) {
                clickOnDiscoverMoreButtonIfItIsAvailable();
            } else {
                flag = false;
            }
        }
        return flag;
    }

    public void waitForLoadingCourses() {
        wait = new Wait(driver);
        wait.forVisibility(allCourses);
    }

    public void clickOnDiscoverMoreButton() {
        scrollToElement(driver, discoverMoreButton);
        try {
            discoverMoreButton.click();
        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth',block: 'center'});", element);
    }

}
