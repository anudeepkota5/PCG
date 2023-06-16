package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.ApplicationPage;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class ParentApplicationsVerifyMessageDisplaysApplicationIsReturnedtoParentTest extends Base {

    private static final String TEST_ID = "5kf6gp6bzdybrgqlnluifsgxv34vyf2v";

    Homepage homePage = new Homepage();
    Loginpage loginPage = new Loginpage();
    Base scholarbase = new Base();

    CreateApplicationPage createapplicationpage = new CreateApplicationPage();
    ApplicationPage applicationpage = new ApplicationPage();

    @Test
    public void verifyChangeStatusToReturnedandParentProcess_5kf6gp6bzdybrgqlnluifsgxv34vyf2v() throws InterruptedException, AWTException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        homePage.HomePageDriverRef(Base.driver);
        applicationpage.newappilcationpageDriverRef(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Applications - Verify message displays if application is Returned to Parent SHIP-470");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser7"), TestProperties.get("password"));
 //       scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

        applicationpage.applicationLink();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on application");
        String studentName  = applicationpage.getStudentName();
        applicationpage.verifyMessageApplication(studentName);

        String firstName[]  = applicationpage.spiltingStudentName(studentName);
        homePage.EditApplication( firstName[0]);
        extentTest.log(LogStatus.PASS, "Verified : Edit Application page opened successfully");

        applicationpage.verifyMessageInEditApplication(studentName);
        extentTest.log(LogStatus.PASS, "Verified : Message at the top of each step page");


    }
}