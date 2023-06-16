package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Shipyard_ForgotPasswordLinkTest extends Base {
	 
	private static final String TEST_ID ="fyix766xl46uiqpfjvytscuncl3le4bw";
	
	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();

	@Test
	public void shipyard_forgotpasswordlink_fyix766xl46uiqpfjvytscuncl3le4bw() throws InterruptedException  {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		//Launch Shipyard url
		loginPage.LoginPageDriverRef(driver);
		extentTest.log(LogStatus.INFO, "Verified : Launching of Shipyard application page");

		//Verifying forgot password reset link
		loginPage.verifyforgotpasswordlink();
		extentTest.log(LogStatus.INFO, "Verified : Forgot password reset link");
	}
}
