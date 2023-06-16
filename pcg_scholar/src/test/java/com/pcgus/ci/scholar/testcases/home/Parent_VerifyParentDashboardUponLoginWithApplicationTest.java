package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Parent_VerifyParentDashboardUponLoginWithApplicationTest extends Base {
    private static final String TEST_ID="ay3jx7tr57vw55no25t7b3vyicaoudwq";

    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    CreateApplicationPage createapplicationpage=new CreateApplicationPage();
    HashMap<String, String> fileDateMap = new HashMap<>();

    @Test
    public void parent_verifyparentdashboarduponloginwithapplication_ay3jx7tr57vw55no25t7b3vyicaoudwq() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Applications - Verify Parent Dashboard upon login with applications SHIP-219 218 634");
        loginPage.LoginPageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        homePage.HomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        homePage.verify_parent_homepage_icons();
        extentTest.log(LogStatus.PASS, "Verified : Logo and name on left Nav bar after parent login");

        String schoolYear = createapplicationpage.createApplicationPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        String uniqueName = "Rishabh_"+returnUniqueData();
        createapplicationpage.addingStudentInformationWithUniqueName(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        fileDateMap = createapplicationpage.uploadPdfNCaptureDates();
        extentTest.log(LogStatus.PASS, "Verified : All files uploaded successfully");

        createapplicationpage.entersignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        homePage.verifySchoolYear(uniqueName, schoolYear);
        extentTest.log(LogStatus.PASS, "Verified : School Year detail successfully");

        homePage.verifyStudentDetails(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student details successfully");

        homePage.verifyScholarShipAmount(uniqueName, TestProperties.get("scholarShipAmount"));
        extentTest.log(LogStatus.PASS, "Verified : Scholarship amount successfully");

        homePage.verifyPDFFileDetails(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : PDF File details successfully");

        homePage.verifyPDFUploadDate(uniqueName, fileDateMap);
        extentTest.log(LogStatus.PASS, "Verified : PDF File upload dates are correctly displayed on application page");

        homePage.verifyActionDropdown(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Action dropdown details successfully");

        //Expected to fail due to existing defect in application as default
        // LNH PDF not displayed after creation of application
        homePage.verifyPDFFileLabel(uniqueName, TestProperties.get("lnhLabel"));
        extentTest.log(LogStatus.PASS, "Verified : LNH PDF file details successfully");
    }
}
