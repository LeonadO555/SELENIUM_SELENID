package e2e.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EndPoint {
    BUSINESS_SCHOOL("(//div[contains(@role,'button')])[6]"),
    ENGINEERING("(//div[contains(@role,'button')])[7]"),
    SCIENCES("(//div[contains(@role,'button')])[8]"),
    MEDICINE("(//div[contains(@role,'button')])[]");
    private final String value;


}
