package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.SocialLinks;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Footer extends PageBase{
    HomePage homePage = new HomePage();

    public void goToWebsite(String link){
        homePage.getSocialLinks().findBy(Condition.href(link)).click();
        switchTo().window(1);
        webdriver().shouldHave(url(link));
    }
    public void closeWebsite(){
        Selenide.closeWindow();
        switchTo().window(0);
    }

}
