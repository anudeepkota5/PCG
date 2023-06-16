package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.ApplicationPage;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class State_Applications_VerifyChangingStatusTest extends Base {
	
	private static final String TEST_ID="diik2ufsropgkdd5hhk6ehs3y3onlzua";

	Homepage homePage = new Homepage();
	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();

	CreateApplicationPage createapplicationpage=new CreateApplicationPage();
	ApplicationPage applicationpage = new ApplicationPage();

	@Test
	public void parent_createstudentapplicationtest_yjiakg6gqp2yviswy3zomiqiwymdt2ae() throws InterruptedException, AWTException {
		String firstName =  TestProperties.get("firstName")+getSaltString();
		String lastName = TestProperties.get("lastName")+getSaltString();
		String dob =  TestProperties.get("dateOfBirth");
		String statusType = TestProperties.get("statusTypeWithdraw");
		String statusType_Declined = TestProperties.get("statusTypeWithdraw");

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);
		homePage.HomePageDriverRef(Base.driver);
		applicationpage.newappilcationpageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
		createapplicationpage.newappilcationpageDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		applicationpage.clickTermDD();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on term DD");

		applicationpage.selectFirstValueOfTermDD("2023-2024");
		extentTest.log(LogStatus.PASS, "Verified : Selected the term as 23-24");

		String uniqueID = applicationpage.clickOnFirstApplicationWhoDoesNotHaveStatusType(statusType,statusType_Declined);
		extentTest.log(LogStatus.PASS, "Verified : Click on the id who does not contain withdrawn & declined status & get the unique ID");

		applicationpage.clickOnEditStatus();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on edit status");

		String selectedStatus = applicationpage.clickAndGetFirstStatus();
		extentTest.log(LogStatus.PASS, "Verified : Select the status");

		applicationpage.verifyStatusValue("Status", selectedStatus);
		extentTest.log(LogStatus.PASS, "Verified : Verify selected status on application page");

		homePage.clickOnapplication_icon();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on application icon");

		applicationpage.searchApplication(uniqueID);
		extentTest.log(LogStatus.PASS, "Verified : Searched the user via id");

		applicationpage.verifyStatusValueOnSearchApplicationPage(selectedStatus);
		extentTest.log(LogStatus.PASS, "Verified : Verify selected status on application search page");


	}
}
