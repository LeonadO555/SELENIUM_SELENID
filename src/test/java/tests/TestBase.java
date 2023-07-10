package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestBase {
    @BeforeMethod
    public void setUp(){
        Configuration.browserCapabilities = new ChromeOptions().addArguments("-remote-allow-origins=*");
        open("https://jere237.softr.app");
        getWebDriver().manage().window().maximize();
    }


    @AfterMethod
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}


