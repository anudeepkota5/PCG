package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.List;

public class Parent_OnlyStudentFromParentVisible extends Base {

    private static final String TEST_ID ="ljj2tdfpp7gem3ufhjwy7oqn6xyk4jd4";

    Loginpage loginPage=new Loginpage();
    Homepage homepage =new Homepage();
    Base scholarbase=new Base();
    ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();

    @Test
    public void parent_onlystudentfromparentvisible_ljj2tdfpp7gem3ufhjwy7oqn6xyk4jd4() throws InterruptedException {

        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
        loginPage.LoginPageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser"), TestProperties.get("password"));
     //   scholarbase.loginToPCGScholarPortal("saharanqa2023+admintemp7@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent 1 user account");
        homepage.HomePageDriverRef(Base.driver);
        List<String> Students = homepage.getParentStudents();

        extentTest.log(LogStatus.INFO, "Verified : Got the student list");
        Base.takeScreenShot();
        homepage.logout();

        scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));

   //     scholarbase.loginToPCGScholarPortal("saharanqa2023+admintemp6@gmail.com", TestProperties.get("password"));
        extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent 2 user account");

        List<String> newStudents = homepage.getParentStudents();

        for(String Student:Students){
            if(newStudents.contains(Student))
                extentTest.log(LogStatus.FAIL, Student +"is in "+newStudents.toString());
            else
                extentTest.log(LogStatus.INFO, Student +"is NOT in "+newStudents.toString());
        }
        Base.takeScreenShot();
        homepage.logout();

    }
}
