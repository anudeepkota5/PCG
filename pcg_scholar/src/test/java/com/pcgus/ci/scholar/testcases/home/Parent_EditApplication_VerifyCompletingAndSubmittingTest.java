package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_EditApplication_VerifyCompletingAndSubmittingTest extends Base {
    private static final String TEST_ID="7ino4ulkq6yq52ne6ghbj2sn3of3xrew";

    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_editapplication_verifycompletingandsubmittingtest_7ino4ulkq6yq52ne6ghbj2sn3of3xrew() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Edit Application - Verify completing and submitting");
        loginPage.LoginPageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        homePage.HomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        String uniqueName = "Rishabh_"+returnUniqueData();
        createapplicationpage.addingStudentInformationWithUniqueName(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        homePage.verifyApplicationsTab();
        extentTest.log(LogStatus.PASS, "Verified : Applications Info page opened successfully");

        homePage.EditApplication(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Edit Application page opened successfully");

        createapplicationpage.clickContinueButton();
        extentTest.log(LogStatus.PASS, "Verified : Moved forward to Parent information successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.uploadFiles();
        extentTest.log(LogStatus.PASS, "Verified : All files uploaded successfully");

        createapplicationpage.entersignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        homePage.verifyStudentDetails(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student details successfully");

        homePage.verifyDownloads(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : ALL PDF downloaded successfully");

        //Expected to fail due to existing defect in application as default
        // LNH PDF not displayed after creation of application
        homePage.verifyPDFFileLabel(uniqueName, TestProperties.get("lnhLabel"));
        extentTest.log(LogStatus.PASS, "Verified : LNH PDF file details successfully");
    }
}
