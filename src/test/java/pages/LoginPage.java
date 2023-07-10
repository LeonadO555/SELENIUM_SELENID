package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class LoginPage extends MainPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy (id = "signin")
    protected WebElement loginForm;

    @FindBy (xpath = "//input[@id='sw-form-capture-email-input']")
    protected WebElement emailInput;

    @FindBy (xpath = "//input[@id='sw-form-password-input']")
    protected WebElement passwordInput;

    @FindBy (xpath = "//a[@id='sw-sign-in-submit-btn']")
    protected WebElement signInButtonInTheForm;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(loginForm);
        wait.forVisibility(emailInput);
        wait.forVisibility(passwordInput);
        wait.forVisibility(signInButtonInTheForm);
    }

    public void fillEmail(String email) {
        fillField(emailInput, email);
    }

    public void fillPassword(String password) {
        fillField(passwordInput, password);
    }

    public void clickOnTheSignInButtonInTheForm() {
        signInButtonInTheForm.click();
    }


}
