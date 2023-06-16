package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_DashboardWithoutApplicationTest extends Base {
	
	private static final String TEST_ID ="5ls5afio3fhyt5qeyfjwjbxaootkocmx";

    Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();
	
	@Test
	public void verify_parent_dashboardwithoutapplication_5ls5afio3fhyt5qeyfjwjbxaootkocmx() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "<b>TC Summary : Login page - Login with valid credentials</b>");
		loginPage.LoginPageDriverRef(driver);
		homePage.HomePageDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuserblank"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "<b>Verified : Logged in as Parent user successfully</b>");

		homePage.verifyNoApplicationDashboard("welcomeTitle", "WelcomeBody1", "WelcomeBody2");
		extentTest.log(LogStatus.PASS, "<b>Verified : Confirm the welcome message displayed correctly</b>");

		homePage.verifyhomepage();
		extentTest.log(LogStatus.PASS, "<b>Verified : Confirmed the side menu post login</b>");
	}

}
