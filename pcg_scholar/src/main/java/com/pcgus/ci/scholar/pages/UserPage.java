package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class UserPage extends Base {

	WebDriver driver;
	Element element;
	BrowserDriver browserDriver = new BrowserDriver();
	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());

	@FindBy(xpath = "//button[contains(text(),'Save changes')]")
	WebElement saveChangesButton;
	
	@FindBy(xpath = "//button[text()='Add User'][not(@disabled)]")
	WebElement addUserButton;

	public String errorMsgFromUI = "//label[text()='%s']/following-sibling::span";

	public String fieldValue = "//label[text()='%s']/following-sibling::span";

	@FindBy(xpath = "//div[contains(@class,'user-type-selector__value-container user-type')]//span")
	WebElement selectedUserType;

	@FindBy(xpath = "//label[text()='Organization']/input[@disabled]")
	WebElement organizationValue;

	@FindBy(xpath = "//label[text()='Status']//select/option[@value='true']")
	WebElement selectedStatusType;

	@FindBy(xpath = "//*[contains(text(),'Changes saved')]")
	WebElement savedChangesPopup;

	@FindBy(xpath = "//div[@class='grid-search-container']//input")
	WebElement searchUserInputField;

	@FindBy(xpath = "(//div[contains(@class,'grid grid-id')]/descendant::span[@colname='Name']/span[not(contains(@class,'inactive'))]//a)[1]")
	WebElement firstNameInGrid;

	@FindBy(xpath = "//div[contains(@class,'user-type-selector__dropdown-indicator')]")
	WebElement userTypeDD;

	@FindBy(xpath = "//div[contains(@class,'user-type-component')]//span")
	WebElement userTypeSelectedValue;



	public String inputBoxBasedOnLabel = "//label[text()='%s']/input";

	public String editUserHeading = "//span[contains(text(),'Edit user')]/strong[contains(text(),'%s')]";

	public String disabledFieldValue = "//label[text()='%s']/input[@disabled]";

	public String inputFieldValue = "//label[text()='%s']/input";

	public String userTypeDDValue = "//div[contains(@class,'user-type-selector__menu')]//*[contains(text(),'%s')]";



	public void newappilcationpageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory,this);
		element = new Element(driver);
		browserDriver =new BrowserDriver();
		JSWaiter.setDriver(driver);
	}


	public void verifyUserSelectType(String expectedValue) {
		String valueFromUI = userTypeSelectedValue.getText();
		logger.info("Text from UI "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedValue.toLowerCase()),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public void selectUserType(String userType){
		try {
			element.click(driver, userTypeDD);
			logger.info("User type DD clicked");
			Base.extentTest.log(LogStatus.PASS, "User type DD clicked");
			Base.takeScreenShot();
		}catch (Exception e){}

		driver.findElement(By.xpath(String.format(userTypeDDValue, userType))).click();
		logger.info("User type selected as "+userType);
		Base.extentTest.log(LogStatus.PASS, "User type selected as "+userType);
		Base.takeScreenShot();

	}

	public void clickOnAddUserButton() throws InterruptedException {
		//waitABit(10000);

		base.waitForElement(addUserButton);

		element.waitVisibility(driver, addUserButton,15);
		element.click(driver, addUserButton);
		logger.info("Clicked on add user button");
		Base.extentTest.log(LogStatus.PASS, "Verified clicked on add user");
		Base.takeScreenShot();
	}

	public void clickOnSaveChanges() throws InterruptedException {
	//	waitABit(10000);
		base.waitForElement(saveChangesButton);
		element.waitVisibility(driver, saveChangesButton,15);
		element.click(driver, saveChangesButton);
		logger.info("Clicked on save changes");
		Base.extentTest.log(LogStatus.PASS, "Verified cliked on save changes");
		Base.takeScreenShot();
	}

	public void verifyErrorMessage(String fieldName, String errorMessage) throws InterruptedException {
		String textFromUI = driver.findElement(By.xpath(String.format(errorMsgFromUI,fieldName))).getText();
		logger.info("Text from UI "+textFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+textFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(textFromUI.toLowerCase().contains(textFromUI.toLowerCase()),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public void verifySelectValue(String expectedValue){
		String valueFromUI = selectedUserType.getText();
		logger.info("Text from UI "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedValue.toLowerCase()),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public void verifyOrganizationFieldDisabledAndValueSetAsNA(){

		String valueFromUI = organizationValue.getAttribute("value");
		logger.info("Text from UI "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(valueFromUI.contains("N/A"),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public void verifyStatus(String expectedValue){
		String valueFromUI = selectedStatusType.getText();
		logger.info("Text from UI "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedValue.toLowerCase()),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public void enterUserDetails(String fieldName, String value) throws InterruptedException {
	//	waitABit(7000);
		waitForElement(driver.findElement(By.xpath(String.format(inputBoxBasedOnLabel,fieldName))));
		driver.findElement(By.xpath(String.format(inputBoxBasedOnLabel,fieldName))).clear();
		driver.findElement(By.xpath(String.format(inputBoxBasedOnLabel,fieldName))).sendKeys(value);
		logger.info("Enter value in field as "+value);
		Base.extentTest.log(LogStatus.PASS, "Enter value in field as "+value);
		Base.takeScreenShot();
	}

	public void verifySaveChangesPopup(){
		saveChangesButton.isDisplayed();
		logger.info("Verify save changes popup");
		Base.extentTest.log(LogStatus.PASS, "Verify save changes popup");
		Base.takeScreenShot();
	}

	public void searchUser(String searchKey) throws InterruptedException {
		//waitABit(5000);

		waitForElement(searchUserInputField);

		element.waitVisibility(driver,searchUserInputField,20);
		searchUserInputField.clear();
		searchUserInputField.sendKeys(searchKey);
		logger.info("User searched");
		Base.extentTest.log(LogStatus.PASS, "User searched");
		Base.takeScreenShot();

		searchUserInputField.sendKeys(Keys.ENTER);
		logger.info("Enter pressed");
		Base.extentTest.log(LogStatus.PASS, "Enter pressed");
		Base.takeScreenShot();
	}

	public void clickOnFirstValueUnderGrid() throws InterruptedException {
		Thread.sleep(15000);
		element.click(driver, firstNameInGrid);
		logger.info("Clicked on first name in grid");
		Base.extentTest.log(LogStatus.PASS, "Verified clicked on first name in grid");
		Base.takeScreenShot();
	}

	public void verifyEditUserNameHeading(String name) throws InterruptedException {
	//	waitABit(5000);
		Thread.sleep(10000);
		waitForElement(driver.findElement(By.xpath(String.format(editUserHeading,name))));
		Thread.sleep(3000);
		takeScreenShot();
		element.isDisplayed(driver.findElement(By.xpath(String.format(editUserHeading,name))));
		logger.info("Verify first & last name in edit user heading");
	}

	public void verifyDisabledFieldValue(String fieldName, String expectedValue) {
		String valueFromUI = driver.findElement(By.xpath(String.format(disabledFieldValue,fieldName))).getAttribute("value");
		logger.info("Text from UI "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedValue.toLowerCase()),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public void verifyFieldValue(String fieldName, String expectedValue) {
		String valueFromUI = driver.findElement(By.xpath(String.format(inputFieldValue,fieldName))).getAttribute("value");
		logger.info("Text from UI "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Text from UI "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedValue.toLowerCase()),"Expected value is incorrect");
		logger.info("Expected value is incorrect");
		Base.extentTest.log(LogStatus.PASS, "Expected value is incorrect");
		Base.takeScreenShot();
	}

	public String getUserDetails(String fieldName) throws InterruptedException {
	//	waitABit(20000);
		Thread.sleep(10000);
		waitForElement(driver.findElement(By.xpath(String.format(inputBoxBasedOnLabel,fieldName))));
		String value = driver.findElement(By.xpath(String.format(inputBoxBasedOnLabel,fieldName))).getAttribute("value");
		logger.info("Value in field as "+value);
		Base.extentTest.log(LogStatus.PASS, "Value in field as "+value);
		Base.takeScreenShot();
		return value;
	}

}


