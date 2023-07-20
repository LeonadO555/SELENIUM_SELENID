package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import wait.Wait;

public class ProfilePage extends HomePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='profile']")
    protected WebElement profileForm;

    @FindBy(xpath = "//div[@class='filter-option-inner-inner']")
    protected WebElement selectRoleButton;

    @FindBy(xpath = "//a[@id='bs-select-1-1']")
    protected WebElement selectedStudent;

    @FindBy(xpath = "//input[@name='full_name']")
    protected WebElement nameInput;

    @FindBy(xpath = "//input[@name='static_email']")
    protected WebElement emailInput;

    @FindBy(xpath = "//div//textarea[@name='About']")
    protected WebElement aboutYourselfInput;

    @FindBy(xpath = "//*[@class=\"top-box\"]//*[@id=\"sw-form-capture-External Profile URL\"]")
    protected WebElement externalProfileInput;

    @FindBy(xpath = "//*[@class=\"top-box\"]//*[@id=\"sw-form-capture-Major\"]")
    protected WebElement majorInput;

    @FindBy(xpath = "//*[@class=\"top-box\"]//*[@id=\"sw-update-profile-btn\"]")
    public WebElement updateProfileButton;

    @FindBy(xpath = "//i[@class='fa fa-fw fa-check d-none']")
    protected WebElement successfulUpdateProfileMsg;

    String successMsg = "//i[@class='fa fa-fw fa-check d-none']";


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(profileForm);
        wait.forVisibility(selectRoleButton);
        wait.forVisibility(nameInput);
        wait.forVisibility(emailInput);
        wait.forVisibility(aboutYourselfInput);
        wait.forVisibility(userAvatarButton);
        wait.forVisibility(logoButton);
        wait.forVisibility(externalProfileInput);
    }

    public void waitSuccessMsgForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(successfulUpdateProfileMsg);
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth',block: 'center'});", element);
    }


    public void selectStudentRole(){
        selectRoleButton.click();
        click(selectedStudent);
    }


    public boolean clickOnUpdateProfileButton() {
        scrollToElement(driver, updateProfileButton);
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            try {
                updateProfileButton.click();
                break;
            } catch (ElementNotInteractableException e) {
                flag = false;
            }
        } return flag;
    }


    public void fillAboutYourself(String text){
        aboutYourselfInput.click();
        aboutYourselfInput.clear();
        aboutYourselfInput.sendKeys(text);
    }

    public void fillExternalProfile(String text) {
        scrollToElement(driver, updateProfileButton);
        driver.findElement(By.id("sw-form-capture-External Profile URL"));
        try {
            externalProfileInput.click();
            externalProfileInput.clear();
            externalProfileInput.sendKeys(text);
        } catch ( ElementNotInteractableException e){
            System.out.println("Worked catch");
        }
    }

    public void fillMajor(String text){
        scrollToElement(driver, updateProfileButton);
        try {
            majorInput.click();
            majorInput.clear();
            majorInput.sendKeys(text);
        } catch ( ElementNotInteractableException e){
            System.out.println("Worked catch");
        } finally {
            majorInput.sendKeys(text);
        }
    }

    public boolean isSuccessfulButtonPresent() {
        try {
            driver.findElement(By.xpath(successMsg));
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println("Worked catch");
            return false;
        }
    }

}
