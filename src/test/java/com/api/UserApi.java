package com.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserApi {
    private static final String baseUrl = "https://demoqa.com";
    private static final String userName = "chincho";
    private static final String password = "Chincho123@";
    private static final String userId = "b1703b5f-b163-4949-bc61-b29928f8cd86";

    // POJO for credentials
    public static class Credentials {
        private String userName;
        private String password;

        public Credentials(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }

    // API methods
    private String generateToken() {
        RestAssured.baseURI = baseUrl;
        Credentials credentials = new Credentials(userName, password);
        try {
            String credentialsJson = new ObjectMapper().writeValueAsString(credentials);
            Response response = given()
                    .header("Content-Type", "application/json")
                    .body(credentialsJson)
                    .post("/Account/v1/GenerateToken");
            return response.jsonPath().getString("token");
        } catch (Exception e) {
            throw new RuntimeException("Serialization Error", e);
        }
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
