package com.pcgus.ci.scholar.testcases.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class State_Users_VerifyAddAndEditUserAsScholarshipAdminTest extends Base {
	
	private static final String TEST_ID="cmy5itgf2n3avz5zfw3zy3tyckafblnk";

	Homepage homePage = new Homepage();
	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();

	CreateApplicationPage createapplicationpage=new CreateApplicationPage();
	ApplicationPage applicationpage = new ApplicationPage();
	UserPage userPage = new UserPage();

	String firstName =  TestProperties.get("firstName")+getSaltString_WithoutDigit();
	String lastName = TestProperties.get("lastName")+getSaltString_WithoutDigit();

	String mobileNumber = TestProperties.get("mobileNumber");
	String email =  TestProperties.get("emailPrefix")+getCurrentTimeStamp()+ TestProperties.get("emailSuffix");


	@Test
	public void state_users_verifyaddandedituserasscholarshipadmin_cmy5itgf2n3avz5zfw3zy3tyckafblnk() throws InterruptedException, AWTException {

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);
		homePage.HomePageDriverRef(Base.driver);
		applicationpage.newappilcationpageDriverRef(Base.driver);
		userPage.newappilcationpageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Site Settings - Users - Verify Add and Edit User as Scholarship Admin  SHIP-596 759");
		createapplicationpage.newappilcationpageDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		homePage.clickOnSetting_icon();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on settings icon");

		userPage.clickOnAddUserButton();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on add user");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifyErrorMessage("First name", "Please enter a valid name");
		extentTest.log(LogStatus.PASS, "Verified : Error msg for first name field");

		userPage.verifyErrorMessage("Last name", "Please enter a valid name");
		extentTest.log(LogStatus.PASS, "Verified : Error msg for Last name field");

		userPage.verifyErrorMessage("Phone number", "Please enter your phone number in a valid 10 digit format");
		extentTest.log(LogStatus.PASS, "Verified : Error msg for phone nymber field");

		userPage.verifyErrorMessage("Email address", "Please enter your email in a valid email format");
		extentTest.log(LogStatus.PASS, "Verified : Error msg for email field");

		userPage.verifySelectValue("Parent");
		extentTest.log(LogStatus.PASS, "Verified : Verify selected user type");

		userPage.verifyOrganizationFieldDisabledAndValueSetAsNA();
		extentTest.log(LogStatus.PASS, "Verified : Organization field is disabled & value set as NA");

		userPage.verifyStatus("Active");
		extentTest.log(LogStatus.PASS, "Verified : Status type should be active");

		userPage.enterUserDetails("First name", firstName);
		extentTest.log(LogStatus.PASS, "Verified : Enter first name");

		userPage.enterUserDetails("Last name", lastName);
		extentTest.log(LogStatus.PASS, "Verified : Enter last name");

		userPage.enterUserDetails("Phone number", mobileNumber);
		extentTest.log(LogStatus.PASS, "Verified : Enter mobile no");

		userPage.enterUserDetails("Email address", email);
		extentTest.log(LogStatus.PASS, "Verified : enter email");

		String saveChangesTime = Base.getCurrentDateTime("M/d/yy");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.searchUser(email);
		extentTest.log(LogStatus.PASS, "Verified : Search user after save the user details");

		userPage.clickOnFirstValueUnderGrid();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on first value");

		userPage.verifyEditUserNameHeading(firstName+" "+lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify first & last name in heading with edit user tag");

		userPage.verifyDisabledFieldValue("Created date",saveChangesTime);
		extentTest.log(LogStatus.PASS, "Verified : Verify created date value & field should be disabled");

		userPage.verifyDisabledFieldValue("Last updated date",saveChangesTime);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");
	}
}
