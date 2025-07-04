package com.bookstore;

import com.api.UserApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class UserTest {
    UserApi userApi = new UserApi();

    @Test(description = "Retrieve User Data")
    public void testUserInfo() {
        Response response = userApi.getUserInformation();
        assertEquals(response.jsonPath().getString("username"), "chincho");
        assertNotNull(response.jsonPath().getString("books"));
    }

    @Test(description = "Check User Is Authorized")
    public void testUserIsAuthorized() {
        boolean authorized = userApi.postUserAuthorized();
        assertTrue(authorized);
    }
}
