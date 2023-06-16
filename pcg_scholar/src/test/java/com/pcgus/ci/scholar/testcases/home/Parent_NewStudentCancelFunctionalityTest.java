package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_NewStudentCancelFunctionalityTest extends Base {

	private static final String TEST_ID ="5ygoihx5usxkq4mmfqxabdzhgxxdpjr7";
	
	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();

	CreateApplicationPage createAppPage = new CreateApplicationPage();
	
	@Test
	public void parent_newstudentcancefunctioinality_5ygoihx5usxkq4mmfqxabdzhgxxdpjr7() throws InterruptedException {

		// Not to be deleted
		// Need special type pf account which has list of student from previous year as well
		// Test Data :: testingold@pcgus.com / Aloha2023!

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "<b>TC Summary : SHIP-218 - Parents landing page</b>");
		loginPage.LoginPageDriverRef(Base.driver);
		homePage.HomePageDriverRef(Base.driver);
		createAppPage.newappilcationpageDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser3"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "<b>Verified : Logged in as Parent user account</b>");

		createAppPage.verifyOldStudentListInNewStudentToast();
		extentTest.log(LogStatus.INFO, "<b>Verified : New Student popup is validated and gets cancelled successfully</b>");
	}
}
