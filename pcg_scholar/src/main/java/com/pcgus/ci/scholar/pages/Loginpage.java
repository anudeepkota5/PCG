package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.Element;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Loginpage{

	SoftAssert softAssert = new SoftAssert();	
	WebDriver driver;
	Element element;
	JSWaiter jSWaiter = new JSWaiter();
	Base base = new Base();
	
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());

	@FindBy(id = "//div[@class='labeled-input ']/label/input")
	WebElement userName;

	@FindBy(id = "//label[text()[contains(.,'Password')]]//input")
	WebElement passWord;

	@FindBy(xpath = "//span[text()[contains(.,'Log in to your Account')]]")
	WebElement login;

	@FindBy(xpath = "//a[text()[contains(.,'Forgot password')]]")
	WebElement forgotpasswordlink;

	@FindBy(xpath = "//h2[text()[contains(.,'Reset password')]]")
	WebElement resetpasswordheader;

	@FindBy(xpath ="//a[text()[contains(., 'Return to Sign In')]]")
	WebElement returntosignin;

	@FindBy(xpath ="//div[text()[contains(.,'Incorrect Email or Password')]]")
	WebElement wrongCredenialsErrorMessage;

	@FindBy(xpath ="//div[text()[contains(.,'Enter your Email')]]")
	WebElement blankUsernameErrorMessage;

	@FindBy(xpath ="//div[text()[contains(.,'Enter your password')]]")
	WebElement blankPasswordErrorMessage;

	String uName = "//label[text()[contains(.,'Email')]]//input";
	String pWord = "//label[text()[contains(.,'Password')]]//input";
	String loginButton = "//span[text()[contains(.,'Log in to your Account')]]";
	String incorrectEmailErrorMessage = "//div[text()[contains(.,'Incorrect Email or Password')]]";

	public void LoginPageDriverRef(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
	}


	public void verifyforgotpasswordfieldmasking() throws InterruptedException {

		element.waitVisibility(driver, forgotpasswordlink, 20);
		Assert.assertTrue(forgotpasswordlink.isDisplayed());
		logger.info("Forgot password link is displayed");
		Base.extentTest.log(LogStatus.PASS, "Forgot password link is displayed");
		Base.takeScreenShot();

		forgotpasswordlink.click();
		logger.info("Forgot password link is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Forgot password link is clicked");
		Base.takeScreenShot();

		element.waitVisibility(driver, resetpasswordheader, 20);
		Assert.assertTrue(resetpasswordheader.isDisplayed());
		logger.info("Reset password is displayed");
		Base.extentTest.log(LogStatus.PASS, "Reset password is displayed");
		Base.takeScreenShot();

		element.waitVisibility(driver, returntosignin, 20);
		Assert.assertTrue(returntosignin.isDisplayed());
		logger.info("Return sign in link is displayed");
		Base.extentTest.log(LogStatus.PASS, "Return to sign in link is displayed");
		Base.takeScreenShot();

		returntosignin.click();
		logger.info("Return to signin is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Return to signin is clicked");
		Base.takeScreenShot();
	}

	
	public void verifyforgotpasswordlink() throws InterruptedException {

		element.waitVisibility(driver, forgotpasswordlink, 20);
		Assert.assertTrue(forgotpasswordlink.isDisplayed());
		logger.info("Forgot password link is displayed");
		Base.extentTest.log(LogStatus.PASS, "Forgot password link is displayed");
		Base.takeScreenShot();

		forgotpasswordlink.click();
		logger.info("Forgot password link is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Forgot password link is clicked");
		Base.takeScreenShot();

		element.waitVisibility(driver, resetpasswordheader, 20);
		Assert.assertTrue(resetpasswordheader.isDisplayed());
		logger.info("Reset password is displayed");
		Base.extentTest.log(LogStatus.PASS, "Reset password is displayed");
		Base.takeScreenShot();

		element.waitVisibility(driver, returntosignin, 20);
		Assert.assertTrue(returntosignin.isDisplayed());
		logger.info("Return sign in link is displayed");
		Base.extentTest.log(LogStatus.PASS, "Return to sign in link is displayed");
		Base.takeScreenShot();

		returntosignin.click();
		logger.info("Return to signin is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Return to signin is clicked");
		Base.takeScreenShot();
	}

	public void verifyNotExistingEmailForLogin(String userID, String password) throws InterruptedException {
		Thread.sleep(3000);
	//	driver.navigate().refresh();
/*		element.click(driver, userName);
		element.entervalue(userName, "xyz");*/
		driver.findElement(By.xpath(uName)).clear();
		driver.findElement(By.xpath(uName)).sendKeys(TestProperties.get(userID));
		logger.info("Entered not existed Username");
		Base.extentTest.log(LogStatus.PASS, "Entered not existed Username");
		Base.takeScreenShot();
		Thread.sleep(2000);

	//	element.waitVisibility(driver, passWord, 20);
		driver.findElement(By.xpath(pWord)).clear();
		driver.findElement(By.xpath(pWord)).sendKeys(TestProperties.get(password));
		logger.info("Password entered");
		Base.extentTest.log(LogStatus.PASS, "Password entered");
		Base.takeScreenShot();
		Thread.sleep(2000);

	//	login.click();
		driver.findElement(By.xpath(loginButton)).click();
		logger.info("Login button clicked");
		Base.extentTest.log(LogStatus.PASS, "Login button clicked");
		Base.takeScreenShot();
		Thread.sleep(2000);

		Assert.assertTrue(wrongCredenialsErrorMessage.isDisplayed());
		logger.info("Error message captured is <b>"+wrongCredenialsErrorMessage.getText()+"</b> for entering wrong username");
		Base.extentTest.log(LogStatus.PASS, "Error message captured is <b>"+wrongCredenialsErrorMessage.getText()+"</b> for entering wrong username");
		Base.takeScreenShot();
	}


	public void verifyWrogPasswordForLogin(String userID, String password) throws InterruptedException {
		Thread.sleep(3000);
	//	driver.navigate().refresh();
/*		element.click(driver, userName);
		element.entervalue(userName, "xyz");*/
		driver.findElement(By.xpath(uName)).clear();
		driver.findElement(By.xpath(uName)).sendKeys(TestProperties.get(userID));
		logger.info("Entered correct Username");
		Base.extentTest.log(LogStatus.PASS, "Entered correct Username");
		Base.takeScreenShot();
		Thread.sleep(2000);

		//	element.waitVisibility(driver, passWord, 20);
		driver.findElement(By.xpath(pWord)).clear();
		driver.findElement(By.xpath(pWord)).sendKeys(TestProperties.get(password));
		logger.info("Wrong Password entered");
		Base.extentTest.log(LogStatus.PASS, "Wrong Password entered");
		Base.takeScreenShot();
		Thread.sleep(2000);

		//	login.click();
		driver.findElement(By.xpath(loginButton)).click();
		logger.info("Login button clicked");
		Base.extentTest.log(LogStatus.PASS, "Login button clicked");
		Base.takeScreenShot();
		Thread.sleep(2000);

		Assert.assertTrue(wrongCredenialsErrorMessage.isDisplayed());
		logger.info("Error message captured is <b>"+wrongCredenialsErrorMessage.getText()+"</b> for entering wrong password");
		Base.extentTest.log(LogStatus.PASS, "Error message captured is <b>"+wrongCredenialsErrorMessage.getText()+"</b> for entering wrong password");
		Base.takeScreenShot();
	}

	public void verifyEmptyUsernameForLogin(String userID, String password) throws InterruptedException {
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(5000);
/*		element.click(driver, userName);
		element.entervalue(userName, "xyz");*/
		driver.findElement(By.xpath(uName)).clear();
		driver.findElement(By.xpath(uName)).sendKeys(TestProperties.get(userID));
		logger.info("Entered blank Username");
		Base.extentTest.log(LogStatus.PASS, "Entered blank Username");
		Base.takeScreenShot();
		Thread.sleep(2000);

		//	element.waitVisibility(driver, passWord, 20);
		driver.findElement(By.xpath(pWord)).clear();
		driver.findElement(By.xpath(pWord)).sendKeys(TestProperties.get(password));
		logger.info("Wrong Password entered");
		Base.extentTest.log(LogStatus.PASS, "Wrong Password entered");
		Base.takeScreenShot();
		Thread.sleep(2000);

		//	login.click();
		driver.findElement(By.xpath(loginButton)).click();
		logger.info("Login button clicked");
		Base.extentTest.log(LogStatus.PASS, "Login button clicked");
		Base.takeScreenShot();
		Thread.sleep(2000);

	//driver.findElement(By.xpath(uName)).clear();
		Assert.assertTrue(blankUsernameErrorMessage.isDisplayed());
		logger.info("Error message captured is <b>"+blankUsernameErrorMessage.getText()+"</b> for entering blank username");
		Base.extentTest.log(LogStatus.PASS, "Error message captured is <b>"+blankUsernameErrorMessage.getText()+"</b> for entering blank username");
		Base.takeScreenShot();

	}

	public void verifyEmptyPasswordForLogin(String userID, String password) throws InterruptedException {
Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
/*		element.click(driver, userName);
		element.entervalue(userName, "xyz");*/
		driver.findElement(By.xpath(uName)).clear();
		driver.findElement(By.xpath(uName)).sendKeys(TestProperties.get(userID));
		logger.info("Entered blank Username");
		Base.extentTest.log(LogStatus.PASS, "Entered blank Username");
		Base.takeScreenShot();
		Thread.sleep(2000);

		//	element.waitVisibility(driver, passWord, 20);
		driver.findElement(By.xpath(pWord)).clear();
		driver.findElement(By.xpath(pWord)).sendKeys(TestProperties.get(password));
		logger.info("Wrong Password entered");
		Base.extentTest.log(LogStatus.PASS, "Wrong Password entered");
		Base.takeScreenShot();
		Thread.sleep(2000);

		//	login.click();
		driver.findElement(By.xpath(loginButton)).click();
		logger.info("Login button clicked");
		Base.extentTest.log(LogStatus.PASS, "Login button clicked");
		Base.takeScreenShot();
		Thread.sleep(2000);

		Assert.assertTrue(blankPasswordErrorMessage.isDisplayed());
		logger.info("Error message captured is <b>"+blankPasswordErrorMessage.getText()+"</b> for entering blank password");
		Base.extentTest.log(LogStatus.PASS, "Error message captured is <b>"+blankPasswordErrorMessage.getText()+"</b> for entering blank password");
		Base.takeScreenShot();
	}
}
