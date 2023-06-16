package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;


public class FinancesPage extends Base {

	WebDriver driver;
	Element element;
	BrowserDriver browserDriver = new BrowserDriver();
	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());

	@FindBy(xpath = "//div[contains(text(),'Status/Actions')]")
	WebElement statusColumn;

	@FindBy(xpath = "(//span[text()='Created']/following::button[text()='Edit'][1])[1]")
	WebElement editLink;
	
	@FindBy(xpath = "//select[contains(@id,'labeled-select-id')][@disabled='']")
	WebElement disabledGradeDD;

	@FindBy(xpath = "//button[contains(@class,'picker__calendar')]")
	WebElement calendarIcon;

	@FindBy(xpath = "//div[contains(@class,'-date-picker__calendar--open')]")
	WebElement openCalendar;

	@FindBy(xpath = "//button[contains(text(),'Save changes')]")
	WebElement saveChangesButton;

	@FindBy(xpath = "//div[contains(text(),'A date must be selected.')]")
	WebElement validationMessageOfDate;

	@FindBy(xpath = "//button[contains(text(),'Submit statement')]")
	WebElement submitStatementButton;

	@FindBy(xpath = "//button[contains(text(),'Autopopulate table')]")
	WebElement autoPopulateButton;

	@FindBy(xpath = "//div[contains(text(),'Click to add item')]")
	WebElement clickToAddItemLink;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter a fee description')][@value='']")
	WebElement inputBoxForDescSection;

	@FindBy(xpath = "//select[contains(@id,'labeled-select-id')]")
	WebElement gradeDD;

	@FindBy(xpath = "//div[contains(text(),'Please enter fee amount(s) that are numeric and greater than $0.00.')]")
	WebElement validationMessageForAlphabet;

	@FindBy(xpath = "//div[contains(@class,'discount-table')]//*[contains(text(),'Click to add item')]")
	WebElement addItemLinkUnderDiscount;

	@FindBy(xpath = "//button[contains(@class,'picker__calendar')][@disabled]")
	WebElement disabledCalendarIcon;

	@FindBy(xpath = "//button[contains(text(),'Autopopulate table')][@disabled]")
	WebElement disabledAutoPopulateButton;

	@FindBy(xpath = "//button[contains(text(),'Submit statement')][@disabled]")
	WebElement disabledSubmitStatementButton;

	@FindBy(xpath = "//button[contains(text(),'Save changes')][@disabled]")
	WebElement disabledSaveChangesButton;

	public String statusPanelField = "//div[@class='panel-section-content']//span[contains(text(),'%s')]";

	public String panelFieldValue = "//div[@class='panel-section-content']//span[contains(text(),'%s')]/following::span[1]";

	public String descFieldValue = "//input[@value='%s']/following::input[1]";

	public String descLabelValue = "//input[@value='%s']";

	public String calValue ="//*[contains(@class,'month-view__days__day')]//*[text()='%s']";

	public void newFinancePageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory,this);
		element = new Element(driver);
		browserDriver =new BrowserDriver();
		JSWaiter.setDriver(driver);
	}

	public void clickOnEditLinkOfApplication(){
		//waitABit(10000);
		base.waitForElement(statusColumn);
		element.click(driver,statusColumn);
		logger.info("Click on status column");
		Base.extentTest.log(LogStatus.PASS, "Click on status column");
		Base.takeScreenShot();


	//	waitABit(5000);
		try {
			base.waitForElement(editLink);
			element.click(driver, editLink);
			logger.info("Click on edit link");
			Base.extentTest.log(LogStatus.PASS, "Click on edit link");
			Base.takeScreenShot();
			waitABit(10000);
		}catch(Exception e){
			logger.info("School User > Finance > Annual Statement, No Record found with edit link");
			Base.extentTest.log(LogStatus.PASS, "School User > Finance > Annual Statement, No Record found with edit link");
			Base.takeScreenShot();
			throw new AssertionError("School User > Finance > Annual Statement, No Record found with edit link");
		}


	}

	public void verifyPanelValue(String fieldName) throws InterruptedException {
		mouseHoverJScript(driver.findElement(By.xpath(String.format(statusPanelField, fieldName))));
		Assert.assertTrue(driver.findElement(By.xpath(String.format(statusPanelField, fieldName))).isDisplayed(),"Verify status panel field");
		logger.info("Verify status panel field");
		Base.extentTest.log(LogStatus.PASS, "Verify status panel field");
		Base.takeScreenShot();
	}

	public void verifyPanelFieldValue(String fieldName) throws InterruptedException {
		Assert.assertFalse(driver.findElement(By.xpath(String.format(panelFieldValue, fieldName))).getText().isEmpty(),"Verify status panel field value");
		logger.info("Verify status panel field value");
		Base.extentTest.log(LogStatus.PASS, "Verify status panel field value");
		Base.takeScreenShot();
	}

	public void verifyGradeDDShouldBeEnabled() throws InterruptedException {
		Assert.assertFalse(element.isDisplayed(disabledGradeDD),"Verify Grade DD should be enabled");
		logger.info("Verify Grade DD should be enabled");
		Base.extentTest.log(LogStatus.PASS, "Verify Grade DD should be enabled");
		Base.takeScreenShot();
	}

	public void verifyDateFieldShouldBeEnabled() throws InterruptedException {
		waitABit(2000);
		mouseHoverJScript(calendarIcon);
		waitABit(2000);
		element.clickByJs(driver,calendarIcon);
		logger.info("Click Calendar icon");
		Base.extentTest.log(LogStatus.PASS, "Click Calendar icon");
		Base.takeScreenShot();

		Assert.assertTrue(element.isDisplayed(openCalendar),"Verify calendar should get open");
		logger.info("Verify calendar should get open");
		Base.extentTest.log(LogStatus.PASS, "Verify calendar should get open");
		Base.takeScreenShot();
	}

	public void clickOnSaveChangesButton() throws InterruptedException {
		element.click(driver, saveChangesButton);
		logger.info("Clicked on save changes button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on save changes button");
		Base.takeScreenShot();
	}

	public void verifyValidationMessageForDate() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(validationMessageOfDate),"Verify validation message of date");
		logger.info("Verify validation message of date");
		Base.extentTest.log(LogStatus.PASS, "Verify validation message of date");
		Base.takeScreenShot();
	}

	public void verifySubmitStatementButton() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(submitStatementButton),"Verify submit statement button");
		logger.info("Verify validation message of date");
		Base.extentTest.log(LogStatus.PASS, "Verify validation message of date");
		Base.takeScreenShot();
	}

	public void verifyAutoPopulateButton() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(autoPopulateButton),"Verify auto populate button");
		logger.info("Verify auto populate button");
		Base.extentTest.log(LogStatus.PASS, "Verify auto populate button");
		Base.takeScreenShot();
	}

	public void clickOnAddItemLink() throws InterruptedException {
		waitABit(2000);
		mouseHoverJScript(clickToAddItemLink);
		waitABit(2000);
		element.clickByJs(driver, clickToAddItemLink);
		logger.info("Clicked on add item");
		Base.extentTest.log(LogStatus.PASS, "Clicked on add item");
		Base.takeScreenShot();
	}

	public void addDataInDescription(String fieldName, String value){
		waitABit(2000);
		element.clickByJs(driver,inputBoxForDescSection);
		element.clear(inputBoxForDescSection);
		element.sendKeys(inputBoxForDescSection,fieldName);
		logger.info("Entered field name as "+fieldName);
		Base.extentTest.log(LogStatus.PASS, "Entered field name as "+fieldName);
		Base.takeScreenShot();
		inputBoxForDescSection.sendKeys(Keys.TAB);

		waitABit(2000);
		element.clear(driver.findElement(By.xpath(String.format(descFieldValue,fieldName))));
		element.sendKeys(driver.findElement(By.xpath(String.format(descFieldValue,fieldName))),value);
		logger.info("Entered field value as "+value);
		Base.extentTest.log(LogStatus.PASS, "Entered field value as "+value);
		Base.takeScreenShot();
	}

	public void selectGradeLevel(String gradeType){
		Select se = new Select(gradeDD);
		se.selectByValue(gradeType);
		logger.info("Select grade as "+gradeType);
		Base.extentTest.log(LogStatus.PASS, "Select grade as "+gradeType);
		Base.takeScreenShot();

	}

	public void clickOnAutoPopulateButton() throws InterruptedException {
		mouseHoverJScript(autoPopulateButton);
		waitABit(2000);
		element.click(driver, autoPopulateButton);
		logger.info("Clicked on auto populate");
		Base.extentTest.log(LogStatus.PASS, "Clicked on auto populate");
		Base.takeScreenShot();
		waitABit(5000);
	}

	public void verifyAddedDataShouldNotBeDisplayed(String fieldName){
		boolean isNameDisplayed =true;
		try{
			isNameDisplayed = driver.findElement(By.xpath(String.format(descFieldValue,fieldName))).isDisplayed();
		}catch (Exception e){
			isNameDisplayed = false;
		}
		Assert.assertFalse(isNameDisplayed,"Verify data should not be displayed");
		logger.info("Verify data should not be displayed");
		Base.extentTest.log(LogStatus.PASS, "Verify data should not be displayed");
		Base.takeScreenShot();
	}

	public void verifyFieldValueDataShouldBeDisplayed(String fieldName){
		Assert.assertTrue(element.isDisplayed(driver.findElement(By.xpath(String.format(descFieldValue,fieldName)))),"Verify data should not be displayed");
		logger.info("Verify data should be displayed");
		Base.extentTest.log(LogStatus.PASS, "Verify data should be displayed");
		Base.takeScreenShot();
	}

	public void verifyLabelValueDataShouldBeDisplayed(String fieldName){
		Assert.assertTrue(element.isDisplayed(driver.findElement(By.xpath(String.format(descLabelValue,fieldName)))),"Verify data should not be displayed");
		logger.info("Verify data should be displayed");
		Base.extentTest.log(LogStatus.PASS, "Verify data should be displayed");
		Base.takeScreenShot();
	}

	public void verifyValidationMessageForAlphabetChar(){
		waitABit(3000);
		Assert.assertTrue(element.isDisplayed(validationMessageForAlphabet),"Verify data should not be displayed");
		logger.info("Verify validation message should be displayed for alphabet char");
		Base.extentTest.log(LogStatus.PASS, "Verify validation message should be displayed for alphabet char");
		Base.takeScreenShot();
	}

	public void verifyAddItemLinkShouldNotBeDsiaplyedUnderDiscount(){
		Assert.assertFalse(element.isDisplayed(addItemLinkUnderDiscount),"Verify add item link should not be displayed under discount");
		logger.info("Verify add item link should not be displayed under discount");
		Base.extentTest.log(LogStatus.PASS, "Verify add item link should not be displayed under discount");
		Base.takeScreenShot();
	}

	public void selectTodayDate() throws InterruptedException {
		element.click(driver,calendarIcon);
		logger.info("Click Calendar icon");
		Base.extentTest.log(LogStatus.PASS, "Click Calendar icon");
		Base.takeScreenShot();

		String dayOfWeek = getDayOfWeek();
		element.click(driver, driver.findElement(By.xpath(String.format(calValue,dayOfWeek))));
		logger.info("Day of week selected");
		Base.extentTest.log(LogStatus.PASS, "Day of week selected");
		Base.takeScreenShot();
	}

	public void clickOnSubmitButton() throws InterruptedException {
		element.click(driver, submitStatementButton);
		logger.info("Clicked on submit statement button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit statement button");
		Base.takeScreenShot();
	}

	public void verifyPanelFieldValue(String fieldName, String expectedStatus) throws InterruptedException {
		waitABit(5000);
		Assert.assertTrue(driver.findElement(By.xpath(String.format(panelFieldValue, fieldName))).getText().toLowerCase().contains(expectedStatus.toLowerCase()),"Verify status panel field value");
		logger.info("Verify status panel field value");
		Base.extentTest.log(LogStatus.PASS, "Verify status panel field value");
		Base.takeScreenShot();
	}

	public void verifyGradeDDShouldBeDisabled() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(disabledGradeDD),"Verify Grade DD should be disabled");
		logger.info("Verify Grade DD should be disabled");
		Base.extentTest.log(LogStatus.PASS, "Verify Grade DD should be disabled");
		Base.takeScreenShot();
	}

	public void verifyCalendarShouldBeDisabled() throws InterruptedException {
		mouseHoverJScript(disabledCalendarIcon);
		waitABit(3000);
		Assert.assertTrue(element.isDisplayed(disabledCalendarIcon),"Verify calendar should be disabled");
		logger.info("Verify calendar should be disabled");
		Base.extentTest.log(LogStatus.PASS, "Verify calendar should be disabled");
		Base.takeScreenShot();
	}

	public void verifyAutoPopulateButtonShouldBeDisabled() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(disabledAutoPopulateButton),"Verify AutoPopulateButton should be disabled");
		logger.info("Verify AutoPopulateButton should be disabled");
		Base.extentTest.log(LogStatus.PASS, "Verify AutoPopulateButton should be disabled");
		Base.takeScreenShot();
	}

	public void verifySubmitButtonShouldBeDisabled() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(disabledSubmitStatementButton),"Verify Submit Button should be disabled");
		logger.info("Verify Submit button should be disabled");
		Base.extentTest.log(LogStatus.PASS, "Verify Submit button should be disabled");
		Base.takeScreenShot();
	}

	public void verifySaveChangesButtonShouldBeDisabled() throws InterruptedException {
		Assert.assertTrue(element.isDisplayed(disabledSaveChangesButton),"Verify Save changes Button should be disabled");
		logger.info("Verify Save changes button should be disabled");
		Base.extentTest.log(LogStatus.PASS, "Verify Save changes button should be disabled");
		Base.takeScreenShot();
	}

}


