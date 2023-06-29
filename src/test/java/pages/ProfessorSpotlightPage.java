package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import java.util.Collections;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class ProfessorSpotlightPage extends HomePage{
    public SelenideElement professorSpotlightTitle = $x("//span[normalize-space()='Professor spotlight']");
    public SelenideElement searchBox = $x("//input[@id=':r0:']");
    public ElementsCollection professorList = $$x("//body//div[@class='horizontal-list-item']//div[@class='css-1w7j2y6']");
    public ElementsCollection professorRole = $$x("//body//div[@class='horizontal-list-item']//div[@class='css-1w7j2y6']//p");
    public ElementsCollection professorName = $$x("//body//div[@class='horizontal-list-item']//div[@class='css-1w7j2y6']//h3");
    public SelenideElement viewProfileButton = $x("//a[normalize-space()='View profile']");

    public void searchProfessorByName(String userName){
        searchBox.shouldBe(Condition.visible);
        searchBox.sendKeys(userName);

    }

    public void openViewProfile(String userName){
        professorList.findBy(Condition.exactText(userName)).click();
        viewProfileButton.click();
    }



}
