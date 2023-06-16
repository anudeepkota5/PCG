package com.pcgus.ci.scholar.testcases.inprogresstest;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.AdmiralHomepage;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class kkaz22f4vuuonrkuhplfjx7paz366sf3 extends Base {

    private static final String TEST_ID = "kkaz22f4vuuonrkuhplfjx7paz366sf3";

    Loginpage loginPage = new Loginpage();
    Base scholarbase = new Base();
    CreateApplicationPage createapplicationpage = new CreateApplicationPage();

    @Test
    public void parent_homepagemenuoptions_blpwe7s40uxvznkt685am2rqdfji39y1() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser3"), TestProperties.get("password2"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent user account");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.INFO, "Verified : Create new Student Application");

        createapplicationpage.clickContinueButton();
        extentTest.log(LogStatus.INFO, "Verified : Continue on personal Information");

        createapplicationpage.clickContinueButton();
        extentTest.log(LogStatus.INFO, "Verified : Continue on Parent Information");

        createapplicationpage.checkSSNErrMsg();
        extentTest.log(LogStatus.INFO, "Verified : SSN Validated");
    }
}