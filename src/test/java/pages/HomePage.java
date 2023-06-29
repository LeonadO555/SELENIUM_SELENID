package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"navbar-brand\"]//img")
    protected WebElement logoButton;

    @FindBy(xpath = "//div[@xpath=\"1\"]//button[@type='button']")
    protected WebElement userAvatarButton;

    @FindBy(xpath = "//a[@href=\"/user-profile\"]")
    protected WebElement myProfileButton;

    @FindBy(xpath = "//a[@href=\"#\"]")
    protected WebElement signOutButton;

    @FindBy(xpath = "//a[@role=\"button\"]")
    protected WebElement courseButton;

    @FindBy(xpath = "//a[@href=\"#teacher-spotlight-heading\"]")
    protected WebElement professorsSpotlightButton;

    @FindBy(xpath = "//div[@class=\"MuiToolbar-root MuiToolbar-dense css-1jmxd2t\"]//a[@href=\"/student-directory\"]")
    protected WebElement studentDirectoryButton;

    @FindBy(xpath = "//div[@class=\"inbox-list-container\"]")
    protected WebElement professorsSpotlightForm;

    @FindBy(xpath = "//div[@class=\"list-container\"]")
    protected WebElement coursesList;


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(logoButton);
        wait.forVisibility(userAvatarButton);
        wait.forVisibility(myProfileButton);
        wait.forVisibility(signOutButton);
        wait.forVisibility(courseButton);
        wait.forVisibility(professorsSpotlightButton);
        wait.forVisibility(studentDirectoryButton);
        wait.forVisibility(professorsSpotlightForm);
        wait.forVisibility(coursesList);
    }

    public void clickOnLogoButton(){
        logoButton.click();
    }

    public void clickOUserAvatarButton(){
        userAvatarButton.click();
    }

    public void clickOnMyProfileButton(){
        myProfileButton.click();
    }

    public void clickOnSignOutButton(){
        signOutButton.click();
    }

    public void clickOnCourseButton(){
        courseButton.click();
    }

    public void clickOnProfessorsSpotlightButton(){
        professorsSpotlightButton.click();
    }

    public void clickOnStudentDirectoryButton(){
        studentDirectoryButton.click();
    }


    public void clickOnCoursesList(){
        coursesList.click();
    }







}
