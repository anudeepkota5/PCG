package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyDeleteApplicationButtonNotDisplayedForExistingApplicationTest extends Base {
    private static final String TEST_ID ="yppzfadgo2zhbv3gwr23xqgs4mvtdocm";

    Loginpage loginPage=new Loginpage();

    Homepage homePage = new Homepage();
    Base scholarbase=new Base();

    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_verifydeleteapplicationbuttonnotdisplayedforexistingapplication_yppzfadgo2zhbv3gwr23xqgs4mvtdocm() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Verify  Delete application button should not be displayed for existing student complete application form in parent portal #SHIP-1223");
        loginPage.LoginPageDriverRef(driver);
        homePage.HomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(driver);

        scholarbase.loginToPCGScholarPortal("saharanqa2023+parent6@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");

        createapplicationpage.VerifyStatsNotDisplayed("Delete application");
    }
}
