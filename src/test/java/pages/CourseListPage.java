package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;


import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CourseListPage extends HomePage{
    public SelenideElement searchBox = $x("//input[@id=':r0:']");
    public SelenideElement courseListTitle = $x("//h1[normalize-space()='Our courses']");
    public ElementsCollection courseCarts = $$x("//*[@class=\"list-container\"]");
    public ElementsCollection courseTitles = $$x("//*[@class=\"list-container\"]//h3");
    public SelenideElement courseCard = $x("//*[@class=\"list-action-wrapper\"]//a");
    public SelenideElement searchedFacultyCourseInTable = $x("//*[@class=\"MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 clickable css-isbt42\"]//h3[contains(text(),\"Enjoy QA with Selenide\")]");

    //this method with such locator does not work .
    public void checkCourseIsVisible(String facultyName){
        $x("//*[@class=\"MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 clickable css-isbt42\"]//*[contains(text(),"+ facultyName +")]").shouldBe(Condition.visible);
    }

    public void searchCourseByName(String name){
        searchBox.shouldBe(Condition.visible);
        searchBox.sendKeys(name);
    }





}
