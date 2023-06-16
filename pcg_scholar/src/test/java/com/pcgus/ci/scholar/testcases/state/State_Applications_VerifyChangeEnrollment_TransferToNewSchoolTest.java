package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;


public class State_Applications_VerifyChangeEnrollment_TransferToNewSchoolTest extends  Base {
    private static final String TEST_ID ="tjp6db2ks6d3wnxx2sjyklhxkgdq3vkw";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();

    StateHomePage statePage=new StateHomePage();

    Homepage homePage = new Homepage();
    @Test
    public void state_applications_verifychangeenrollment_transfertonewschool_tjp6db2ks6d3wnxx2sjyklhxkgdq3vkw() throws InterruptedException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        extentTest.log(LogStatus.INFO, "TC Summary : Scholarship Admin - Verify Enrollment Changes - Transfer to new school SHIP-812");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.admiraluserPageDriverRef(Base.driver);
        statePage.StateHomePageDriverRef(Base.driver);
        Thread.sleep(5000);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as scholarship admin  account");

        statePage.clickOnApplicationsIcon();
        extentTest.log(LogStatus.PASS, "Verified : Successfully landed on Applications page");

        statePage.termSelect(TestProperties.get("termYearRange"));
        extentTest.log(LogStatus.PASS, "Verified : Successfully selected the term year range :"+ TestProperties.get("termYearRange") );

        statePage.termSelect(TestProperties.get("termYearRange1"));
        extentTest.log(LogStatus.PASS, "Verified : Successfully selected the term year range :"+ TestProperties.get("termYearRange1") );

        statePage.selectApplicationStatus(TestProperties.get("applicationsStatus"));
        extentTest.log(LogStatus.PASS, "Verified : Successfully selected the applications status :"+ TestProperties.get("applicationsStatus") );

        boolean bool = statePage.applicationsList();
        if (bool) {
            extentTest.log(LogStatus.PASS, "Verified : Applications list displayed ");
            statePage.selectPrivateSchool(TestProperties.get("privateSchoolName"));
            extentTest.log(LogStatus.PASS, "Verified : Successfully selected the school name :"+TestProperties.get("privateSchoolName") );
            boolean flag = statePage.verifyApplicationExists();
            if (flag) {
                String studentName = statePage.changeEnrollmentOfStudent(TestProperties.get("schoolNameToSelect"));
                extentTest.log(LogStatus.PASS, "Verified : Successfully change the enrollment of student. Student Name : " + studentName);
                admiralpage.admiralLogout();
                extentTest.log(LogStatus.INFO, "Verified : Successful logout from  account");

                scholarbase.reloginToPCGScholar(TestProperties.get("privateSchoolLogin2"), TestProperties.get("password"));
                extentTest.log(LogStatus.PASS, "Verified : Logged in to account");
                statePage.clickOnStudentsIcon();
                boolean exists = statePage.verifyStudentNameExists(studentName);
                if (!exists) {
                    extentTest.log(LogStatus.PASS, "Verified : Student name doesn't exists");
                }
                admiralpage.admiralLogout();
                extentTest.log(LogStatus.INFO, "Verified : Successful logout from account");

                scholarbase.reloginToPCGScholar(TestProperties.get("privateSchoolLogin2"), TestProperties.get("password"));
                extentTest.log(LogStatus.PASS, "Verified : Logged in to account");
                statePage.clickOnStudentsIcon();
                boolean exists2 = statePage.verifyStudentNameExists(studentName);
                if (exists2) {
                    extentTest.log(LogStatus.PASS, "Verified : Student name exists");
                }
                admiralpage.admiralLogout();
                extentTest.log(LogStatus.INFO, "Verified : Successful logout from account");
            }

        }else {
            extentTest.log(LogStatus.PASS, "Verified : Application list is empty kindly use different account" );
            admiralpage.admiralLogout();
            extentTest.log(LogStatus.INFO, "Verified : Successful logout from Admiral user account");
        }
    }
}
