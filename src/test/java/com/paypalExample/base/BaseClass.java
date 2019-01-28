package com.paypalExample.base;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class BaseClass {

    static String accessToken;
    private static final String clientid = "Ae3IIuLrsvKgFjq0C1L8i7RsEWNOBLLum0ftWI8oJAeGhdvf3wXmpqhC_PyX-NcvZu1HgF_VLdE-eTeF";
    private static final String clientSecret = "ELpQs-KLJ3h3By4MtgeefYWivqsjoRmDbsTwWbm7Lee6ccQUMUsSw3iMfVgzCKjy3d-n0aXMWVIt3jwp";

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "https://api.sandbox.paypal.com/";
        RestAssured.basePath = "/v1";
        accessToken = given()
                .param("grant_type", "client_credentials")
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
