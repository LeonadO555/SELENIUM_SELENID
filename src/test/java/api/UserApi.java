package api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class UserApi extends ApiBase {
    RegistrationDTO dto;
    Response response;
    Faker faker = new Faker();

    public RegistrationDTO randomDataForNewUser(){
        dto = new RegistrationDTO();
        dto.setFull_name(faker.name().username());
        dto.setEmail(faker.internet().safeEmailAddress());
        dto.setPassword("123456");
        dto.setGenerate_magic_link("false");
        return dto;
    }
    public Response registrationNewUserApi(Integer code){
        String endpoint = "/v1/api/users";
        response = doPostRequest(endpoint, code, randomDataForNewUser());
        return response;
    }

    public void deleteExistingUser(String userEmail, Integer code){
        String endpoint = "/v1/api/users/{email}";
        doDeleteRequest(endpoint,code, userEmail);
    }
}
