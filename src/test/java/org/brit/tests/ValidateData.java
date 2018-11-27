package org.brit.tests;

import io.restassured.http.ContentType;
import org.brit.tests.classes.MessageResponse;
import org.brit.tests.classes.StatusEnum;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.brit.tests.Constants.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class ValidateData {

    @Test
    public void getAll(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .queryParam("status", StatusEnum.available.toString())
                .when()
                .get(POSTS_ENDPOINT)
                .then()
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @Test
    public void getPost(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .queryParam("status", StatusEnum.available.toString())
                .when()
                .get(POSTS_ENDPOINT+"/1")
                .then()
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @Test
    public void getCommentsForPost(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .queryParam("status", StatusEnum.available.toString())
                .when()
                .get(POSTS_ENDPOINT+"/1/comments")
                .then()
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @Test
    public void getCommentsByPostId(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .queryParam("status", StatusEnum.available.toString())
                .when()
                .get(COMMENTS_ENDPOINT+"?postId=1")
                .then()
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @Test
    public void getPostsByUser(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .queryParam("status", StatusEnum.available.toString())
                .when()
                .get(POSTS_ENDPOINT+"?userId=1")
                .then()
                .extract()
                .body()
                .jsonPath()
                .prettyPrint();
    }

    @Test
    public void createPost(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\"id\": 101, \"userId\": 1, \"title\": \"this is a title\", \"body\": \"this is the body\"}")
                .post(POSTS_ENDPOINT);

//        given().baseUri(TYPICODE_URL)
//                .log().everything()
//                .contentType(ContentType.JSON)
//                .queryParam("status", StatusEnum.available.toString())
//                .when()
//                .get(POSTS_ENDPOINT+"/101")
//                .then()
//                .body("title",equalTo("this is a title"))
//                .extract().body().jsonPath()
//                .prettyPrint();
    }

    @Test
    public void updatePost(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\"id\": 1, \"userId\": 1, \"title\": \"carpe diem\", \"body\": \"carpe noctem\"}")
                .put(POSTS_ENDPOINT+"/1");

//        given().baseUri(TYPICODE_URL)
//                .log().everything()
//                .contentType(ContentType.JSON)
//                .queryParam("status", StatusEnum.available.toString())
//                .when()
//                .get(POSTS_ENDPOINT+"/1")
//                .then()
//                .body("title",equalTo("carpe diem"))
//                .extract().body().jsonPath()
//                .prettyPrint();
    }

    @Test
    public void patchPost(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\"id\": 1, \"userId\": 1, \"title\": \"carpe diem\", \"body\": \"carpe noctem\"}")
                .patch(POSTS_ENDPOINT+"/1");

//                given().baseUri(TYPICODE_URL)
//                .log().everything()
//                .contentType(ContentType.JSON)
//                .queryParam("status", StatusEnum.available.toString())
//                .when()
//                .get(POSTS_ENDPOINT+"/1")
//                .then()
//                .body("title",equalTo("carpe diem"))
//                .extract().body().jsonPath()
//                .prettyPrint();
    }

    @Test
    public void deletePost(){
        given().baseUri(TYPICODE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .queryParam("status", StatusEnum.available.toString())
                .when()
                .delete(POSTS_ENDPOINT+"/1");

//        Assert.assertEquals(
//                given().baseUri(TYPICODE_URL)
//                .log().everything()
//                .contentType(ContentType.JSON)
//                .get(POSTS_ENDPOINT+"/1")
//                .then()
//                .extract().body().jsonPath().getObject("", MessageResponse.class)
//                .getMessage(),"");
    }
}
