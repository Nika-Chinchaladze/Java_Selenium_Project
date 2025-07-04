package com.api;

import com.api.BaseApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApi extends BaseApi {
    // API methods
    public Response getUserInformation() {
        RestAssured.baseURI = baseUrl;
        String token = generateToken();
        return given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .pathParam("UUID", userId)
                .get("/Account/v1/User/{UUID}");
    }

    public boolean postUserAuthorized() {
        RestAssured.baseURI = baseUrl;
        Credentials credentials = new Credentials(userName, password);
        try {
            String credentialsJson = new ObjectMapper().writeValueAsString(credentials);
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(credentialsJson)
                    .post("/Account/v1/Authorized");
            return response.jsonPath().getBoolean("");
        } catch (Exception e) {
            throw new RuntimeException("Serialization Error", e);
        }
    }
}
