package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StudentDirectoryPage extends PageBase{
    private SelenideElement header = $x("//div[@class='sw-font-family-default sw-letter-spacing-wide sw-line-height-loose']");
    private SelenideElement searchBox = $x("//input[@id=':r0:']");

}
