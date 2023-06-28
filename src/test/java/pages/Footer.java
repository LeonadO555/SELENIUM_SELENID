package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Footer extends PageBase{
    HomePage homePage = new HomePage();
    String twitterLink = "https://twitter.com/mycompany";
    String facebookLink = "https://facebook.com/mycompany";
    String instagramLink = "https://instagram.com/mycompany";

    public void checkTwitterLink(){
    homePage.getSocialLinks().findBy(Condition.href(twitterLink)).click();
        switchTo().window(1);
        webdriver().shouldHave(url(twitterLink));
        Selenide.closeWindow();
        switchTo().window(0);
    }

    public void checkFacebookLink(){
        homePage.getSocialLinks().findBy(Condition.href(facebookLink)).click();
        switchTo().window(1);
        webdriver().shouldHave(url(facebookLink));
        Selenide.closeWindow();
        switchTo().window(0);
    }

    public void checkInstagramLink(){
        homePage.getSocialLinks().findBy(Condition.href(instagramLink)).click();
        switchTo().window(1);
        webdriver().shouldHave(url(instagramLink));
        Selenide.closeWindow();
        switchTo().window(0);
    }
}
