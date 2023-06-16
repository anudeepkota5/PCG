package com.pcgus.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.scholar.pages.state.StateHomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

	public class StateUserHomePageTest extends Base {
		
	private static final String TEST_ID ="otfu3zlxps54uvrxnl4kmslt7a2nbbxc";

		
		Loginpage loginPage=new Loginpage();
		Homepage homepage = new Homepage();
		Base scholarbase=new Base();
		StateHomePage statehomepage=new StateHomePage();
		
		@Test
		public void stateuserhomepage_otfu3zlxps54uvrxnl4kmslt7a2nbbxc() throws InterruptedException {
			
			setTestId(TEST_ID);
			BrowserDriver.setDriver(Base.driver);

			extentTest.log(LogStatus.INFO, "Scholarship Admin - Applications - Verify loading student application SHIP-403 663");
			loginPage.LoginPageDriverRef(Base.driver);
			statehomepage.StateHomePageDriverRef(Base.driver);
			homepage.HomePageDriverRef(Base.driver);

			scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
			extentTest.log(LogStatus.PASS, "Verified : Logged in as Satet user account successfully");

			statehomepage.selectFirstRowAnsValidateData();
			extentTest.log(LogStatus.PASS, "Verified : Student row is selected successfully");

			homepage.logout();
			extentTest.log(LogStatus.PASS, "Verified : Logged out from application successfully");

		}
	}

