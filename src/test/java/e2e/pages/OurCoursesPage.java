package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OurCoursesPage extends PageBase{
    public OurCoursesPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "(//div[contains(@role,'button')])[6]")
    protected WebElement businessSchoolTagListSort;
    @FindBy(xpath = "(//div[contains(@role,'button')])[7]")
    protected WebElement engineeringTagLIstSort;
    @FindBy(xpath = "(//div[contains(@role,'button')])[8]")
    protected WebElement sciencesTagLIstSort;
    @FindBy(xpath = "(//div[contains(@role,'button')])[]")
    protected WebElement medicineTagLIstSort;
    @FindBy(xpath = "(//div[contains(@role,'button')])[10]")
    protected WebElement lawTagLIstSort;
    @FindBy(xpath = "(//input[@id=':r0:'])[1]")
    protected WebElement searchField;
    @FindBy(xpath = "//div[@class='list-container']")
    protected WebElement listAllCourses;
    @FindBy(xpath = "//button[normalize-space()='Discover more']")
    protected WebElement discoverMoreButton;
    @FindBy(xpath = "//a[contains(text(),'Add a course')]")
    protected WebElement addACourseButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(listAllCourses);
    }
    public void clickBusinessSchoolTagListSort(){
        click(businessSchoolTagListSort);
    }
    public void clickEngineeringTagLIstSort(){
        click(engineeringTagLIstSort);
    }
    public void clickSciencesTagLIstSort(){
        click(sciencesTagLIstSort);
    }
    public void clickMedicineTagLIstSort(){
        click(medicineTagLIstSort);
    }
    public void clickLawTagLIstSort(){
        click(lawTagLIstSort);
    }
    public void fillFieldSearchCourses(String nameCourse){
        searchField.sendKeys(nameCourse);
    }
    public void clickDiscoverMoreButton(){
        click(discoverMoreButton);
    }
    public void clickAddACourseButton(){
        click(addACourseButton);
    }

}
