package pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class HomePage extends PageBase{
    public SelenideElement courseList = $x("//span[normalize-space()='Course list']");
    public ElementsCollection courseTitles = $$x("//div[@class='MuiBox-root css-0']//h3");
    public SelenideElement goToButton = $x("//*[@data-item-index='0']//a");
    public SelenideElement teacherSpotlightNonLoggedIn = $x("//*[@id='teacher-spotlight-non-logged-in']");
    public SelenideElement aboutUsButton = $x("//span[normalize-space()='About Us']");
    public SelenideElement coursesButton = $x("//span[normalize-space()='Courses']");
    public SelenideElement professorsButton = $x("//span[normalize-space()='Professors']");
    public SelenideElement signInButton = $x("//span[@class='MuiBox-root css-jf8tht']");
    public SelenideElement signUpButton = $x("//div/a[@href='/sign-up']");
    public SelenideElement addCourseButton = $x("//div[@class='css-183hjg0']//div");
    public SelenideElement coursesDropdownMenu = $x("//a[@role='button']//*[name()='svg']");
    public SelenideElement courseListButton = $x("//div[@class='MuiBox-root css-0']//a[@href=\"/course-list\"]");
    public SelenideElement viewCoursesButton = $x("//a[normalize-space()='View Courses']");
    public SelenideElement studentDirectoryButton = $x("//span[normalize-space()='Student Directory']");
    public SelenideElement studentDirectoryAboutUsButton = $x("//span[normalize-space()='Student Directory']");
    public SelenideElement avatarButton = $x("//div[@category='Header']//header//div//div//div//button[@type='button']");
    private ElementsCollection avatarList = $$x("//ul[@role=\"menu\"]");
    public SelenideElement myProfileButton = $x("//span[normalize-space()='My Profile']");
    public SelenideElement singOutButton = $x("//span[normalize-space()='Sign Out']");
    public SelenideElement addButton = $x("//button[normalize-space()='Add']");

    public WebElement makeBlockLocator(String index){
        return $x("//*[@data-item-index='"+index+"']");
    }

}
