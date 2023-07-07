package tests.e2e;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;

public class TeacherCanAddCourseAndStudentCanViewItTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AddNewCoursePage addNewCoursePage;
    CourseDeatailsPage courseDeatailsPage;
    CourseListPage courseListPage;

    String faculty = "Engineering";
    String facultyName = "Enjoy QA with Selenide";
    String courseDescription = "Selenide is a framework for test automation powered by Selenium WebDriver that brings the following advantages:\n" +
            "Concise fluent API for tests Stable tests Powerful selectors Simple configuration";
    String courseStart = "August 01 2023";
    String courseEnd = "October 01 2023";
    @Test
    public void addNewCourseAndCheckByStudentItInCoursesList(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().isDisplayed();
        loginPage.getTeacherLogIn();
        homePage.getAddCourseButton().click();
        addNewCoursePage = new AddNewCoursePage();
        addNewCoursePage.getAddNewCourseTable().isDisplayed();
        addNewCoursePage.addNewCourse(facultyName, faculty, courseDescription,courseStart,courseEnd );
        courseDeatailsPage = new CourseDeatailsPage();
        courseDeatailsPage.getReturnHomeButton().isDisplayed();
        homePage.avatarButton.click(); //тест падает на этом этапе. Не могу подобрать корректный локатор
        homePage.getAvatarList().findBy(Condition.exactText("Sign Out")).click();
        loginPage.getLoginTable().isDisplayed();
        loginPage.getStudentLogIn();

    }


}
