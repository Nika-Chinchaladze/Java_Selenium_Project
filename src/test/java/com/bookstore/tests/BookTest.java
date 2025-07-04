package com.bookstore.tests;

import com.api.BookApi;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class BookTest {
    BookApi bookApi = new BookApi();

    @Test(description = "Retrieve One Book : GET Request")
    public void testGetOneBook() {
        Response response = bookApi.getOneBookRequest(bookApi.bookIsbn[0]);
        assertEquals(response.jsonPath().getString("title"), "Git Pocket Guide");
    }

    @Test(description = "Retrieve Multiple Books : GET Request")
    public void testGetMultipleBooks() {
        Response response = bookApi.getMultipleBooksRequest();
        assertEquals(response.jsonPath().getString("books[0].title"), "Git Pocket Guide");
    }

    @Test(description = "Create Book : POST Request")
    public void testPostBook() {
        Response response = bookApi.postBookRequest();
        assertNull(response.jsonPath().getString("isbn"));
    }
}
