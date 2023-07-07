package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class CourseDeatailsPage extends HomePage{
    private ElementsCollection courseDetails = $$x("//div[@class='MuiGrid-root MuiGrid-container css-1cn3yto']");
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
