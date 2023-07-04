package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageBase{
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//input[@id='sw-form-capture-email-input']")
    protected WebElement emailInput;
    @FindBy(xpath = "//input[@id='sw-form-password-input']")
    protected WebElement passwordInput;
    @FindBy(xpath = "//a[@id='sw-sign-in-submit-btn']")
    protected WebElement signInButton;
    @FindBy(xpath = "//a[normalize-space()='Forgot password']")
    protected WebElement forgotPasswordButton;
    @FindBy(xpath = "//a[@id='sw-go-to-sign-up-btn']")
    protected WebElement signUpButton;
    @FindBy(xpath = "//*[@class='fa fa-eye-slash show-password']")
    protected WebElement visiblePasswordButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(emailInput);
    }
    public void fillEmail(String email){
        emailInput.sendKeys(email);
    }
    public void fillPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickSignInButton(){
        click(signInButton);
    }
    public void clickForgotPasswordButton(){
        click(forgotPasswordButton);
    }
    public void clickSignUpButton(){
        click(signUpButton);
    }
    public void clickVisiblePasswordButton(){
        click(visiblePasswordButton);
    }
}
