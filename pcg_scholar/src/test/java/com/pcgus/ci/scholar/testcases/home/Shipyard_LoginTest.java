package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Shipyard_LoginTest extends Base {
	
	private static final String TEST_ID ="wrdbpzvmk7z4ee7ybsfukofz2jiqgrzz";

	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();
	
	@Test
	public void shipyard_login_wrdbpzvmk7z4ee7ybsfukofz2jiqgrzz() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Login page - Verify Login Page displays SHIP-207");
		loginPage.LoginPageDriverRef(driver);
		homePage.HomePageDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");



	}

}
