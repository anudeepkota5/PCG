package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.pages.SchoolHomepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class ScholarshipAdminFinancesAnnualStatementVerifyStatusActionsEditTest extends Base {

    private static final String TEST_ID ="cmazzxxozouedshfeac4oe3ho3obvhmq";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();
    BrowserDriver browserDriver = new BrowserDriver();
    SchoolHomepage schoolHomepage = new SchoolHomepage();

    @Test
    public void school_annualstatement_VerifyStatusActionsEdit_cmazzxxozouedshfeac4oe3ho3obvhmq() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        loginPage.LoginPageDriverRef(Base.driver);
        schoolHomepage.SchoolHomePageDriverRef(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Scholarship Admin - Finances - Annual Statement - Verify Status Actions and Edit");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser2"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as School user account successfully");
        takeScreenShot();
        Thread.sleep(3000);

        schoolHomepage.verify_VerifyStatusActionsEditApplication();
        extentTest.log(LogStatus.INFO, "Verified : Verify Status Actions and Edit");
    }
}
