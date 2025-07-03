package com.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApi {
    protected String baseUrl = "https://demoqa.com";
    protected String userId = "b1703b5f-b163-4949-bc61-b29928f8cd86";

    private String generateToken() {
        RestAssured.baseURI = baseUrl;
        String credentials =  """
            {
                "userName": "chincho",
                "password": "Chincho123@"
            }
            """;
        Response response = given()
                .header("Content-Type", "application/json")
                .body(credentials)
                .post("/Account/v1/GenerateToken");
        return response.jsonPath().getString("token");
    }

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
        String credentials =  """
            {
                "userName": "chincho",
                "password": "Chincho123@"
            }
            """;
        Response response = given()
                .header("Content-Type", "application/json")
                .body(credentials)
                .post("/Account/v1/Authorized");
        return response.jsonPath().getBoolean("");
    }
}
