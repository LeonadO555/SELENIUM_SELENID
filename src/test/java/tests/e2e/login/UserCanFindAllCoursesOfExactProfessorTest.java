package tests.e2e.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.user.CoursesPage;
import pages.user.HomePage;
import tests.TestBase;

public class UserCanFindAllCoursesOfExactProfessorTest extends TestBase {
    MainPage mainPage;
    LoginPage loginPage;
    HomePage homePage;
    CoursesPage coursesPage;
    String email = "malik@example.com";
    String password = "123456";
    String professorName = "Roxanne";

    @Test
    public void userCanFindAllCoursesOfExactProfessor() {
        mainPage = new MainPage(app.driver);
        mainPage.clickOnSingInButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.clickOnTheSignInButtonInTheForm();

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.goToCoursesPage();

        coursesPage = new CoursesPage(app.driver);
        coursesPage.waitForLoadingCourses();
        coursesPage.fillSearchInput(professorName);
        coursesPage.clickOnDiscoverMoreButtonIfItIsAvailable();
        coursesPage.waitForLoadingCourses();
        coursesPage.checkCoursesPreviewsContainExpectedText(professorName);
        //Assert.assertTrue(coursesPage.checkCoursesPreviewsContainExpectedText(professorName));

    }
}
