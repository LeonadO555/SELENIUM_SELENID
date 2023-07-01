package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class LoginPage extends HomePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy (id = "signin")
    protected WebElement loginForm;

    @FindBy (xpath = "//input[@id='sw-form-capture-email-input']")
    protected WebElement emailField;

    @FindBy (xpath = "//input[@id='sw-form-password-input']")
    protected WebElement passwordField;

    @FindBy (xpath = "//a[@id='sw-sign-in-submit-btn']")
    protected WebElement signInButtonInTheForm;

    @FindBy (xpath = "//a[normalize-space()='Forgot password']")
    protected WebElement forgotPasswordLink;

    @FindBy (xpath = "//a[@id='sw-go-to-sign-up-btn']")
    protected WebElement signUpButtonInTheForm;

    @FindBy (xpath = "//img[@class='sw-width-5xs']")
    protected WebElement logoButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(loginForm);
        wait.forInvisibility(emailField);
        wait.forVisibility(passwordField);
        wait.forVisibility(signInButtonInTheForm);
    }

    public void fillEmailField(String email) {
        fillField(emailField, email);
    }

    public void fillPasswordField(String password) {
        fillField(passwordField, password);
    }

    public void clickOnTheSignInButtonInTheForm() {
        signInButtonInTheForm.click();
    }


}
