package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyNavigationButtonPinnedAtBottomOfPageTest extends Base {

    private static final String TEST_ID ="lkgjpqn47usckdlxwwjb2h4zluzdd5wg";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_verifynavigationbuttonpinnedatbottomofpage_lkgjpqn47usckdlxwwjb2h4zluzdd5wg() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

       scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
  //      scholarbase.loginToPCGScholarPortal("saharanqa2023+testparent1@gmail.com", TestProperties.get("password"));

        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        createapplicationpage.verifyButtons();

        createapplicationpage.editlatestapplication();
        extentTest.log(LogStatus.PASS, "Verified : Application Edit Successfully");

        createapplicationpage.verifyButtons();

    }
}
