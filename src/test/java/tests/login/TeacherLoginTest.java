package tests.login;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.LoginPage;
import pages.teachers.TeachersHomePage;
import tests.TestBase;

public class TeacherLoginTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    TeachersHomePage teachersHomePage;
    String email = "roxanne@example.com";
    String password = "123456";

    @Test
    public void loginExistingTeacherUser() {
        mainPage = new MainPage(app.driver);
        mainPage.clickOnSingInButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillEmailField(email);
        loginPage.fillPasswordField(password);
        loginPage.clickOnTheSignInButtonInTheForm();

        teachersHomePage = new TeachersHomePage(app.driver);
        teachersHomePage.waitForLoading();
        teachersHomePage.checkForVisibilityAddCourseButton();
    }


}
