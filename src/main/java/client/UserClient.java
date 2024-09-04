package client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static client.BaseApi.*;
import static client.RestClient.getBaseSpec;
import static io.restassured.RestAssured.given;

public class UserClient {

    @Step
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(POST_CREATE_USER)
                .then();
    }

    @Step
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getBaseSpec(accessToken))
                .when()
                .delete(DELETE_USER)
                .then();
    }

    @Step
    public ValidatableResponse loginUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(POST_LOGIN_USER)
                .then();
    }
}
