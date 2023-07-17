package tests.e2e;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.account.CoursesPage;
import pages.account.HomePage;
import tests.TestBase;

public class UserCanViewAllCoursesUATest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    CoursesPage coursesPage;
    String email = "roxanne@example.com";
    String password = "123456";

    @Test
    public void userCanVewAllCourses() {
        mainPage = new MainPage(app.driver);
        mainPage.clickOnSingInButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.goToCoursesPage();

        coursesPage = new CoursesPage(app.driver);
        coursesPage.waitForLoadingCourses();
        coursesPage.clickOnDiscoverMoreButtonIfItIsAvailable();

        Assert.assertTrue(coursesPage.clickOnDiscoverMoreButtonIfItIsAvailable());
    }

}
