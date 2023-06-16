package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class State_Finance_AnnualStatement_VerifyStudentListTest extends Base {

private static final String TEST_ID ="z7v6p3s26baugnjllmfqgqnj2noval4l";


    Loginpage loginPage=new Loginpage();
    Homepage homepage = new Homepage();
    Base scholarbase=new Base();
    StateHomePage statehomepage=new StateHomePage();
    ScholarAdmiralPage scholarAdmiralPage=new ScholarAdmiralPage();

    @Test
    public void state_finance_annualstatement_verifystudentlist_z7v6p3s26baugnjllmfqgqnj2noval4l() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "Scholarship Admin - Finances - Annual Statement - Verify Student list SHIP-506");
        loginPage.LoginPageDriverRef(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);
        homepage.HomePageDriverRef(Base.driver);
        scholarAdmiralPage.admiraluserPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as State user account successfully");

        scholarAdmiralPage.click_finance_icon();

        scholarAdmiralPage.click_annualstatement_tab();

        scholarAdmiralPage.selectFirstStudentName();
        extentTest.log(LogStatus.PASS, "Verified : Student row is selected successfully");

   /*     homepage.logout();
        extentTest.log(LogStatus.PASS, "Verified : Logged out from application successfully");*/

    }
}

