package pages.teachers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import wait.Wait;

public class AddCoursePage extends HomePage {
    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container css-t7lb4m']")
    protected WebElement addANewCourseForm;

    @FindBy(xpath = "//input[@id='course-documents-form-CourseName--1078269106']")
    protected WebElement courseNameField;

    @FindBy(xpath = "//div[@id='course-documents-form-Faculty-1389247778']")
    protected WebElement facultyDropDown;

    @FindBy(xpath = "//textarea[@id='course-documents-form-Description-1634506682']")
    protected WebElement courseDescriptionField;

    @FindBy(xpath = "//input[@id='course-documents-form-CoverPhoto-1704715303']")
    protected WebElement coverPhotoButton;

    @FindBy(xpath = "//input[@id='course-documents-form-Startdate-831849774']")
    protected WebElement courseStartDateButton;

    @FindBy(xpath = "//input[@id='course-documents-form-Enddate-1271684309']")
    protected WebElement courseEndDateButton;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    protected WebElement addButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(addANewCourseForm);
        wait.forVisibility(courseNameField);
        wait.forVisibility(facultyDropDown);
        wait.forVisibility(courseStartDateButton);
        wait.forVisibility(courseEndDateButton);
        wait.forVisibility(addButton);
    }

    public void fillCourseNameField(String courseName) {
        fillField(courseNameField, courseName);
    }

    // Написать!!!
    public void selectFaculty() {

    }

    public void fillCourseDescriptionField(String description) {
        fillField(courseDescriptionField, description);
    }

    // Написать!!!
    public void selectCourseStartDate() {

    }

    // Написать!!!
    public void selectCourseEndDate() {

    }

    public void clickOnTheAddButton() {
        addButton.click();
    }
}
