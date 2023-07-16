package tests.e2e;

import api.UserApi;
import com.codeborne.selenide.Condition;
import enums.Roles;
import enums.UserEmails;
import enums.UserNames;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfessorSpotlightPage;
import pages.RegistrationPage;
import pages.StudentDirectoryPage;
import tests.TestBase;

public class RegistrationNewUserUITest extends TestBase {
    UserApi userApi;
    RegistrationPage registrationPage;
    HomePage homePage;
    StudentDirectoryPage studentDirectoryPage;
    ProfessorSpotlightPage professorSpotlightPage;

    String studentVasilyListovName = "Vasily Listov";
    String studentAnnaBelovaName = "Anna Belova";
    String studentAnnaBelovaEmail = "tafida6678@eimatro.com";
    String studentVasilyEmail = "ysu80133@zslsz.com";
    String teacherBorisName = "Boris Risker";
    String teacherBorisEmail = "vse23688@omeie.com";
    String invalidPassword = "1234";
    String errorMessage1 = "Please make sure there are no empty required fields";
    String errorMessage2 = "User by given email already exists.";

    @Test
    public void registrationNewUserViaApiCheckViaUIAndDeleteViaApiTest(){
        userApi = new UserApi();
        Response response = userApi.registrationNewUserApi(201);
        String userEmail = response.jsonPath().getString("email");
        String userName = response.jsonPath().getString("full_name");
        homePage = new HomePage();
        homePage.professorsButton.shouldBe(Condition.visible);
        homePage.professorsButton.click();
        professorSpotlightPage = new ProfessorSpotlightPage();
        professorSpotlightPage.professorSpotlightTitle.shouldBe(Condition.visible);
        professorSpotlightPage.checkProfessorTableContainsUserInfo(userName);
        professorSpotlightPage.checkProfessorTableContainsUserInfo(userEmail);
        userApi.deleteExistingUser(userEmail, 200);
        userApi.deleteExistingUser(userEmail, 404);
    }

    @Test
    public void studentRegistrationAndCheckInStudentDirectoryUITest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.userRegistration(Roles.STUDENT , UserNames.STUDENT_ANNA_BELOVA, UserEmails.STUDENT_ANNA_BELOVA, homePage.getDefaultPassword());
        homePage.avatarButton.shouldBe(Condition.visible);
        homePage.studentDirectoryButton.click();
        studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.header.shouldBe(Condition.visible);
        studentDirectoryPage.searchBox.sendKeys(studentAnnaBelovaName);
        studentDirectoryPage.checkStudentTableContainsUserInfo(studentAnnaBelovaName);
        studentDirectoryPage.checkStudentTableContainsUserInfo(studentAnnaBelovaEmail);
    }

    @Test
    public void teacherRegistrationAndCheckInProfessorDirectoryUITest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.userRegistration(Roles.TEACHER , UserNames.TEACHER_BORIS_RISKER, UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        homePage.avatarButton.shouldBe(Condition.visible);
        homePage.professorsButton.click();
        professorSpotlightPage = new ProfessorSpotlightPage();
        professorSpotlightPage.checkProfessorTableContainsUserInfo(teacherBorisName);
        professorSpotlightPage.checkProfessorTableContainsUserInfo(teacherBorisEmail);

    }

    @Test
    public void registrationNewTeacherWithInvalidPasswordDataTest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.userRegistration(Roles.TEACHER,UserNames.TEACHER_NATALI_VOLKOVA, UserEmails.TEACHER_NATALI_VOLKOVA, invalidPassword);
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.checkErrorMessage(errorMessage1);

    }

    @Test
    public void registrationNewStudentWithInvalidDomainDataTest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.userRegistration(Roles.STUDENT,UserNames.STUDENT_KRISTINA_MUNTIAN, UserEmails.INVALID_DOMAIN_EMAIL, homePage.getDefaultPassword());
        registrationPage.singUpTable.shouldBe(Condition.visible);
    }

    @Test
    public void registrationAnExistingTeacherTest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.userRegistration(Roles.TEACHER,UserNames.TEACHER_BORIS_RISKER, UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        registrationPage.singUpTable.shouldBe(Condition.visible);
        registrationPage.checkExistingUserErrorMessage(errorMessage2);
    }


}
