package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;
import wait.Wait;

public class PageBase extends TestBase {
    public WebDriver driver;
    Wait wait;

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element ) {
        element.click();
    }

    public void fillInput(WebElement field, String text) {
        click(field);
        field.clear();
        field.sendKeys(text);
    }
}
