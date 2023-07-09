package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='navbar-brand']//img")
    protected WebElement logoButton;

    @FindBy(xpath = "//button[@type='button']//div")
    protected WebElement userAvatarButton;

    @FindBy(xpath = "//a[@href='/user-profile']")
    protected WebElement myProfileButton;

    @FindBy(xpath = "//a[@href='#']")
    protected WebElement signOutButton;
    @FindBy(xpath = "//*[@href='/sign-in']")
    protected WebElement signInButton;

    @FindBy(xpath = "//a[@role='button']//span")
    protected WebElement courseButton;

    @FindBy(xpath = "//a[@href='#teacher-spotlight-heading']")
    protected WebElement professorsSpotlightButton;

    @FindBy(xpath = "//div[@class='MuiToolbar-root MuiToolbar-dense css-1jmxd2t']//a[@href='/student-directory']")
    protected WebElement studentDirectoryButton;

    @FindBy(xpath = "//div[@class='inbox-list-container']")
    protected WebElement professorsSpotlightForm;

    @FindBy(xpath = "//div[@class='list-container']")
    protected WebElement coursesList;


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(logoButton);
      //  wait.forVisibility(courseButton);
        wait.forVisibility(professorsSpotlightButton);
    }

    public void clickOnLogoButton(){
        click(logoButton);
    }

    public void clickOUserAvatarButton(){
        click(userAvatarButton);
    }

    public void clickOnSignInButton(){
        click(signInButton);
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
