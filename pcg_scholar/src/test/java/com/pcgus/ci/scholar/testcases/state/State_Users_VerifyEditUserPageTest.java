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

public class State_Users_VerifyEditUserPageTest extends Base {
	
	private static final String TEST_ID="tnoz34s4wqn62wqvpmpo5dwmmznqggwv";

	Homepage homePage = new Homepage();
	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();

	CreateApplicationPage createapplicationpage=new CreateApplicationPage();
	ApplicationPage applicationpage = new ApplicationPage();
	UserPage userPage = new UserPage();

	@Test
	public void state_users_verifyedituserpage_tnoz34s4wqn62wqvpmpo5dwmmznqggwv() throws InterruptedException, AWTException {
//		String firstName =  TestProperties.get("firstName")+getSaltString_WithoutDigit();
//		String lastName = TestProperties.get("lastName")+getSaltString_WithoutDigit();

		String firstName =  TestProperties.get("firstName")+getSaltString();
		String lastName = TestProperties.get("lastName")+getSaltString();

		String mobileNumber = TestProperties.get("mobileNumber");
		String email =  TestProperties.get("emailPrefix")+getCurrentTimeStamp()+ TestProperties.get("emailSuffix");

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);
		homePage.HomePageDriverRef(Base.driver);
		applicationpage.newappilcationpageDriverRef(Base.driver);
		userPage.newappilcationpageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Site Settings - Users - Verify Edit User page SHIP-596 624");
		createapplicationpage.newappilcationpageDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("stateuser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		homePage.clickOnSetting_icon();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on settings icon");

		userPage.clickOnFirstValueUnderGrid();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on first value under grid");

		String firstName_Before = userPage.getUserDetails("First name");
		extentTest.log(LogStatus.PASS, "Verified : get the first name before replace");

		String lastName_Before = userPage.getUserDetails("Last name");
		extentTest.log(LogStatus.PASS, "Verified : get the last name before replace");

		String emailAddress_Before = userPage.getUserDetails("Email address");
		extentTest.log(LogStatus.PASS, "Verified : get the email before replace");

//		firstName =  TestProperties.get("firstName")+getSaltString_WithoutDigit();
//		lastName = TestProperties.get("lastName")+getSaltString_WithoutDigit();

		firstName =  TestProperties.get("firstName")+getSaltString();
		lastName = TestProperties.get("lastName")+getSaltString();


		email =  TestProperties.get("emailPrefix")+getCurrentTimeStamp()+ TestProperties.get("emailSuffix");

		userPage.enterUserDetails("First name", firstName);
		extentTest.log(LogStatus.PASS, "Verified : Enter first name");

		userPage.enterUserDetails("Last name", lastName);
		extentTest.log(LogStatus.PASS, "Verified : Enter last name");

		userPage.enterUserDetails("Email address", email);
		extentTest.log(LogStatus.PASS, "Verified : enter email");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		String saveChangesTime = dtf.format(now);//Base.getCurrentDateTime("M/d/yy");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.refreshPage();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		homePage.clickOnSetting_icon();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on settings icon");

		userPage.searchUser(email);
		extentTest.log(LogStatus.PASS, "Verified : Search user after save the user details");

		userPage.clickOnFirstValueUnderGrid();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on first value");

