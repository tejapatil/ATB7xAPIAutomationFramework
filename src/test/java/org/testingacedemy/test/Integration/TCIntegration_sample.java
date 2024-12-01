package org.testingacedemy.test.Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testingacedemy.Base.BaseTest;
import org.testingacedemy.endpoints.APIConstants;
import org.testingacedemy.modules.PayloadManager;
import org.testingacedemy.pojos.Booking;
import org.testingacedemy.pojos.BookingResponse;
import org.testingacedemy.pojos.TokenResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class TCIntegration_sample extends BaseTest {
    private BookingResponse bookingResponse;
// Create A Booking, Create a Token
    // Get booking
    // Update the Booking
    // Delete the Booking

    @Test(groups = "integration", priority = 1)
    @Owner("Tej")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBooking(ITestContext iTestContext) {
        iTestContext.setAttribute("token", getToken());
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(PayloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);
        //        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));


        // DeSer
        BookingResponse bookingResponse = payloadManager.bookingResponsejava(response.asString());

        //Assertj
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Sally");

        //Set the booking ID
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }

    @Test(groups = "integration", priority = 2)
    @Owner("Tejaswini")
    @Description("TC#INT1 - Step 2. Verify that the Booking By ID")
    public void testVerifyBookingId(ITestContext iTestContext) {
        //bookingid
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        //Get Req
        String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGET);
        requestSpecification.basePath(basePathGET);
        response = RestAssured.given(requestSpecification)
                .when().get();

        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Sally");
    }

    @Test(groups = "integration", priority = 3)
    @Owner("Tejaswini")
    @Description("TC#INT1 - Step 2. Verify that the Booking By ID")
    public void testFullUpdateVerifyBookingId(ITestContext iTestContext) {
        System.out.println("Token- " +iTestContext.getAttribute("token"));
        String token=(String) iTestContext.getAttribute("token");
        Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");

        //Put Req
        String basePathPutPatch= APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPutPatch);

        requestSpecification.basePath(basePathPutPatch);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.fullUpdatePayloadAsString()).put();

        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Tejaswini");
        assertThat(booking.getLastname()).isEqualTo("Patil");
    }
}


