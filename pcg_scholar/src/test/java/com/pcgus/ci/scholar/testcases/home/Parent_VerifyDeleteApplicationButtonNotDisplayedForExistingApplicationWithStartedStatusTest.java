package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyDeleteApplicationButtonNotDisplayedForExistingApplicationWithStartedStatusTest extends Base {

    private static final String TEST_ID ="blpwe7s40uxvznkt685am2rqdfji39y1";

    Loginpage loginPage=new Loginpage();
    Homepage homePage = new Homepage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_verifydeleteapplicationbuttonnotdisplayedforexistingapplicationwithstartedstatus_blpwe7s40uxvznkt685am2rqdfji39y1() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Applications - Verify  Delete application option is not available for existing editable applications #SHIP-1223");
        loginPage.LoginPageDriverRef(driver);
        homePage.HomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(driver);

        scholarbase.loginToPCGScholarPortal("saharanqa2023+parent6@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");

        createapplicationpage.checkforStatusStarted("Delete application");
    }
}
