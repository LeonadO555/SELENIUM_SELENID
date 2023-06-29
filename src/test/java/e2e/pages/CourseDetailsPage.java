package e2e.pages;

import e2e.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class CourseDetailsPage extends NavigationBar{
    public CourseDetailsPage(WebDriver driver) {
        super(driver);
    }
    Wait wait;

    @FindBy(xpath = "(//div[@class='MuiBox-root css-0'])[1]")
    protected WebElement nameCourse;
    @FindBy(xpath = "(//div)[38]")
    protected WebElement nameProfessors;
    @FindBy(xpath = "(//div)[45]")
    protected WebElement professorsProfileLink;
    @FindBy(xpath = "(//div)[51]")
    protected WebElement faculty;
    @FindBy(xpath = "(//div)[58]")
    protected WebElement aboutThisCourse;
    @FindBy(xpath = "(//div)[67]")
    protected WebElement startDate;
    @FindBy(xpath = "(//div)[73]")
    protected WebElement endDate;
    @FindBy(xpath = "(//div[contains(@class,'modal-trigger sw-js-details-edit-button-rec1uY1uwJcl4Wgb4')])[1]")
    protected WebElement editCourseButton;

    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(nameCourse);
    }
    public void clickEditCourseButton(){
        click(editCourseButton);
    }

}
