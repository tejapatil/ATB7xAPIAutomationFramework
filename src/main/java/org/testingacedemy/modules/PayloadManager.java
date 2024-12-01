package org.testingacedemy.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testingacedemy.pojos.*;

public class PayloadManager {
    Gson gson;

    // Converting the JAVA object to the String
    // {}
    public static String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Sally");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2024-02-02");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON String (byteStream) - Serlization
        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);
        return jsonStringpayload;
    }

    public Object createPayloadBookingAsStringFaker() {
        Faker faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1000));
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-02");
        bookingdates.setCheckout("2024-02-02");

        booking.setBookingdates(bookingdates);


        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Java Object -> JSON String (byteStream) - Serlization
        gson = new Gson();
        String jsonStringPayload = gson.toJson(booking);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;
    }
    // Java Object -> JSON String (byteStream) - Deserlization

    //Parse DeSerilization

    public BookingResponse bookingResponsejava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;

    }

    public String setAuthPayload() {
        // Auth Object -> json String
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson = new Gson();
        String jsonStringPayload = gson.toJson(auth);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;
    }

    //Java object to JSON String(byte stream) Deserlization
    public String getTokenFromJson(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse;
    }
    // get Booking ID
    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        // Response ( JSON) ->  Object TokenResponse
        // Deserialization
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return booking;
    }

    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Tejaswini");
        booking.setLastname("Patil");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

}









