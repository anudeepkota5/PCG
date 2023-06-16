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

public class State_Applications_VerifyViewAndEditStudentApplicationTest extends Base {
	
	private static final String TEST_ID="qi2bskfsdl24njv3wkfcyy2qo6up35j6";

	Homepage homePage = new Homepage();
	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();

	CreateApplicationPage createapplicationpage=new CreateApplicationPage();
	ApplicationPage applicationpage = new ApplicationPage();


	@Test
	public void state_applications_verifyviewandeditstudentapplication_qi2bskfsdl24njv3wkfcyy2qo6up35j6() throws InterruptedException, AWTException {
		String firstName =  TestProperties.get("firstName")+getSaltString();
		String lastName = TestProperties.get("lastName")+getSaltString();
		String dob =  TestProperties.get("dateOfBirth");
		String statusType = TestProperties.get("statusTypeWithdraw");
		String address1 =TestProperties.get("address1");
		String city = TestProperties.get("city");
		String state = TestProperties.get("state");
		String postalCode = TestProperties.get("postalCode");
		String mobileNumber = TestProperties.get("mobileNumber");
		String email =  TestProperties.get("emailPrefix")+getCurrentTimeStamp()+ TestProperties.get("emailSuffix");;
		String SSN =  TestProperties.get("SSN");

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

		applicationpage.clickOnFirstApplicationWhoDoesNotHaveStatusType(statusType);
		extentTest.log(LogStatus.PASS, "Verified : Click on the id who does not contain withdrawan status");

		applicationpage.verifyIsFieldDisabled("Status");
		extentTest.log(LogStatus.PASS, "Verified : Status field should be disabled");

		applicationpage.verifyIsFieldDisabled("Application Type");
		extentTest.log(LogStatus.PASS, "Verified : application type field should be disabled");

		applicationpage.verifyIsFieldDisabled("Submitted by");
		extentTest.log(LogStatus.PASS, "Verified : Submitted by field should be disabled");

		applicationpage.verifyIsFieldDisabled("Submitted on");
		extentTest.log(LogStatus.PASS, "Verified : Submitted on field should be disabled");

		applicationpage.verifyIsFieldDisabled("10 Day Timeline Expiration");
		extentTest.log(LogStatus.PASS, "Verified : 10 day timeline field should be disabled");

		applicationpage.verifyIsFieldDisabled("Date Approved");
		extentTest.log(LogStatus.PASS, "Verified : Date field should be disabled");

		applicationpage.verifyIsFieldEnabled("studentFirstName");
		extentTest.log(LogStatus.PASS, "Verified : First name field should be enabled");

		applicationpage.verifyIsFieldEnabled("studentLastName");
		extentTest.log(LogStatus.PASS, "Verified : Last name field should be enabled");

		applicationpage.verifyIsFieldEnabled("nextGrade");
		extentTest.log(LogStatus.PASS, "Verified : Grade field should be enabled");

		applicationpage.verifyIsFieldValueEnabled("stn");
		extentTest.log(LogStatus.PASS, "Verified : stn field should be enabled");

		applicationpage.verifyIsFieldEnabled("districtResidence");
		extentTest.log(LogStatus.PASS, "Verified : Distric of residence field should be enabled");

		applicationpage.verifyIsFieldEnabled("districtIEP");
		extentTest.log(LogStatus.PASS, "Verified : District of IEP field should be enabled");

		applicationpage.verifyIsFieldEnabled("IEPorISP");
		extentTest.log(LogStatus.PASS, "Verified : IEP or ISP field should be enabled");

		applicationpage.verifyIsFieldEnabled("primaryDisability");
		extentTest.log(LogStatus.PASS, "Verified : Primary disability field should be enabled");

		applicationpage.verifyIsFieldEnabled("secondaryDisability");
		extentTest.log(LogStatus.PASS, "Verified : Secondary Disability field should be enabled");

		applicationpage.verifyIsFieldEnabled("school");
		extentTest.log(LogStatus.PASS, "Verified : School field should be enabled");

		applicationpage.verifyIsFieldEnabled("initYear");
		extentTest.log(LogStatus.PASS, "Verified : Initial year field should be enabled");

		applicationpage.verifyIsFieldValueEnabled("parentFirstName");
		extentTest.log(LogStatus.PASS, "Verified : First name field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("parentLastName");
		extentTest.log(LogStatus.PASS, "Verified : Last name field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("address");
		extentTest.log(LogStatus.PASS, "Verified : address field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("city");
		extentTest.log(LogStatus.PASS, "Verified : city field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("state");
		extentTest.log(LogStatus.PASS, "Verified : state field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("zip");
		extentTest.log(LogStatus.PASS, "Verified : zip code field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("phoneNumber");
		extentTest.log(LogStatus.PASS, "Verified : address field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("email");
		extentTest.log(LogStatus.PASS, "Verified : address field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("payeeNum");
		extentTest.log(LogStatus.PASS, "Verified : Payee number field should be enabled for parent");

		applicationpage.verifyIsFieldValueEnabled("location");
		extentTest.log(LogStatus.PASS, "Verified : Location field should be enabled for parent");

		applicationpage.verifyEligibilityVerificationSectionDisplayed();
		extentTest.log(LogStatus.PASS, "Verified : Eligibility panel should be displayed");

		applicationpage.verifyEnrollmentVerificationSectionDisplayed();
		extentTest.log(LogStatus.PASS, "Verified : Enrollment verification panel should be displayed");

		applicationpage.verifyDocumentsSectionDisplayed();
		extentTest.log(LogStatus.PASS, "Verified : Documents panel should be displayed");

		applicationpage.verifyLNHSectionDisplayed();
		extentTest.log(LogStatus.PASS, "Verified : LNH panel should be displayed");

		String firstName_BeforeChange = applicationpage.getFieldValue("studentFirstName");
		extentTest.log(LogStatus.PASS, "Verified : get the first name before change");

		String lastName_BeforeChange = applicationpage.getFieldValue("studentLastName");
		extentTest.log(LogStatus.PASS, "Verified : get the last name before change");

		applicationpage.enterStudentInformation("studentFirstName",firstName);
		extentTest.log(LogStatus.PASS, "Verified : enter first name");

		applicationpage.enterStudentInformation("studentLastName",lastName);
		extentTest.log(LogStatus.PASS, "Verified : enter last name");

		applicationpage.selectIEPOrISP();
		extentTest.log(LogStatus.PASS, "Verified : select IEP");

		applicationpage.selectLocation();
		extentTest.log(LogStatus.PASS, "Verified : select location");

		applicationpage.enterParentInformationInformation("tin",SSN);
		extentTest.log(LogStatus.PASS, "Verified : enter SSN/TIN");

		applicationpage.clickOnSaveChangesButton();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		refreshPage();
		extentTest.log(LogStatus.PASS, "Refresh the page after save");

		applicationpage.verifyStudentFormValue("studentFirstName",firstName);
		extentTest.log(LogStatus.PASS, "Verified : Verify first name after update");

		applicationpage.verifyStudentFormValue("studentLastName",lastName);
		extentTest.log(LogStatus.PASS, "Verified : verify last name after update");

		applicationpage.clickOnEditStatus();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on edit status");

		applicationpage.verifyTheStatusDD();
		extentTest.log(LogStatus.PASS, "Verified : verify status DD value");

		applicationpage.clickOnCloseIcon_EditStatusPopup();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on close icon of edit ");

		applicationpage.enterStudentInformation("studentFirstName",firstName_BeforeChange);
		extentTest.log(LogStatus.PASS, "Verified : Verify enter first name for revert");

		applicationpage.enterStudentInformation("studentLastName",lastName_BeforeChange);
		extentTest.log(LogStatus.PASS, "Verified : Verify enter last name for revert");

		applicationpage.clickOnSaveChangesButton();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on save changes button");

		refreshPage();
		extentTest.log(LogStatus.PASS, "Refresh the page after save");

		applicationpage.verifyStudentFormValue("studentFirstName",firstName_BeforeChange);
		extentTest.log(LogStatus.PASS, "Verified : Verify first name after revert");

		applicationpage.verifyStudentFormValue("studentLastName",lastName_BeforeChange);
		extentTest.log(LogStatus.PASS, "Verified : Verify last name after revert");
	}
}
