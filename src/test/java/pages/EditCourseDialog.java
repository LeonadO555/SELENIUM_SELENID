package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

@Getter
public class EditCourseDialog extends HomePage{
    public SelenideElement editTitle = $x("//h2[@id='course-details-modal-rec2dBNr4rcB2StDM-title']");
    public SelenideElement courseNameInput = $x("//input[@name='Course Name']");
    public SelenideElement descriptionInput = $x("//div[@class='ProseMirror toastui-editor-contents']");
    public SelenideElement saveButton = $x("//button[@id='course-details-modal-save-rec2dBNr4rcB2StDM']");

    public void editExistingCourse(String newCourseName, String newDescription){
        editTitle.shouldBe(Condition.visible);
        courseNameInput.sendKeys(newCourseName);
        descriptionInput.sendKeys(newDescription);
        saveButton.click();
    }

}
