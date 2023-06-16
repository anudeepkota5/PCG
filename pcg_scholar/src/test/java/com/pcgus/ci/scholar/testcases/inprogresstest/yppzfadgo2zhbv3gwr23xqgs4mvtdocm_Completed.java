package com.pcgus.ci.scholar.testcases.inprogresstest;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class yppzfadgo2zhbv3gwr23xqgs4mvtdocm_Completed extends Base {
    private static final String TEST_ID ="yppzfadgo2zhbv3gwr23xqgs4mvtdocm";

    Loginpage loginPage=new Loginpage();

    Homepage homePage = new Homepage();
    Base scholarbase=new Base();

    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_homepagemenuoptions_egpjhsof6cs7c65jfjwxwdgeuijeya4y() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Login page - Verify Login Page displays SHIP-207");
        loginPage.LoginPageDriverRef(driver);
        homePage.HomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(driver);

        scholarbase.loginToPCGScholarPortal("saharanqa2023+parent6@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");


        createapplicationpage.VerifyStatsNotDisplayed("Delete application");
    }
}
