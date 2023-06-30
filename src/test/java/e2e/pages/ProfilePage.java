package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//button[@title='student']")
    protected WebElement choseRoleList;
    @FindBy(xpath = "//input[@id='sw-form-capture-full_name-input']")
    protected WebElement NameField;
    @FindBy(xpath = "//input[@id='sw-form-capture-email-input']")
    protected WebElement EmailField;
    @FindBy(xpath = "//textarea[@id='sw-form-capture-About']")
    protected WebElement AboutUsField;

    @FindBy(xpath = "//input[@type='file']")
    protected WebElement studentPhoto;
    @FindBy(xpath = "//input[@id='sw-form-capture-External Profile URL']")
    protected WebElement linkToWebStudentField;
    @FindBy(xpath = "//input[@id='sw-form-capture-Major']")
    protected WebElement majorField;
    @FindBy(xpath = "//a[@id='sw-update-profile-btn']")
    protected WebElement updateProfileButton;
    @FindBy(xpath = "//input[@id='sw-form-password-input']")
    protected WebElement oldPasswordField;
    @FindBy(xpath = "//input[@id='sw-new-password-input']")
    protected WebElement newPasswordField;
    @FindBy(xpath = "//a[@id='sw-change-password-btn']")
    protected WebElement changePasswordButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(choseRoleList);
    }
    public void selectRole(String nameRole){
        selectOption(nameRole, choseRoleList);
    }
    public void imputeFillName(String nameStudent){
        NameField.sendKeys(nameStudent);
    }
    public void imputeFillEmail(String email){
        EmailField.sendKeys(email);
    }
    public void imputeFillAboutUs(String aboutUs){
        AboutUsField.sendKeys(aboutUs);
    }
    public void imputeFillStudentPhoto(String photoStudentLogo){
        studentPhoto.sendKeys(photoStudentLogo);
    }
    public void imputeFillLinkToWebStudent(String webLink){
        linkToWebStudentField.sendKeys(webLink);
    }
    public void imputeFillMajor(String major){
        majorField.sendKeys(major);
    }
    public void clickUpdateProfileButton(){
        click(updateProfileButton);
    }
    public void imputeFillOldPassword(String oldPassword){
        oldPasswordField.sendKeys(oldPassword);
    }
    public void imputeFillNewPassword(String newPassword){
        newPasswordField.sendKeys(newPassword);
    }
    public void clickChangePasswordButton(){
        click(changePasswordButton);
    }

}
