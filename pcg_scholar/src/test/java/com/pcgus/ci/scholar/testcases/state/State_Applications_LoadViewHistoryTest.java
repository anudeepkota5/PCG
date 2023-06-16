package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class State_Applications_LoadViewHistoryTest extends Base {

    private static final String TEST_ID="4aiy3qgrozbo6zsb27ro3zg6tiuu7o7e";

    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    StateHomePage statehomepage=new StateHomePage();
    ScholarAdmiralPage scholarAdmiralPage = new ScholarAdmiralPage();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void state_applications_loadviewhistory_4aiy3qgrozbo6zsb27ro3zg6tiuu7o7e() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Scholarship Admin - Applications - Load View History SHIP-182 893");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        scholarAdmiralPage.admiraluserPageDriverRef(driver);

        scholarbase.loginToPCGScholarPortal("saharanqa2023+state@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

        statehomepage.selectAnyStudentApplication();
        extentTest.log(LogStatus.PASS, "Verified : Selected a student successfully");

        statehomepage.clickActionsButton();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on Actions Button successfully");

        statehomepage.clickViewHistoryLink();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on View History Button successfully");
    }

}
