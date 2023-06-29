package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class HomePage extends PageBase{
    public SelenideElement courseList = $x("//*[@class='list-container']");
    public ElementsCollection courseTitles = $$x("//div[@class='MuiBox-root css-0']//h3");
    public SelenideElement goToButton = $x("//*[@data-item-index='0']//a");
    public SelenideElement teacherSpotlightNonLoggedIn = $x("//*[@id='teacher-spotlight-non-logged-in']");
    public SelenideElement aboutUsButton = $x("//span[normalize-space()='About Us']");
    public SelenideElement coursesButton = $x("//span[normalize-space()='Courses']");
    public SelenideElement ProfessorsButton = $x("//span[normalize-space()='Professors']");
    public SelenideElement signInButton = $x("//a[@id='sw-sign-in-submit-btn']");
    public SelenideElement signUpButton = $x("//a[@id='sw-go-to-sign-up-btn']");
    public SelenideElement AddCourseButton = $x("//span[normalize-space()='Add course']");
    public SelenideElement CourrsesDropDownMenu = $x("//span[normalize-space()='Add course']");
    public SelenideElement courseListButton = $x("//div[@class='MuiBox-root css-0']//a[@role='menuitem']");
    public SelenideElement viewCoursesButton = $x("//a[normalize-space()='View Courses']");
    public SelenideElement studentDirectoryButton = $x("//span[normalize-space()='Student Directory']");
    public SelenideElement studentDirectoryAboutUsButton = $x("//span[normalize-space()='Student Directory']");
    public SelenideElement avatarButton = $x("//span[normalize-space()='Student Directory']");
    public SelenideElement myProfileButton = $x("//span[normalize-space()='My Profile']");
    public SelenideElement singOutButton = $x("//span[normalize-space()='Sign Out']");


    public WebElement makeBlockLocator(String index){
        return $x("//*[@data-item-index='"+index+"']");
    }
    public void clickOnGoToButton(String index){
        makeBlockLocator(index).findElement(By.xpath("//a[@href='/sign-up?recordId=rec0dPvLYTpfd1jvd']")).click();
    }

}
