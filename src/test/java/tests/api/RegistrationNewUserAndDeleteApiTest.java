package tests.api;

import api.ApiBase;
import api.registration.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class RegistrationNewUserAndDeleteApiTest extends ApiBase {
    UserApi userApi;
    Response response;

    @Test
    public void registrationNewUserAndDeleteApi(){
        userApi = new UserApi();
        userApi.randomNewUserData();
        response = userApi.registrationNewUserApi(201);
        String userEmail = response.jsonPath().getString("email");
        userApi.deleteExistingUserApi(userEmail, 200);
        userApi.deleteExistingUserApi(userEmail, 404);
    }

}
