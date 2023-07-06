package tests.e2e;

import org.testng.annotations.Test;
import pages.AddNewCoursePage;
import pages.CourseListPage;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;

public class TeacherCanAddCourseAndStudentCanViewItTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AddNewCoursePage addNewCoursePage;
    CourseListPage courseListPage;

    String faculty = "Engineering";
    String facultyName = "Enjoy QA with Selenide";
    String courseDescription = "Selenide is a framework for test automation powered by Selenium WebDriver that brings the following advantages:\n" +
            "Concise fluent API for tests Stable tests Powerful selectors Simple configuration";
    String courseStart = "01.08.2023";
    String courseEnd = "01.10.2023";
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




    }

}
