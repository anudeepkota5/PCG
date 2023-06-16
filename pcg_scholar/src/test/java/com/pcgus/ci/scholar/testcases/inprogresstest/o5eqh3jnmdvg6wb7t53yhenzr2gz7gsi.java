package com.pcgus.ci.scholar.testcases.inprogresstest;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.AdmiralHomepage;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.HashMap;

public class o5eqh3jnmdvg6wb7t53yhenzr2gz7gsi extends Base {

    private static final String TEST_ID = "o5eqh3jnmdvg6wb7t53yhenzr2gz7gsi";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    ScholarAdmiralPage scholarPage = new ScholarAdmiralPage();
    StateHomePage statehomepage=new StateHomePage();

    @Test
    public void parent_homepagemenuoptions_blpwe7s40uxvznkt685am2rqdfji39y1() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);
        scholarPage.admiraluserPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as State user account");

        String[] columns = {"ID","Last Name","First Name","Term","DOB","Private School","Type","Username","Status"};
        statehomepage.VerifyColumnsHeaders(columns);
        extentTest.log(LogStatus.INFO, "Verified : Column Headers");

        statehomepage.searchUser("Rishabh_05142023211728");
        extentTest.log(LogStatus.INFO, "Verified : Search for User");

        HashMap<String, String> tabledata = statehomepage.getUserData();
        extentTest.log(LogStatus.INFO, "Verified : Fetch User Data");

        statehomepage.compareUserdata(tabledata);
        extentTest.log(LogStatus.INFO, "Verified : Compare User Data");
    }
}
