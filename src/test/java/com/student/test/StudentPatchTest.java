package com.student.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.model.Student;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static com.jayway.restassured.RestAssured.given;

public class StudentPatchTest {

    @BeforeClass
    public static void init(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port= 8080;
        RestAssured.basePath = "student/";
    }

    @Test
    public void patchStudentInfo(){

        ArrayList<String> courses = new ArrayList<String>();
        courses.add("Java");
        courses.add("C++");
        courses.add("C#");

        Student student = new Student();
        student.setFirstName("Mark");
        student.setLastName("Jones");
        student.setEmail("testpatch@gmail.com");
        student.setProgramme("Geography");
        student.setCourses(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .body(student)
                .patch("/2")
                .then().statusCode(200);
    }
}
