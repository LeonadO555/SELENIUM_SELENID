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
    private SelenideElement addNewCourseTable = $x("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-8 MuiGrid-grid-lg-6 form-holder css-1ea2flx']");
    private SelenideElement addNewCourseTitle = $x("//h2[normalize-space()='Add a new course']");
    private SelenideElement courseNameInput = $x("//input[@id='course-documents-form-CourseName--1078269106']");
    private SelenideElement facultyDropdown = $x("//div[@field=\"Faculty\"]");
    private ElementsCollection facultyList = $$x("//li[@role=\"option\"]");
    private SelenideElement courseDescriptionField = $x("//textarea[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline css-1ym0rqf\"]");
    private SelenideElement coverPhotoForm = $x("//input[@id='course-documents-form-CoverPhoto-1704715303']");
    private SelenideElement courseStartDate = $x("//input[@id='course-documents-form-Startdate-831849774']");
    private SelenideElement courseEndDate = $x("//input[@id='course-documents-form-Enddate-1271684309']");
    private SelenideElement addButton = $x("//button[normalize-space()='Add']");
    private ElementsCollection calendarData = $$x("//div[@class='rdrDays']");

    public void selectFaculty(String facultyName) {
        selectOption(facultyName,facultyDropdown);
    }


    public void fillFields(String courseName, String faculty, String courseDescription, String txtDoc){
        addNewCourseTitle.shouldBe(Condition.visible);
        courseNameInput.sendKeys(courseName);
        facultyDropdown.click();
        facultyList.findBy(Condition.exactText(faculty)).click();
        courseDescriptionField.sendKeys(courseDescription);
        coverPhotoForm.sendKeys(txtDoc);
    }

    public void setStartDataInCalendar( String data) {
        courseStartDate.click();
        $x(("//div[@class='rdrMonth']//*[contains(text(),"+ data +")]")).click();
    }

    public void setEndDataInCalendar( String data) {
        courseEndDate.click();
        $x(("//div[@class='rdrMonth']//*[contains(text(),"+ data +")]")).click();
    }

}
