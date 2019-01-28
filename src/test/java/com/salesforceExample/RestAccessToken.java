package com.salesforceExample;

import com.oracle.javafx.jmx.json.JSONException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URLEncoder;

public class RestAccessToken {

    public String grant_type = "client_credentials";
    private String client_id = "3MVG9HxRZv05HarSFdD2UK3hFPy6.BPUxl6do3a.ExNeJvvFo2POq2rVfWNxbG6RpNkeuPQvQhgPv32tf59pd";
    private String clientSecret = "655457239625000611";
    private String redirect_uri = "https://test.salesforce.com/";

    public String auth_url = "https://test.salesforce.com/services/oauth2/token";

    @Test
    public void getAccessToken() throws IOException {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("https://eu18.salesforce.com/services/oauth2/token");
        post.setParameter("grant_type","authorization_code");
        post.setParameter("client_id",client_id);
        post.setParameter("client_secret",clientSecret);
        post.setParameter("redirect_uri","https://eu18.salesforce.com/services/oauth2/token");
        //post.setParameter("code", in.nextLine());
        post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        client.executeMethod(post);
        String responseBody = post.getResponseBodyAsString();
        System.out.println(responseBody.toString());
        String accessToken = null;
        JSONObject json = null;

        try {
            json = new JSONObject(responseBody);
            accessToken = json.getString("access_token");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
