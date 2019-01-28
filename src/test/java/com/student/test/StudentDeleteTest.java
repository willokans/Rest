package com.student.test;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class StudentDeleteTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port= 8080;
        RestAssured.basePath = "student/";
    }

    @Test
    public void deleteStudent(){
        given()
                .when()
                .delete("/2")
                .then()
                .statusCode(204);
    }
}
