package tests.api;
import api.ApiBase;
import api.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import api.RegistrationDTO;

public class RegistrationAndDeleteUser extends ApiBase{
    UserApi userApi;
    Response response;

        @Test public void registrationNewUserAndDeleteApi(){
            userApi = new UserApi();
            RegistrationDTO registrationDTO = userApi.randomUserData();
            Response response = userApi.registrationNewUserApi(201);
            String userEmail = response.jsonPath().getString("email");
            userApi.deleteExistingUserApi(userEmail, 200);
            userApi.deleteExistingUserApi(userEmail, 404);
        }
    }

