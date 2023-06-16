package com.pcgus.ci.scholar.testcases.common;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class VerifyItemDisplayAccordingToUserTypeTest extends Base {

    private static final String TEST_ID ="dmitp6h4svaubazvlib4n26fefhqbj5d";


    Loginpage loginPage=new Loginpage();
    Homepage homepage = new Homepage();
    SchoolHomepage schoolHomepage = new SchoolHomepage();
    Base scholarbase=new Base();
    StateHomePage statehomepage=new StateHomePage();
    ScholarAdmiralPage scholarAdmiralPage = new ScholarAdmiralPage();
    AdmiralHomepage admiralHomepage = new AdmiralHomepage();
    @Test
    public void verifyitemdisplayaccordingtousertype_dmitp6h4svaubazvlib4n26fefhqbj5d() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "Scholarship Admin - Applications - Verify loading student application SHIP-403 663");
        loginPage.LoginPageDriverRef(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);
        homepage.HomePageDriverRef(Base.driver);
        schoolHomepage.SchoolHomePageDriverRef(Base.driver);
        scholarAdmiralPage.admiraluserPageDriverRef(Base.driver);
        admiralHomepage.AdmiralHomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Logged in into Parent user successfully");

        homepage.verify_parent_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : Parent user displays Items successfully");
        homepage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Logged in into School user successfully");

        schoolHomepage.verify_school_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : School user displays Items successfully");
        homepage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Logged in into State user successfully");

        scholarAdmiralPage.verify_state_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : State user displays Items successfully");
        homepage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Logged in into Admiral user successfully");

        admiralHomepage.verify_admiral_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : Admiral user displays Items successfully");
        homepage.logout();

       /* statehomepage.selectFirstRowAnsValidateData();
        extentTest.log(LogStatus.PASS, "Verified : Student row is selected successfully");

        homepage.logout();
        extentTest.log(LogStatus.PASS, "Verified : Logged out from application successfully");*/

    }
}

