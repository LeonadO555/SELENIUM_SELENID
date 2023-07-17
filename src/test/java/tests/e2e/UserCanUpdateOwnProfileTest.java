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
    String studentFullName = "Diana Malova";
    String teacherFullName = "Boris Risker";
    String introduce = faker.lorem().characters();
    String externalProfileLink = faker.internet().url();
    String major = "Engineering";
    String studentImg = "C:\\work\\GraduationProject\\SELENIUM_SELENID\\src\\test\\java\\images\\our-students.jpg";
    String teacherImg = "C:\\work\\GraduationProject\\SELENIUM_SELENID\\src\\test\\java\\images\\teacherman.jpg";

    @Test
    public void studentCanUpdateProfile() {
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
        myProfilePage.updateUserProfile(Roles.STUDENT, studentFullName, introduce,studentImg,externalProfileLink,major);

    }

    @Test
    public void teacherCanUpdateProfile() {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        homePage.getAvatarButton().shouldBe(Condition.visible);
        homePage.getAvatarButton().click();
        homePage.getAvatarList().get(0).click();
        myProfilePage = new MyProfilePage();
        myProfilePage.fullNameInput.shouldBe(Condition.visible);
        myProfilePage.tellMeAboutYourselfTitle.shouldBe(Condition.visible);
        myProfilePage.updateUserProfile(Roles.TEACHER, teacherFullName ,introduce, teacherImg, externalProfileLink,major);

    }
}
