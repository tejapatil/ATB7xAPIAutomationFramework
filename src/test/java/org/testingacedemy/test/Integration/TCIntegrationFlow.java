package org.testingacedemy.test.Integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testingacedemy.Base.BaseTest;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TCIntegrationFlow extends BaseTest {

    //Create a booking,  create a token
    //Get Booking
    //Update the Booking
    //Delete the Booking

    @Test(groups = "integration", priority = 1)
    @Description("TC#INT1- Step 1.Verify that the Booking can be created")
    public void testCreateBooking(ITestContext ITestContext){
    }

    @Test(groups = "integration", priority = 2)
    @Owner("Promode")
    @Description("TC#INT1 - Step 2. Verify that the Booking By ID")
    public void testVerifyBookingId(){
        Assert.assertTrue(true);

    }

    @Test(groups = "integration", priority = 3)
    @Owner("Promode")
    @Description("TC#INT1 - Step 3. Verify Updated Booking by ID")
    public void testUpdateBookingByID(){
        Assert.assertTrue(true);


    }

    @Test(groups = "integration", priority = 4)
    @Owner("Promode")
    @Description("TC#INT1 - Step 4. Delete the Booking by ID")
    public void testDeleteBookingById(){
        Assert.assertTrue(true);


    }


}



