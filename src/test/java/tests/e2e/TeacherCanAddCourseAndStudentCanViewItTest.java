package tests.e2e;

import com.codeborne.selenide.Condition;
import enums.UserEmails;
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
    String txtDoc = "C:\\work\\GraduationProject\\SELENIUM_SELENID\\src\\test\\java\\images\\qa..jpg";
    @Test
    public void addNewCourseAndCheckByStudentItInCoursesList(){
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().isDisplayed();
        loginPage.login(UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        homePage.getAddCourseButton().click();
        addNewCoursePage = new AddNewCoursePage();
        addNewCoursePage.getAddNewCourseTable().shouldBe(Condition.visible);
        addNewCoursePage.addNewCourse(facultyName, faculty, courseDescription,txtDoc,courseStart,courseEnd );
        courseDeatailsPage = new CourseDeatailsPage();
        courseDeatailsPage.getReturnHomeButton().shouldBe(Condition.visible);

    }

    @Test
    public void checkNewCourseByStudent()  {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA, homePage.getDefaultPassword());
        homePage.coursesDropdownMenu.shouldBe(Condition.visible);
        homePage.coursesDropdownMenu.click();
        homePage.courseListButton.shouldBe(Condition.visible);
        homePage.courseListButton.click();
        courseListPage = new CourseListPage();
        courseListPage.searchBox.shouldBe(Condition.visible);
        courseListPage.searchCourseByName(facultyName);
        courseListPage.getSearchedFacultyCourseInTable().shouldBe(Condition.visible);
        courseListPage.courseCard.click();
        courseDeatailsPage = new CourseDeatailsPage();
        courseDeatailsPage.getProfessorEmail().shouldHave(Condition.exactText("vse23688@omeie.com"));
        courseDeatailsPage.getStartDate().shouldHave(Condition.exactText(courseStart));
        courseDeatailsPage.getEndDate().shouldHave(Condition.exactText(courseEnd));

    }



}
