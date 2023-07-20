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

    @FindBy(xpath = "//div[@class='container MuiBox-root css-0']//*[@href='/sign-in']")
    protected WebElement signInButton;

    @FindBy(xpath = "//a[@href='#teacher-spotlight-heading']")
    protected WebElement professorsSpotlightButton;


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(logoButton);
        wait.forVisibility(professorsSpotlightButton);
    }

    public void clickOUserAvatarButton(){
        click(userAvatarButton);
    }

    public void clickOnSignInButton(){
        wait.forVisibility(signInButton);
        click(signInButton);
    }
    public void clickOnMyProfileButton(){
        myProfileButton.click();
    }

}
