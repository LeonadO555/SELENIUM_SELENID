package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    TEACHER("teacher"),
    STUDENT("student");

    public final String value;
}
