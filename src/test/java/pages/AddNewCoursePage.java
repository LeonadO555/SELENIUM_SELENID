package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class AddNewCoursePage extends PageBase{
    private SelenideElement addNewCourseTable = $x("//div[@class='MuiGrid-root MuiGrid-container css-t7lb4m']");
    private SelenideElement courseNameInput = $x("//input[@id='course-documents-form-CourseName--1078269106']");
    private SelenideElement facultyInput = $x("//div[@id='course-documents-form-Faculty-1389247778']");
    private SelenideElement courseDescriptionField = $x("//textarea[@id='course-documents-form-Description-1634506682']");
    private SelenideElement coverPhotoForm = $x("//input[@id='course-documents-form-CoverPhoto-1704715303']");
    private SelenideElement courseStartDate = $x("//input[@id='course-documents-form-Startdate-831849774']");
    private SelenideElement courseEndDate = $x("//input[@id='course-documents-form-Enddate-1271684309']");
    private SelenideElement addButton = $x("//input[@id='course-documents-form-Enddate-1271684309']");

    public void addNewCourse(String courseName, String facultyName, String courseDescription, String photoLink, String courseStart, String courseEnd){
        courseNameInput.sendKeys(courseName);
        facultyInput.sendKeys(facultyName);
        courseDescriptionField.sendKeys(courseDescription);
        coverPhotoForm.click(); //Как выбрать фото
        courseStartDate.sendKeys(courseStart);
        courseEndDate.sendKeys(courseEnd);
        addButton.click();
    }

}
