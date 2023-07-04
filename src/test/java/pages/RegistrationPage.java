package pages;

import com.codeborne.selenide.SelenideElement;
import enums.Roles;
import enums.UserEmails;
import enums.UserNames;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class RegistrationPage extends PageBase{
    public SelenideElement singUpTable = $x("//div[@id='signup']");
    public SelenideElement roleOption = $x("//select[@data-mappedto='Role']");
    public SelenideElement teacherRole = $x("//span[normalize-space()='teacher']");
    public SelenideElement studentRole = $x("//span[normalize-space()='student']");
    public SelenideElement fullNameInput = $x("//input[@placeholder='Full Name']");
    public SelenideElement emailInput = $x("//input[@placeholder='Email']");
    public SelenideElement passwordInput = $x("//input[@placeholder='Password']");
    public SelenideElement checkBox = $x("//span[@class='checkmark position-relative sw-checkbox']");
    public SelenideElement singUpButton = $x("//a[@id='sw-sign-up-submit-btn']");
    public SelenideElement signInButton = $x("//a[@id='sw-go-to-sign-in-btn']");

    public SelenideElement emptyRequiredFieldsMessageBlock= $x("//div[@class='error-message required-errors d-block']");
    public SelenideElement existUserMessageBlock= $x("//div[@class='error-message signup-error d-flex']");
    public void userRegistration ( Roles role, UserNames name, UserEmails userEmail){
        selectRole(role, roleOption);
        fullNameInput.sendKeys(name.getValue());
        emailInput.sendKeys(userEmail.getValue());
        passwordInput.sendKeys(getDefaultPassword());
        checkBox.click();
        singUpButton.click();
    }
    public void userRegistrationWithInvalidPasswordData ( Roles role, UserNames name, UserEmails email, String password){
        selectRole(role, roleOption);
        fullNameInput.sendKeys(name.getValue());
        emailInput.sendKeys(email.getValue());
        passwordInput.sendKeys(password);
        checkBox.click();
        singUpButton.click();
    }

    public void userRegistrationWithInvalidDomainData ( Roles role, UserNames name, String email){
        selectRole(role, roleOption);
        fullNameInput.sendKeys(name.getValue());
        emailInput.sendKeys(email);
        passwordInput.sendKeys(getDefaultPassword());
        checkBox.click();
        singUpButton.click();
    }

}
