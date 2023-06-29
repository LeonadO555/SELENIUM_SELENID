package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCoursePage extends NavigationBar{
    public AddCoursePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//div[@field='Course Name']")
    protected WebElement courseNameField;

    @FindBy(xpath = "//div[@field='Faculty']")
    protected WebElement facultyRow;

    @FindBy(xpath = "//div[@field='Description']")
    protected WebElement courseDescriptionField;

    @FindBy(xpath = "(//input[@id='course-documents-form-CoverPhoto-1704715303'])[1]")
    protected WebElement coverPhoto;

    @FindBy(xpath = "//div[@field='Start date']")
    protected WebElement courseStartData;

    @FindBy(xpath = "//div[@field='End date']")
    protected WebElement courseEndDate;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    protected WebElement addButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(addButton);
    }
    public void fieldFillCourseName(String courseName){
        courseNameField.sendKeys(courseName);
    }
    public void choseFacultyRow(String faculty){
        selectOption(faculty, facultyRow);
    }
    public void fieldFillCourseDescription(String descriptionInfo){
        courseDescriptionField.sendKeys(descriptionInfo);
    }
    public void fieldFillCoverPhoto(String photo){
        coverPhoto.sendKeys(photo);
    }
    public void fieldFillCourseStartData(String startData){
        courseStartData.sendKeys(startData);
    }
    public void fieldFillCourseEndData(String endData){
        courseEndDate.sendKeys(endData);
    }
    public void clickAddButton(){
        click(addButton);
    }
}

