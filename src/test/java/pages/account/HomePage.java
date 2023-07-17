package pages.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import wait.Wait;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;
    @FindBy(xpath = "//span[@class='MuiBox-root css-jf8tht']")
    protected WebElement addACourseButton;
    @FindBy(xpath = "//div[@class=\"container MuiBox-root css-0\"]//a[@role='button']//span")
    protected WebElement coursesTab;
    @FindBy(xpath = "//div[@class=\"container MuiBox-root css-0\"]//a[@href='/course-list']")
    protected WebElement coursesListTab;
    @FindBy(xpath = "//a[@href='/course-list']")
    protected WebElement viewCoursesButton;
    @FindBy(xpath = "//img[@class='sw-width-5xs']")
    protected WebElement logoButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(logoButton);
    }

    public void goToCoursesPage() {
        coursesTab.click();
        coursesListTab.click();
    }

    public void checkForVisibilityAddCourseButton() {
        wait.forVisibility(addACourseButton);
        addACourseButton.isDisplayed();
    }
}
