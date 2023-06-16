package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Admiral_VerifyMyInfopageTest extends Base {
	
	private static final String TEST_ID ="ahfkbfwlvpqqiwfsf33ogik5krw2me6m";

	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();
	ScholarAdmiralPage admiralpage=new ScholarAdmiralPage();
	
	@Test
	public void verify_admiralmyinfopage_ahfkbfwlvpqqiwfsf33ogik5krw2me6m() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Admin - Verify My Info page");
		loginPage.LoginPageDriverRef(Base.driver);
		admiralpage.admiraluserPageDriverRef(Base.driver);


		scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
		extentTest.log(LogStatus.INFO, "Verified : Logged in as Admiral user account");
		
	    admiralpage.verifyinfopage();
		extentTest.log(LogStatus.INFO, "Verified : Page loads with accurate information, same as it was used to create the account. Username and password are readonly with Change Password button underneath");
		
		admiralpage.saveEditChanges();
		extentTest.log(LogStatus.INFO, "Verified : While saving, the fields become disabled, and the save button displays 'Saving..' until saving is completed . Changes persist");

		admiralpage.admiralLogout();
		extentTest.log(LogStatus.INFO, "Verified : Successful logout from Admiral user account");
	}

}
