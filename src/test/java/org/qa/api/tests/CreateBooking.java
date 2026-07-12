package org.qa.api.tests;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.annotations.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class CreateBooking {
    String BASEURL = "https://restful-booker.herokuapp.com";
    Playwright playwright = Playwright.create();
    APIRequest apiRequest = playwright.request();
    APIRequestContext apiRequestContext = apiRequest.newContext();

    @Test
    public void createBooking() {
        HashMap<String, Object> body = new HashMap<>();
        body.put("firstname", "Jim");
        body.put("lastname", "Brown");
        body.put("totalprice", 111);
        body.put("depositpaid", true);
// Create bookingdates map
        HashMap<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");
// Add nested object
        body.put("bookingdates", bookingDates);
        body.put("additionalneeds", "Breakfast");

        APIResponse apiResponse = apiRequestContext.post(BASEURL + "/booking", RequestOptions.create()
                .setData(body)
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json"));
        System.out.println(apiResponse.status());
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.body());
        System.out.println("Response Body: \n" + jsonNode.toPrettyString());
    }
}
