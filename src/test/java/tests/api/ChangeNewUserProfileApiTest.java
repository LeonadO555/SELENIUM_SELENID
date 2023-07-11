package tests.api;

import api.ApiBase;
import api.registration.UserApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import tests.TestBase;

public class ChangeNewUserProfileApiTest extends TestBase {
        UserApi userApi;
        LoginPage loginPage;
        HomePage homePage;
        ProfilePage profilePage;
        Faker faker = new Faker();

        WebDriver driver;
        @Test
        public void changeStudentProfileInformationTest(){
            userApi = new UserApi();
            userApi.randomNewUserData();
            Response response = userApi.registrationNewUserApi(201);
            String userEmail = response.jsonPath().getString("email");
            String password = userApi.randomNewUserData().getPassword();

            homePage = new HomePage(driver);
           // homePage.waitForLoading();
            homePage.clickOnSignInButton();
            loginPage = new LoginPage(driver);
            loginPage.waitForLoading();
            loginPage.fillEmailInput(userEmail);
            loginPage.fillPasswordInput(password);
            loginPage.clickOnSignInButton();
            homePage.waitForLoading();


            homePage.clickOUserAvatarButton();
            homePage.clickOnMyProfileButton();
            profilePage = new ProfilePage(app.driver);
            profilePage.waitForLoading();
            profilePage.selectStudentRole();
            profilePage.fillAboutYourself(faker.lorem().sentences(1).toString());
            //  profilePage.fillExternalProfile("https://www.google.com");
            // profilePage.fillMajor("Marketing");
            profilePage.clickOnUpdateProfileButton();
            profilePage.waitSuccessMsgForLoading();
            Assert.assertTrue(profilePage.isSuccessfulButtonPresent());

            userApi.deleteExistingUserApi(userEmail, 200);
            userApi.deleteExistingUserApi(userEmail, 404);

        }


    }

