package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RegistrationPage extends PageBase{
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

    public void TeacherRegistration (String userEmail, String userPassword){
        roleOption.click();
        teacherRole.click();
        emailInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        checkBox.click();
        singUpButton.click();
    }

    public void StudentRegistration (String userEmail, String userPassword){
        roleOption.click();
        studentRole.click();
        emailInput.sendKeys(userEmail);
        passwordInput.sendKeys(userPassword);
        checkBox.click();
        singUpButton.click();
    }

}
