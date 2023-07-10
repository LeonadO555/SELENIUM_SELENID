package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CourseDeatailsPage extends HomePage{
    private ElementsCollection courseDetails = $$x("//div[@class='MuiGrid-root MuiGrid-container css-1cn3yto']");
    private SelenideElement courseDescription = $x("//div[@class='MuiGrid-root MuiGrid-container css-1cn3yto']");
    private SelenideElement facultyTitle = $x("//h3[normalize-space()='Enjoy QA with Selenide']");
    private SelenideElement startDate = $x("//*[@class=\"MuiBox-root css-0\"]//p");
    private SelenideElement EndDate = $x("(//div[contains(@class,'MuiBox-root css-0')])[6]");
    private SelenideElement professorEmail = $x("//a[contains(@class,'link-field sw-font-size-xl sw-text-color-0146b1 sw-font-family-default sw-font-weight-normal sw-text-align-left sw-letter-spacing-normal sw-padding-top-none sw-padding-bottom-4xs sw-padding-left-none sw-padding-right-none sw-margin-top-none sw-margin-bottom-none')]");
    private SelenideElement courseMaterialSection = $x("//div[@id='course-material-list']//section[1]");
    private SelenideElement searchBox = $x("//input[@id=':r0:']");
    private SelenideElement materialLink = $x("//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 css-1oic8wn']//div[@style='text-align: left;']/a");
    private SelenideElement uploadCourseMaterialTitle = $x("//h3[normalize-space()='Upload course material']");
    private SelenideElement documentNameInput = $x("//input[@id='upload-course-material-form-DocumentName--1971305433']");
    private SelenideElement uploadDocumentField = $x("//input[@id='upload-course-material-form-Document-1880928548']");
    private SelenideElement uploadButton = $x("//input[@id='upload-course-material-form-Document-1880928548']");
    private SelenideElement returnHomeButton = $x("//span[normalize-space()='Return home']");


    public void uploadCourseMaterial(String courseName){
        documentNameInput.sendKeys(courseName);
        uploadDocumentField.sendKeys("files/qa.txt");
        uploadButton.click();

    }



}
