package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.scholar.pages.Createyouraccountpage;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class VerifyCreateAccountUsingExistingEmailTest extends Base {
	
	private static final String TEST_ID ="espjdbepryi7and2t2xbwhbk23b342gs";

	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();
	Createyouraccountpage createaccountpage=new Createyouraccountpage();
	
	@Test
	public void createaccountusingexistingemail_espjdbepryi7and2t2xbwhbk23b342gs() throws InterruptedException {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Login page - Verify create account using existing email");
		loginPage.LoginPageDriverRef(Base.driver);
		 
		createaccountpage.createanaccountPageDriverRef(driver);
		
		createaccountpage.verifycreateaccountexistingemail();
		extentTest.log(LogStatus.INFO, "Verified : Account already exists message is verified successfully");
	
		}
	}
