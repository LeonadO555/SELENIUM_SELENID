package pages;

import com.codeborne.selenide.SelenideElement;
import enums.UserEmails;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class LoginPage extends PageBase{
    private SelenideElement loginTable = $x("//div[@id='signin']");
    private SelenideElement emailInput = $x("//input[@placeholder='Email']");
    private SelenideElement passwordInput = $x("//input[@placeholder='Password']");
    private SelenideElement signInButton = $x("//a[@id='sw-sign-in-submit-btn']");
    private SelenideElement forgotPasswordButton = $x("//a[normalize-space()='Forgot password']");
    private SelenideElement signUpButton = $x("//a[@id='sw-go-to-sign-up-btn']");

    public void login (UserEmails userEmails){
        emailInput.sendKeys(userEmails.value);
        passwordInput.sendKeys(defaultPassword);
        signInButton.click();
    }
    public void login (UserEmails userEmails, String password){
        emailInput.sendKeys(userEmails.value);
        passwordInput.sendKeys(password);
        signInButton.click();
    }
    public void getTeacherLogIn(){
        login(UserEmails.TEACHER_BORIS_RISKER);
    }
    public void getStudentLogIn(){
        login(UserEmails.STUDENT_ANNA_BELOVA);
    }

    public void getStudentLogIn2(){
        login(UserEmails.STUDENT_DIANA_MALIKOVA);
    }
}
