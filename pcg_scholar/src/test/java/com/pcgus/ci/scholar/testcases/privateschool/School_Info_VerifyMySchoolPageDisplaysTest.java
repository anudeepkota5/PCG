package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.SchoolHomepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.text.ParseException;

public class School_Info_VerifyMySchoolPageDisplaysTest extends Base {
    private static final String TEST_ID="aalmucrgufupcslfyqve7grs3ef3ulfm";

    SchoolHomepage schoolHomePage = new SchoolHomepage();
    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    @Test
    public void school_info_verifymyschoolpagedisplays_aalmucrgufupcslfyqve7grs3ef3ulfm() throws InterruptedException, ParseException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Private School - Student Info - Verify My School page displays SHIP-253");
        loginPage.LoginPageDriverRef(Base.driver);
        schoolHomePage.SchoolHomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("privateSchoolLogin2"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Private School user successfully");

        schoolHomePage.verifySchoolName(TestProperties.get("schoolName"));
        extentTest.log(LogStatus.PASS, "Verified : School Name successfully");

        schoolHomePage.verifySchoolDetailsLabel();
        extentTest.log(LogStatus.PASS, "Verified : School Info Label details successfully");

        schoolHomePage.verifyDisabledFieldsForSchool();
        extentTest.log(LogStatus.PASS, "Verified : Presence of disabled fields successfully");

        schoolHomePage.verifyEditableFieldsForSchool();
        extentTest.log(LogStatus.PASS, "Verified : Presence of Editable fields successfully");
    }
}
