package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Parent_VerifyStudentParentInfoFilledTest extends Base {
	
	private static final String TEST_ID="5gjroxoz7i7xu2ncb4as44qr4r2sn2if";

	Homepage homePage = new Homepage();
	CreateApplicationPage createapplicationpage=new CreateApplicationPage();
	Base scholarbase=new Base();
	
	@Test
	public void verify_studentparentinfofilled_5gjroxoz7i7xu2ncb4as44qr4r2sn2if() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
		createapplicationpage.newappilcationpageDriverRef(Base.driver);
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

		createapplicationpage.newStudentPopUp();
		extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

		createapplicationpage.addingStudentInformation();
		extentTest.log(LogStatus.PASS, "Verified : Student information entered");

		createapplicationpage.verifyStudentSectionCompletion();
		extentTest.log(LogStatus.PASS, "Verified : All fields in Student information are entered successfully");

		createapplicationpage.parentinformation();
		extentTest.log(LogStatus.PASS, "Verified : Parent information entered");

		createapplicationpage.verifyParentSectionCompletion();
		extentTest.log(LogStatus.PASS, "Verified : All fields in Parent information are entered successfully");

/*		createapplicationpage.verifysignature();
		extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");
		*/

		}
}
