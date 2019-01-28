package com.salesforceExample;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class BaseClass2 {

    static String accessToken;
    private static final String clientid = "3MVG9HxRZv05HarSFdD2UK3hFPy6.BPUxl6do3a.ExNeJvvFo2POq2rVfWNxbG6RpNkeuPQvQhgPv32tf59pd";
    private static final String clientSecret = "655457239625000611";
    private static final String username = "willokans@gmail.com";
    private static final String password = "Auto2019";


    @Test
    public static void init() {

        RestAssured.baseURI = "https://eu18.salesforce.com/";
        RestAssured.basePath = "services/";
        accessToken = given()
                .param("grant_type", "password")
                //.param("code", "authorization_code")
                .param("Content-Type", "application/x-www-form-urlencoded")
                //.param("redirect_uri", "https://eu18.salesforce.com/services/oauth2/token")
                .param("username", username)
                .param("password", password)
                .auth()
                .preemptive()
                .basic(clientid, clientSecret)
                .when()
                .post("oauth2/token")
                .then()
                .log()
                .all()
                .extract()
                .path("access_token");

        System.out.println("Access Token = " +accessToken);

    }
}
