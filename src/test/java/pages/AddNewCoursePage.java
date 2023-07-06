package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AddNewCoursePage extends HomePage{
    private SelenideElement addNewCourseTable = $x("//div[@class='MuiGrid-root MuiGrid-container css-t7lb4m']");
    private SelenideElement courseNameInput = $x("//input[@id='course-documents-form-CourseName--1078269106']");
    private SelenideElement facultyDropdown = $x("//div[@field=\"Faculty\"]");
    private ElementsCollection facultyList = $$x("//li[@role=\"option\"]");
    private SelenideElement courseDescriptionField = $x("//textarea[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-1ym0rqf\"]");
    private SelenideElement coverPhotoForm = $x("//input[@id='course-documents-form-CoverPhoto-1704715303']");
    private SelenideElement courseStartDate = $x("//input[@id='course-documents-form-Startdate-831849774']");
    private SelenideElement courseEndDate = $x("//input[@id='course-documents-form-Enddate-1271684309']");
    private SelenideElement addButton = $x("//input[@id='course-documents-form-Enddate-1271684309']");

    public void selectFaculty(String facultyName) {
        selectOption(facultyName,facultyDropdown);
    }

    public List<String> getTitles(){return facultyList.texts();}

    public void addNewCourse(String courseName, String faculty, String courseDescription, String courseStart, String courseEnd){
        addNewCourseTable.shouldBe(Condition.visible);
        courseNameInput.sendKeys(courseName);
        facultyDropdown.click();
        facultyList.findBy(Condition.exactText(faculty)).click();
        courseDescriptionField.sendKeys(courseDescription);
        coverPhotoForm.sendKeys("C:\\work\\GraduationProject\\SELENIUM_SELENID\\src\\test\\java\\images\\qa..jpg");
        courseStartDate.sendKeys(courseStart);
        courseEndDate.sendKeys(courseEnd);
        addButton.click();
    }

}
