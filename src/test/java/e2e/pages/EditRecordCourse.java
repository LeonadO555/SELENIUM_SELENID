package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditRecordCourse extends AddCoursePage{
    public EditRecordCourse(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "'(//div[contains(@ROLE,'dialog')])[1]' remove [1]")
    protected WebElement editDialog;
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
    @FindBy(xpath = "//*[@id='course-list-modal-rec0dPvLYTpfd1jvd']//footer/button[1]")
    protected WebElement cancelButton;
    @FindBy(xpath = "//div[contains(@category,'List Details')]//footer//button[1]")
    protected WebElement saveButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(editDialog);

    }

    public void clickCancelButton(){
        click(cancelButton);
    }
    public void clickSaveButton(){
        click(saveButton);
    }

}
