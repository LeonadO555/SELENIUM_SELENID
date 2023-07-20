package tests.e2e.profile;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PageBase;
import pages.ProfilePage;
import tests.TestBase;

public class ChangeExistingUserProfileInformationTest extends TestBase {
    PageBase pageBase;
    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    Faker faker = new Faker();
    String email = "malik@example.com";
    String password = "123456";

    @Test
    public void changeExistingUserProfileInformationTest(){

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickOnSignInButton();
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.clickOnSignInButton();
        homePage.waitForLoading();

        homePage.clickOUserAvatarButton();
        homePage.clickOnMyProfileButton();
        profilePage = new ProfilePage(app.driver);
        profilePage.waitForLoading();
        profilePage.selectStudentRole();
        profilePage.fillAboutYourself(faker.lorem().sentences(1).toString());

        app.driver.getPageSource();
        profilePage.fillExternalProfile("https://www.google.com");
        profilePage.fillMajor("Marketing");

        profilePage.clickOnUpdateProfileButton();
        Assert.assertTrue(profilePage.clickOnUpdateProfileButton());
        profilePage.waitSuccessMsgForLoading();
        Assert.assertTrue(profilePage.isSuccessfulButtonPresent());
    }
}
