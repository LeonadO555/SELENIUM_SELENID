package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.UserNames;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class StudentDirectoryPage extends HomePage{
    public SelenideElement header = $x("//div[@class='sw-font-family-default sw-letter-spacing-wide sw-line-height-loose']");
    public SelenideElement searchBox = $x("//input[@id=':r0:']");
    public ElementsCollection studentList = $$x("//div[@class='horizontal-list-item']//h3");
    public SelenideElement viewProfileButton = $x("//a[normalize-space()='View profile']");


    public boolean checkStudentTableContainsUserInfo(String info) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getText().equals(info)){
                return true;
            }
        }
        return false;
    }


    public void searchStudentByName(UserNames userName){
        searchBox.shouldBe(Condition.visible);
        searchBox.sendKeys(userName.getValue());
    }

    public void openViewProfile(UserNames userName){
        studentList.findBy(Condition.exactText(userName.getValue())).click();
        viewProfileButton.click();
    }
}
