package tests.e2e;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
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

    @Test
    public void teacherUploadCourseMaterial() throws InterruptedException {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.getTeacherLogIn();
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        courseDeatailsPage.getUploadCourseMaterialTitle().shouldBe(Condition.visible);
        courseDeatailsPage.uploadCourseMaterial(faker.name().title());
        courseDeatailsPage.getSearchBox().sendKeys("Selenium");
        courseDeatailsPage.checkExistingDocument("Selenium");

    }

    @Test
    public void studentCanViewDocumentsAndDownLoadIt() throws InterruptedException {
        homePage = new HomePage();
        homePage.signInButton.click();
        loginPage = new LoginPage();
        loginPage.getLoginTable().shouldBe(Condition.visible);
        loginPage.getStudentLogIn();
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        courseDeatailsPage.getCourseMaterialSection().shouldBe(Condition.visible);
        courseDeatailsPage.getSearchBox().sendKeys(courseName);
        courseDeatailsPage.clickOnSelectedDocument(link);

    }


}
