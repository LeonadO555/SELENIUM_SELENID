package tests.login;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.teachers.TeachersMainPage;
import tests.TestBase;

public class TeacherLoginTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    TeachersMainPage teachersMainPage;
    String email = "sasha2@gmail.com";
    String password = "123456";

    @Test
    public void loginExistingTeacherUser() {
        homePage = new HomePage(app.driver);
        homePage.clickOnSingInButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnTheSignInButtonInTheForm();

        teachersMainPage = new TeachersMainPage(app.driver);
        teachersMainPage.waitForLoading();
    }


}
