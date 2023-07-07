package tests.e2e;

import enums.UserEmails;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;

public class UserLogInTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void teacherSuccessfullyLogIn(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().isDisplayed();
        loginPage.login(UserEmails.TEACHER_BORIS_RISKER);
        homePage.avatarButton.isDisplayed();
    }
    @Test
    public void studentSuccessfullyLogIn(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().isDisplayed();
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA);
        homePage = new HomePage();
        homePage.avatarButton.isDisplayed();
    }


}
