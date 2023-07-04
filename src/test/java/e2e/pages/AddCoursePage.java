package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCoursePage extends PageBase{
    public AddCoursePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//div[@field='Course Name']")
    protected WebElement courseNameInput;

    @FindBy(xpath = "//div[@field='Faculty']")
    protected WebElement facultyDropdown;

    @FindBy(xpath = "//div[@field='Description']")
    protected WebElement courseDescriptionInput;

    @FindBy(xpath = "(//input[@id='course-documents-form-CoverPhoto-1704715303'])[1]")
    protected WebElement coverImageInput;

    @FindBy(xpath = "//div[@field='Start date']")
    protected WebElement courseStartDateInput;

    @FindBy(xpath = "//div[@field='End date']")
    protected WebElement courseEndDateInput;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    protected WebElement addButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(courseNameInput);
        wait.forVisibility(facultyDropdown);
        wait.forVisibility(courseDescriptionInput);
        wait.forVisibility(courseStartDateInput);
        wait.forVisibility(courseEndDateInput);
        wait.forVisibility(addButton);
    }
    public void fillName(String courseName){
        courseNameInput.sendKeys(courseName);
    }
    public void selectFaculty(String faculty){
        selectOption(faculty, facultyDropdown);
    }
    public void fillDescription(String descriptionInfo){
        courseDescriptionInput.sendKeys(descriptionInfo);
    }
    public void uploadCoverImage(String photo){
        coverImageInput.sendKeys(photo);
    }
    public void fillStartDate(String startData){
        courseStartDateInput.sendKeys(startData);
    }
    public void fillEndDate(String endData){
        courseEndDateInput.sendKeys(endData);
    }
    public void clickAddButton(){
        click(addButton);
    }
}

