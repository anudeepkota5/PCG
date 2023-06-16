package com.pcgus.ci.scholar.testcases.home;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Shipyard_LoginWithInvalidCredentialsTest extends Base {
	 
	private static final String TEST_ID ="lmxi7uzk2qzdm46unry3k6n6apujm222";

	
	Loginpage loginPage=new Loginpage();
	Homepage homePage = new Homepage();
	Base scholarbase=new Base();

	
	@Test
	public void shipyard_loginwithinvalidcredentials_lmxi7uzk2qzdm46unry3k6n6apujm222() throws InterruptedException  {
		
		setTestId(TEST_ID);
		BrowserDriver.setDriver(Base.driver);

		//Launch Shipyard url
		loginPage.LoginPageDriverRef(driver);
		extentTest.log(LogStatus.INFO, "Verified : Login - Login with invalid credentials");

		//Verifying error message on entering incorrect username
		loginPage.verifyNotExistingEmailForLogin("usernamenotexist", "password");
		extentTest.log(LogStatus.INFO, "Verified : Error message<b> Incorrect email or password </b>for entering wrong username");

		//Verifying error message on entering incorrect username
		loginPage.verifyWrogPasswordForLogin("parentuser", "wrongpasscode");
		extentTest.log(LogStatus.INFO, "Verified : Error message<b> Incorrect email or password</b> for entering wrong password");

		//Verifying error message on entering blank username
		loginPage.verifyEmptyUsernameForLogin("blankusername", "password");
		extentTest.log(LogStatus.INFO, "Verified : Error message <b>Enter your Email</b> for entering blank username");

		//Verifying error message on entering blank password
		loginPage.verifyEmptyPasswordForLogin("parentuser", "blankpassword");
		extentTest.log(LogStatus.INFO, "Verified : Error message <b>Enter your password</b> for entering blank password");
	}
}
