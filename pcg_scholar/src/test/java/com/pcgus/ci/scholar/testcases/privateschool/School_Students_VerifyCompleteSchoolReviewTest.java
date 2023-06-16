package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.SchoolHomepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.HashMap;

public class School_Students_VerifyCompleteSchoolReviewTest extends Base {
    private static final String TEST_ID="xvadpfvaijdhid224l337xy5ojgmyrkd";

    SchoolHomepage schoolHomePage = new SchoolHomepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    @Test
    public void school_students_verifycompleteschoolreview_xvadpfvaijdhid224l337xy5ojgmyrkd() throws InterruptedException, ParseException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Private School - Students - Complete School Review SHIP-588 583");
        loginPage.LoginPageDriverRef(Base.driver);
        schoolHomePage.SchoolHomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("privateSchoolLogin"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Private School user successfully");

        boolean schoolReviewGrid = schoolHomePage.verifySchoolReviewGridPresence();
        if(schoolReviewGrid){
            HashMap<String, String> userDetails = schoolHomePage.getFirstUserDetails();
            extentTest.log(LogStatus.PASS, "Verified : First user details captured");

            schoolHomePage.clickFirstUser();
            extentTest.log(LogStatus.PASS, "Verified : First user traversed from Review grid list");

            schoolHomePage.verifyReviewMessageDetails(userDetails);
            extentTest.log(LogStatus.PASS, "Verified : Review message details successfully");

            schoolHomePage.editStatusAction(TestProperties.get("initialReview"));
            extentTest.log(LogStatus.PASS, "Verified : Application status updated successfully");

            schoolHomePage.verifyApplicationRemovedFromReview(userDetails);
            extentTest.log(LogStatus.PASS, "Verified : Application removed from School review grid successfully");

            schoolHomePage.verifyApplicationPresentInNewAppGrid(userDetails);
            extentTest.log(LogStatus.PASS, "Verified : Application present in New application grid successfully");
        }
        else{
            extentTest.log(LogStatus.INFO, "School review Grid not present for the logged in user: "+TestProperties.get("privateSchoolLogin"));
            Assert.assertTrue(schoolReviewGrid);
        }
    }
}
