package tests.e2e;

import com.codeborne.selenide.Condition;
import enums.UserEmails;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfessorSpotlightPage;
import pages.StudentDirectoryPage;
import tests.TestBase;

public class UserLogInTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    ProfessorSpotlightPage professorSpotlightPage;

    @Test
    public void teacherSuccessfullyLogIn(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.TEACHER_BORIS_RISKER);
        homePage.avatarButton.shouldBe(Condition.visible);
    }

    @Test
    public void studentSuccessfullyLogIn(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA);
        homePage = new HomePage();
        homePage.avatarButton.shouldBe(Condition.visible);
    }


}
