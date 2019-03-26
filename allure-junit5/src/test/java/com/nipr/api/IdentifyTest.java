package com.nipr.api;

import com.google.gson.Gson;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@Epic("Identify Applicant")
@Feature("Identify as an individual")
public class IdentifyTest {

    private Gson gson = new Gson();

    @BeforeEach
    public void setUp()
    {
        baseURI = "https://pdb.nipr.com/my-nipr/api";
    }

    @Tag("api")
    @Story("User Identifies with minimal valid information")
    @DisplayName("Identify with Required Data")
    @Test
    public void identifyWithMinimalDataTest()
    {
        Identity identity= new Identity("INDIVIDUAL", "TAX_ID", "HOBART", "312-54-6857", "01/01/1980");

        given().spec(requestSpec(gson.toJson(identity)))
                .when().post("/identify.json")
                .then()
                .log().all();
    }

    @Story("User Identifies with an Invalid Tax Number")
    @ParameterizedTest()
    @MethodSource("stringProvider")
    @DisplayName("identifyWithInvalidTaxNum")
    public void identifyWithInvalidTaxNum(String taxNum)
    {
        Identity identity = new Identity("INDIVIDUAL", "TAX_ID", "HOBART", taxNum, "01/01/1980");

        given().spec(requestSpec(gson.toJson(identity)))
                .when().post("/identify.json")
                .then()
                .log().all();
    }

    static Stream<String> stringProvider() {
        return Stream.of("000-00-1234", "3I2-54-6857", "31-54-6857", "312-54-6857", "312-54-68$7");
    }

    @Tag("api")
    @DisplayName("Identify without a DOB")
    @Test
    public void identifyWithoutDobTest()
    {
        Identity identity = new Identity("INDIVIDUAL", "TAX_ID", "HOBART", "312-54-6857");

        given().spec(requestSpec(gson.toJson(identity)))
                .when().post("/identify.json")
                .then()
                .body("status", equalTo("AUTHORIZATION_FAILURE"))
                .body("ssnVerification", equalTo("LAST_FOUR"));

        // {"status":"AUTHORIZATION_FAILURE","ssnVerification":"LAST_FOUR"}
    }

    /*
     * Reusable request specification.
     */
    private RequestSpecification requestSpec(String json)
    {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("content-type","application/json");
        builder.addHeader("Accept","*/*");
        builder.addHeader("Accept-Encoding","gzip, deflate, br");
        builder.setBody(json);
        return builder.build();
    }
}
