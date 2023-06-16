package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.HashMap;

public class State_Applications_VerifyChangeEnrollment_WithdrawFromProgramTest extends Base {

    private static final String TEST_ID="cuq3vsqbfagznzdxlve6ibolxk5wrx6n";

    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    ScholarAdmiralPage scholarAdmiralPage = new ScholarAdmiralPage();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();


    @Test
    public void stateapplicationsverifychangeenrollmentwithdrawfromprogram_cuq3vsqbfagznzdxlve6ibolxk5wrx6n() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        scholarAdmiralPage.admiraluserPageDriverRef(driver);

        scholarbase.loginToPCGScholarPortal("saharanqa2023+state@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");
     //   Thread.sleep(60000);

        HashMap<String, String> data = scholarAdmiralPage.selectAcceptedApplication();
        extentTest.log(LogStatus.PASS, "Verified : Selected an Accepted Application");

        scholarAdmiralPage.changeEnrollement();
        extentTest.log(LogStatus.PASS, "Verified : Selected Change Enrolment");

        scholarAdmiralPage.SelectChangeReason("Withdrawal");
        extentTest.log(LogStatus.PASS, "Verified : Perform WithDraw Application");

        scholarbase.signout();
        extentTest.log(LogStatus.PASS, "Verified : SignOut From Application");

        scholarbase.loginToPCGScholarPortal("saharanqa2023+admiral@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Admiral user successfully");
     //   Thread.sleep(60000);

        scholarAdmiralPage.assignSchoolToSTateUser(data.get("oldschool"));
        extentTest.log(LogStatus.PASS, "Verified : Assigned School " + data.get("oldschool"));

        scholarbase.signout();
        extentTest.log(LogStatus.PASS, "Verified : SignOut From Application");

        scholarbase.loginToPCGScholarPortal("saharanqa2023+sch1@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as School user successfully");
        Thread.sleep(60000);

        scholarAdmiralPage.verifyStudentExists(data.get("lName").trim() + " " + data.get("fname").trim());
        extentTest.log(LogStatus.PASS, "Verified : User doesnt Exist");
    }

}
