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

    String studentName = "Nona Sirbul";
    String teacherName = "Boris Risker";
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
        homePage.avatarButton.isDisplayed();
        homePage.professorsButton.click();
        professorSpotlightPage = new ProfessorSpotlightPage();
        professorSpotlightPage.professorList.findBy(Condition.exactText(userName));
        professorSpotlightPage.professorList.contains(userName);
        userApi.deleteExistingUser(userEmail, 200);
        userApi.deleteExistingUser(userEmail, 404);
    }

    @Test
    public void studentRegustrationAndCheckInStudentDirectoryUITest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.isDisplayed();
        registrationPage.userRegistration(Roles.STUDENT , UserNames.STUDENT_ANNA_BELOVA, UserEmails.STUDENT_ANNA_BELOVA, homePage.getDefaultPassword());
        homePage.avatarButton.isDisplayed();
        homePage.studentDirectoryButton.click();
        studentDirectoryPage = new StudentDirectoryPage();
        studentDirectoryPage.header.isDisplayed();
        studentDirectoryPage.searchBox.sendKeys(studentName);
        studentDirectoryPage.studentList.contains(studentName);
        studentDirectoryPage.studentList.contains(UserEmails.STUDENT_ANNA_BELOVA);
    }

    @Test
    public void teacherRegustrationAndCheckInProfessorDirectoryUITest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.isDisplayed();
        registrationPage.userRegistration(Roles.TEACHER , UserNames.TEACHER_BORIS_RISKER, UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        homePage.avatarButton.isDisplayed();
        homePage.professorsButton.click();
        professorSpotlightPage = new ProfessorSpotlightPage();
        professorSpotlightPage.professorList.findBy(Condition.exactText(teacherName));
        professorSpotlightPage.professorList.contains(teacherName);
        professorSpotlightPage.professorList.contains(UserEmails.TEACHER_BORIS_RISKER);
    }

    @Test
    public void registrationNewTeacherWithInvalidPasswordDataTest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.isDisplayed();
        registrationPage.userRegistration(Roles.TEACHER,UserNames.TEACHER_NATALI_VOLKOVA, UserEmails.TEACHER_NATALI_VOLKOVA, invalidPassword);
        registrationPage.singUpTable.isDisplayed();
        registrationPage.emptyRequiredFieldsMessageBlock.getOwnText().equals(errorMessage1);

    }

    @Test
    public void registrationNewStudentWithInvalidDomainDataTest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.isDisplayed();
        registrationPage.userRegistration(Roles.STUDENT,UserNames.STUDENT_KRISTINA_MUNTIAN, UserEmails.INVALID_DOMAIN_EMAIL, homePage.getDefaultPassword());
        registrationPage.singUpTable.isDisplayed();
        //registrationPage.emptyRequiredFieldsMessageBlock.getOwnText().equals(errorMessage1); // this functional does not work. Was created bug report Defect ID: [2]
    }

    @Test
    public void registrationAnExistingTeacherTest(){
        homePage = new HomePage();
        homePage.signUpButton.click();
        registrationPage = new RegistrationPage();
        registrationPage.singUpTable.isDisplayed();
        registrationPage.userRegistration(Roles.TEACHER,UserNames.TEACHER_BORIS_RISKER, UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        registrationPage.singUpTable.isDisplayed();
        registrationPage.existUserMessageBlock.getOwnText().equals(errorMessage2);
    }


}
