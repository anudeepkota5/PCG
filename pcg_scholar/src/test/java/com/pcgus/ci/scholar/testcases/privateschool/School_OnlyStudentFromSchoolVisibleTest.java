package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.List;

public class School_OnlyStudentFromSchoolVisibleTest extends Base {

    private static final String TEST_ID ="oqll6m5jprr6ninouyjntrllff22grmo";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();

    @Test
    public void school_onlystudentfromschoolvisible_oqll6m5jprr6ninouyjntrllff22grmo() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser2"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");
        homepage.HomePageDriverRef(Base.driver);
        List<String> Students = homepage.getStudents();
        homepage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser3"), TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");

        List<String> newStudents = homepage.getStudents();

        for(String Student:Students){
            if(newStudents.contains(Student))
                extentTest.log(LogStatus.FAIL, Student +"is in "+newStudents.toString());
            else
                extentTest.log(LogStatus.INFO, Student +"is NOT in "+newStudents.toString());
        }

        homepage.logout();

    }
}
