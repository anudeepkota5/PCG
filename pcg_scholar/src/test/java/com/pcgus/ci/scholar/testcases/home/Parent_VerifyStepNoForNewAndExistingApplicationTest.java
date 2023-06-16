
package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.CreateApplicationPage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

	public class Parent_VerifyStepNoForNewAndExistingApplicationTest extends Base {
		
		private static final String TEST_ID="zymxt7rmpvvambzsxqcnuwx342pbejwx";

		Homepage homePage = new Homepage();
		CreateApplicationPage createapplicationpage=new CreateApplicationPage();
		Base scholarbase=new Base();
		
		@Test
		public void parent_verifystepnofornewandexistingapplication_zymxt7rmpvvambzsxqcnuwx342pbejwx() throws InterruptedException {
			
			setTestId(TEST_ID);
			BrowserDriver.setDriver(Base.driver);

			createapplicationpage.newappilcationpageDriverRef(Base.driver);

			//Given I am logged in as a parent
			scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser5"), TestProperties.get("password"));
			extentTest.log(LogStatus.PASS, "Verified : Logged in as Admiral user account");

			//When I click on Create application
			createapplicationpage.newStudentPopUp();
			extentTest.log(LogStatus.PASS, "Verified : Clicked on create application button");

			//I see 4 tiles with step # underneath
			createapplicationpage.newApplicationVerifyTabsStepNumber();
			extentTest.log(LogStatus.PASS, "Verified : I see 4 tiles with step # underneath");

			//When I click on each of the tiles,I still see the step # nd I see I can click on each of the tiles when I am on each page
			createapplicationpage.clickeachtiles();
			extentTest.log(LogStatus.PASS, "Verified : When I click on each of the tiles,I still see the step # nd I see I can click on each of the tiles when I am on each page");

			//Repeat All whole process post editing an exiting application
			createapplicationpage.editlatestapplication();
			extentTest.log(LogStatus.PASS, "Verified : Repeat All whole process post editing an exiting application");

			}

	}

