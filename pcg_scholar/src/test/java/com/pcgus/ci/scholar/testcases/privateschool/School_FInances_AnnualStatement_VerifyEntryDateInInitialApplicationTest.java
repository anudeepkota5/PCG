package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.pages.SchoolHomepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class School_FInances_AnnualStatement_VerifyEntryDateInInitialApplicationTest extends Base {

    private static final String TEST_ID ="uis6mzs53livqsx32wddabh5y5npjcra";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();
    BrowserDriver browserDriver = new BrowserDriver();
    SchoolHomepage schoolHomepage = new SchoolHomepage();

    @Test
    public void school_annualstatement_verifyentrydate_uis6mzs53livqsx32wddabh5y5npjcra() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        loginPage.LoginPageDriverRef(Base.driver);
        schoolHomepage.SchoolHomePageDriverRef(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Private School - Annual Statements - Verify Entry Date field for Initial Applications SHIP-812");


        scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser2"), TestProperties.get("password"));
 //       scholarbase.loginToPCGScholarPortal("saharanqa2023+testparent1@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as School user account successfully");
        takeScreenShot();
        Thread.sleep(3000);

        schoolHomepage.verify_entryDateFieldForInitialApplication();
        extentTest.log(LogStatus.INFO, "Verified : Entry Date field is verified successfully for Initial appliaction");
    }
}
