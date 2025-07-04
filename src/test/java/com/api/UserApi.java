package com.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {
    private static final String userEndpoint = "/Account/v1/User/{UUID}";
    private static final String authorizedEndpoint = "/Account/v1/Authorized";

    // API methods
    public Response getUserInformation() {
        RestAssured.baseURI = baseUrl;
        String token = generateToken();
        return given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .pathParam("UUID", userId)
                .get(userEndpoint);
    }

    public boolean postUserAuthorized() {
        RestAssured.baseURI = baseUrl;
        Credentials credentials = new Credentials(userName, password);
        try {
            String credentialsJson = new ObjectMapper().writeValueAsString(credentials);
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(credentialsJson)
                    .post(authorizedEndpoint);
            return response.jsonPath().getBoolean("");
        } catch (Exception e) {
            throw new RuntimeException("Serialization Error", e);
        }
    }
}
