package e2e.pages;

import com.google.inject.spi.StaticInjectionRequest;
import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditRecordCourse extends NavigationBar{
    public EditRecordCourse(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "(//div[contains(@role,'dialog')])[1]")
    protected WebElement editRecordText;
    @FindBy(xpath = "//input[@name='Course Name']")
    protected WebElement courseNameField;
    @FindBy(xpath = "//div[@class='toastui-editor ww-mode']")
    protected WebElement descriptionField;
    @FindBy(xpath = "(//div[contains(@class,'filter-option-inner')])[1]")
    protected WebElement facultyDropDown;
    @FindBy(xpath = "(//input[@type='select-multiple'])[1]")
    protected WebElement teacherField;
    @FindBy(xpath = "(//input[contains(@type,'select-multiple')])[2]")
    protected WebElement documentNameField;
    @FindBy(xpath = "//input[contains(@class,'file-input sw-js-file-input')]")
    protected WebElement uploadFileField;
    @FindBy(xpath = "//input[contains(@name,'Start date')]")
    protected WebElement startData;
    @FindBy(xpath = "//input[@name='End date']")
    protected WebElement endData;
    @FindBy(xpath = "//div[contains(@aria-hidden,'false')]//div//button[contains(@aria-label,'Close this dialog window')]")
    protected WebElement cancelButton;
    @FindBy(xpath = "//div[contains(@category,'List Details')]//footer//button[1]")
    protected WebElement saveButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(editRecordText);
    }
    public void fieldFillCourseName(String courseName){
        courseNameField.sendKeys(courseName);
    }
    public void fieldFillDescription(String description){
        descriptionField.sendKeys(description);
    }
    public void choseFaculty(String faculty){
        selectOption(faculty, facultyDropDown);
    }
    public void fieldTeacher(String nameTeacher){
        teacherField.sendKeys(nameTeacher);
    }
    public void fieldDocumentName(String fileDocuments){
        documentNameField.sendKeys(fileDocuments);
    }
    public void fieldUploadFile(String fileUpload){
        uploadFileField.sendKeys(fileUpload);
    }
    public void fieldStartData(String dataStart){
        startData.sendKeys(dataStart);
    }
    public void fieldEndData(String dataEnd){
        endData.sendKeys(dataEnd);
    }
    public void clickCancelButton(){
        click(cancelButton);
    }
    public void clickSaveButton(){
        click(saveButton);
    }

}
