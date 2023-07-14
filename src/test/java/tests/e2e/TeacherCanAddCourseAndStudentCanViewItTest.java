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
    String facultyName = "Java for QA";
    String courseDescription = "Java ist eine objektorientierte Programmiersprache und eine eingetragene Marke des Unternehmens Sun Microsystems, welches 2010 von Oracle aufgekauft wurde.";
    String courseStart = "7/14/2023";
    String courseEnd = "7/21/2023";
    String txtDoc = "C:\\work\\GraduationProject\\SELENIUM_SELENID\\src\\test\\java\\images\\teacher.jpg";
    String professorName = "Boris Risker";
    @Test
    public void addNewCourseAndCheckByStudentItInCoursesList() throws InterruptedException {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        homePage.avatarButton.shouldBe(Condition.visible);
        homePage.addCourseButton.click();
        addNewCoursePage = new AddNewCoursePage();
        addNewCoursePage.getAddNewCourseTitle().shouldBe(Condition.visible);
        addNewCoursePage.addNewCourse(facultyName, faculty, courseDescription,txtDoc );
        addNewCoursePage.setStartDataInCalendar("14");
        addNewCoursePage.setEndDataInCalendar("21");
        addNewCoursePage.getAddButton().click();
        homePage.getCoursesDropdownMenu().click();
        homePage.getCourseList().click();
        courseListPage = new CourseListPage();
        courseListPage.searchBox.shouldBe(Condition.visible);
        courseListPage.searchCourseByName(facultyName);
        courseListPage.getSearchedFacultyCourseInTable().shouldBe(Condition.visible);

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
        courseDeatailsPage.getProfessorName().shouldHave(Condition.exactText(professorName));
        courseDeatailsPage.getStartDate().shouldHave(Condition.exactText(courseStart));
        courseDeatailsPage.getEndDate().shouldHave(Condition.exactText(courseEnd));

    }



}
