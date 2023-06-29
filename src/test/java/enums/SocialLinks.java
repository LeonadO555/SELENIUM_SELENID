package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SocialLinks {
    TWITTER_LINK("https://twitter.com/mycompany"),
    FACEBOOK_LINK("https://facebook.com/mycompany"),
    INSTAGRAM_LINK("https://instagram.com/mycompany");
    public final String value;
}
