package api;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class ApiBase {
    final String BASE_URI = "https://studio-api.softr.io";
    final String Api_Key = "khIbAyJIU5CIuh1oDuBRx1s49";
    final String Domain = "jere237.softr.app";

    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .addHeader("Softr-Api-Key", Api_Key )
            .addHeader("Softr-Domain", Domain)
            .build();
    public Response doPostRequest(String endPoint, Integer responseCode, Object body) {
        Response resp = RestAssured.given()
                .spec(spec)
                .body(body)
                .when()
                .log().all()
                .post(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }
    public Response doDeleteRequest(String endPoint, Integer responseCode, String email) {
        Response resp = RestAssured.given()
                .spec(spec)
                .when()
                .pathParam("email", email)
                .log().all()
                .delete(endPoint)
                .then().log().all()
                .extract().response();
        resp.then().assertThat().statusCode(responseCode);
        return resp;
    }
}