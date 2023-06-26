package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends PageBase{
    private SelenideElement courseList = $x("//*[@class='list-container']");
    private ElementsCollection courseTitles = $$x("//div[@class='MuiBox-root css-0']//h3");
    private SelenideElement goToButton = $x("//*//a[@type='button']");
    private SelenideElement teacherSpotlightNonLoggedIn = $x("//*[@id='teacher-spotlight-non-logged-in']");
    private SelenideElement AddCourseButton = $x("//span[normalize-space()='Add course']");
    private SelenideElement CourrsesDropDownMenu = $x("//span[normalize-space()='Add course']");
    private SelenideElement courseListButton = $x("//div[@class='MuiBox-root css-0']//a[@role='menuitem']");


}
