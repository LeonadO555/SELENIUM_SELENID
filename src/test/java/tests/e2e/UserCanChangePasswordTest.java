package tests.e2e;

import com.codeborne.selenide.Condition;
import enums.UserEmails;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyProfilePage;
import tests.TestBase;

public class UserCanChangePasswordTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    MyProfilePage myProfilePage;
    String oldPassword = "123456";
    String newPassword = "1234567";

    @Test
    public void userCanChangePassword(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA, oldPassword );
        homePage.professorsButton.shouldBe(Condition.visible);
        homePage.getAvatarButton().click();
        homePage.getAvatarList().get(0).click();
        myProfilePage = new MyProfilePage();
        myProfilePage.changePasswordTitle.shouldBe(Condition.visible);
        myProfilePage.changePassword(oldPassword, newPassword);
        homePage.getAvatarButton().click();
        homePage.singOutButton.click();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA, newPassword);
        homePage.avatarButton.should(Condition.visible);
        homePage.getAvatarButton().click();
        homePage.getAvatarList().get(0).click();
        myProfilePage = new MyProfilePage();
        myProfilePage.changePasswordTitle.shouldBe(Condition.visible);
        myProfilePage.changePassword(newPassword, oldPassword);
        homePage.getAvatarButton().click();
        homePage.singOutButton.click();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA, oldPassword);

    }
}
