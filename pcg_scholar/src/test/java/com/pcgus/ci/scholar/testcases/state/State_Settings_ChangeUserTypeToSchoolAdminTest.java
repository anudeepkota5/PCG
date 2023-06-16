package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.AdmiralHomepage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class State_Settings_ChangeUserTypeToSchoolAdminTest extends Base {

private static final String TEST_ID ="l6o76nqzw3brxe7rmwohm2irqcqra3b3";

    Loginpage loginPage=new Loginpage();
    Homepage homepage = new Homepage();
    Base scholarbase=new Base();
    StateHomePage statehomepage=new StateHomePage();
    ScholarAdmiralPage scholarAdmiralPage=new ScholarAdmiralPage();
    AdmiralHomepage admiralHomepage=new AdmiralHomepage();

    @Test
    public void statesettingschangeusertypetoschooladmin_l6o76nqzw3brxe7rmwohm2irqcqra3b3() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "Scholarship Admin - Finances - Annual Statement - Verify Student list SHIP-506");
        loginPage.LoginPageDriverRef(Base.driver);
        statehomepage.StateHomePageDriverRef(Base.driver);
        homepage.HomePageDriverRef(Base.driver);
        scholarAdmiralPage.admiraluserPageDriverRef(Base.driver);
        admiralHomepage.AdmiralHomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as State user account successfully");

        admiralHomepage.changeUserType("saharanqa2023+parent@gmail.com","School Admin");
        extentTest.log(LogStatus.PASS, "Verified : Changes the User to School Admin role type successfully");

        admiralHomepage.changeUserType("saharanqa2023+parent@gmail.com","Parent");
        extentTest.log(LogStatus.PASS, "Verified : Changes the User to back to previous actual user role type successfully");
    }
}

