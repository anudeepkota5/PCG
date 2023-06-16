package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.*;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.awt.*;

public class School_Finance_AnnualStatement_VerifyEditTest extends Base {

	private static final String TEST_ID="api3qctv6rycdqws3vtogjpespqkb4ac";

	Homepage homePage = new Homepage();
	Loginpage loginPage=new Loginpage();
	Base scholarbase=new Base();
	ScholarAdmiralPage scholarAdmiralPage=new ScholarAdmiralPage();
	FinancesPage financesPage = new FinancesPage();

	CreateApplicationPage createapplicationpage=new CreateApplicationPage();
	ApplicationPage applicationpage = new ApplicationPage();

	@Test
	public void School_Finance_AnnualStatement_VerifyEditTest_api3qctv6rycdqws3vtogjpespqkb4ac() throws InterruptedException, AWTException {
		String firstName =  TestProperties.get("firstName")+getSaltString();
		String lastName = TestProperties.get("lastName")+getSaltString();
		String dob =  TestProperties.get("dateOfBirth");
		String labelName = "qwerty";
		String value = "50";

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);
		homePage.HomePageDriverRef(Base.driver);
		applicationpage.newappilcationpageDriverRef(Base.driver);
		scholarAdmiralPage.admiraluserPageDriverRef(Base.driver);
		financesPage.newFinancePageDriverRef(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Private School - Finances - Annual Statement  - Verify Edit SHIP-385 633 698");
		createapplicationpage.newappilcationpageDriverRef(Base.driver);

		scholarbase.loginToPCGScholarPortal(TestProperties.get("schooluser4"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as State user successfully");

		scholarAdmiralPage.click_finance_icon();
		extentTest.log(LogStatus.PASS, "Verified : click on finance link");

		scholarAdmiralPage.click_annualstatement_tab();
		extentTest.log(LogStatus.PASS, "Verified : click on annual statement link");

		financesPage.clickOnEditLinkOfApplication();
		extentTest.log(LogStatus.PASS, "Verified : Click on edit link of application");

		financesPage.verifyPanelValue("Status");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of status");

		financesPage.verifyPanelFieldValue("Status");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of status");

		financesPage.verifyPanelValue("Submitted by");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of Submitted by");

//		financesPage.verifyPanelFieldValue("Submitted by");
//		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Submitted by");

		financesPage.verifyPanelValue("Submitted on");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of Submitted on");

		financesPage.verifyPanelFieldValue("Submitted on");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Submitted on");

		financesPage.verifyPanelValue("Student Name");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of Student Name");

		financesPage.verifyPanelFieldValue("Student Name");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Student Name");

		financesPage.verifyPanelValue("Student DOB");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of Student DOB");

		financesPage.verifyPanelFieldValue("Student DOB");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Student DOB");

		financesPage.verifyPanelValue("Statement Date");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of Student Date");

		financesPage.verifyPanelFieldValue("Statement Date");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Student Date");

		financesPage.verifyPanelValue("Parent/Guardian Name");
		extentTest.log(LogStatus.PASS, "Verified : Verify field label of Parent/Guardian Name");

		financesPage.verifyPanelFieldValue("Parent/Guardian Name");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Parent/Guardian Name");

		financesPage.verifyGradeDDShouldBeEnabled();
		extentTest.log(LogStatus.PASS, "Verified : Verify Grade DD should be enabled");

		financesPage.verifyDateFieldShouldBeEnabled();
		extentTest.log(LogStatus.PASS, "Verified : Verify calendar should be enabled");

		financesPage.clickOnSaveChangesButton();
		extentTest.log(LogStatus.PASS, "Verified : click on save changes button");

//		financesPage.verifyValidationMessageForDate();
//		extentTest.log(LogStatus.PASS, "Verified : Verify validation message of date");

		financesPage.verifySubmitStatementButton();
		extentTest.log(LogStatus.PASS, "Verified : verify submit statement button");

		financesPage.verifyAutoPopulateButton();
		extentTest.log(LogStatus.PASS, "Verified : verify auto populate button");

		financesPage.clickOnAddItemLink();
		extentTest.log(LogStatus.PASS, "Verified : click on add item");

		financesPage.addDataInDescription(labelName, value);
		extentTest.log(LogStatus.PASS, "Verified : Enter data is desc");

		financesPage.selectGradeLevel("10");
		extentTest.log(LogStatus.PASS, "Verified : Enter data is desc");

		financesPage.clickOnAutoPopulateButton();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on auto populate");

		financesPage.verifyAddedDataShouldNotBeDisplayed(labelName);
		extentTest.log(LogStatus.PASS, "Verified : added data should not be displayed");

		financesPage.verifyLabelValueDataShouldBeDisplayed("Annual Tuition");
		extentTest.log(LogStatus.PASS, "Verified : Annual Tuition label should be displayed");

		financesPage.verifyFieldValueDataShouldBeDisplayed("Annual Tuition");
		extentTest.log(LogStatus.PASS, "Verified : Annual Tuition label value should be displayed");

//		financesPage.verifyLabelValueDataShouldBeDisplayed("Automation fee");
//		extentTest.log(LogStatus.PASS, "Verified : Automation fee label should be displayed");
//
//		financesPage.verifyFieldValueDataShouldBeDisplayed("Automation fee");
//		extentTest.log(LogStatus.PASS, "Verified : Automation fee label value should be displayed");

		financesPage.clickOnAddItemLink();
		extentTest.log(LogStatus.PASS, "Verified : click on add item");

		financesPage.addDataInDescription(labelName, "fff");
		extentTest.log(LogStatus.PASS, "Verified : Enter data is desc");

		financesPage.verifyValidationMessageForAlphabetChar();
		extentTest.log(LogStatus.PASS, "Verified : Verify validation message should be displayed");

		financesPage.clickOnAutoPopulateButton();
		extentTest.log(LogStatus.PASS, "Verified : Clicked on auto populate");

		financesPage.verifyAddItemLinkShouldNotBeDsiaplyedUnderDiscount();
		extentTest.log(LogStatus.PASS, "Verified : Verify add item link should not be displayed under discount");

		/*****************Now enter data ************************/
		refreshPage();

		financesPage.clickOnAddItemLink();
		extentTest.log(LogStatus.PASS, "Verified : click on add item");

		financesPage.addDataInDescription(labelName, value);
		extentTest.log(LogStatus.PASS, "Verified : Enter data is desc");

		financesPage.selectGradeLevel("10");
		extentTest.log(LogStatus.PASS, "Verified : Enter data is desc");

		financesPage.selectTodayDate();
		extentTest.log(LogStatus.PASS, "Verified : select today's date");

		financesPage.clickOnSubmitButton();
		extentTest.log(LogStatus.PASS, "Verified : sClicked on submit button");

		refreshPage();

		financesPage.verifyPanelFieldValue("Status","Submitted");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of status");

		financesPage.verifyGradeDDShouldBeDisabled();
		extentTest.log(LogStatus.PASS, "Verified : Verify Grade DD should be disabled");

//		financesPage.verifyCalendarShouldBeDisabled();
//		extentTest.log(LogStatus.PASS, "Verified : Verify calendar should be disabled");

		financesPage.verifyAutoPopulateButtonShouldBeDisabled();
		extentTest.log(LogStatus.PASS, "Verified : Verify Auto populate button should be disabled");

		financesPage.verifySubmitButtonShouldBeDisabled();
		extentTest.log(LogStatus.PASS, "Verified : Verify Submit button should be disabled");

		financesPage.verifySaveChangesButtonShouldBeDisabled();
		extentTest.log(LogStatus.PASS, "Verified : Verify Save changes button should be disabled");

		financesPage.verifyPanelFieldValue("Submitted by");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Submitted by");

		financesPage.verifyPanelFieldValue("Submitted on");
		extentTest.log(LogStatus.PASS, "Verified : Verify field value of Submitted on");
	}
}
