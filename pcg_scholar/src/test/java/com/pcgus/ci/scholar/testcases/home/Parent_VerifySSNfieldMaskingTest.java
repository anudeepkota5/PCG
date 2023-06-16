package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifySSNfieldMaskingTest extends Base {

    private static final String TEST_ID ="p66ya4l4puqnymqqqqapvllububpk6ld";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_verifyssnfieldmasking_p66ya4l4puqnymqqqqapvllububpk6ld() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser2"), TestProperties.get("password"));
      //  scholarbase.loginToPCGScholarPortal("saharanqa2023+admintemp7@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        //       createapplicationpage.clickApplication();

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        createapplicationpage.clickSignAndSubmitTab();
        extentTest.log(LogStatus.PASS, "Verified : Clicked on Sign and Submit tab successfully");

        createapplicationpage.SSN_UnMasking("444-456-789");
        extentTest.log(LogStatus.PASS, "Verified : Unmasking functionality successfully for new application");

        createapplicationpage.SSN_Masking("345-456-789");
        extentTest.log(LogStatus.PASS, "Verified : Masking functionality successfully for new application");

        createapplicationpage.clickApplication();

        createapplicationpage.VerifyStatus("No Name", "Started");

        createapplicationpage.editapplication();

        createapplicationpage.clickSignAndSubmitTab();

        createapplicationpage.SSN_UnMasking("666-456-789");
        createapplicationpage.SSN_Masking("555-456-789");
/*
        createapplicationpage.verifysignature(TestProperties.get("SSN"));
        createapplicationpage.VerifyStatus("Wilber Zooman","SDE Review");
*/
    }
}
