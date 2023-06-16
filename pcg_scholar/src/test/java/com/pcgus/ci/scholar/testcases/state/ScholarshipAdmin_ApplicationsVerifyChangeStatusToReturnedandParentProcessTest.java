package com.pcgus.ci.scholar.testcases.state;

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

public class ScholarshipAdmin_ApplicationsVerifyChangeStatusToReturnedandParentProcessTest extends Base {

    private static final String TEST_ID = "ex7udufjolha5iaxvvxtseuo7xsqhpk4";

    Homepage homePage = new Homepage();
    Loginpage loginPage = new Loginpage();
    Base scholarbase = new Base();

    CreateApplicationPage createapplicationpage = new CreateApplicationPage();
    ApplicationPage applicationpage = new ApplicationPage();

    @Test
    public void verifyChangeStatusToReturnedandParentProcess_ex7udufjolha5iaxvvxtseuo7xsqhpk4() throws InterruptedException, AWTException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        homePage.HomePageDriverRef(Base.driver);
        applicationpage.newappilcationpageDriverRef(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Scholarship Admin - Applications - Verify Change Status to Returned and Parent process SHIP-377");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser9"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as School user successfully");
        String studentName = applicationpage.getStudentName();
        String applicationStatus = applicationpage.applicationStatus(studentName);

        if (applicationStatus.equals("Returned to Parent")) {
            homePage.EditApplication(studentName);
            extentTest.log(LogStatus.PASS, "Verified : Edit Application page opened successfully");

            createapplicationpage.clickContinueButton();
            extentTest.log(LogStatus.PASS, "Verified : Moved forward to Parent information successfully");

            createapplicationpage.clickOnSubmit();
            extentTest.log(LogStatus.PASS, "Verified : Submitted successfully");
        }

        homePage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("scholaradmin"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

        applicationpage.applicationLink();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on application");

        String firstName[] = applicationpage.spiltingStudentName(studentName);
        applicationpage.searchApplication(firstName[0]);
        extentTest.log(LogStatus.PASS, "Verified : Searched the user via first name");

        applicationpage.firstNameLink();
        applicationpage.clickOnEditStatus();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on edit status");

        applicationpage.selectStatusAsReturnedtoParent();
        extentTest.log(LogStatus.PASS, "Verified : status Updated to Returned to Parent");

        applicationpage.clickOnSaveChangesButton();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

        homePage.logout();
        extentTest.log(LogStatus.PASS, "Verified : User logged out");

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser9"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as School user successfully");

        applicationpage.verifyApplicationStatus(studentName);
        extentTest.log(LogStatus.PASS, "Verified : Verifying the message and status to 'Return to Parent' ");

        homePage.EditApplication(studentName);
        extentTest.log(LogStatus.PASS, "Verified : Edit Application page opened successfully");

        createapplicationpage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Verified : Moved forward to Parent information successfully");

        createapplicationpage.clickOnSubmit();
        extentTest.log(LogStatus.PASS, "Verified : Submitted successfully");

        applicationpage.applicationLink();
        applicationpage.verifyApplicationStatusInitial();

        extentTest.log(LogStatus.PASS, "Verified : Clicked on application");

        homePage.logout();
        scholarbase.loginToPCGScholarPortal(TestProperties.get("scholaradmin"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as School user successfully");

        applicationpage.applicationLink();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on application");

        applicationpage.searchApplication(firstName[0]);
        extentTest.log(LogStatus.PASS, "Verified : Searched the user via first name");

        applicationpage.firstNameLink();
        applicationpage.verifyStatus();
        homePage.logout();

    }
}