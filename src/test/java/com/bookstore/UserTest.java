package com.bookstore;

import com.api.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class UserTest {
    UserApi userApi = new UserApi();

    @Test(description = "Get Generated Token")
    public void testUserInfo() {
        Response response = userApi.getUserInformation();
        assertEquals(response.jsonPath().getString("username"), "chincho");
        assertNotNull(response.jsonPath().getString("books"));

        boolean authorized = userApi.postUserAuthorized();
        assertTrue(authorized);
    }
}
