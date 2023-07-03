package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class ProfilePage extends HomePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='profile']")
    protected WebElement profileForm;

    @FindBy(xpath = "//div[@class='filter-option-inner-inner']")
    protected WebElement selectRoleButton;

    @FindBy(xpath = "//a[@id='bs-select-1-0']")
    protected WebElement selectedTeacher;

    @FindBy(xpath = "//a[@id='bs-select-1-1']")
    protected WebElement selectedStudent;

    @FindBy(xpath = "//input[@name='full_name']")
    protected WebElement nameInput;

    @FindBy(xpath = "//input[@name='static_email']")
    protected WebElement emailInput;

    @FindBy(xpath = "//div//textarea[@name='About']")
    protected WebElement aboutYourselfInput;

    @FindBy(xpath = "//input[@name='External Profile URL']")
    protected WebElement externalProfileInput;

    @FindBy(xpath = "//input[@name='Major']")
    protected WebElement majorInput;

    @FindBy(xpath = "//a[@id='sw-update-profile-btn']")
    protected WebElement updateProfileButton;

    @FindBy(xpath = "//div[@class='change-password']")
    protected WebElement changePasswordForm;

    @FindBy(xpath = "//input[@placeholder='Old password']")
    protected WebElement oldPasswordInput;

    @FindBy(xpath = "//input[@placeholder='New password']")
    protected WebElement newPasswordInput;

    @FindBy(xpath = "//a[@id='sw-change-password-btn']")
    protected WebElement changePasswordButton;

    @FindBy(xpath = "//div[@role='status']")
    protected WebElement successfulUpdateProfileMsg;


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(profileForm);
        wait.forVisibility(selectRoleButton);
        wait.forVisibility(nameInput);
        wait.forVisibility(emailInput);
        wait.forVisibility(aboutYourselfInput);
        wait.forVisibility(userAvatarButton);
        wait.forVisibility(logoButton);
    }
    

    public void selectTeacherRole(){
        selectRoleButton.click();
        click(selectedTeacher);
    }

    public void selectStudentRole(){
        selectRoleButton.click();
        click(selectedStudent);
    }

    public void clickOnSelectedTeacher(){
        selectedTeacher.click();
    }

    public void clickOnUpdateProfileButton(){
        updateProfileButton.click();
    }

    public void clickOnChangePasswordButton(){
        changePasswordButton.click();
    }


    public void fillName(String text){
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(text);
    }

    public void fillEmail(String text){
        emailInput.click();
        aboutYourselfInput.clear();
        emailInput.sendKeys(text);
    }

    public void fillAboutYourself(String text){
        aboutYourselfInput.click();
        aboutYourselfInput.clear();
        aboutYourselfInput.sendKeys(text);
    }

    public void fillExternalProfile(String text){
        externalProfileInput.click();
        externalProfileInput.clear();
        externalProfileInput.sendKeys(text);
    }

    public void fillMajor(String text){
        majorInput.click();
        majorInput.clear();
        majorInput.sendKeys(text);
    }

    public void fillOldPassword(String text) {
        oldPasswordInput.click();
        oldPasswordInput.clear();
        oldPasswordInput.sendKeys(text);
    }

    public void fillNewPassword(String text) {
        newPasswordInput.click();
        newPasswordInput.clear();
        newPasswordInput.sendKeys(text);
    }

    public boolean isSuccessfulButtonPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}
