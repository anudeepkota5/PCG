package com.pcgus.ci.scholar.testcases.common;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class VerifyAllPageLoadsOnAllUsersTest extends Base {
    private static final String TEST_ID="n4at77lw6yhboipsv4gyatzfyohlfu3k";
    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();
    StateHomePage statehomepage=new StateHomePage();
    ScholarAdmiralPage scholarAdmiralPage = new ScholarAdmiralPage();
    AdmiralHomepage admiralHomepage = new AdmiralHomepage();
    SchoolHomepage schoolHomepage = new SchoolHomepage();

    @Test
    public void verifyallpageloadsOnallusers_n4at77lw6yhboipsv4gyatzfyohlfu3k() throws InterruptedException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : ONLY FOR PROD - Production Sanity - Private School and Scholarship Admin - Verify all pages load");
        loginPage.LoginPageDriverRef(Base.driver);
        homePage.HomePageDriverRef(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        schoolHomepage.SchoolHomePageDriverRef(Base.driver);
        scholarAdmiralPage.admiraluserPageDriverRef(Base.driver);
        admiralHomepage.AdmiralHomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : <b>Student pop-up handled successfully</b>");

        createapplicationpage.newApplicationVerifyTabsStepNumber();
        extentTest.log(LogStatus.PASS, "Verified : <b>I see 4 tiles with step # underneath</b>");

        homePage.verifyMyInfoTab();
        extentTest.log(LogStatus.PASS, "Verified : <b>My Info page loaded successfully</b>");

        homePage.verify_parent_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : <b>Parent user displays Items successfully</b>");
        homePage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "<b>Logged in into School user successfully</b>");

        schoolHomepage.verify_school_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : <b>School user displays Items successfully</b>");

        schoolHomepage.verifyAllPageLoad();
        extentTest.log(LogStatus.PASS, "Verified : <b>All pages loaded successfully for Private user</b>");
        homePage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "<b>Logged in into State user successfully</b>");

        scholarAdmiralPage.verify_state_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : <b>State user displays Items successfully</b>");

        scholarAdmiralPage.verifyAllPageLoad();
        extentTest.log(LogStatus.PASS, "Verified : <b>All pages loaded successfully for Scholar Admiral user</b>");
        homePage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "<b>Logged in into Admiral user successfully</b>");

        admiralHomepage.verify_admiral_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : <b>Admiral user displays Items successfully</b>");

        admiralHomepage.verifyAllPageLoad();
        extentTest.log(LogStatus.PASS, "Verified : <b>All pages loaded successfully for Admiral user</b>");
        homePage.logout();

    }
}
