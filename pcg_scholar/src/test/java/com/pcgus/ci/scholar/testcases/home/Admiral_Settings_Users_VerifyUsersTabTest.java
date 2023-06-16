package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Admiral_Settings_Users_VerifyUsersTabTest extends Base {

    private static final String TEST_ID="rljtcr4bg73rx3tw5nweghdgzfrhnzzu";

    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    AdmiralHomepage admiralpage = new AdmiralHomepage();

    @Test
    public void admiral_settings_users_verifyuserstab_rljtcr4bg73rx3tw5nweghdgzfrhnzzu() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify Site Settings/Users tab");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.AdmiralHomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");

        admiralpage.clickSettingsIcon();
        extentTest.log(LogStatus.INFO, "Verified : Click action on Setting Icon");

        admiralpage.verifySiteSettingsTab();
        extentTest.log(LogStatus.INFO, "Verified : Details on Site Settings tab");

        admiralpage.clickUsersTab();
        extentTest.log(LogStatus.INFO, "Verified : click action on Users tab");

        admiralpage.verifySearchBox();
        extentTest.log(LogStatus.INFO, "Verified : Presence of Search box on Users page");

        admiralpage.verifySiteDropDown();
        extentTest.log(LogStatus.INFO, "Verified : Presence of Site dropdown on Users page");

        admiralpage.verifyUserTableHeader();
        extentTest.log(LogStatus.INFO, "Verified : Header details of User table on Users page");

        admiralpage.verifyUserTable();
        extentTest.log(LogStatus.INFO, "Verified : Information of user table on Users page");

        admiralpage.verifyUserTypeColor();
        extentTest.log(LogStatus.INFO, "Verified : Colors of each UserType on different user details on Users page");

     //   admiralpage.verifySearchByName(TestProperties.get("searchByName"));
        admiralpage.verifySearchByName();
        extentTest.log(LogStatus.INFO, "Verified : Search by name feature to filter user information based on User name");

     //   admiralpage.verifySearchByPhoneNumber(TestProperties.get("searchByPhoneNumber"));
        admiralpage.verifySearchByPhoneNumber();
        extentTest.log(LogStatus.INFO, "Verified : Search by Phone Number feature to filter user information based on Phone Number");

    //    admiralpage.verifySearchByEmailAddress(TestProperties.get("searchByEmail"));
        admiralpage.verifySearchByEmailAddress();
        extentTest.log(LogStatus.INFO, "Verified : Search by Email Id feature to filter user information based on Email address");

     //   admiralpage.verifyUserDetails(TestProperties.get("searchByName"));
        admiralpage.verifyUserDetails();
        extentTest.log(LogStatus.INFO, "Verified : User information from user detail page traversed by clicking on User name link");

        admiralpage.verifyUserBasedOnClient();
        extentTest.log(LogStatus.INFO, "Verified : User details based different client selected from Site drop down");

        admiralpage.traverseUserList(TestProperties.get("siteOption"));
        extentTest.log(LogStatus.INFO, "Verified : User details on all pages by moving back and forth using arrow keys at the bottom of user table");
    }
}
