package e2e.pages;
import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends NavigationBar{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "//header[@id='hero-non-logged-in']//h1[1]")
    protected WebElement welcomeToNoCodeUniversityText;

    @FindBy(xpath = "//a[normalize-space()='Sign up now']")
    protected WebElement signUpNowOnHomePageButton;

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    protected WebElement singInOnHomePageButton;

    @FindBy(xpath = "//body/div/section[@id='about-us']/div/div/div/div[1]")
    protected WebElement aboutUsInfoOnHomePageRow;

    @FindBy(xpath = "//div[@class='row']//div[1]//div[1]")
    protected WebElement firstRowAboutUsInfo;
    @FindBy(xpath = "(//div[contains(@class,'s-feature-box')])[2]")
    protected WebElement secondRowAboutUsInfo;
    @FindBy(xpath = "(//div[contains(@class,'s-feature-box')])[3]")
    protected WebElement thirdRowAboutUsInfo;
    @FindBy(xpath = "(//div[contains(@class,'s-feature-box')])[3]")
    protected WebElement fourthRowAboutUsInfo;

    @FindBy(xpath = "//p[contains(text(),'Check out our courses \uD83D\uDC47')]")
    protected WebElement coursesCheckOutOurCoursesOnHomePageInfo;
    @FindBy(xpath = "(//div)[43]")
    protected WebElement firstCourseOnHomePageInfo;
    @FindBy(xpath = "(//div)[62]")
    protected WebElement secondCourseOnHomePageInfo;
    @FindBy(xpath = "(//div)[85]")
    protected WebElement thirdCourseOnHomePageInfo;
    @FindBy(xpath = "(//span)[9]")
    protected WebElement firstCourseOnHomePageGoToButton;
    @FindBy(xpath = "(//span)[11]")
    protected WebElement secondCourseOnHomePageGoToButton;
    @FindBy(xpath = "(//span)[13]")
    protected WebElement thirdCourseOnHomePageGoToButton;

    @FindBy(xpath = "//span[normalize-space()='Professor spotlight']")
    protected WebElement professorSpotlightOnHomePage;
    @FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 test css-168b4fm')])[1]")
    protected WebElement professorsSpotlightList;
    @FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-8 css-1v86jwt'])[1]")
    protected WebElement professorsSpotlightInfoAboutProfessors;


    public void waitForLoadingWelcomeToNoCodeUniversityText() {
        wait = new Wait(driver);
        wait.forVisibility(welcomeToNoCodeUniversityText);
    }
    public void waitForLoadingAboutUsInfoOnHomePageRow() {
        wait = new Wait(driver);
        wait.forVisibility(aboutUsInfoOnHomePageRow);
    }
    public void waitForLoadingCoursesCheckOutOurCoursesOnHomePageInfo() {
        wait = new Wait(driver);
        wait.forVisibility(coursesCheckOutOurCoursesOnHomePageInfo);
    }
    public void waitForLoadingProfessorSpotlightOnHomePage() {
        wait = new Wait(driver);
        wait.forVisibility(professorSpotlightOnHomePage);
    }

    public void clickSignUpNowOnHomePageButton(){
        click(signUpNowOnHomePageButton);
    }
    public void clickSingInOnHomePageButton(){
        click(singInOnHomePageButton);
    }
    public void clickFirstRowAboutUsInfo(){
        click(firstRowAboutUsInfo);
    }
    public void clickSecondRowAboutUsInfo(){
        click(secondRowAboutUsInfo);
    }
    public void clickThirdRowAboutUsInfo(){
        click(thirdRowAboutUsInfo);
    }
    public void clickFourthRowAboutUsInfo(){
        click(fourthRowAboutUsInfo);
    }
    public void waitForLoadingFirstCourseOnHomePageInfo(){
        wait = new Wait(driver);
        wait.forVisibility(firstCourseOnHomePageInfo);
    }
    public void waitForLoadingSecondCourseOnHomePageInfo(){
        wait = new Wait(driver);
        wait.forVisibility(secondCourseOnHomePageInfo);
    }
    public void waitForLoadingThirdCourseOnHomePageInfo(){
        wait = new Wait(driver);
        wait.forVisibility(thirdCourseOnHomePageInfo);
    }
    public void clickSecondCourseOnHomePageGoToButton(){
        click(firstCourseOnHomePageGoToButton);
    }
    public void clickFirstCourseOnHomePageGoToButton(){
        click(secondCourseOnHomePageGoToButton);
    }
    public void clickThirdCourseOnHomePageGoToButton(){
        click(thirdCourseOnHomePageGoToButton);
    }

}
