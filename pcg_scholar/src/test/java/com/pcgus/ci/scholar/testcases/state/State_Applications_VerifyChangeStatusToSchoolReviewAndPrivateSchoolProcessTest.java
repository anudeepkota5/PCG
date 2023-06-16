package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class State_Applications_VerifyChangeStatusToSchoolReviewAndPrivateSchoolProcessTest extends  Base{

    private static final String TEST_ID ="ejtfmew554ro2ylyr7fzn3jtpau26vc4";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();
    StateHomePage stateHomePage =new StateHomePage();
    SchoolHomepage schoolHomePage = new SchoolHomepage();

    @Test
    public void state_applications_verifychangestatustoschoolreviewandprivateschoolprocess_ejtfmew554ro2ylyr7fzn3jtpau26vc4_test() throws InterruptedException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        extentTest.log(LogStatus.INFO, "TC Summary : Admiral Settings Users - Verify Users tab SHIP-284426");
        loginPage.LoginPageDriverRef(Base.driver);
        stateHomePage.StateHomePageDriverRef(Base.driver);
        admiralpage.admiraluserPageDriverRef(Base.driver);
        schoolHomePage.SchoolHomePageDriverRef(Base.driver);
        Thread.sleep(5000);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as scholarship admin  account");

        stateHomePage.clickOnApplicationsIcon();
        extentTest.log(LogStatus.PASS, "Verified : Successfully landed on Applications page");

        stateHomePage.selectPrivateSchool(TestProperties.get("enteringSchool"));
        extentTest.log(LogStatus.PASS, "Verified : Successfully selected the school name :"+TestProperties.get("privateSchoolName"));

        stateHomePage.selectApplicationStatus(TestProperties.get("applicationStatusSchoolAdmin"));
        extentTest.log(LogStatus.PASS, "Verified : Successfully selected the applications status :"+ TestProperties.get("applicationsStatus") );

        String studentNameReviewList = schoolHomePage.studentNameClicked();
        extentTest.log(LogStatus.PASS, "Verified : Successfully clicked on student name:"+ studentNameReviewList);

        schoolHomePage.editStatusAction(TestProperties.get("schoolReview"));
        extentTest.log(LogStatus.PASS, "Status updated successfully with "+TestProperties.get("schoolReview"));

        admiralpage.admiralLogout();
        extentTest.log(LogStatus.INFO, "Verified : Successful logout from Scholarship admin user account");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("privateSchoolLogin3"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Private School  account");

        schoolHomePage.verifyStudentNameExistsReviewListAndClick(studentNameReviewList);
        extentTest.log(LogStatus.PASS, "Verified : Student name exists and click on application");

        schoolHomePage.verifyAttentionNotificationAndContent();
        extentTest.log(LogStatus.PASS, "Verified : Review message exists and verified its content");

/*
        schoolHomePage.uploadAcceptanceLetter(TestProperties.get("acparatorceptanceFilePath"));
        extentTest.log(LogStatus.PASS, "Verified : Acceptance letter uploaded successfully");
*/

        schoolHomePage.editStatusAction(TestProperties.get("initialReview2"));
        extentTest.log(LogStatus.PASS, "Status updated successfully with "+TestProperties.get("schoolReview"));
    }
}
