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
    STUDENT_NONA_SIRBUL("Nona Sirbul"),
    STUDENT_LOLA_ZERNOVA("Lola Zernova"),
    STUDENT_VASILY_LISTOV("Vasily Listov"),
    TEACHER_NATALI_VOLKOVA("Natali Volkova");

    public final String value;
    }
