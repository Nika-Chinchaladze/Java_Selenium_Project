package com.api;

import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BookApi extends BaseApi {
    public String[] bookIsbn = {"9781449325862", "9781449331818", "9781449337711"};
    private static final String postBookEndpoint = "/BookStore/v1/Books";
    private static final String getOneBookEndpoint = "/BookStore/v1/Book";

    // POJO For BookBody
    public static class BookBody {
        private String userId;
        private List<Isbn> collectionOfIsbns;

        public BookBody(String userId, List<Isbn> collectionOfIsbns) {
            this.userId = userId;
            this.collectionOfIsbns = collectionOfIsbns;
        }

        public static class Isbn {
            private String isbn;

            public Isbn(String isbn) {
                this.isbn = isbn;
            }

            public void setIsbn(String isbn) {
                this.isbn = isbn;
            }

            public String getIsbn() {
                return isbn;
            }
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserId() {
            return userId;
        }

        public void setCollectionOfIsbns(List<Isbn> collectionOfIsbns) {
            this.collectionOfIsbns = collectionOfIsbns;
        }

        public List<Isbn> getCollectionOfIsbns() {
            return collectionOfIsbns;
        }
    }

    // GET Methods
    public Response getOneBookRequest(String isbn) {
        RestAssured.baseURI = baseUrl;
        String token = generateToken();
        return given()
                .queryParam("ISBN", isbn)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .get(getOneBookEndpoint);
    }

    public Response getMultipleBooksRequest() {
        RestAssured.baseURI = baseUrl;
        String token = generateToken();
        return given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .get(postBookEndpoint);
    }

    // POST Method
    public Response postBookRequest() {
        RestAssured.baseURI = baseUrl;
        String token = generateToken();
        String randomIsbn = bookIsbn[new Random().nextInt(bookIsbn.length)];
        BookBody bookBody = new BookBody(userId, List.of(new BookBody.Isbn(randomIsbn)));
        try {
            String bookBodyStringify = new ObjectMapper().writeValueAsString(bookBody);
            return given()
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .body(bookBodyStringify)
                    .post(postBookEndpoint);
        } catch (Exception e) {
            throw new RuntimeException("Serialization Failed!", e);
        }
    }

    // PUT
    // DELETE
}
