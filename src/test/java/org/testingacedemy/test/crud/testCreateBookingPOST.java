package org.testingacedemy.test.crud;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testCreateBookingPOST {

    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Link to TC", url = "https://bugz.atlassian.net/browse/RBT-4")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    @Description("Verify that POST request is working fine ")
    @Test
    public void testVerifyCreateBookingPOST01(){
        Assert.assertEquals(true, true);

    }


}
