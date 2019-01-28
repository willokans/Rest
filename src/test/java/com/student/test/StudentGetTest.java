package com.student.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class StudentGetTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port= 8080;
        RestAssured.basePath = "student/";
    }

    @Test
    public void getAllStudentInformaiton(){
        /**
         * given()
         * set cookies, add auth, adding parameters, setting header infor
         * .when()
         * GET, POST, DELETE... etc
         * .then()
         * Validate status code, extract response,, header, cookies, response body
         */

        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
    }

    @Test
    public void getStudentInfo() {
        given()
                .when().get("/1")
                .then().statusCode(200);
    }

    @Test
    public void getStudentsFromFA(){

        Response response = given()
                .param("programme", "Financial Analysis")
                .param("limit", 104)
                .when()
                .get("/list");
        System.out.println(response.body().prettyPeek());
    }
}
