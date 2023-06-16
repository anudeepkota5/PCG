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

public class hd3qkhngqpil54csfmraqsxqvbkqiscf extends Base {

    private static final String TEST_ID = "hd3qkhngqpil54csfmraqsxqvbkqiscf";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    AdmiralHomepage admiralpage = new AdmiralHomepage();

    ScholarAdmiralPage scholarPage = new ScholarAdmiralPage();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_homepagemenuoptions_blpwe7s40uxvznkt685am2rqdfji39y1() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.AdmiralHomePageDriverRef(Base.driver);
        scholarPage.admiraluserPageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser3"), TestProperties.get("password2"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent user account");

        String name = "Elias Boyer";
        Thread.sleep(15000);
//        String name = createapplicationpage.RenewalStudentPopUp();
//        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        createapplicationpage.updateMissingStudentInformation();
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.clickContinue();
        extentTest.log(LogStatus.PASS, "Verified : Parent information updated successfully");

        createapplicationpage.updateSignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        createapplicationpage.verifyApplicationStatusAndType(name);
        extentTest.log(LogStatus.PASS, "Verified : Application Status and Type successfully");
    }
}
