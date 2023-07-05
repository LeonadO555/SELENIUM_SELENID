package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wait.Wait;

public class MainPage extends PageBase{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy (xpath = "//a[contains(text(),'Sign in')]")
    protected WebElement signInButton;

    @FindBy (xpath = "//a[contains(text(),'Sign up ')]")
    protected WebElement signUpButton;

    @FindBy (xpath = "//span[normalize-space()='About Us']")
    protected WebElement aboutUsTab;

    @FindBy (xpath = "//span[normalize-space()='Courses']")
    protected WebElement coursesTab;

    @FindBy (xpath = "//span[normalize-space()='Professors']")
    protected WebElement professorsTab;

    @FindBy (xpath = "//img[@class='sw-width-5xs']")
    protected WebElement logoButton;

    @FindBy (xpath = "(//h1[normalize-space()=\"Welcome to NoCode University's Student Portal\"])[1]")
    protected WebElement welcomeToNoCodeTitle;

    @FindBy (xpath = "//a[normalize-space()='Sign up now']")
    protected WebElement SignUpNowButton;

    public void waitForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(logoButton);
        //wait.forInvisibility(signInButton);
        wait.forVisibility(signUpButton);
        wait.forVisibility(aboutUsTab);
        wait.forVisibility(coursesTab);
        wait.forVisibility(professorsTab);
        wait.forVisibility(welcomeToNoCodeTitle);
    }

    public void clickOnSingInButton() {
        click(signInButton);
    }

    public void clickOnSingUpButton() {
        click(signUpButton);
    }

    public void clickOnAboutUsTab() {
        click(aboutUsTab);
    }

    public void clickOnCoursesTab() {
        click(coursesTab);
    }

    public void clickOnProfessorsTab() {
        click(professorsTab);
    }

    public void clickOnLogoButton() {
        click(logoButton);
    }

}
