package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_AllButtonsOnUserHomePageTest extends Base {
	
	private static final String TEST_ID = "bmgeilmjmthaiy5jtgrpa5gspuf5ruzv";
	
	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();
	
	@Test
	public void verify_parent_allbuttononhomepage_bmgeilmjmthaiy5jtgrpa5gspuf5ruzv() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "SHIP-218 - Parents landing page action icons");
		loginPage.LoginPageDriverRef(driver);
		homePage.HomePageDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser2"), TestProperties.get("password"));
		extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent user successfully");
		
		homePage.verifyparentsystemlogo();
		extentTest.log(LogStatus.INFO, "Verified : On parent user,all buttons are displayed on the page");
		
		
		
		
	}

}
