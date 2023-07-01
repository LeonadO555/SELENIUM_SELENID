package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends PageBase{
    public Footer(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "//a[normalize-space()='Koval IT.']")
    protected WebElement linkOnKovaliItWeb;

    @FindBy(xpath = "//i[@class='fab fa-facebook-f']")
    protected WebElement linkOnFaceBook;

    @FindBy(xpath = "//i[@class='fab fa-twitter']")
    protected WebElement linkOnTwitter;

    @FindBy(xpath = "//i[@class='fab fa-instagram']")
    protected WebElement linkOnInstagram;


    public class ScrollUtils {
        public static void scrollToElement(WebDriver driver, WebElement element)
        { JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth',block: 'center'});",
                    element);
        }
    }
    public void openLinkOnKoyaliItWeb(){
        click(linkOnKovaliItWeb);
    }
    public void openLinkOnFaceBook(){
        click(linkOnFaceBook);
    }
    public void openLinkOnTwitter(){
        click(linkOnTwitter);
    }
    public void openLinkOnInstagram(){
        click(linkOnInstagram);
    }
}
