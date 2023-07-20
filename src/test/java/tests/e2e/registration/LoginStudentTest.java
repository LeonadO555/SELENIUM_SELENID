package tests.e2e.registration;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;

public class LoginStudentTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    String email = "malik@example.com";
    String password = "123456";

    @Test
    public void loginStudentWithValidData(){
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickOnSignInButton();
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickOnSignInButton();
        homePage.waitForLoading();
    }
}
