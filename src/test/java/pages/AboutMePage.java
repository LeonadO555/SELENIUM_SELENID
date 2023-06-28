package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class AboutMePage extends HomePage{
    public SelenideElement nameTitle = $x("//div[@class='list-field-element MuiBox-root css-1qw4ra5']");
    public SelenideElement userContact = $x("//div[@class='list-field-element MuiBox-root css-1qw4ra5']//div[@class='css-1vykty2']");
    public SelenideElement userRole = $x("//div[@class=\"MuiChip-root MuiChip-filled MuiChip-sizeMedium MuiChip-colorDefault MuiChip-filledDefault tag-item css-191hohl\"]");
    public SelenideElement professorOfTitle = $x("//h2[normalize-space()='Professor of']");
    public SelenideElement backToDirectoryButton = $x("//div[@class='list-field-element MuiBox-root css-gz82tb']//a//span[@class='MuiTouchRipple-root css-w0pj6f']");

}
