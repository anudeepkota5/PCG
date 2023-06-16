package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;


public class ApplicationPage {

    WebDriver driver;
    Element element;
    BrowserDriver browserDriver = new BrowserDriver();
    Base base = new Base();
    JSWaiter jSWaiter = new JSWaiter();
    private static Logger logger = LogManager.getLogger(Homepage.class.getName());

    @FindBy(xpath = "//div[contains(@class,'MuiPaper-elevation')]/descendant::div[@id='termSelect'][1]")
    WebElement termSelectDD;

    @FindBy(xpath = "//ul[contains(@class,'MuiList-root')]/descendant::li[1]")
    WebElement firstDDValueOfTerm;

    @FindBy(xpath = "//*[contains(@class,'MuiInputBase-root MuiInput-root MuiInput-underline')]//input")
    WebElement searchInputBox;

    @FindBy(xpath = "//*[@class='actions-button tertiary']")
    WebElement actionsButton;

    @FindBy(xpath = "//div[contains(text(),'Edit Status')]")
    WebElement editStatus;

    @FindBy(xpath = "//button[contains(text(),'Update Status')]")
    WebElement updateStatusButton;

    @FindBy(xpath = "//*[@class='app-review-message-input']/textarea")
    WebElement inputBoxForReason;

    @FindBy(xpath = "//tbody[contains(@class,'MuiTableBody-root')]/tr")
    List<WebElement> applicationList;

    @FindBy(xpath = "//div[@class='eligibility-verification panel-section']")
    WebElement eligibilityPanel;

    @FindBy(xpath = "//div[@class='enrollment-verification panel-section']")
    WebElement enrollmentVerificationPanel;

    @FindBy(xpath = "//div[@class='documents panel-section']")
    WebElement documentsPanel;

    @FindBy(xpath = "//div[@class='osde panel-section']")
    WebElement LNHPanel;

    @FindBy(xpath = "//button[text()='Save changes']")
    WebElement saveChangesButton;

    @FindBy(xpath = "//div[contains(@class,'status-select__option')]")
    List<WebElement> editStatusDD;

    @FindBy(xpath = "//*[contains(@data-icon,'times-circle')]")
    WebElement closeIconOfEditApplication;

    @FindBy(xpath = "//*[contains(text(),'Please enter a nine-digit Social Security Number')]")
    WebElement ssnValidationMsg;

	@FindBy(xpath = "driver.findElement(By.xpath('//*[contains(@data-form-key,'sectionA.IEPorISP')]'))")
	WebElement iepOrispDropdown;

	@FindBy(xpath = "//*[contains(@data-form-key,'sectionB.location")
	WebElement locationDD;

	public String searchValueBasedOnRowAndColumn = "//tbody[contains(@class,'MuiTableBody-root')]/tr[%s]/th[%s]//p";

    @FindBy(xpath = "(//div[contains(@class,'status-select__option')])[1]")
    WebElement firstStatusDDValue;

	@FindBy(xpath = "//li[@class='selected']/span[contains(text(),'Applications')]")
	WebElement applications;

	@FindBy(xpath = "//div[contains(@class,'MuiPaper-elevation')]/descendant::div[@id='termSelect'][4]")
	WebElement status;

	public String statusSelect = "//ul[contains(@class,'MuiList-root')]/descendant::li[contains(text(),'%s')]";

	@FindBy(xpath = "//table[contains(@class,'MuiTable-root MuiTable-stickyHeader')]//tbody//tr[1]//th[4]//p")
	WebElement firstNameLink;

	@FindBy(xpath = "//table[contains(@class,'MuiTable-root MuiTable-stickyHeader')]//tbody//tr[1]//th[10]//p")
	WebElement statusColmn;

	@FindBy(xpath = "//span[text()='Status' and @role='button']")
	WebElement StatusButton;

	@FindBy(xpath = "//div[text()='Status:']//following-sibling::div")
	WebElement StatusLabel;

	@FindBy(xpath = "//div[@class='review message'][1]")
	WebElement reviewMessage;

	@FindBy(xpath = "//span[@class='status-component']")
	WebElement applicationStatus;

	@FindBy(xpath = "(//div[@class='review-message']//div[1])[1]")
	WebElement returnToPrentRcordMessage;