		userPage.verifyEditUserNameHeading(firstName+" "+lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify first & last name in heading with edit user tag");

		userPage.verifyFieldValue("First name",firstName);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		userPage.verifyFieldValue("Last name",lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		userPage.verifyFieldValue("Email address",email);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		userPage.verifyDisabledFieldValue("Last updated date",saveChangesTime);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		// Replace the data
		userPage.enterUserDetails("First name", firstName_Before);
		extentTest.log(LogStatus.PASS, "Verified : Enter first name");

		userPage.enterUserDetails("Last name", lastName_Before);
		extentTest.log(LogStatus.PASS, "Verified : Enter last name");

		userPage.enterUserDetails("Email address", emailAddress_Before);
		extentTest.log(LogStatus.PASS, "Verified : entered email");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Cliked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		/**********Verify all things with admiral user ****************/

		homePage.logout();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on logout button");

		scholarbase.loginToPCGScholarPortal(TestProperties.get("admiraluser"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		homePage.clickOnSiteSetting_icon();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on settings icon");

		userPage.clickOnFirstValueUnderGrid();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on first value under grid");

		firstName_Before = userPage.getUserDetails("First name");
		extentTest.log(LogStatus.PASS, "Verified : get the first name before replace");

		lastName_Before = userPage.getUserDetails("Last name");
		extentTest.log(LogStatus.PASS, "Verified : get the last name before replace");

		emailAddress_Before = userPage.getUserDetails("Email address");
		extentTest.log(LogStatus.PASS, "Verified : get the email before replace");

//		firstName =  TestProperties.get("firstName")+getSaltString_WithoutDigit();
//		lastName = TestProperties.get("lastName")+getSaltString_WithoutDigit();

		firstName =  TestProperties.get("firstName")+getSaltString();
		lastName = TestProperties.get("lastName")+getSaltString();

		email =  TestProperties.get("emailPrefix")+getCurrentTimeStamp()+ TestProperties.get("emailSuffix");

		userPage.enterUserDetails("First name", firstName);
		extentTest.log(LogStatus.PASS, "Verified : Enter first name");

		userPage.enterUserDetails("Last name", lastName);
		extentTest.log(LogStatus.PASS, "Verified : Enter last name");

		userPage.enterUserDetails("Email address", email);
		extentTest.log(LogStatus.PASS, "Verified : enter email");

		userPage.selectUserType("Parent");
		extentTest.log(LogStatus.PASS, "Verified : select user type as parent");

		saveChangesTime = dtf.format(now); //Base.getCurrentDateTime("M/d/yy");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Cliked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.refreshPage();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		homePage.clickOnSiteSetting_icon();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on settings icon");

		userPage.searchUser(email);
		extentTest.log(LogStatus.PASS, "Verified : Search user after save the user details");

		userPage.clickOnFirstValueUnderGrid();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on first value");

		userPage.verifyEditUserNameHeading(firstName+" "+lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify first & last name in heading with edit user tag");

		userPage.verifyFieldValue("First name",firstName);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		userPage.verifyFieldValue("Last name",lastName);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		userPage.verifyFieldValue("Email address",email);
		extentTest.log(LogStatus.PASS, "Verified : Verify last updated date value & field should be disabled");

		userPage.verifyUserSelectType("Parent");
		extentTest.log(LogStatus.PASS, "Verified : Verify user selected user type as parent");

		/******************Now select usertype as school admin *****************/

		userPage.selectUserType("School Admin");
		extentTest.log(LogStatus.PASS, "Verified : select user type as school admin");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.refreshPage();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.verifyUserSelectType("School Admin");
		extentTest.log(LogStatus.PASS, "Verified : Verify user selected user type as school admin");

		/******************Now select usertype as Scholarship Admin *****************/

		userPage.selectUserType("Scholarship Admin");
		extentTest.log(LogStatus.PASS, "Verified : select user type as Scholarship admin");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.refreshPage();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.verifyUserSelectType("Scholarship Admin");
		extentTest.log(LogStatus.PASS, "Verified : Verify user selected user type as Scholarship admin");

		/******************Now select usertype as Admiral *****************/

		userPage.selectUserType("Admiral");
		extentTest.log(LogStatus.PASS, "Verified : select user type as Admiral");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.refreshPage();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

		userPage.verifyUserSelectType("Admiral");
		extentTest.log(LogStatus.PASS, "Verified : Verify user selected user type as Admiral");

		// Replace the data
		userPage.enterUserDetails("First name", firstName_Before);
		extentTest.log(LogStatus.PASS, "Verified : Enter first name");

		userPage.enterUserDetails("Last name", lastName_Before);
		extentTest.log(LogStatus.PASS, "Verified : Enter last name");

		userPage.enterUserDetails("Email address", emailAddress_Before);
		extentTest.log(LogStatus.PASS, "Verified : entered email");

		userPage.clickOnSaveChanges();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		userPage.verifySaveChangesPopup();
		extentTest.log(LogStatus.PASS, "Verified : Verify save changes popup");

	}
}
