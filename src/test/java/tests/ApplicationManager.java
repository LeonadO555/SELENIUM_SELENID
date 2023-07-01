package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver driver;

    public WebDriver remoteDriverSelenoid() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserName", "firefox");
        options.setCapability("browserVersion", "114.0.2");
        options.setCapability("enableVNC", true);
        options.setCapability("enableLog", true);

        return new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
    }
    protected void init(boolean useRemoteDriver) throws MalformedURLException {
        if (useRemoteDriver == true) {
            driver = remoteDriverSelenoid();
            System.out.println("Using remote driver (Selenoid)");
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Using local FirefoxDriver");
        }
        driver.get("https://jere237.softr.app/");
        driver.manage().window().setSize(new Dimension(1920,1080));
    }
    protected void stop() {
        driver.quit();
    }
}