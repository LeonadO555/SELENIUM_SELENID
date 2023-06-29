package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class RegistrationPage extends LoginPage{
    private SelenideElement singUpTable = $x("//div[@id='signup']");
    private SelenideElement roleOption = $x("//div[@class='filter-option-inner-inner']");
    private SelenideElement teacherRole = $x("//span[normalize-space()='teacher']");
    private SelenideElement studentRole = $x("//span[normalize-space()='student']");
    private SelenideElement fullNameInput = $x("//input[@placeholder='Full Name']");
    private SelenideElement emailInput = $x("//input[@placeholder='Email']");
    private SelenideElement passwordInput = $x("//input[@placeholder='Password']");
    private SelenideElement checkBox = $x("//span[@class='checkmark position-relative sw-checkbox']");
    private SelenideElement singUpButton = $x("//a[@id='sw-sign-up-submit-btn']");
    private SelenideElement signInButton = $x("//a[@id='sw-go-to-sign-in-btn']");

    public void selectRole(String role) {
        selectOption(role,roleOption);
    }
    public void userRegistration (String email,  String role){
        selectRole(role);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(getDefaultPassword());
        checkBox.click();
        singUpButton.click();
    }

}
