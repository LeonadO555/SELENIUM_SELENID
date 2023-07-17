package tests.e2e_api;

import api.UserApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.account.CoursesPage;
import pages.account.HomePage;
import tests.TestBase;


public class UserCanViewAllCoursesTest extends TestBase {

    UserApi userApi;
    MainPage mainPage;
    HomePage homePage;
    CoursesPage coursesPage;
    LoginPage loginPage;

    @Test (enabled = false)
    public void userCanViewAllCourses() {
        userApi = new UserApi();
        Response response = userApi.registrationNewUserApi(201);
        String userEmail = response.jsonPath().getString("email");
        String password = userApi.randomUserData().getPassword();

        mainPage = new MainPage(app.driver);
        mainPage.clickOnSingInButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(userEmail, password);

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        // TODO: Test failed because here is bug (ID)
        homePage.goToCoursesPage();

        coursesPage = new CoursesPage(app.driver);
        coursesPage.waitForLoadingCourses();
        coursesPage.clickOnDiscoverMoreButtonIfItIsAvailable();

        Assert.assertTrue(coursesPage.clickOnDiscoverMoreButtonIfItIsAvailable());

        userApi.deleteExistingUser(userEmail, 200);
        userApi.deleteExistingUser(userEmail, 404);
    }

}
