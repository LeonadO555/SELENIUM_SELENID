package tests.e2e;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import enums.UserEmails;
import org.testng.annotations.Test;
import pages.CourseDeatailsPage;
import pages.CourseListPage;
import pages.HomePage;
import pages.LoginPage;
import tests.TestBase;


public class TeacherCanUploadCourseMaterialAndStudentCanDownLoadIt extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    CourseDeatailsPage courseDeatailsPage;
    CourseListPage courseListPage;
    Faker faker = new Faker();

    String facultyName = "Enjoy QA with Selenide";
    String courseName = "Selenium framework";
    String link = "qa_aa5c466a.txt";
    String txtDoc = "C:\\work\\GraduationProject\\SELENIUM_SELENID\\src\\test\\java\\files\\qa.txt";

    @Test
    public void teacherUploadCourseMaterial() {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.TEACHER_BORIS_RISKER, homePage.getDefaultPassword());
        homePage.avatarButton.should(Condition.visible);
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
        courseDeatailsPage.getUploadCourseMaterialTitle().shouldBe(Condition.visible);
        courseDeatailsPage.uploadCourseMaterial(faker.name().title(), txtDoc);
        courseDeatailsPage.getSearchBox().sendKeys("Selenium");
        courseDeatailsPage.checkExistingDocument("Selenium");

    }

    @Test
    public void studentCanViewDocumentsAndDownLoadIt() throws InterruptedException {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.login(UserEmails.STUDENT_ANNA_BELOVA, homePage.getDefaultPassword());
        homePage.avatarButton.should(Condition.visible);
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
        courseDeatailsPage.getCourseMaterialSection().shouldBe(Condition.visible);
        courseDeatailsPage.getSearchBox().sendKeys(courseName);
        courseDeatailsPage.clickOnSelectedDocument(link);

    }


}
