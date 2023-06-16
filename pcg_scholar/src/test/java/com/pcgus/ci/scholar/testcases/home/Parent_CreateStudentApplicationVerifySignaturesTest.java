package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.MyInfoPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

	public class Parent_CreateStudentApplicationVerifySignaturesTest extends Base {

		private static final String TEST_ID="a2c5pd2udpauqixl3j6tp6athfdddhri";

		Homepage homePage = new Homepage();
		CreateApplicationPage createapplicationpage=new CreateApplicationPage();
		Base scholarbase=new Base();

		@Test
		public void parent_createstudentapplicationverifysignatures_a2c5pd2udpauqixl3j6tp6athfdddhri() throws InterruptedException {

			setTestId(TEST_ID);
			BrowserDriver.setDriver(Base.driver);

			extentTest.log(LogStatus.INFO, "TC Summary : Parent - Create Application - Student Information, ... - Click continue when completed");
			createapplicationpage.newappilcationpageDriverRef(Base.driver);
			scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
			extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");

			createapplicationpage.newStudentPopUp();
			extentTest.log(LogStatus.PASS, "Verified : Student pop-up handled successfully");

			createapplicationpage.addingStudentInformation();
			extentTest.log(LogStatus.PASS, "Verified : Student information entered successfully");

			createapplicationpage.parentinformation();
			extentTest.log(LogStatus.PASS, "Verified : Parent information entered successfully");

			createapplicationpage.verifySSNErrMsg(TestProperties.get("wrongSSN"));
			extentTest.log(LogStatus.PASS, "Verified : Application submitted successfully");

		}
	}
