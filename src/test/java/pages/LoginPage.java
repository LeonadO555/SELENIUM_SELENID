package pages;

import com.codeborne.selenide.SelenideElement;
import enums.UserEmails;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LoginPage extends PageBase{
    private SelenideElement emailInput = $x("//input[@placeholder='Email']");
    private SelenideElement passwordInput = $x("//input[@placeholder='Password']");
    private SelenideElement signInButton = $x("//a[@id='sw-sign-in-submit-btn']");
    private SelenideElement forgotPasswordButton = $x("//a[normalize-space()='Forgot password']");
    private SelenideElement signUpButton = $x("//a[@id='sw-go-to-sign-up-btn']");

    public void login (UserEmails userEmails){
        emailInput.sendKeys(userEmails.getValue());
        passwordInput.sendKeys(defaultPassword);
        signInButton.click();
    }
}
