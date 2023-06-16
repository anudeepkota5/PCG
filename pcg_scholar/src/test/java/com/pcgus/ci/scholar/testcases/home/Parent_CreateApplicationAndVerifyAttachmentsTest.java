package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_CreateApplicationAndVerifyAttachmentsTest extends Base {

    private static final String TEST_ID ="cghjvcj4wwqp45orwpi5tanutdoza7ud";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_createapplicationandverifyattachments_cghjvcj4wwqp45orwpi5tanutdoza7ud() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);
        createapplicationpage.newappilcationpageDriverRef(Base.driver);
        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);

      scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
 //       scholarbase.loginToPCGScholarPortal("saharanqa2023+admintemp7@gmail.com", TestProperties.get("password"));

        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

/*
        createapplicationpage.editlatestapplication();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");
*/

        createapplicationpage.verifyUploads();
        extentTest.log(LogStatus.PASS, "Verified : upload successfully");
    }
}