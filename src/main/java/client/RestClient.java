package client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static client.BaseApi.STELLAR_BURGERS_URL;

public class RestClient {

    protected static RequestSpecification getBaseSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(STELLAR_BURGERS_URL)
                .build();
    }

    protected static RequestSpecification getBaseSpec(String accessToken) {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(STELLAR_BURGERS_URL)
                .addHeader("Authorization", accessToken)
                .build();
    }
}
