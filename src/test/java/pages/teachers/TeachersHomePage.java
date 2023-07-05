package pages.teachers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import wait.Wait;

public class TeachersHomePage extends MainPage {
    public TeachersHomePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy (xpath = "//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-1s7t6r0']")
    protected WebElement avatarButton;

    @FindBy (xpath = "//span[normalize-space()='My Profile']")
    protected WebElement myProfileButton;

    @FindBy (xpath = "//span[normalize-space()='Sign Out']")
    protected WebElement signOutButton;

    @FindBy (xpath = "//span[normalize-space()='Add course']")
    protected WebElement addACourseButton;

    @FindBy (xpath = "//span[normalize-space()='Student Directory']")
    protected WebElement studentDirectoryTab;

    @FindBy (xpath = "//span[normalize-space()='Professors']")
    protected WebElement professorsTab;

    @FindBy (xpath = "//span[normalize-space()='Courses']")
    protected WebElement coursesTab;

    @FindBy (css = ".sw-font-size-m.sw-text-color-424242.sw-font-family-default.sw-font-weight-normal.sw-letter-spacing-normal.MuiBox-root.css-0")
    protected WebElement coursesListTab;

    @FindBy (xpath = "//span[normalize-space()='About Us']")
    protected WebElement aboutUsTab;

    @FindBy (xpath = "//a[normalize-space()='View Courses']")
    protected WebElement viewCoursesButton;

    @FindBy (xpath = "//img[@class='sw-width-5xs']")
    protected WebElement logoButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(avatarButton);
        wait.forVisibility(logoButton);
        wait.forVisibility(addACourseButton);
    }

    public void clickOnAvatarButton() {
        avatarButton.click();
    }

    public void clickOnMyProfileButton() {
        myProfileButton.click();
    }

    public void clickOnSignOutButton() {
        signOutButton.click();
    }

    public void clickOnAddCourseButton() {
        addACourseButton.click();
    }

    public void clickOnStudentDirectoryTab() {
        studentDirectoryTab.click();
    }

    public void clockOnProfessorsTab() {
        professorsTab.click();
    }

    public void goToCoursesPage() {
        coursesTab.click();
        coursesListTab.click();
    }

    public void clickOnAboutUsTab() {
        aboutUsTab.click();
    }

    public void clickOnViewCoursesButton() {
        viewCoursesButton.click();
    }

    public void goToMainPage() {
        logoButton.click();
    }

    public void checkForVisibilityAddCourseButton() {
        wait.forVisibility(addACourseButton);
    }
}
