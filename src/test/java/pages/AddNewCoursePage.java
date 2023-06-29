package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AddNewCoursePage extends HomePage{
    private SelenideElement addNewCourseTable = $x("//div[@class='MuiGrid-root MuiGrid-container css-t7lb4m']");
    private SelenideElement courseNameInput = $x("//input[@id='course-documents-form-CourseName--1078269106']");
    private SelenideElement facultyDropdown = $x("//div[@id='course-documents-form-Faculty-1389247778']");
    private SelenideElement courseDescriptionField = $x("//textarea[@id='course-documents-form-Description-1634506682']");
    private SelenideElement coverPhotoForm = $x("//input[@id='course-documents-form-CoverPhoto-1704715303']");
    private SelenideElement courseStartDate = $x("//input[@id='course-documents-form-Startdate-831849774']");
    private SelenideElement courseEndDate = $x("//input[@id='course-documents-form-Enddate-1271684309']");
    private SelenideElement addButton = $x("//input[@id='course-documents-form-Enddate-1271684309']");

    public void selectFaculty(String facultyName) {
        selectOption(facultyName,facultyDropdown);
    }
    public void addNewCourse(String courseName, String facultyName, String courseDescription, String photoLink, String courseStart, String courseEnd, String faculty){
        addNewCourseTable.shouldBe(Condition.visible);
        courseNameInput.sendKeys(courseName);
        selectFaculty(faculty);
        courseDescriptionField.sendKeys(courseDescription);
        coverPhotoForm.sendKeys("images/qa..jpg");
        courseStartDate.sendKeys(courseStart);
        courseEndDate.sendKeys(courseEnd);
        addButton.click();
    }

}
