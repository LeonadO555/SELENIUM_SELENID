package api.registration;
import com.github.javafaker.Faker;
import io.restassured.response.Response;

import api.ApiBase;
import schema.registration.RegistrationDTO;

public class UserApi extends ApiBase {

    RegistrationDTO dto;
    Response response;
    Faker faker = new Faker();

    public RegistrationDTO randomNewUserData(){
        dto = new RegistrationDTO();
        dto.setFull_name(faker.name().lastName());
        dto.setEmail(faker.internet().safeEmailAddress());
        dto.setPassword("123456");
        dto.setGenerate_magic_link(false);
        return dto;
    }

    public Response registrationNewUserApi(Integer code){
        String endpoint = "/v1/api/users";
        response = doPostRequest(endpoint, code, randomNewUserData());
        return response;
    }

    public void deleteExistingUserApi(String userEmail, Integer code){
        String endpoint = "/v1/api/users/{email}";
        doDeleteRequest(endpoint, code, userEmail);
    }
}
