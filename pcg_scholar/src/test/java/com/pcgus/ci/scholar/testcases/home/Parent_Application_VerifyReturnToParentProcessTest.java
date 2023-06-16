package com.pcgus.ci.scholar.testcases.home;

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

public class Parent_Application_VerifyReturnToParentProcessTest extends Base{
    private static final String TEST_ID="nvf2mkmwm6exbwxuoi3nh6gmu3bqs6lb";

    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    CreateApplicationPage createapplicationpage=new CreateApplicationPage();
    StateHomePage statehomepage=new StateHomePage();
    Homepage homepage = new Homepage();
    ScholarAdmiralPage scholarAdmiralPage=new ScholarAdmiralPage();

    @Test
    public void parent_application_verifyreturntoparentprocess_nvf2mkmwm6exbwxuoi3nh6gmu3bqs6lb() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        homepage.HomePageDriverRef(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        loginPage.LoginPageDriverRef(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Applications - Verify Returned to Parent process SHIP-483");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        String uniqueName = "Rishabh_"+returnUniqueData();
        createapplicationpage.addingStudentInformationWithUniqueName(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.verifysignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        statehomepage.verifyApplicationReturnedToParent(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : application returned to parent from State user");

        statehomepage.logout();
        extentTest.log(LogStatus.PASS, "Verified : Logout from State user");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        homepage.verifyReviewMessage(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Review message successfully populated on parent home page");

        homepage.verifyApplicationStatus(uniqueName, "Returned to Parent");
        extentTest.log(LogStatus.PASS, "Verified : Application status is Returned to Parent");

        homepage.updateApplicationStatus(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : The Application status updated successfully");

        homepage.verifyApplicationStatus(uniqueName, "Initial Review");
        extentTest.log(LogStatus.PASS, "Verified : Application status is updated back to Initial Review");
    }
}
