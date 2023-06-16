package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.Element;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Createyouraccountpage {

	SoftAssert softAssert = new SoftAssert();	
	WebDriver driver;
	Element element = new Element(driver);
	JSWaiter jSWaiter = new JSWaiter();
	Base base = new Base();
	
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());
	
	
	@FindBy(xpath="//a[text()[contains(.,'Create your account')]]")
	WebElement createyouraccoutbutton;
	
	@FindBy(xpath="//div/label[text()[contains(.,'First Name')]]")
	WebElement firstname;
	
	@FindBy(xpath="//div/label[text()[contains(.,'Last Name')]]")
	WebElement lastname;
	
	@FindBy(xpath="//div/label[text()[contains(.,'Email')]]")
	WebElement emailaddress;
	
	@FindBy(xpath="//div/label[text()[contains(.,'Mobile Phone')]]")
	WebElement phonenum;
	
	@FindBy(xpath="//div/label[text()[contains(.,'Password')]]")
	WebElement pwd;
	
	@FindBy(xpath="//div/label[text()[contains(.,'Repeat password')]]")
	WebElement confirmpwd;
	
	@FindBy(xpath="//button/span[text()[contains(.,'Send a verification code')]]")
	WebElement sendcodebutton;

	@FindBy(xpath ="//div[text()[contains(., 'Account already exists.')]]")
	WebElement accountExistPopUp;

	@FindBy(id = "admiraluser")
	WebElement admiralUserName;

	
	public void createanaccountPageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);

	}
	
	
	public void verifycreateaccountexistingemail() throws InterruptedException {
		element.waitVisibility(driver, createyouraccoutbutton, 20);
		Assert.assertTrue(createyouraccoutbutton.isDisplayed());
		logger.info("Create account button  is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create account button is displayed");
		Base.takeScreenShot();

		element.clickByJs(driver, createyouraccoutbutton);
		logger.info("Create account button  is clicked");
		Base.extentTest.log(LogStatus.PASS, "Create account button is clicked");
		Base.takeScreenShot();

		firstname.sendKeys("Dave");
		logger.info("First name entered");
		Base.extentTest.log(LogStatus.PASS, "First name entered");
		Base.takeScreenShot();

		lastname.sendKeys("Brake");
		logger.info("Entered last name");
		Base.extentTest.log(LogStatus.PASS, "Entered last name");
		Base.takeScreenShot();

		emailaddress.sendKeys(TestProperties.get("admiraluser"));
		logger.info("Entered last name");
		Base.extentTest.log(LogStatus.PASS, "Entered last name");
		Base.takeScreenShot();

		phonenum.sendKeys("8123812831");
		logger.info("Phone number entered");
		Base.extentTest.log(LogStatus.PASS, "Phone number entered");
		Base.takeScreenShot();

		pwd.sendKeys(TestProperties.get("password"));
		logger.info("Password entered");
		Base.extentTest.log(LogStatus.PASS, "Password entered");
		Base.takeScreenShot();

		confirmpwd.sendKeys(TestProperties.get("password"));
		logger.info("Confirmation password entered");
		Base.extentTest.log(LogStatus.PASS, " Confirmation password entered");
		Base.takeScreenShot();

		element.clickByJs(driver, sendcodebutton);
		logger.info("Send verification code button clicked");
		Base.extentTest.log(LogStatus.PASS, "Send verification code button clicked");
		Base.takeScreenShot();

		element.isDisplayed(accountExistPopUp);
		logger.info("Account already exists.");
		Base.extentTest.log(LogStatus.PASS, "Account already exists.");
		base.timeinterval(1);
		Base.takeScreenShot();
	}

}
