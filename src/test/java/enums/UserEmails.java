package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserEmails {
    STUDENT_DIANA_MALIKOVA("hia47833@nezid.com"),
    STUDENT_ANNA_BELOVA("tafida6678@eimatro.com"),
    STUDENT_KRISTINA_MUNTIAN("lolinal129@extemer.com"),
    STUDENT_NONA_SIRBUL("rcl08416@zslsz.com"),
    TEACHER_BORIS_RISKER("vse23688@omeie.com"),
    TEACHER_NATALI_VOLKOVA("rideti7920@fulwark.com"),
    INVALID_DOMAIN_EMAIL("ggcdhzd@brrrr.brrrrrr");

    public final String value;
    }
