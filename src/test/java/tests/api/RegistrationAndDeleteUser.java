package tests.api;
import api.ApiBase;
import api.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import api.RegistrationDTO;

public class RegistrationAndDeleteUser extends ApiBase{
    UserApi userApi;

        @Test
        public void registrationNewUserAndDeleteApi(){
            userApi = new UserApi();
            Response response = userApi.registrationNewUserApi(201);
            String userEmail = response.jsonPath().getString("email");
            userApi.deleteExistingUser(userEmail, 200);
            userApi.deleteExistingUser(userEmail, 404);
        }
    }

