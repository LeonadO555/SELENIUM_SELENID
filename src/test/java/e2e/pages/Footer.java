package e2e.pages;

import e2e.wait.Wait;
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


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(linkOnKovaliItWeb);
    }
    public void clickLinkOnKoyaliItWeb(){
        click(linkOnKovaliItWeb);
    }
    public void clickLinkOnFaceBook(){
        click(linkOnFaceBook);
    }
    public void clickLinkOnTwitter(){
        click(linkOnTwitter);
    }
    public void clickLinkOnInstagram(){
        click(linkOnInstagram);
    }
}
