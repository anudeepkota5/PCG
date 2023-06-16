package com.pcgus.ci.scholar.testcases.home;
import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_CreateAndSubmitApplicationTest extends Base{
        private static final String TEST_ID="levtrzmpqemfphbnha2uyup4z2tzxuha";
    Homepage homePage = new Homepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_createandsubmitapplication_levtrzmpqemfphbnha2uyup4z2tzxuha() throws InterruptedException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Create and Submit application");
        loginPage.LoginPageDriverRef(Base.driver);
        homePage.HomePageDriverRef(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        String uniqueName = TestProperties.get("firstName")+getSaltString();
        createapplicationpage.addingStudentInformationWithUniqueName(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.verifyAllUploads();
        extentTest.log(LogStatus.PASS, "Verified : Verified all uploads and downloads successfully");

        createapplicationpage.entersignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        homePage.verifyStudentDetails(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : Student details successfully");

        homePage.verifyDownloads(uniqueName);
        extentTest.log(LogStatus.PASS, "Verified : PDF downloads successfully");

        //Expected to fail due to existing defect in application as default
        // LNH PDF not displayed after creation of application
        homePage.verifyPDFFileLabel(uniqueName, TestProperties.get("lnhLabel"));
        extentTest.log(LogStatus.PASS, "Verified : LNH PDF file details successfully");
    }
}
