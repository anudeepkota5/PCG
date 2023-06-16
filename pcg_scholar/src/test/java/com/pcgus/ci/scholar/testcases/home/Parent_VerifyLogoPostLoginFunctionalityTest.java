package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyLogoPostLoginFunctionalityTest extends Base {
	 
	private static final String TEST_ID="5aokx6u666cfq2vcduj4uos743gxcqvq";
	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();
	
	@Test
	public void verify_parent_logopostlogin_5aokx6u666cfq2vcduj4uos743gxcqvq() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : SHIP-218 - Parents landing page system logo");
		loginPage.LoginPageDriverRef(driver);
		homePage.HomePageDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.INFO, "Verified : Logged in as Parent user account");
		
		homePage.verifyparentsystemlogo();
		extentTest.log(LogStatus.INFO, "Verified : Logo is verified on Parent user at home page");

	}

}
