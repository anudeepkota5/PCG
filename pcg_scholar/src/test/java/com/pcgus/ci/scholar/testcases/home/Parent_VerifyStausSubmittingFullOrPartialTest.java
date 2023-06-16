package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyStausSubmittingFullOrPartialTest extends Base{

    private static final String TEST_ID ="fl3dr36n74ubyc3qib6anuftmptqcysp";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_verifystatussubmittingfullorpartial_fl3dr36n74ubyc3qib6anuftmptqcysp() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser"), TestProperties.get("password"));
     //   scholarbase.loginToPCGScholarPortal("saharanqa2023+testparent1@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        createapplicationpage.addingStudentInformation();
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.entersignature(TestProperties.get("SSN"));
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        createapplicationpage.VerifyStatus("Oliver Twist","Initial Review");


        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        createapplicationpage.clickContinue();
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.clickContinue();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.clickContinue();
        Thread.sleep(5000);

        createapplicationpage.clickSubmit();
        extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

        createapplicationpage.VerifyStatus("No Name", "Started");
    }
}
