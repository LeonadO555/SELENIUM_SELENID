package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class ProfilePage extends PageBase{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"profile\"]")
    protected WebElement profileForm;

    @FindBy(xpath = "//div[@class=\"filter-option-inner-inner\"]")
    protected WebElement selectRoleButton;

    @FindBy(xpath = "//a[@id=\"bs-select-1-0\"]")
    protected WebElement selectedTeacher;

    @FindBy(xpath = "//a[@id=\"bs-select-1-1\"]")
    protected WebElement selectedStudent;

    @FindBy(xpath = "//input[@name=\"full_name\"]")
    protected WebElement nameInput;

    @FindBy(xpath = "//input[@name=\"static_email\"]")
    protected WebElement emailInput;

    @FindBy(xpath = "//div//textarea[@name=\"About\"]")
    protected WebElement aboutYourselfInput;

    @FindBy(xpath = "//input[@name=\"External Profile URL\"]")
    protected WebElement externalProfileInput;

    @FindBy(xpath = "//input[@name=\"Major\"]")
    protected WebElement majorInput;

    @FindBy(xpath = "//a[@id=\"sw-update-profile-btn\"]")
    protected WebElement updateProfileButton;

    @FindBy(xpath = "//div[@class=\"change-password\"]")
    protected WebElement changePasswordForm;

    @FindBy(xpath = "//input[@placeholder=\"Old password\"]")
    protected WebElement oldPasswordInput;

    @FindBy(xpath = "//input[@placeholder=\"New password\"]")
    protected WebElement newPasswordInput;

    @FindBy(xpath = "//a[@id=\"sw-change-password-btn\"]")
    protected WebElement changePasswordButton;

    @FindBy(xpath = "//img[@class=\"MuiAvatar-img css-1hy9t21\"]")
    protected WebElement userAvatarButton;

    @FindBy(xpath = "//div[@role='presentation']//a[1]//span[1]")
    protected WebElement signOutButton;

    @FindBy(xpath = "//a[@class=\"navbar-brand\"]")
    protected WebElement logoButton;

    @FindBy(xpath = "//div[@role=\"status\"]")
    protected WebElement successfulUpdateProfileMsg;


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(profileForm);
        wait.forVisibility(selectRoleButton);
        wait.forVisibility(nameInput);
        wait.forVisibility(emailInput);
        wait.forVisibility(aboutYourselfInput);
        wait.forVisibility(externalProfileInput);
        wait.forVisibility(updateProfileButton);
        wait.forVisibility(changePasswordForm);
        wait.forVisibility(oldPasswordInput);
        wait.forVisibility(newPasswordInput);
        wait.forVisibility(changePasswordButton);
        wait.forVisibility(userAvatarButton);
        wait.forVisibility(signOutButton);
        wait.forVisibility(logoButton);
    }

    public void profileUpdatedMsg(){
        wait.forVisibility(successfulUpdateProfileMsg);
    }

    public void clickOnSelectRoleButton(){
        selectRoleButton.click();
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

    public void clickOnLogoButton(){
        logoButton.click();
    }

    public void clickOnUserAvatarButton(){
        userAvatarButton.click();
    }

    public void clickOnSignOutButton(){
        signOutButton.click();
    }


    public void fillNameInput(String text){
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(text);
    }

    public void fillEmailInput(String text){
        emailInput.click();
        aboutYourselfInput.clear();
        emailInput.sendKeys(text);
    }

    public void fillAboutYourselfInput(String text){
        aboutYourselfInput.click();
        aboutYourselfInput.clear();
        aboutYourselfInput.sendKeys(text);
    }

    public void fillExternalProfileInput(String text){
        externalProfileInput.click();
        externalProfileInput.clear();
        externalProfileInput.sendKeys(text);
    }

    public void fillMajorInput(String text){
        majorInput.click();
        majorInput.clear();
        majorInput.sendKeys(text);
    }

    public void fillChangePasswordForm(String text){
        oldPasswordInput.click();
        oldPasswordInput.clear();
        oldPasswordInput.sendKeys(text);
        newPasswordInput.click();
        newPasswordInput.clear();
        newPasswordInput.sendKeys(text);
    }

}
