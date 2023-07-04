package tests.api;

import api.ApiBase;
import api.RegistrationDTO;
import api.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RegistrationAndDeleteUserApiTest extends ApiBase {
    UserApi userApi;
    RegistrationDTO registrationDTO;


    @Test
    public void registrationNewUserApi(){
        userApi = new UserApi();
        RegistrationDTO registrationDTO = userApi.randomDataForNewUser();
        userApi.registrationNewUserApi(200, registrationDTO);
    }

    @Test
    public void registrationNewUserAndDeleteApi(){
        userApi = new UserApi();
        RegistrationDTO registrationDTO = userApi.randomDataForNewUser();
        Response response = userApi.registrationNewUserApi(201, registrationDTO);
        String userEmail = response.jsonPath().getString("email");
        userApi.deleteExistingUser(userEmail, 200);
    }

}
