package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='signin']")
    protected WebElement signInForm;

    @FindBy(xpath = "//input[@type='email']")
    protected WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    protected WebElement passwordField;

    @FindBy(xpath = "//a[@id='sw-sign-in-submit-btn']")
    protected WebElement signInButton;

    @FindBy(xpath = "//a[normalize-space()='Forgot password']")
    protected WebElement forgotPasswordButton;

    @FindBy(xpath = "//a[@id='sw-go-to-sign-up-btn']")
    protected WebElement signUpButton;

    @FindBy(xpath = "//a[normalize-space()='']//img")
    protected WebElement homePageButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(signInForm);
        wait.forVisibility(emailField);
        wait.forVisibility(passwordField);
        wait.forVisibility(signInButton);
        wait.forVisibility(forgotPasswordButton);
        wait.forVisibility(signUpButton);
        wait.forVisibility(homePageButton);

    }

    public void fillEmailInput(String text){
        emailField.click();
        emailField.sendKeys(text);
    }

    public void fillPasswordInput(String text){
        passwordField.click();
        passwordField.sendKeys(text);
    }

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void clickOnSignUpButton(){
        signUpButton.click();
    }

    public void clickOnForgotPasswordButton(){
        forgotPasswordButton.click();
    }


}
