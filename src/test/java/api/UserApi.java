package api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;

public class UserApi extends ApiBase {
    RegistrationDTO dto;
    Response response;
    Faker faker = new Faker();

    public RegistrationDTO randomUserData() {
        dto = new RegistrationDTO();
        dto.setFull_Name(faker.name().firstName());
        dto.setEmail(faker.internet().emailAddress());
        dto.setPassword("12345678");
        dto.setGenerate_magic_link(false);
        return dto;
    }

    public Response registrationNewUserApi(Integer StatusCode) {
        String endPoint = "/v1/api/users";
        response = doPostRequest(endPoint, StatusCode, randomUserData());
        return response;
    }

    public void deleteExistingUserApi(String email, Integer statusCode) {
        String endPoint = "/v1/api/users{email}";
        doDeleteRequest(endPoint, statusCode, email);
    }
}
