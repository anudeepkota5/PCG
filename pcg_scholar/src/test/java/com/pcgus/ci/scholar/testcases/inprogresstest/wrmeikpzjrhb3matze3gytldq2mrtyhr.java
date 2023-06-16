package com.pcgus.ci.scholar.testcases.inprogresstest;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class wrmeikpzjrhb3matze3gytldq2mrtyhr extends Base {

    private static final String TEST_ID = "wrmeikpzjrhb3matze3gytldq2mrtyhr";


    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    AdmiralHomepage admiralpage = new AdmiralHomepage();

    ScholarAdmiralPage scholarPage = new ScholarAdmiralPage();

    @Test
    public void parent_homepagemenuoptions_blpwe7s40uxvznkt685am2rqdfji39y1() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.AdmiralHomePageDriverRef(Base.driver);
        scholarPage.admiraluserPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");

        admiralpage.clickSettingsIcon();
        extentTest.log(LogStatus.INFO, "Verified : Click action on Setting Icon");

        admiralpage.verifySiteSettingsTab();
        extentTest.log(LogStatus.INFO, "Verified : Details on Site Settings tab");

        admiralpage.clickUsersTab();
        extentTest.log(LogStatus.INFO, "Verified : click action on Users tab");

        admiralpage.enterInSearchTextBox(TestProperties.get("parentuser4"));
        extentTest.log(LogStatus.INFO, "Verified : Successful Searched user account");

        admiralpage.clickSearchedUser();
        extentTest.log(LogStatus.INFO, "Verified : Click on Searched user account");

        admiralpage.selectUserStatus("Inactive");
        extentTest.log(LogStatus.INFO, "Verified : User Account status updated to Inactive");

        admiralpage.clickSaveChanges();
        extentTest.log(LogStatus.INFO, "Verified : clicked on Save Changes");

        scholarPage.admiralLogout();
        extentTest.log(LogStatus.INFO, "Verified : Successful logout from Admiral user account");

        admiralpage.checkNoLoginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Not Logged in as Parent user account");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");

        admiralpage.clickSettingsIcon();
        extentTest.log(LogStatus.INFO, "Verified : Click action on Setting Icon");

        admiralpage.verifySiteSettingsTab();
        extentTest.log(LogStatus.INFO, "Verified : Details on Site Settings tab");

        admiralpage.clickUsersTab();
        extentTest.log(LogStatus.INFO, "Verified : click action on Users tab");

        admiralpage.enterInSearchTextBox(TestProperties.get("parentuser4"));
        extentTest.log(LogStatus.INFO, "Verified : Successful Searched user account");

        admiralpage.clickSearchedUser();
        extentTest.log(LogStatus.INFO, "Verified : Click on Searched user account");

        admiralpage.selectUserStatus("Active");
        extentTest.log(LogStatus.INFO, "Verified : User Account status updated to Inactive");

        admiralpage.clickSaveChanges();
        extentTest.log(LogStatus.INFO, "Verified : clicked on Save Changes");

        scholarPage.admiralLogout();
        extentTest.log(LogStatus.INFO, "Verified : Successful logout from Admiral user account");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent user account");
    }
}
