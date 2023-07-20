package schema.registration;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RegistrationDTO {

    String full_name;
    String email;
    String password;
    Boolean generate_magic_link;

}
