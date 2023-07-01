package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends PageBase{
    public NavigationBar(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//a[normalize-space()='']//img")
    protected WebElement toHomePageLogoNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='About Us']")
    protected WebElement aboutUsNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Courses']")
    protected WebElement coursesNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Professors']")
    protected WebElement professorsNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    protected WebElement signInNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Sign up']")
    protected WebElement signUpNavBarButton;

    @FindBy(xpath = "(//button[@type='button'])[1]")
    protected WebElement loggedUserProfileListNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Student Directory']")
    protected WebElement loggedUserStudentDirectoryButton;

    @FindBy(xpath = "//span[normalize-space()='My Profile']")
    protected WebElement loggedUserProfileNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    protected WebElement loggedUserSignOutNavBarButton;

    @FindBy(xpath = "//span[normalize-space()='Course list']")
    protected WebElement loggedUserCourseListButton;

    @FindBy(xpath = "//span[normalize-space()='Add course']")
    protected WebElement professorUserAddCourseButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(toHomePageLogoNavBarButton);
    }

    public void clickToHomePageLogoButton(){
        click(toHomePageLogoNavBarButton);
    }
    public void clickAboutUsNavBarButton(){
        click(aboutUsNavBarButton);
    }
    public void clickCoursesNavBarButton(){
        click(coursesNavBarButton);
    }
    public void clickProfessorsNavBarButton(){
        click(professorsNavBarButton);
    }
    public void clickSignInNavBarButton(){
        click(signInNavBarButton);
    }
    public void clickSignUpNavBarButton(){
        click(signUpNavBarButton);
    }
    public void clickLoggedUserProfileListNavBarButton(){
        click(loggedUserProfileListNavBarButton);
    }
    public void clickLoggedUserStudentDirectoryButton(){
        click(loggedUserStudentDirectoryButton);
    }
    public void clickLoggedUserProfileNavBarButton(){
        click(loggedUserProfileNavBarButton);
    }
    public void clickLoggedUserSignOutNavBarButton(){
        click(loggedUserSignOutNavBarButton);
    }
    public void clickLoggedUserCourseListButton(){
        click(loggedUserCourseListButton);
    }
    public void clickProfessorUserAddCourseButton(){
        click(professorUserAddCourseButton);
    }




}
