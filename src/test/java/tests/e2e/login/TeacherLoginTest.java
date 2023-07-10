package tests.e2e.login;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.LoginPage;
import pages.user.HomePage;
import tests.TestBase;

public class TeacherLoginTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    String email = "roxanne@example.com";
    String password = "123456";

    @Test
    public void loginExistingTeacherUser() {
        mainPage = new MainPage(app.driver);
        mainPage.clickOnSingInButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickOnTheSignInButtonInTheForm();

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.checkForVisibilityAddCourseButton();
    }


}
