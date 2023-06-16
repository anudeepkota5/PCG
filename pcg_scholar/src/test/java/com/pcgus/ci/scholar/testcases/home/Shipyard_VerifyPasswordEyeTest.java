package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Shipyard_VerifyPasswordEyeTest extends Base {

    private static final String TEST_ID ="nxzouceznugpgvodp62zp63egp242ytp";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();

    @Test
    public void school_verifypasswordeye_nxzouceznugpgvodp62zp63egp242ytp() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Login - Verify Password field masking SHIP-645");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.admiraluserPageDriverRef(Base.driver);

        scholarbase.enterUserName(TestProperties.get("admiraluser"));
        extentTest.log(LogStatus.INFO, "Verified : User Entered UserName :: "+TestProperties.get("admiraluser"));

        scholarbase.enterPassword(TestProperties.get("password"));

        boolean defaultmask = scholarbase.PasswordMaskByDefault();
        extentTest.log(LogStatus.INFO, "Verified : Password Field is MASKED by Default :: "+defaultmask);
        Base.takeScreenShot();

        scholarbase.clickEyeToUnMask();
        extentTest.log(LogStatus.INFO, "Verified : Password Field is UNMASKED :: "+scholarbase.isPasswordDisplayed());
        Base.takeScreenShot();

        scholarbase.clickEyeToMask();
        extentTest.log(LogStatus.INFO, "Verified : Password Field is MASKED :: "+scholarbase.isPasswordMaskDisplayed());
        Base.takeScreenShot();
    }
}
