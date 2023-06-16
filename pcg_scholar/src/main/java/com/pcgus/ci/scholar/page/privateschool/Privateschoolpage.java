package com.pcgus.ci.scholar.page.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class Privateschoolpage {
	
	
	WebDriver driver;
	Element element;
	BrowserDriver browserDriver = new BrowserDriver();
	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());

	@FindBy(xpath = "//div[text()[contains(.,'School Review')]]")
	WebElement schoolreviewgrid;

	@FindBy(xpath = "//div[text()[contains(.,'New Applications')]]")
	WebElement newApplicationsgrid;

	@FindBy(xpath = "//div[text()[contains(.,'Current Roster')]]")
	WebElement currentrostergrid;

	@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
	private WebElement logoutbutton;

	

	public void privatepageschoolDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
	}
	
public void verifyprivateschoolpagegrids() throws InterruptedException {
		try {
			base.timeinterval(3);
			element.isDisplayed(schoolreviewgrid);
			Assert.assertTrue(schoolreviewgrid.isDisplayed());
			logger.info("school review grid is displayed");
			Base.extentTest.log(LogStatus.PASS, "School review grid is displayed");
			Base.takeScreenShot();
		} catch (NoSuchElementException e) {
			Base.extentTest.log(LogStatus.PASS, "School review grid is not displayed for this account. Please use account which has atleast one application under School Review status");
			Base.takeScreenShot();
		}
		Thread.sleep(2000);
		browserDriver.scrollToElement(driver, newApplicationsgrid);
		base.timeinterval(2);
		Thread.sleep(2000);
		element.isDisplayed(newApplicationsgrid);
		Assert.assertTrue(newApplicationsgrid.isDisplayed());
		logger.info("New applications grid is displayed");
		Base.extentTest.log(LogStatus.PASS, "New applications grid is displayed");
		Base.takeScreenShot();

		base.timeinterval(2);
		browserDriver.scrollToElement(driver, currentrostergrid);
		base.timeinterval(2);
		element.isDisplayed(currentrostergrid);
		Assert.assertTrue(currentrostergrid.isDisplayed());
		logger.info("Current roster grid is displayed");
		Base.extentTest.log(LogStatus.PASS, "Current roster grid is displayed");
		Base.takeScreenShot();

		base.timeinterval(2);
		element.isDisplayed(logoutbutton);
		Assert.assertTrue(logoutbutton.isDisplayed());
		Base.extentTest.log(LogStatus.PASS, "Log out button is displayed");
		Base.takeScreenShot();

		base.timeinterval(2);
		logoutbutton.click();
		Base.extentTest.log(LogStatus.PASS, "log out button is clicked");
		Base.takeScreenShot();
		
		} 



     public void verifyschoolstudents() throws InterruptedException {
    	 
    	 base.timeinterval(3);
    	 
    	 
    	 
    	 
    	 
     }

          }
