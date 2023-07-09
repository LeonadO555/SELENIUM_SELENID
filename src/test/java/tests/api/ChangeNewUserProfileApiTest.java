package tests.api;

import api.ApiBase;
import api.registration.UserApi;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class ChangeNewUserProfileApiTest extends ApiBase {
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
            loginPage = new LoginPage(driver);
            homePage = new HomePage(driver);
            homePage.waitForLoading();

            homePage.clickOUserAvatarButton();
            homePage.clickOnMyProfileButton();
            profilePage = new ProfilePage(driver);
            profilePage.waitForLoading();
            profilePage.selectStudentRole();
            profilePage.fillAboutYourself(faker.lorem().sentences(4).toString());
            profilePage.fillExternalProfile(faker.internet().url());
            profilePage.fillMajor("Marketing");
            profilePage.clickOnUpdateProfileButton();
            profilePage.isSuccessfulButtonPresent(By.xpath("//div[@role='status']"));

            userApi.deleteExistingUserApi(userEmail, 200);
            userApi.deleteExistingUserApi(userEmail, 404);

        }


    }

