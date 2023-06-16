package com.pcgus.ci.scholar.testcases.inprogresstest;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class zs56vsj4qwbcyvgqwctk4jcoqp6n4j7o extends Base {
    private static final String TEST_ID ="zs56vsj4qwbcyvgqwctk4jcoqp6n4j7o";

    Loginpage loginPage=new Loginpage();
    Homepage homePage = new Homepage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_homepagemenuoptions_zs56vsj4qwbcyvgqwctk4jcoqp6n4j7o() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Login page - Verify Login Page displays SHIP-207");
        loginPage.LoginPageDriverRef(driver);
        homePage.HomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(driver);

        scholarbase.loginToPCGScholarPortal("saharanqa2023+parent6@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        String uniqueName = "Rishabh_"+returnUniqueData();
        createapplicationpage.addingStudentInformationWithUniqueName(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.verifyAllUploads();
        extentTest.log(LogStatus.PASS, "Verified : Verified all uploads and downloads successfully");

        createapplicationpage.entersignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        createapplicationpage.VerifyStatsNotDisplayed("Delete application");
    }
}
