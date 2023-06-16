package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.pages.AdmiralHomepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ScholarshipCreateScholarshipAdminUserAdmiralTest extends Base {

    private static final String TEST_ID = "cuw2pdhkzcrp7x5txv5hxqh5oqqahpkf";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();

    @Test
    public void verifyAddAdminUser_cuw2pdhkzcrp7x5txv5hxqh5oqqahpkf() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.admiraluserPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral uscholaradminser account");

        admiralpage.verifyChangeUserType("Scholarship Admin");
        extentTest.log(LogStatus.INFO, "Verified : User name is changed by Admiral user");

        admiralpage.admiralLogout();
        extentTest.log(LogStatus.INFO, "Verified : Successful logout from Admiral user account");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("pcgAdmiraluser"), TestProperties.get("password"));
        admiralpage.verifyChangeUserType("Admiral");
        extentTest.log(LogStatus.INFO, "Verified : Re-Logged in as Admiral user account with new username");
    }

}