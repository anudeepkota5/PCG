package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.MyInfoPage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_UserPasswordChangeTest extends Base {
	
	private static final String TEST_ID ="2ok5id7n72he2ss4vy3nfu2f4onsdee2";

	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();
	ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();
	MyInfoPage myinfoPage = new MyInfoPage();
	Homepage homepage = new Homepage();

	@Test
	public void parent_userchangepassword_2ok5id7n72he2ss4vy3nfu2f4onsdee2() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		myinfoPage.MyInfoDriverRef(Base.driver);
		homepage.HomePageDriverRef(driver);
		loginPage.LoginPageDriverRef(Base.driver);
		admiralpage.admiraluserPageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
		String currentPwd = scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
		extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent <b>"+TestProperties.get("parentuser")+"</b> user account with Password <b>"+currentPwd+"</b>");

		String newPass = myinfoPage.changepassword(currentPwd);
		extentTest.log(LogStatus.INFO, "Verified : Change password is working fine");

		homepage.logout();
		extentTest.log(LogStatus.INFO, "Verified : Successful logout from Parent user account");

		scholarbase.reloginToPCGScholar(TestProperties.get("parentuserpwdchange"), newPass);
		extentTest.log(LogStatus.INFO, "Verified : Re-Logged in as Admiral user account");
	}
}
