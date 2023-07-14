package tests.e2e;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import enums.Roles;
import enums.UserEmails;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;
import tests.TestBase;

public class UserCanUpdateOwnProfileTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    MyProfilePage myProfilePage;
    Faker faker = new Faker();
    String fullName = "Diana Malova";
    String email = faker.internet().emailAddress();
    String introduce = faker.internet().emailAddress();
    String externalProfileLink = faker.internet().url();
    String major = "Engineering";

    @Test
    public void userCanUpdateProfile() {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_DIANA_MALIKOVA, homePage.getDefaultPassword());
        homePage.getAvatarButton().shouldBe(Condition.visible);
        homePage.getAvatarButton().click();
        homePage.getAvatarList().get(0).click();
        myProfilePage = new MyProfilePage();
        myProfilePage.fullNameInput.shouldBe(Condition.visible);
        myProfilePage.tellMeAboutYourselfTitle.shouldBe(Condition.visible);
        myProfilePage.updateUserProfile(Roles.STUDENT, fullName, email, introduce,externalProfileLink,major);

    }
}
