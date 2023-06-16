package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_Homepage_MenuOptionTest extends Base {

	private static final String TEST_ID ="egpjhsof6cs7c65jfjwxwdgeuijeya4y";

	Homepage homePage = new Homepage();
	Base scholarbase=new Base();
	
	@Test
	public void parent_homepagemenuoptions_egpjhsof6cs7c65jfjwxwdgeuijeya4y() throws InterruptedException {

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

	//	homePage.HomePageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : SHIP-218 - Parents landing page");
		homePage.HomePageDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");

		homePage.verifyHomeapagebuttons();
		extentTest.log(LogStatus.INFO, "Verified : Home page side menu options");

		homePage.logout();
		extentTest.log(LogStatus.INFO, "Verified : User logged out successfully");

	}
}
