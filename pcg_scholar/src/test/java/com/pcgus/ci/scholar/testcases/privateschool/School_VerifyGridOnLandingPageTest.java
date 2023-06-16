package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.page.privateschool.Privateschoolpage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class School_VerifyGridOnLandingPageTest extends Base {

	private static final String TEST_ID ="b436seylvz4oyra36tekpph2csfqenyy";


	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();
	Privateschoolpage privateschoolpage=new Privateschoolpage();

	@Test
	public void school_verifygridonlandingpage_b436seylvz4oyra36tekpph2csfqenyy() throws InterruptedException {

		setTestId(TEST_ID);
	//	BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Private school - Verify grids display on My Students page SHIP-143");
		loginPage.LoginPageDriverRef(Base.driver);
		privateschoolpage.privatepageschoolDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser2"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as School user account");

		privateschoolpage.verifyprivateschoolpagegrids();
		extentTest.log(LogStatus.INFO, "Verified : Grids on the school landing page");

	}
}