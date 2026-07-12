package org.qa.api.tests;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public class GetBooking {

    String BASEURL = "https://restful-booker.herokuapp.com";
    Playwright playwright = Playwright.create();
    APIRequest apiRequest = playwright.request();
    APIRequestContext apiRequestContext = apiRequest.newContext();

    @Test
    public void getBooking() {
        APIResponse apiResponse = apiRequestContext.get(BASEURL + "/booking");
        Assert.assertEquals(apiResponse.status(), 200);
        System.out.println("StatusCode: \n" + apiResponse.status());
        System.out.println("StatusTest: \n" + apiResponse.statusText());
        System.out.println("Response: \n" + apiResponse.text());
        System.out.println("Response Headers: \n" + apiResponse.headers());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println("Response Body: \n" + jsonNode.toPrettyString());
    }

    @Test
    public void getBookingId() {
        APIResponse apiResponse = apiRequestContext.get(BASEURL + "/booking/1");
        Assert.assertEquals(apiResponse.status(), 200);
        System.out.println("StatusCode: \n" + apiResponse.status());
        System.out.println("StatusTest: \n" + apiResponse.statusText());
        System.out.println("Response: \n" + apiResponse.text());
        System.out.println("Response Headers: \n" + apiResponse.headers());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println("Response Body: \n" + jsonNode.toPrettyString());
        apiResponse.dispose();
        /* apiResponse.dispose() -- will delete response body*/
        jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println("Response Body: \n" + jsonNode.toPrettyString());
    }
}
