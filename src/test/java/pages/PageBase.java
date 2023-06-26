package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class PageBase {
    private SelenideElement menuBlock = $x("//div[@id='home-header-logged-in-teachers']");
    private SelenideElement aboutUsButton = $x("//span[normalize-space()='About Us']");
    private SelenideElement coursesButton = $x("//span[normalize-space()='Courses']");
    private SelenideElement ProfessorsButton = $x("//span[normalize-space()='Professors']");
    private SelenideElement signInButton = $x("//a[@id='sw-sign-in-submit-btn']");
    private SelenideElement signUpButton = $x("//a[@id='sw-go-to-sign-up-btn']");

    private ElementsCollection socialLinks = $$x("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-5 links css-waew46']//a"); //общий локатор для 3х элементов (ссылок)





}
