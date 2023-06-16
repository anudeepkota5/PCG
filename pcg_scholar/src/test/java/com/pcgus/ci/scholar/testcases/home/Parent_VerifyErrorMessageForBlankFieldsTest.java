package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyErrorMessageForBlankFieldsTest extends Base{
    private static final String TEST_ID ="oin56yoed7jfs7hxiwvss4ncwbt5wbqv";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    CreateApplicationPage createapplicationpage=new CreateApplicationPage();

    @Test
    public void parent_verifyerrormessageforblankfieldstest_oin56yoed7jfs7hxiwvss4ncwbt5wbqv() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
        createapplicationpage.newappilcationpageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
     //   scholarbase.loginToPCGScholarPortal("saharanqa2023+testparent@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

        createapplicationpage.newStudentPopUp();
        extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

        createapplicationpage.addingStudentInformation();
        extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

        createapplicationpage.parentinformation();
        extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

        createapplicationpage.validateError("Please review your application for errors. All section headers must be check-marked before you can submit your application.");
        extentTest.log(LogStatus.PASS, "Verified : Error Message Displayed");
    }
}
