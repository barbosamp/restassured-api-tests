package dev.etech.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RestConfig {

    private String urlBase;
    public static RequestSpecification request;
    public static Response response;
    public static String accessToken = "";

    public RestConfig() {
        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
            urlBase = properties.getProperty("baseURI");
            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.log(LogDetail.ALL);
            builder.setBaseUri(urlBase);
            builder.setContentType(ContentType.JSON);
            request = RestAssured.given().spec(builder.build());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
