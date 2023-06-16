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

public class Parent_SaveChangesInMyInfoPageTest extends Base {
	
	private static final String TEST_ID ="kgkgxnllkfhuzqhoehixtseh356fdcry";

    Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	MyInfoPage myinfoPage= new MyInfoPage();
	Base scholarbase=new Base();
	
	@Test
	public void parent_savechangesinmyinfopage_kgkgxnllkfhuzqhoehixtseh356fdcry() throws InterruptedException {

		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		extentTest.log(LogStatus.INFO, "TC Summary : Login page - Login with valid credentials");
		loginPage.LoginPageDriverRef(driver);
		homePage.HomePageDriverRef(Base.driver);
		myinfoPage.MyInfoDriverRef(Base.driver);
		
		scholarbase.loginToPCGScholarPortal(TestProperties.get("parentuser4"), TestProperties.get("password"));
		extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user successfully");
		
		homePage.verifyhomepage();
		extentTest.log(LogStatus.PASS, "Verified : Confirmed the side menu post login");

		myinfoPage.validateInfoPage();
		extentTest.log(LogStatus.PASS, "Verified : Validation of <b>My Info</b> page");
	}

}
