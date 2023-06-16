package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Admiral_UserPasswordChangeTest extends Base {
	
	private static final String TEST_ID ="52q4q5sjd7im6jrelhhyxme7apx5fvcb";

	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();
	ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();
	
	@Test
	public void admiralchangepassword_52q4q5sjd7im6jrelhhyxme7apx5fvcb() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
		loginPage.LoginPageDriverRef(Base.driver);
		admiralpage.admiraluserPageDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
		extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");

		String newPass = admiralpage.changeUserPassword();
		extentTest.log(LogStatus.INFO, "Verified : User password is changed by Admiral user");

		admiralpage.admiralLogout();
		extentTest.log(LogStatus.INFO, "Verified : Successful logout from Admiral user account");

		extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
		loginPage.LoginPageDriverRef(Base.driver);
		admiralpage.admiraluserPageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "Password going to entered is "+newPass);
		scholarbase.reloginToPCGScholar(TestProperties.get("parentuserpwdchange"), newPass);
		extentTest.log(LogStatus.INFO, "Verified : Re-Logged in as Admiral user account");
	}

}
