package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.Roles;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class MyProfilePage extends HomePage{
    public SelenideElement tellMeAboutYourselfTitle = $x("//h2[normalize-space()='Please tell us more about yourself']");
    public SelenideElement roleDropdown = $x("//select[@title='Select your role']");
    public SelenideElement teacherRole = $x("//span[normalize-space()='teacher']");
    public SelenideElement studentRole = $x("//span[normalize-space()='student']");
    public SelenideElement fullNameInput = $x("//input[@id='sw-form-capture-full_name-input']");
    public SelenideElement emailInput = $x("//input[@id='sw-form-capture-full_name-input']");
    public SelenideElement aboutMeInput = $x("//textarea[@id='sw-form-capture-About']");
    public SelenideElement avatarImageInput = $x("//input[@type='file']");
    public SelenideElement externalProfileLinkInput = $x("//input[@id='sw-form-capture-External Profile URL']");
    public SelenideElement majorInput = $x("//input[@id='sw-form-capture-Major']");
    public SelenideElement updateProfileButton = $x("//*[@id=\"sw-update-profile-btn\"]");
    public SelenideElement changePasswordTitle = $x("//h2[normalize-space()='Change password']");
    public SelenideElement oldPasswordInput = $x("//input[@id='sw-form-password-input']");
    public SelenideElement newPasswordInput = $x("//input[@id='sw-new-password-input']");
    public SelenideElement changePasswordButton = $x("//a[@id='sw-change-password-btn']");


    public void updateUserProfile(Roles role, String userName, String userEmail, String description, String externalProfileLink, String majorIn ){
        selectRole(role,roleDropdown);
        fullNameInput.clear();
        fullNameInput.sendKeys(userName);
        emailInput.clear();
        emailInput.sendKeys(userEmail);
        aboutMeInput.clear();
        aboutMeInput.sendKeys(description);
       // avatarImageInput.sendKeys("images/teacher.jpg"); this functional does not work. Was created bug report Defect ID: [12]
        externalProfileLinkInput.clear();
        externalProfileLinkInput.sendKeys(externalProfileLink);
        majorInput.clear();
        majorInput.sendKeys(majorIn);
        updateProfileButton.click();
    }

    public void changePassword(String oldPassword, String newPassword){
        changePasswordTitle.shouldBe(Condition.visible);
        oldPasswordInput.sendKeys(oldPassword);
        newPasswordInput.sendKeys(newPassword);
        changePasswordButton.click();
    }

}
