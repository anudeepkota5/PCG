package com.pcgus.ci.scholar.testcases.privateschool;

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

public class School_VerifySchoolReviewGridTest extends Base {

	private static final String TEST_ID="hcamckwrprbpdgkdnvadqjbag3wocxhc";

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

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);
		homePage.HomePageDriverRef(Base.driver);
		applicationpage.newappilcationpageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
		createapplicationpage.newappilcationpageDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

		createapplicationpage.newStudentPopUp();
		extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

		createapplicationpage.addingStudentInformation(firstName, lastName, dob);
		extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

		createapplicationpage.parentinformation();
		extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

		createapplicationpage.verifysignature(TestProperties.get("SSN"));
		extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

		scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		applicationpage.clickTermDD();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on term DD");

		applicationpage.selectFirstValueOfTermDD("2022-2023");
		extentTest.log(LogStatus.PASS, "Verified : Deselected the selected term");

		applicationpage.selectFirstValueOfTermDD("2023-2024");
		extentTest.log(LogStatus.PASS, "Verified : Selected the term as 23-24");

		applicationpage.searchApplication(firstName);
		extentTest.log(LogStatus.PASS, "Verified : Searched the user via first name");

		String uniqueID = applicationpage.getUniqueID("1", "2");
		extentTest.log(LogStatus.PASS, "Verified : Get the unique ID");

		applicationpage.clickOnSearchedValue("1","3");
		extentTest.log(LogStatus.PASS, "Verified : Clicked on user");

		applicationpage.verifyValueInHeader(firstName+" "+lastName);
		extentTest.log(LogStatus.PASS, "Verified : verify first & last name in header");

		applicationpage.verifyUniqueIdInHeader(lastName,uniqueID);
		extentTest.log(LogStatus.PASS, "Verified : Verify unique ID in header");

		applicationpage.clickOnEditStatus();
		extentTest.log(LogStatus.PASS, "Verified : Cliked on edit status");

		applicationpage.selectStatusAsSchoolReview();
		extentTest.log(LogStatus.PASS, "Verified : Select the status as school review");

		homePage.logout();
		extentTest.log(LogStatus.PASS, "Verified : User logged out");

		scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser4"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as School user successfully");

		applicationpage.verifyApplicationInSchoolReviewSection(firstName+" "+lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify first & last name under school review section");

		homePage.logout();
		extentTest.log(LogStatus.PASS, "Verified : User logged out");

		scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		applicationpage.clickTermDD();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on term DD");

		applicationpage.selectFirstValueOfTermDD("2022-2023");
		extentTest.log(LogStatus.PASS, "Verified : Deselected the selected term");

		applicationpage.selectFirstValueOfTermDD("2023-2024");
		extentTest.log(LogStatus.PASS, "Verified : Selected the term as 23-24");

		applicationpage.searchApplication(firstName);
		extentTest.log(LogStatus.PASS, "Verified : Searched the user via first name");

		applicationpage.clickOnSearchedValue("1","3");
		extentTest.log(LogStatus.PASS, "Verified : Clicked on user");

		applicationpage.clickOnEditStatus();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on edit status");

		applicationpage.selectStatusAsInitialReview();
		extentTest.log(LogStatus.PASS, "Verified : Select the status as school review");

		homePage.logout();
		extentTest.log(LogStatus.PASS, "Verified : User logged out");

		scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as School user successfully");

		applicationpage.verifyApplicationShouldNotBeDisplayedInSchoolReviewSection(firstName+" "+lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify first & last name under school review section should not be displayed");

	}
}
