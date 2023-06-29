package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IndexCardWithoutAuth {
    ZERO(0),
    ONE(1),
    TWO(2);
    public final int value;
}