	@FindBy(xpath = "//div[@class='message-container']")
	WebElement messageContainera;

	@FindBy(xpath = "//div[@class='signature-container']")
	WebElement dateAndName;

	@FindBy(xpath = "(//div[@class='student-name'])[1]")
	WebElement studentName;

	@FindBy(xpath = "//span[@class='orange circle']")
	WebElement pinkcircle;

	@FindBy(xpath = "//div[contains(@class,'school-review-grid')]//*[contains(@class,'max-page-display')]")
	WebElement maxPageCount;

	@FindBy(xpath = "//div[contains(@class,'school-review-grid')]//button[contains(@class,'next-page-button')]")
	WebElement nextIcon;

	public String valueInHeader = "//h2[contains(text(),'%s')]";

	public String detailInSchoolReviewSection = "//div[contains(@class,'school-review-grid grid-container')]//button[contains(text(),'%s')]";

	public String fieldValue = "//div[contains(text(),'%s')]/..//input";

	public String enabledStudentFieldValue = "//*[contains(@data-form-key,'sectionA.%s')]";

	public String enabledParentFieldValue = "//*[contains(@data-form-key,'sectionB.%s')]";

	public String enabledFieldValue = "//*[contains(@data-form-key,'%s')]";

	public String valueOfApplicationInformation = "//div[contains(text(),'%s')]/following::span[contains(@class,'status-component')]";

	public String yearDD = "//ul[contains(@class,'MuiList-root')]/descendant::li[contains(text(),'%s')]";


