package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserNames {
    STUDENT_DIANA_MALIKOVA("Diana Malikova"),
    STUDENT_ANNA_BELOVA("Anna Belova"),
    TEACHER_BORIS_RISKER("Boris Risker"),
    STUDENT_KRISTINA_MUNTIAN("Kristina Muntian"),
    TEACHER_NATALI_VOLKOVA("Natali Volkova");

    public final String value;
    }
