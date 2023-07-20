package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement emailInput;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement passwordInput;

    @FindBy(xpath = "//a[@id='sw-sign-in-submit-btn']")
    protected WebElement signInButton;

    @FindBy(xpath = "//a[normalize-space()='Forgot password']")
    protected WebElement forgotPasswordButton;

    @FindBy(xpath = "//a[normalize-space()='']//img")
    protected WebElement logoButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(emailInput);
        wait.forVisibility(passwordInput);
        wait.forVisibility(signInButton);
        wait.forVisibility(forgotPasswordButton);
        wait.forVisibility(logoButton);

    }

    public void fillEmailInput(String text){
       fillInput(emailInput, text);
    }

    public void fillPasswordInput(String text){
        fillInput(passwordInput, text);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }
}