	public void newappilcationpageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory,this);
		element = new Element(driver);
		browserDriver =new BrowserDriver();
		JSWaiter.setDriver(driver);
	}

	public String applicationStatus(String studentName) throws InterruptedException {
		String xpathAction = "//div[contains(text(), '" + studentName + "')]/..//div[3]//div[text()='Application Status']//parent::div//span[@class='status-component']";
		String status =  driver.findElement(By.xpath(xpathAction)).getText();
		String applicationStatus = status.trim();
		return applicationStatus;
	}

	public void verifySearchedValue(String rowNo, String columnNo, String value) throws InterruptedException {
		jSWaiter.waitAllRequest();
		Thread.sleep(5000);
		String valueFromUI = driver.findElement(By.xpath(String.format(searchValueBasedOnRowAndColumn, rowNo, columnNo))).getText();
		logger.info("Value from UI is "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Value from UI is "+valueFromUI);
		Base.takeScreenShot();

		if(valueFromUI.contains("/")){
			valueFromUI = valueFromUI.replaceAll("/","").trim();
		}
		Assert.assertTrue(valueFromUI.toLowerCase().contains(value.toLowerCase()), "Expected value is not displayed");
		logger.info("Expected value is not displayed");
		Base.extentTest.log(LogStatus.PASS, "Expected value is not displayed");
		Base.takeScreenShot();
	}

	public void verifyApplicationShouldNotBeDisplayedInSchoolReviewSection(String detailName) throws InterruptedException {
		Thread.sleep(5000);
		boolean isElementDIsplayed = true;
		try {
			if ((element.isDisplayed(driver.findElement(By.xpath(String.format(detailInSchoolReviewSection, detailName))))) == false) {
				isElementDIsplayed = false;
			}
		}catch (Exception e){
			isElementDIsplayed=false;
		}
		Assert.assertFalse(isElementDIsplayed, "Verify details are not getting displayed in school review section");
		logger.info("Verify details are not getting displayed in school review section");
		Base.extentTest.log(LogStatus.PASS, "Verify details are not getting displayed in school review section");
		Base.takeScreenShot();

	}

	public void searchApplication(String searchKey) throws InterruptedException {
		Thread.sleep(5000);

		base.actionClassClick(driver,driver.findElement(By.xpath("//button[contains(text(),'Select Actions')]")));

		Thread.sleep(2000);
		base.javaScriptClick(driver, searchInputBox);
		Thread.sleep(10000);

		base.actionClassClick(driver,searchInputBox);
		searchInputBox.sendKeys(searchKey);
		logger.info("Searched Value as "+searchKey);
		Base.extentTest.log(LogStatus.PASS, "Searched Value as "+searchKey);
		Base.takeScreenShot();
		Thread.sleep(10000);
	}

	public void selectFirstValueOfTermDD(String yearName) throws InterruptedException {
		driver.findElement(By.xpath(String.format(yearDD,yearName))).click();
		logger.info("Value selected of term DD");
		Base.extentTest.log(LogStatus.PASS, "Value selected of term DD");
		Base.takeScreenShot();
	}

	public void clickTermDD() throws InterruptedException {
		termSelectDD.click();
		logger.info("Term DD clicked");
		Base.extentTest.log(LogStatus.PASS, "Term DD clicked");
		Base.takeScreenShot();
	}

	public String getUniqueID(String rowNo, String columnNo) throws InterruptedException {
		jSWaiter.waitAllRequest();
		Thread.sleep(5000);
		String valueFromUI = driver.findElement(By.xpath(String.format(searchValueBasedOnRowAndColumn, rowNo, columnNo))).getText();
		logger.info("Value from UI is "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Value from UI is "+valueFromUI);
		Base.takeScreenShot();

		Assert.assertTrue(Integer.parseInt(valueFromUI)>0,"Verify unique id is displayed correct");
		logger.info("Verify unique id is displayed correct");
		Base.extentTest.log(LogStatus.PASS, "Verify unique id is displayed correct");
		Base.takeScreenShot();
		return valueFromUI;
	}


	public void selectIEPOrISP(){
		try {
			Select se = new Select(iepOrispDropdown);
			se.selectByVisibleText("IEP");
			logger.info("Select value as IEP");
			Base.extentTest.log(LogStatus.PASS, "Select value as IEP");
			Base.takeScreenShot();
		}catch (Exception e){}
	}

	public void selectLocation(){
		try {
			Select se = new Select(driver.findElement(By.xpath("//*[contains(@data-form-key,'sectionB.location')]")));
			se.selectByVisibleText("0");
			logger.info("Select location is 0");
			Base.extentTest.log(LogStatus.PASS, "Select location as 0");
			Base.takeScreenShot();
		}catch (Exception e){}
	}

	public void clickOnSearchedValue(String rowNo, String columnNo){
		jSWaiter.waitAllRequest();

		driver.findElement(By.xpath(String.format(searchValueBasedOnRowAndColumn, rowNo, columnNo))).click();
		logger.info("Clicked on search value");
		Base.extentTest.log(LogStatus.PASS, "Clicked on search value");
		Base.takeScreenShot();

	}

	public String clickOnFirstApplicationWhoDoesNotHaveStatusType(String statusType, String statusType2) throws InterruptedException {
		Thread.sleep(5000);
		String uniqueID = null;
		base.actionClassClick(driver,driver.findElement(By.xpath("//button[contains(text(),'Select Actions')]")));
		int sizeOfList = applicationList.size();
		for(int i=1; i<sizeOfList; i++){
			String columnNo = "10";
			String applicationStatus = getApplicationValue(String.valueOf(i),columnNo);
			logger.info("Status of row no "+i+"th is "+applicationStatus);
			Base.extentTest.log(LogStatus.PASS, "Clicked on application");
			Base.takeScreenShot();
			if(applicationStatus.trim().toLowerCase().contains(statusType.toLowerCase()) && applicationStatus.trim().toLowerCase().contains(statusType2.toLowerCase())){
				continue;
			}else{
				uniqueID = getUniqueID(String.valueOf(i), "2");
				Thread.sleep(3000);
				clickOnSearchedValue(String.valueOf(i),"3");
				logger.info("Clicked on application");
				Base.extentTest.log(LogStatus.PASS, "Clicked on application");
				Base.takeScreenShot();
				break;
			}
		}
		Thread.sleep(15000);
		return uniqueID;
	}

	public void verifyStatusValueOnSearchApplicationPage(String expectedStatus) throws InterruptedException {
		String valueFromUI = getApplicationValue("1","10");
		logger.info("Value from UI is "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Value from UI is "+valueFromUI);
		Base.takeScreenShot();


		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedStatus.toLowerCase()), "Expected value is not displayed");
		logger.info("Expected value is not displayed");
		Base.extentTest.log(LogStatus.PASS, "Expected value is not displayed");
		Base.takeScreenShot();
	}
	public void verifyStatusValue(String fieldName, String expectedStatus) throws InterruptedException {
		Thread.sleep(10000);
		String valueFromUI = driver.findElement(By.xpath(String.format(valueOfApplicationInformation, fieldName))).getText();
		logger.info("Value from UI is "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Value from UI is "+valueFromUI);
		Base.takeScreenShot();


		Assert.assertTrue(valueFromUI.toLowerCase().contains(expectedStatus.toLowerCase()), "Expected value is not displayed");
		logger.info("Expected value is not displayed");
		Base.extentTest.log(LogStatus.PASS, "Expected value is not displayed");
		Base.takeScreenShot();
	}

	public String clickAndGetFirstStatus() throws InterruptedException, AWTException {
		Thread.sleep(5000);

		element.click(driver, driver.findElement(By.xpath("//div[contains(@class,'status-select__dropdown-indicator')]")));
		logger.info("Clicked on edit status DD");
		Base.extentTest.log(LogStatus.PASS, "Clicked on edit status DD");
		Base.takeScreenShot();
		Thread.sleep(5000);

		String statusValue = firstStatusDDValue.getText();
		logger.info("Status name is "+statusValue);
		Base.extentTest.log(LogStatus.PASS, "Status name is "+statusValue);
		Base.takeScreenShot();

		element.click(driver, firstStatusDDValue);
		logger.info("Clicked on first status value");
		Base.extentTest.log(LogStatus.PASS, "Clicked on first status value");
		Base.takeScreenShot();

		try {
			base.actionClassClick(driver, inputBoxForReason);
			element.sendKeys(inputBoxForReason, "Test Automation");
			logger.info("Entered reason for input box");
			Base.extentTest.log(LogStatus.PASS, "Entered reason for input box");
			Base.takeScreenShot();
		}catch (Exception e){}

		element.click(driver, updateStatusButton);
		logger.info("Update status button clicked");
		Base.extentTest.log(LogStatus.PASS, "Update status button clicked");
		Base.takeScreenShot();
		Thread.sleep(10000);
		return statusValue;
	}


	public String getApplicationValue(String rowNo, String columnNo) throws InterruptedException {
		jSWaiter.waitAllRequest();
		Thread.sleep(5000);
		base.mouseHoverJScript(driver.findElement(By.xpath(String.format(searchValueBasedOnRowAndColumn, rowNo, columnNo))));
		String valueFromUI = driver.findElement(By.xpath(String.format(searchValueBasedOnRowAndColumn, rowNo, columnNo))).getText();
		logger.info("Value from UI is "+valueFromUI);
		Base.extentTest.log(LogStatus.PASS, "Value from UI is "+valueFromUI);
		Base.takeScreenShot();
		return valueFromUI;
	}
	public void clickOnFirstApplicationWhoDoesNotHaveStatusType(String statusType) throws InterruptedException {
		Thread.sleep(5000);

		base.actionClassClick(driver,driver.findElement(By.xpath("//button[contains(text(),'Select Actions')]")));
		int sizeOfList = applicationList.size();
		for(int i=1; i<sizeOfList; i++){
			String columnNo = "10";
			String applicationStatus = getApplicationValue(String.valueOf(i),columnNo);
			logger.info("Status of row no "+i+"th is "+applicationStatus);
			Base.extentTest.log(LogStatus.PASS, "Clicked on application");
			Base.takeScreenShot();
			if(applicationStatus.trim().toLowerCase().contains(statusType.toLowerCase())){
				continue;
			}else{
				Thread.sleep(3000);
				clickOnSearchedValue(String.valueOf(i),"3");
				logger.info("Clicked on application");
				Base.extentTest.log(LogStatus.PASS, "Clicked on application");
				Base.takeScreenShot();
				break;
			}
		}
		Thread.sleep(15000);
	}

	public void verifyIsFieldDisabled(String fieldName) throws InterruptedException {
		boolean isFieldDisabled = true;
		try{
			element.sendKeys(driver.findElement(By.xpath(String.format(fieldValue,fieldName))),"");
		}catch (Exception e){
			isFieldDisabled=false;
		}
		Assert.assertFalse(isFieldDisabled,fieldName+"Verify field value should be disabled");
		logger.info(fieldName+"Verify field value should be disabled");
		Base.extentTest.log(LogStatus.PASS, fieldName+"Verify field value should be disabled");
		Base.takeScreenShot();
	}

	public void verifyIsFieldEnabled(String fieldName) throws InterruptedException {
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))),20);
		Assert.assertTrue(driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))).isDisplayed(),fieldName+" field value should be enabled");
		logger.info(fieldName+" field value should be enabled");
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value should be enabled");
		Base.takeScreenShot();
	}

	public void verifyEligibilityVerificationSectionDisplayed() throws InterruptedException {
		Assert.assertTrue(eligibilityPanel.isEnabled(),"Eligibility panel should be enabled");
		logger.info("Eligibility panel should be enabled");
		Base.extentTest.log(LogStatus.PASS, "Eligibility panel should be enabled");
		Base.takeScreenShot();
	}

	public void verifyEnrollmentVerificationSectionDisplayed() throws InterruptedException {
		Assert.assertTrue(enrollmentVerificationPanel.isEnabled(),"Enrollment panel should be enabled");
		logger.info("Enrollment panel should be enabled");
		Base.extentTest.log(LogStatus.PASS, "Enrollment panel should be enabled");
		Base.takeScreenShot();
	}

	public void verifyDocumentsSectionDisplayed() throws InterruptedException {
		Assert.assertTrue(documentsPanel.isEnabled(),"Documents panel should be enabled");
		logger.info("Documents panel should be enabled");
		Base.extentTest.log(LogStatus.PASS, "Documents panel should be enabled");
		Base.takeScreenShot();
	}

	public void verifyLNHSectionDisplayed() throws InterruptedException {
		Assert.assertTrue(LNHPanel.isEnabled(),"LNH panel should be enabled");
		logger.info("LNH panel should be enabled");
		Base.extentTest.log(LogStatus.PASS, "LNH panel should be enabled");
		Base.takeScreenShot();
	}

	public String getFieldValue(String fieldName){
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))),20);
		String valueOnUI = driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))).getAttribute("value");
		logger.info(fieldName+" field value on UI "+fieldValue);
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value added as "+fieldValue);
		Base.takeScreenShot();
		return valueOnUI;
	}

	public void enterStudentInformation(String fieldName, String fieldValue){
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))),20);
		element.clear( driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))));
		//driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))).clear();
		element.sendKeys(driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))), fieldValue);
		logger.info(fieldName+" field value added as "+fieldValue);
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value added as "+fieldValue);
		Base.takeScreenShot();
	}

	public void enterParentInformationInformation(String fieldName, String fieldValue){
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledParentFieldValue,fieldName))),20);
		element.clear(driver.findElement(By.xpath(String.format(enabledParentFieldValue,fieldName))));
		element.sendKeys(driver.findElement(By.xpath(String.format(enabledParentFieldValue,fieldName))), fieldValue);
		logger.info(fieldName+" field value added as "+fieldValue);
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value added as "+fieldValue);
		Base.takeScreenShot();
	}

	public void clickOnSaveChangesButton() throws InterruptedException {
		element.click(driver, saveChangesButton);
		logger.info("Clicked on save changes button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on save changes button");
		Base.takeScreenShot();
		Thread.sleep(5000);
	}


	public void verifySSNError() throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (ssnValidationMsg.isDisplayed()) {
				enterParentInformationInformation("tin", "213456789");
				logger.info("Entering the SSN for resolving the SSN error");
				Base.extentTest.log(LogStatus.PASS, "Entering the SSN for resolving the SSN error");
				Base.takeScreenShot();
				clickOnSaveChangesButton();
			}
		}catch(Exception e){}
	}

	public void verifyStudentFormValue(String fieldName, String fieldValue) throws InterruptedException {
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))),20);
		String valueOnUI = driver.findElement(By.xpath(String.format(enabledStudentFieldValue,fieldName))).getAttribute("value");
		logger.info(fieldName+" field value on UI "+fieldValue);
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value added as "+fieldValue);


		Thread.sleep(10000);
		Base.takeScreenShot();


		Assert.assertTrue(valueOnUI.trim().toLowerCase().contains(fieldValue.toLowerCase()),fieldName+" Value is not expected");
		logger.info(fieldName+" Value is not expected");
		Base.extentTest.log(LogStatus.PASS, fieldName+" Value is not expected");
		Base.takeScreenShot();
	}

	public void verifyParentFormValue(String fieldName, String fieldValue){
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledParentFieldValue,fieldName))),20);
		String valueOnUI = driver.findElement(By.xpath(String.format(enabledParentFieldValue,fieldName))).getAttribute("value");
		logger.info(fieldName+" field value on UI "+fieldValue);
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value added as "+fieldValue);
		Base.takeScreenShot();

		Assert.assertTrue(valueOnUI.trim().toLowerCase().contains(fieldValue.toLowerCase()),fieldName+" Value is not expected");
		logger.info(fieldName+" Value is not expected");
		Base.extentTest.log(LogStatus.PASS, fieldName+" Value is not expected");
		Base.takeScreenShot();
	}

	public void verifyIsFieldValueEnabled(String fieldName) throws InterruptedException {
		element.waitVisibility(driver, driver.findElement(By.xpath(String.format(enabledFieldValue,fieldName))),20);
		Assert.assertTrue(driver.findElement(By.xpath(String.format(enabledFieldValue,fieldName))).isDisplayed(),fieldName+" field value should be enabled");
		logger.info(fieldName+" field value should be enabled");
		Base.extentTest.log(LogStatus.PASS, fieldName+" field value should be enabled");
		Base.takeScreenShot();
	}

	public void verifyTheStatusDD() throws InterruptedException, AWTException {
		Thread.sleep(5000);

		element.click(driver, driver.findElement(By.xpath("//div[contains(@class,'status-select__dropdown-indicator')]")));
		logger.info("Entered reason for input box");
		Base.extentTest.log(LogStatus.PASS, "Entered reason for input box");
		Base.takeScreenShot();
		Thread.sleep(3000);

		for (WebElement statusName : editStatusDD) {
			String statusValue = statusName.getText();
			logger.info("Status name is "+statusValue);
			Base.extentTest.log(LogStatus.PASS, "Status name is "+statusValue);
			Base.takeScreenShot();
		}
	}

	public void clickOnCloseIcon_EditStatusPopup(){
		element.click(driver,closeIconOfEditApplication);
		logger.info("Close icon clicked");
		Base.extentTest.log(LogStatus.PASS, "Close icon clicked");
		Base.takeScreenShot();
	}




    public void verifyValueInHeader(String value) throws InterruptedException {
        jSWaiter.waitAllRequest();
        Thread.sleep(5000);
        logger.info("Name is <b>" + value + "</b>");
        Base.extentTest.log(LogStatus.PASS, "Name is <b>" + value + "</b>");
        element.waitPresenceBy(driver, By.xpath(String.format(valueInHeader, value)), 50);
        Assert.assertTrue(driver.findElement(By.xpath(String.format(valueInHeader, value))).isDisplayed(), "Expected value is not displayed at header");
        logger.info("Expected value is not displayed at header");
        Base.extentTest.log(LogStatus.PASS, "Expected value is not displayed at header");
        Base.takeScreenShot();

    }

    public void verifyUniqueIdInHeader(String lastName, String value) {
        jSWaiter.waitAllRequest();
        String valueFromUI = driver.findElement(By.xpath(String.format(valueInHeader, lastName))).getText();

        Assert.assertTrue(valueFromUI.contains(value), "Expected value is not displayed at header");
        logger.info("Expected value is not displayed at header");
        Base.extentTest.log(LogStatus.PASS, "Expected value is not displayed at header");
        Base.takeScreenShot();

    }

	public void selectStatusAsInitialReview() throws InterruptedException, AWTException {
		Thread.sleep(6000);
		Robot robot = new Robot();  // Robot class throws AWT Exception
		Thread.sleep(2000); //

		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);

		for(int i=0; i<1; i++){
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}

		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

		logger.info("Select status as Initial Review");
		Base.extentTest.log(LogStatus.PASS, "Select status as Initial Review");
		Base.takeScreenShot();

		base.actionClassClick(driver, inputBoxForReason);
		element.sendKeys(inputBoxForReason,"Test Automation");
		logger.info("Entered reason for input box");
		Base.extentTest.log(LogStatus.PASS, "Entered reason for input box");
		Base.takeScreenShot();

		element.click(driver, updateStatusButton);
		Thread.sleep(5000);
		logger.info("Update status button clicked");
		Base.extentTest.log(LogStatus.PASS, "Update status button clicked");
		Base.takeScreenShot();
	}

    public void clickOnEditStatus() throws InterruptedException {
        Thread.sleep(5000);
        element.click(driver, actionsButton);
        logger.info("Click on actions button");
        Base.extentTest.log(LogStatus.PASS, "Click on actions button");
        Base.takeScreenShot();

        element.click(driver, editStatus);
        logger.info("Click on edit status");
        Base.extentTest.log(LogStatus.PASS, "Click on edit status");
        Base.takeScreenShot();

    }

    public void selectStatusAsSchoolReview() throws InterruptedException, AWTException {
        Thread.sleep(5000);

        element.click(driver, driver.findElement(By.xpath("//div[contains(@class,'status-select__dropdown-indicator')]")));
        Thread.sleep(1000);
        element.click(driver, driver.findElement(By.xpath("//*[contains(text(),'School Review')]")));

        base.actionClassClick(driver, inputBoxForReason);
        element.sendKeys(inputBoxForReason, "Test Automation");
		Thread.sleep(3000);
        logger.info("Entered reason for input box");
        Base.extentTest.log(LogStatus.PASS, "Entered reason for input box");
        Base.takeScreenShot();

        element.click(driver, updateStatusButton);
		Thread.sleep(5000);
        logger.info("Update status button clicked");
        Base.extentTest.log(LogStatus.PASS, "Update status button clicked");
        Base.takeScreenShot();
    }

	public void verifyApplicationInSchoolReviewSection(String detailName) throws InterruptedException {
		//WebElement elementTolocate = driver.findElement(By.xpath(String.format(detailInSchoolReviewSection,detailName)));
		element.waitPresenceBy(driver,By.xpath(String.format(detailInSchoolReviewSection,detailName)),30);
		Thread.sleep(5000);
		int maxPageCountFromUI = Integer.parseInt(maxPageCount.getText());
		logger.info("Get max page count as "+maxPageCountFromUI);
		Base.extentTest.log(LogStatus.PASS, "Get max page count as "+maxPageCountFromUI);
		Base.takeScreenShot();

		Thread.sleep(5000);
		for(int i=1; i<maxPageCountFromUI; i++){
			boolean isNameDisplayed =false;
			try{
				isNameDisplayed = driver.findElement(By.xpath(String.format(detailInSchoolReviewSection,detailName))).isDisplayed();
			}catch (Exception e){}
			if(isNameDisplayed){
				logger.info("Verify is name displayed on page");
				Base.extentTest.log(LogStatus.PASS, "Verify is name displayed on page");
				Base.takeScreenShot();
				break;
			}else{
				nextIcon.click();
			}
		}

		Assert.assertTrue(element.isDisplayed(driver.findElement(By.xpath(String.format(detailInSchoolReviewSection,detailName)))), "Verify details are not getting displayed in school review section");
		logger.info("Verify details are not getting displayed in school review section");
		Base.extentTest.log(LogStatus.PASS, "Verify details are not getting displayed in school review section");
		Base.takeScreenShot();

	}

    public void applicationLink() throws InterruptedException {
        applications.click();
        logger.info("Applications link clicked");
        Base.extentTest.log(LogStatus.PASS, "Applications Link clicked");
        Base.takeScreenShot();
    }

    public void selectStatusValue() throws InterruptedException, AWTException {
        jSWaiter.waitAllRequest();
        Thread.sleep(5000);
       // status.click();
        logger.info("clicked on the status ");
        Base.extentTest.log(LogStatus.PASS, "clicked on the status ");
        Base.takeScreenShot();
        // selectStatus("Initial Review");
        try{
        String statusValue = statusColmn.getText();
        if(statusValue.contains("Withdrawn")){
            StatusButton.click();
        }
        }catch (Exception e){
            logger.info("status button not available ");
        }
    }
    public void firstNameLink() throws InterruptedException {
        Thread.sleep(5000);
        firstNameLink.click();
        logger.info("first Name Link clicked");
        Base.extentTest.log(LogStatus.PASS, "first Name Link clicked");
        Base.takeScreenShot();
    }

	public void selectStatusAsReturnedtoParent() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		element.click(driver, driver.findElement(By.xpath("//div[contains(@class,'status-select__dropdown-indicator')]")));
		Thread.sleep(1000);
		element.click(driver, driver.findElement(By.xpath("//*[contains(text(),'Returned to Parent')]")));

		base.actionClassClick(driver, inputBoxForReason);
		element.sendKeys(inputBoxForReason, "Test Automation");
		logger.info("Entered reason for input box");
		Base.extentTest.log(LogStatus.PASS, "Entered reason for input box");
		Base.takeScreenShot();

		element.click(driver, updateStatusButton);
		logger.info("Update status button clicked");
		Base.extentTest.log(LogStatus.PASS, "Update status button clicked");
		Base.takeScreenShot();
		Thread.sleep(8000);
		base.waitForElement(StatusLabel);
		String str = StatusLabel.getText();
		String statusLabel = str.trim();
		Assert.assertEquals(statusLabel,"Returned to Parent");


	}


	public void verifyStatus() throws InterruptedException, AWTException {
		Thread.sleep(18000);
		//base.waitForElement(StatusLabel);
		String str = StatusLabel.getText();
		String StatusLabel = str.trim();
		Assert.assertEquals(StatusLabel,"Initial Review");
		Base.takeScreenShot();

	}

	public void verifyApplicationStatusInitial() throws InterruptedException {
			Thread.sleep(8000);

			base.waitForElement(applicationStatus);
			String str = applicationStatus.getText();
			String status = str.trim();
			Assert.assertEquals(status,"Initial Review");
			Base.takeScreenShot();
    }

	public void verifyApplicationStatus(String studentName) throws InterruptedException, AWTException {
		Thread.sleep(15000);
		base.waitForElement(reviewMessage);
		String msg = reviewMessage.getText();
		System.out.println();
		Assert.assertEquals(msg,"Attention! "+studentName+"'s application has been returned. Select 'Edit application' from the Actions menu to see more information.");
		Base.takeScreenShot();
		Thread.sleep(8000);

		String applicationStatus = applicationStatus(studentName);
		//String xpathAction = "//div[contains(text(), '" + studentName + "')]/..//div[3]//div[text()='Application Status']//parent::div//span[@class='status-component']";
		//String status =  driver.findElement(By.xpath(xpathAction)).getText();
		//String status = applicationStatus.getText();
		//String applicationStatus = status.trim();
		Assert.assertEquals(applicationStatus,"Returned to Parent");
		Base.takeScreenShot();
		Assert.assertTrue(pinkcircle.isDisplayed());
	}

	public void verifyMessageApplication(String studentName) throws InterruptedException,AWTException{
		Thread.sleep(8000);
		String msg = reviewMessage.getText();
		System.out.println();
		Assert.assertEquals(msg,"Attention! "+studentName+"'s application has been returned. Select 'Edit application' from the Actions menu to see more information.");
		Base.takeScreenShot();
	}

	public void verifyMessageInEditApplication (String studentName) throws InterruptedException {
		Thread.sleep(8000);
		Assert.assertEquals(returnToPrentRcordMessage.getText(),"Attention! "+studentName+"'s application has been returned. Please make the appropriate corrections and sign and submit again.");
		Base.takeScreenShot();

		Thread.sleep(1000);
		Assert.assertTrue(messageContainera.isDisplayed());
		Base.takeScreenShot();

		Thread.sleep(2000);
		Assert.assertTrue(dateAndName.isDisplayed());
		Assert.assertTrue(messageContainera.isDisplayed());
		Base.takeScreenShot();

	}

	public String getStudentName() throws InterruptedException {
		applications.click();
		logger.info("Applications link clicked");
		Base.extentTest.log(LogStatus.PASS, "Applications Link clicked");
		Base.takeScreenShot();
		Thread.sleep(18000);

		base.waitForElement(studentName);
		String str = studentName.getText();
		String studentName = str.trim();
		return studentName;
	}

	public String[] spiltingStudentName(String name) throws InterruptedException {
		String words[] = name.split("\\s");
		return words;
	}

}




