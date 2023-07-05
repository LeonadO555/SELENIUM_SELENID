package pages.teachers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import wait.Wait;

public class MyProfileTeachersPage extends MainPage {

    public MyProfileTeachersPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy (xpath = "//div[@class='form-box sw-background-color-ffffff sw-border-style-none sw-border-width-none sw-border-color-eaeced sw-border-radius-2xl sw-box-shadow-none ']")
    protected WebElement profileEditeForm;

    @FindBy(xpath = "//div[@class='dropdown-menu']")
    protected WebElement roleDropDownMenu;

    @FindBy(xpath = "//input[@id='sw-form-capture-full_name-input']")
    protected WebElement nameField;

    @FindBy(xpath = "//div[@class='sw-js-signup-fields']//div[3]")
    protected WebElement emailField;

    @FindBy(xpath = "//textarea[@id='sw-form-capture-About']")
    protected WebElement aboutField;

    @FindBy(xpath = "//input[@type='file']")
    protected WebElement avatarUploadButton;

    @FindBy(xpath = "//input[@id='sw-form-capture-External Profile URL']")
    protected WebElement linkOfExternalProfileField;

    @FindBy (xpath = "//input[@id='sw-form-capture-Major']")
    protected WebElement majorField;

    @FindBy (xpath = "//a[@id='sw-update-profile-btn']")
    protected WebElement updateProfileButton;

    @FindBy (xpath = "//input[@id='sw-form-password-input']")
    protected WebElement oldPasswordField;

    @FindBy (xpath = "//input[@id='sw-new-password-input']")
    protected WebElement newPasswordField;

    @FindBy (xpath = "//a[@id='sw-change-password-btn']")
    protected WebElement changePasswordButton;

    public void changeName(String newName) {
        nameField.clear();
        fillField(nameField, newName);
    }

    public void changeAboutInformation(String newText) {
        aboutField.clear();
        fillField(aboutField, newText);
    }

    public void clickOnUpdateProfileButton() {
        updateProfileButton.click();
    }

}
