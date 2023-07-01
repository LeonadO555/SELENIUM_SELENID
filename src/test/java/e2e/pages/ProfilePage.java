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
    protected WebElement NameInput;
    @FindBy(xpath = "//input[@id='sw-form-capture-email-input']")
    protected WebElement EmailInput;
    @FindBy(xpath = "//textarea[@id='sw-form-capture-About']")
    protected WebElement AboutUsInput;

    @FindBy(xpath = "//input[@type='file']")
    protected WebElement studentPhoto;
    @FindBy(xpath = "//input[@id='sw-form-capture-External Profile URL']")
    protected WebElement linkToWebStudentInput;
    @FindBy(xpath = "//input[@id='sw-form-capture-Major']")
    protected WebElement majorInput;
    @FindBy(xpath = "//a[@id='sw-update-profile-btn']")
    protected WebElement updateProfileButton;
    @FindBy(xpath = "//input[@id='sw-form-password-input']")
    protected WebElement oldPasswordInput;
    @FindBy(xpath = "//input[@id='sw-new-password-input']")
    protected WebElement newPasswordInput;
    @FindBy(xpath = "//a[@id='sw-change-password-btn']")
    protected WebElement changePasswordButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(choseRoleList);
    }
    public void selectRole(String nameRole){
        selectOption(nameRole, choseRoleList);
    }
    public void fillName(String nameStudent){
        NameInput.sendKeys(nameStudent);
    }
    public void fillEmail(String email){
        EmailInput.sendKeys(email);
    }
    public void fillAboutUs(String aboutUs){
        AboutUsInput.sendKeys(aboutUs);
    }
    public void fillStudentPhoto(String photoStudentLogo){
        studentPhoto.sendKeys(photoStudentLogo);
    }
    public void fillLinkToWebStudent(String webLink){
        linkToWebStudentInput.sendKeys(webLink);
    }
    public void fillMajor(String major){
        majorInput.sendKeys(major);
    }
    public void clickUpdateProfileButton(){
        click(updateProfileButton);
    }
    public void fillOldPassword(String oldPassword){
        oldPasswordInput.sendKeys(oldPassword);
    }
    public void fillNewPassword(String newPassword){
        newPasswordInput.sendKeys(newPassword);
    }
    public void clickChangePasswordButton(){
        click(changePasswordButton);
    }

}
