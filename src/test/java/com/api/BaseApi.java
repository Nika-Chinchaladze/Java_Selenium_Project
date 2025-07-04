package com.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseApi {
    protected String baseUrl = "https://demoqa.com";
    protected String userName = "chincho";
    protected String password = "Chincho123@";
    protected String userId = "b1703b5f-b163-4949-bc61-b29928f8cd86";

    // POJO for credentials
    protected static class Credentials {
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

    // API Methods
    protected String generateToken() {
        RestAssured.baseURI = baseUrl;
        UserApi.Credentials credentials = new UserApi.Credentials(userName, password);
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
}
