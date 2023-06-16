package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
import com.pcgus.ci.PDFReader;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.testbase.Base;
import com.pcgus.ci.scholar.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class CreateApplicationPage {

	WebDriver driver;
	Element element;
	//Homepage homepage;
	BrowserDriver browserDriver;// = new BrowserDriver();
	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());

	@FindBy(css="[class='type-icon']>svg")
	WebElement downloads;
	@FindBy(xpath="//button[text()[contains(.,'Create application')]]")
	WebElement createapplicationbutton;

	@FindBy(xpath="//div[@class='students']//*[text()[contains(.,'New Student')]]")
	WebElement newstudentbutton;

	@FindBy(xpath="//button[text()[contains(.,'Start Application')]]")
	WebElement startapplicationbutton;

	@FindBy(xpath="//h3[text()[contains(.,'Student Information')]]")
	WebElement studentinformation;

	@FindBy(xpath="//input[@id='quest-33' and @type='text']")
	WebElement firstname;

	@FindBy(xpath="//input[@id='quest-34' and @type='text']")
	WebElement lastname;

	@FindBy(xpath="//input[@name='month']")
	WebElement dob;

	@FindBy(xpath="//select[@id='quest-36']")
	WebElement grade;

	@FindBy(xpath="//select[@id='quest-37']")
	WebElement schooldistrictofresidence;

	@FindBy(xpath="//select[@id='quest-38']")
	WebElement schooldistrictIEP;

//	@FindBy("//*/[text()[contains(.,'School district of Individualized Education Program (IEP)')]]")
//	WebElement schooldistrictIEPLabel;

	@FindBy(xpath="//select[@id='quest-39']")
	WebElement schoolname;

	@FindBy(xpath="//select[@id='quest-75']")
	WebElement enrollmenttype;

	@FindBy(xpath="//input[@id='quest-40-opt-1065']")
	WebElement eligibilityverification;

	@FindBy(xpath="//input[@id='quest-41-opt-1067']")
	WebElement enrollmentverification;

	@FindBy(xpath="//input[@id='quest-42-opt-1975']")
	WebElement race;

	@FindBy(xpath="//input[@id='quest-43-opt-1079']")
	WebElement economicallystatus;

	@FindBy(xpath="//button[text()[contains(.,'Continue')]]")
	WebElement continuebutton;

	@FindBy(xpath="//input[@id='quest-44']")
	WebElement parentfirstname;

	@FindBy(xpath="//input[@id='quest-45']")
	WebElement parentlastname;

	@FindBy(xpath="//input[@id='quest-46']")
	WebElement parentemailaddress;

	@FindBy(xpath="//input[@id='quest-47']")
	WebElement parentphonenum;

	@FindBy(xpath="//input[@id='quest-48']")
	WebElement parentaddress;

	@FindBy(xpath="//input[@id='quest-49']")
	WebElement parentcity;

	@FindBy(xpath="//select[@id='quest-50']")
	WebElement parentstate;

	@FindBy(xpath="//input[@id='quest-51']")
	WebElement parentzipcode;

	@FindBy(xpath="//button[text()[contains(.,'Continue')]]")
	WebElement parentcontinuebutton;

	@FindBy(xpath="//button[text()[contains(.,'Continue')]]")
	WebElement attachmentscontinuebutton;

	@FindBy(xpath="//div[3]//div/div[2]//canvas[@class='sigCanvas']")
	WebElement LNHApplicationsignature;

	@FindBy(xpath="//div[10]//div/div[2]/canvas[@class='sigCanvas']")
	WebElement omesapplicationsignature;

	@FindBy(xpath="//input[@id='quest-52']")
	WebElement parentssn;

	@FindBy(xpath="//div[@class='application-section']/div[3]//span[contains(text(),'Apply signature')]")
	WebElement LNHapplysignatture;

	@FindBy(xpath="//div[10]//span[contains(text(),'Apply signature')]")
	WebElement OMEapplysignatture;

	@FindBy(xpath="//span[text()[contains(.,'Submit')]]")
	WebElement submitbutton;

	@FindBy(xpath="//button[text()[contains(.,'Back to My Application')]]")
	WebElement backtomyapplicationbutton;

	@FindBy(xpath="//button[text()[contains(.,'Cancel')]]")
	WebElement cancelbutton;

	@FindBy(xpath="//div[@class='log-out']//button")
	WebElement logout;

	@FindBy(xpath="//div[text()[contains(.,'Student info')]]")
	WebElement studentinfotab;

	@FindBy(xpath="//div[text()[contains(.,'Student info')]]//parent::div/div[text()[contains(.,'Step 1')]]")
	WebElement step1tile;

	@FindBy(xpath="//div[text()[contains(.,'Parent info')]]")
	WebElement parentinfotab;

	@FindBy(xpath="//div[text()[contains(.,'Parent info')]]//parent::div/div[text()[contains(.,'Step 2')]]")
	WebElement step2tile;

	@FindBy(xpath="//div[text()[contains(.,'Attachments')]]")
	WebElement attachmenttab;

	@FindBy(xpath="//div[text()[contains(.,'Attachments')]]//parent::div/div[text()[contains(.,'Step 3')]]")
	WebElement step3tile;

	@FindBy(xpath="//div[text()[contains(.,'Sign & submit')]]")
	WebElement signnsubmittab;

	@FindBy(xpath="//div[text()[contains(.,'Sign & submit')]]//parent::div/div[text()[contains(.,'Step 4')]]")
	WebElement step4tile;

	@FindBy(xpath="//div[@class='details']/div[last()]")
	WebElement lastapplicationname;

	@FindBy(xpath="//div[@class='app-instance'][last()]//parent::span[text()='Actions']")
	WebElement lastactionbutton;

	@FindBy(xpath="//div[@class='app-instance'][1]/div[text()='No Name']//following-sibling::div[@class='actions-container']//span[text()='Actions']")
	WebElement firstactionbuttonwithnoname;

	@FindBy(xpath="//div[@class='app-instance'][last()]//parent::span[text()='Actions']//..//div[@id='react-select-110-listbox']")
	WebElement dropdown;

	@FindBy(xpath="//span[text()[contains(.,'Applications')]]")
	WebElement applicationicon;

	@FindBy(xpath="//button[text()='Cancel']")
	WebElement nsCancelButton;

	@FindBy(xpath="//div[@class='modal-content']")
	WebElement nsModelPopUp;

	@FindBy(xpath="//div[@class='students']")
	WebElement ParentOfExistingStudentList;

	@FindBy(xpath="//div[@class='students']/div")
	List<WebElement> ChildOfExistingStudentList;

	@FindBy(xpath="//div[text()='Step 1']")
	WebElement studentSectionCompletionIndicator;

	@FindBy(xpath="//div[text()='Step 2']")
	WebElement parentSectionCompletionIndicator;

	@FindBy(xpath="//div[text()='Student info']")
	WebElement stuinformation;

	@FindBy(xpath="//div[text()='Parent info']")
	WebElement parentinformation;

	@FindBy(xpath="//span[text()[contains(.,'Please enter a nine-digit Social Security Number')]]")
	WebElement ssnErrorMsg;

	@FindBy(xpath = "//button[text()='Back to Student info']")
	WebElement backtoStudentInfo;

	@FindBy(xpath = "//button[text()='Back to Parent info']")
	WebElement backtoParentInfo;

	@FindBy(xpath = "//button[text()='Back to Attachments']")
	WebElement backtoAttachments;

	@FindBy(xpath = "//span[text()='MEEGS']/..//..//following-sibling::div//.//div[@class='type-icon']")
	WebElement meegsDownloadIcon;

	@FindBy(xpath = "//span[text()='MEEGS']/..//..//following-sibling::div//.//div[@class='remove-icon']")
	WebElement meegsRemoveIcon;

	@FindBy(xpath = "//span[text()='MEEGS']/../../div[2]//span/following-sibling::input")
	WebElement meegsPdfInput;

	@FindBy(xpath = "//span[text()='Individualized Education Program/Individualized Service Plan']/../../div[2]//span/following-sibling::input")
	WebElement iepPdfInput;

	@FindBy(xpath = "//span[text()='Individualized Education Program/Individualized Service Plan']/..//..//following-sibling::div//.//div[@class='type-icon']")
	WebElement iepDownloadIcon;

	@FindBy(xpath = "//span[text()='Individualized Education Program/Individualized Service Plan']/..//..//following-sibling::div//.//div[@class='remove-icon']")
	WebElement iepRemoveIcon;

	@FindBy(xpath = "//span[text()='Private School Acceptance Letter']/../../div[2]//span/following-sibling::input")
	WebElement psalPdfInput;

	@FindBy(xpath = "//span[text()='Private School Acceptance Letter']/..//..//following-sibling::div//.//div[@class='type-icon']")
	WebElement psalDownloadIcon;

	@FindBy(xpath = "//span[text()='Private School Acceptance Letter']/..//..//following-sibling::div//.//div[@class='remove-icon']")
	WebElement psalRemoveIcon;

	@FindBy(xpath = "//span[text()='Miscellaneous']/../../div[2]//span/following-sibling::input")
	WebElement miscPdfInput;

	@FindBy(xpath = "//span[text()='Miscellaneous']/..//..//following-sibling::div//.//div[@class='type-icon']")
	WebElement miscDownloadIcon;

	@FindBy(xpath = "//span[text()='Miscellaneous']/..//..//following-sibling::div//.//div[@class='remove-icon']")
	WebElement miscRemoveIcon;

	@FindBy(xpath = "//div[@class='modal']//button[text()[contains(., 'Continue')]]")
	WebElement removeIconContinueButton;

	@FindBy(xpath = "//div[text()[contains(.,'Please upload one of the listed file types.')]]")
	WebElement invalidFileTypeErr;

	@FindBy(xpath = "//span[text()='MEEGS']/../../div[2]//span[text()='Click here to browse for files']")
	WebElement uploadLink;

	@FindBy(css = "[data-icon='eye-slash']>path")
	WebElement ssnEyeSlash;

	@FindBy(css = "[data-icon='eye']>path")
	WebElement ssnEye;

	@FindBy(css = "div:nth-child(3)>div>div.link-buttons>span")
	WebElement clearAndTryAgainBtn;

	@FindBy(xpath = "//select[@id='type-select']")
	WebElement typeOfApplicationDropdown;

	@FindBy(xpath = "//option[contains(text(),'Initial')]")
	WebElement initialOption;

	@FindBy(xpath = "//option[contains(text(),'Renewal')]")
	WebElement renewalOption;

	@FindBy(xpath = "//p[contains(text(),'LNH Scholarship for Students with Disabilities')]")
	WebElement lnhScholershipMessage;

	@FindBy(xpath = "//h2[contains(text(), 'Create new application for the')]/span")
	WebElement schoolYear;

	@FindBy(xpath = "//div[@class='action-select__option']/span")
	List<WebElement> actionoptions;

	@FindBy(xpath = "//div[@class='app-instance'][1]//parent::span[text()='Actions']")
	WebElement firstactionbutton;

	String status = "//div[text()='%s']/following-sibling::div[2]//span[@class='status-component']";

	@FindBy(xpath = "//div[text()='Application Status']/following-sibling::div/span")
	List<WebElement> appStatus;

	@FindBy(xpath = "//span[text()='Actions']")
	List<WebElement> actions;

	@FindBy(xpath = "//div[@role='radiogroup']/label/span[2]")
	List<WebElement> names;

	public void newappilcationpageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		browserDriver =new BrowserDriver();
		JSWaiter.setDriver(driver);
	}


	public void checkforStatusStarted(String strstatus) throws InterruptedException {
		base.waitForElement(firstactionbutton);

		int index = -1;
		for(int i = 0; i<appStatus.size();i++){
			Base.extentTest.log(LogStatus.INFO, appStatus.get(i).getText().trim());
			if(appStatus.get(i).getText().trim().equalsIgnoreCase("Started")){
				index = i;
				break;
			}
		}
		if(index == -1){
			Base.extentTest.log(LogStatus.FAIL, "Started status for any of the Application is NOT AVAILABLE");
		}else{
			actions.get(index).click();
			logger.info("Click on Action");
			Base.extentTest.log(LogStatus.PASS, "Click on Action");
			Base.takeScreenShot();

			if(actionoptions.stream().filter(e -> e.getText().equals(strstatus))
					.collect(Collectors.toList()).size() == 0) {
				Base.extentTest.log(LogStatus.PASS, strstatus + " NOT DISPLAYED");
				logger.info(strstatus + " NOT DISPLAYED");
			}else {
				Base.extentTest.log(LogStatus.FAIL, strstatus + " DISPLAYED");
				logger.info(strstatus + " DISPLAYED");
			}
			Base.takeScreenShot();
		}
	}


	public void VerifyStatsNotDisplayed(String status) throws InterruptedException {
		base.waitForElement(firstactionbutton);
		logger.info("Click on Action");
		Base.extentTest.log(LogStatus.PASS, "Click on Action");
		//element.clickByJs(driver, firstactionbutton);
		firstactionbutton.click();
		Base.takeScreenShot();

		base.waitForElement(actionoptions.get(0));
		if(actionoptions.stream().filter(e -> e.getText().equals(status))
				.collect(Collectors.toList()).size() == 0) {
			Base.extentTest.log(LogStatus.PASS, status + " NOT DISPLAYED");
			logger.info(status + " NOT DISPLAYED");
		}else {
			Base.extentTest.log(LogStatus.FAIL, status + " DISPLAYED");
			logger.info(status + " DISPLAYED");
		}
		Base.takeScreenShot();
	}

	public void uploadFiles() throws InterruptedException {
		Base.extentTest.log(LogStatus.PASS, "We are inside Upload files");
		Thread.sleep(5000);
		element.click(driver, attachmenttab);
		logger.info("Clicked on Attachments");
		Base.extentTest.log(LogStatus.PASS, "Clicked on Attachments");
		Base.takeScreenShot();

		//Uploading the attachment
		upload_attachment(meegsPdfInput, TestProperties.get("pdfMEEGS"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfMEEGS"));
		Base.takeScreenShot();

		upload_attachment(iepPdfInput, TestProperties.get("pdfIEP"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfIEP"));
		Base.takeScreenShot();

		upload_attachment(psalPdfInput, TestProperties.get("pdfSAL"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfSAL"));
		Base.takeScreenShot();

		upload_attachment(miscPdfInput, TestProperties.get("pdfMISC"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfMISC"));
		Base.takeScreenShot();
	}

	public void clickContinueButton(){
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}
	public String createApplicationPopUp() throws InterruptedException {
		jSWaiter.waitAllRequest();
		element.waitVisibility(driver, createapplicationbutton, 30);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();
		Thread.sleep(3000);

		element.waitVisibleBy(driver, By.xpath("//button[text()[contains(.,'Create application')]])"), 9);

		try{
			element.clickByJs(driver, createapplicationbutton);
		}catch(Exception e){
			Thread.sleep(2000);
			createapplicationbutton.click();
		}

		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		base.timeinterval(4);
		Base.takeScreenShot();

		String schYear = element.getValue(schoolYear);

		element.click(driver, typeOfApplicationDropdown);
		logger.info("Type of application dropdown is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Type of application dropdown is clicked");
		Base.takeScreenShot();

		element.click(driver, initialOption);
		logger.info("Option selected is "+initialOption.getText());
		Base.extentTest.log(LogStatus.PASS, "Option selected is "+initialOption.getText());
		Base.takeScreenShot();


		element.clickByJs(driver, startapplicationbutton);
		logger.info("Start application button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Start application button is clicked");
		Base.takeScreenShot();
		element.waitVisibility(driver, studentinformation, 20);
		return schYear;
	}


	public HashMap<String, String> uploadPdfNCaptureDates() throws InterruptedException {
		Base.extentTest.log(LogStatus.PASS, "We are inside Upload files");
		Thread.sleep(5000);
		element.click(driver, attachmenttab);
		logger.info("Clicked on Attachments");
		Base.extentTest.log(LogStatus.PASS, "Clicked on Attachments");
		Base.takeScreenShot();

		HashMap<String, String> fileUploadDates = new HashMap<>();

		//Uploading the attachment
		upload_attachment(meegsPdfInput, TestProperties.get("pdfMEEGS"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfMEEGS"));
		Base.takeScreenShot();
		String xpathMeegs = "//span[text()='"+TestProperties.get("pdfMEEGSFileName")+"']/..//div";
		Base.takeScreenShot();
		String dateMeegs = driver.findElement(By.xpath(xpathMeegs)).getAttribute("title");
		fileUploadDates.put(TestProperties.get("pdfMEEGSFileName"), dateMeegs);

		upload_attachment(iepPdfInput, TestProperties.get("pdfIEP"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfIEP"));
		Base.takeScreenShot();
		String xpathIep = "//span[text()='"+TestProperties.get("pdfIEPFileName")+"']/..//div";
		String dateIep = driver.findElement(By.xpath(xpathIep)).getAttribute("title");
		fileUploadDates.put(TestProperties.get("pdfIEPFileName"), dateIep);

		upload_attachment(psalPdfInput, TestProperties.get("pdfSAL"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfSAL"));
		Base.takeScreenShot();
		String xpathPsal = "//span[text()='"+TestProperties.get("pdfSALFileName")+"']/..//div";
		String datePsal = driver.findElement(By.xpath(xpathPsal)).getAttribute("title");
		fileUploadDates.put(TestProperties.get("pdfSALFileName"), datePsal);

		upload_attachment(miscPdfInput, TestProperties.get("pdfMISC"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfMISC"));
		Base.takeScreenShot();
		String xpathMisc = "//span[text()='"+TestProperties.get("pdfMISCFileName")+"']/..//div";
		String dateMisc = driver.findElement(By.xpath(xpathMisc)).getAttribute("title");
		fileUploadDates.put(TestProperties.get("pdfMISCFileName"), dateMisc);
		return fileUploadDates;
	}

	public void verifyAllUploads() throws InterruptedException {
		Base.extentTest.log(LogStatus.PASS, "We are inside verify uploads");
		Thread.sleep(5000);
		element.click(driver, attachmenttab);
		logger.info("Clicked on Attachments");
		Base.extentTest.log(LogStatus.PASS, "Clicked on Attachments");
		Base.takeScreenShot();

		//Uploading the attachment
		upload_attachment(meegsPdfInput, TestProperties.get("pdfMEEGS"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfMEEGS"));
		Base.takeScreenShot();

		upload_attachment(iepPdfInput, TestProperties.get("pdfIEP"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfIEP"));
		Base.takeScreenShot();

		upload_attachment(psalPdfInput, TestProperties.get("pdfSAL"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfSAL"));
		Base.takeScreenShot();

		upload_attachment(miscPdfInput, TestProperties.get("pdfMISC"));
		Base.extentTest.log(LogStatus.PASS, "Uploaded the attachment successfully with: "+TestProperties.get("pdfMISC"));
		Base.takeScreenShot();

		//Download the attachment
		download_attachment(meegsDownloadIcon);
		Thread.sleep(2000);
		Base.extentTest.log(LogStatus.PASS, "Downloaded the attachment successfully");
		Base.takeScreenShot();

		download_attachment(psalDownloadIcon);
		Thread.sleep(2000);
		Base.extentTest.log(LogStatus.PASS, "Downloaded the attachment successfully");
		Base.takeScreenShot();

		download_attachment(iepDownloadIcon);
		Thread.sleep(2000);
		Base.extentTest.log(LogStatus.PASS, "Downloaded the attachment successfully");
		Base.takeScreenShot();

		download_attachment(miscDownloadIcon);
		Thread.sleep(2000);
		Base.extentTest.log(LogStatus.PASS, "Downloaded the attachment successfully");
		Base.takeScreenShot();
	}


	public void addingStudentInformationWithUniqueName(String uniqueName) throws InterruptedException{
		Thread.sleep(5000);
		element.waitVisibility(driver, studentinformation, 20);
		Assert.assertTrue(studentinformation.isDisplayed());
		logger.info("Student information is displayed");
		Base.extentTest.log(LogStatus.PASS, "Student information is displayed");
		Base.takeScreenShot();

		Thread.sleep(2000);
		firstname.click();
		firstname.clear();
		firstname.sendKeys(uniqueName);
		logger.info("Entered first name");
		Base.extentTest.log(LogStatus.PASS, "Entered first name");
		Base.takeScreenShot();

		lastname.clear();
		lastname.sendKeys(uniqueName);
		logger.info("Entered last name");
		Base.extentTest.log(LogStatus.PASS, "Entered last name");
		Base.takeScreenShot();

		base.timeinterval(3);
		dob.clear();
		dob.sendKeys("08122011");
		logger.info("Entered DATE OF BIRTH");
		Base.extentTest.log(LogStatus.PASS, "Entered DATE OF BIRTH");
		Base.takeScreenShot();

		Thread.sleep(15000);
		base.timeinterval(3);
		element.selectOption(grade, 1);
		logger.info("Grade selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "Grade selected from dropdown");
		Thread.sleep(15000);
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictofresidence, 1);
		logger.info("School district of residence selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district of residence selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictIEP, 1);
		logger.info("School district IEP selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district IEP selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schoolname, 1);
		logger.info("School Name selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School Name selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(enrollmenttype, 1);
		logger.info("Enrollment option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment option is selected");
		Base.takeScreenShot();

		//	browserDriver.scrollToBottom();
		browserDriver.scrollToElement(driver, eligibilityverification);
		base.timeinterval(3);
		element.clickByJs(driver, eligibilityverification);
		logger.info("Eligibility verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Eligibility verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver, enrollmentverification);
		logger.info("Enrollment verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  race);
		logger.info(" Race option is selected");
		Base.extentTest.log(LogStatus.PASS, " Race is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  economicallystatus);
		logger.info(" Economically status option is selected");
		Base.extentTest.log(LogStatus.PASS, " Economically status option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}



	public void addingStudentInformation(String firstName, String lastName, String dateOfBirth) throws InterruptedException{
		Thread.sleep(5000);
		element.waitVisibility(driver, studentinformation, 20);
		Assert.assertTrue(studentinformation.isDisplayed());
		logger.info("Student information is displayed");
		Base.extentTest.log(LogStatus.PASS, "Student information is displayed");
		Base.takeScreenShot();

		Thread.sleep(2000);
		firstname.click();
		firstname.clear();
		firstname.sendKeys(firstName);
		logger.info("Entered first name");
		Base.extentTest.log(LogStatus.PASS, "Entered first name");
		Base.takeScreenShot();

		lastname.clear();
		lastname.sendKeys(lastName);
		logger.info("Entered last name");
		Base.extentTest.log(LogStatus.PASS, "Entered last name");
		Base.takeScreenShot();

		base.timeinterval(3);
		dob.clear();
		dob.sendKeys(dateOfBirth);
		logger.info("Entered DATE OF BIRTH");
		Base.extentTest.log(LogStatus.PASS, "Entered DATE OF BIRTH");
		Base.takeScreenShot();

		base.waitForElement(grade);
	//	Thread.sleep(15000);
		base.timeinterval(3);
		element.selectOption(grade, 1);
		logger.info("Grade selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "Grade selected from dropdown");
	//	Thread.sleep(15000);
		base.waitForElement(schooldistrictofresidence);
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictofresidence, 1);
		logger.info("School district of residence selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district of residence selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictIEP, 1);
		logger.info("School district IEP selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district IEP selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schoolname, 1);
		logger.info("School Name selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School Name selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(enrollmenttype, 1);
		logger.info("Enrollment option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment option is selected");
		Base.takeScreenShot();

		//	browserDriver.scrollToBottom();
		browserDriver.scrollToElement(driver, eligibilityverification);
		base.timeinterval(3);
		element.clickByJs(driver, eligibilityverification);
		logger.info("Eligibility verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Eligibility verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver, enrollmentverification);
		logger.info("Enrollment verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  race);
		logger.info(" Race option is selected");
		Base.extentTest.log(LogStatus.PASS, " Race is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  economicallystatus);
		logger.info(" Economically status option is selected");
		Base.extentTest.log(LogStatus.PASS, " Economically status option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}

	public void clickClearAndTryAgainBtn(){
		element.waitVisibility(driver, clearAndTryAgainBtn, 20);
		clearAndTryAgainBtn.click();
		logger.info("Clicked on <b>Clear And Try</b> button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on <b>Clear And Try</b> button");
		Base.takeScreenShot();
	}

	public void clickSignAndSubmitTab(){
		signnsubmittab.click();
		logger.info("<b>Sign And Submit tab is clicked</b>");
		Base.extentTest.log(LogStatus.PASS, "<b>Sign And Submit tab is clicked</b>");
		Base.takeScreenShot();
	}

	public void verifyStudentSectionCompletion(){
		String text = "Step 1";
		Assert.assertTrue(base.compareStrings(text,studentSectionCompletionIndicator.getText()));
		logger.info("<b>"+stuinformation.getText()+"</b> is entered completely");
		Base.extentTest.log(LogStatus.PASS, "<b>"+stuinformation.getText()+"</b> is entered completely");
		Base.takeScreenShot();
	}

	public void verifyStudentSectionCompletionWithoutIEP(){
		stuinformation.click();
		browserDriver.scrollToElement(driver, schooldistrictIEP);
		Assert.assertEquals(schooldistrictIEP.getAttribute("value"),"");
		logger.info("<b>"+stuinformation.getText()+"</b> is entered completely");
		Base.extentTest.log(LogStatus.PASS, "<b>"+stuinformation.getText()+"</b> is entered completely");
		Base.takeScreenShot();
	}

	public void verifyParentSectionCompletion(){
		String text = "Step 2";
		Assert.assertTrue(base.compareStrings(text,parentSectionCompletionIndicator.getText()));
		logger.info("<b>"+parentinformation.getText()+"</b> is entered completely");
		Base.extentTest.log(LogStatus.PASS, "<b>"+parentinformation.getText()+"</b> is entered completely");
		Base.takeScreenShot();
	}

	public void verifyOldStudentListInNewStudentToast() throws InterruptedException {
		jSWaiter.waitAllRequest();
		element.waitVisibility(driver, createapplicationbutton, 20);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();
		Thread.sleep(3000);

		element.waitVisibleBy(driver, By.xpath("//button[text()[contains(.,'Create application')]])"), 9);
		element.clickByJs(driver, createapplicationbutton);
		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		base.timeinterval(4);
		Base.takeScreenShot();

		try {
			Thread.sleep(3000);
			if(ChildOfExistingStudentList.size()>1) {
				logger.info("<b>Create > List of existing student from previous year is displayed consist of "+(ChildOfExistingStudentList.size()-1)+" students from previous year </b>");
				Base.extentTest.log(LogStatus.PASS, "<b>Create > List of existing student from previous year is displayed consist of "+(ChildOfExistingStudentList.size()-1)+" students from previous year </b>");
				Base.takeScreenShot();
			}

			Thread.sleep(3000);
			element.waitVisibility(driver, startapplicationbutton, 20);
			Assert.assertTrue(startapplicationbutton.isDisplayed());
			logger.info("<b>Create > Start Application button is displayed</b>");
			Base.extentTest.log(LogStatus.PASS, "<b>Create > Start Application button is displayed</b>");
			browserDriver.scrollToElement(driver,startapplicationbutton);
			Base.takeScreenShot();

			cancelnverifyNewStudentPopUp();
		}catch(Exception e){
			Thread.sleep(3000);
			element.waitVisibility(driver, newstudentbutton, 20);
			Assert.assertTrue(newstudentbutton.isDisplayed());
			logger.info("<b>Create > There is no list of existing student from the previous years</b>");
			Base.extentTest.log(LogStatus.PASS, "<b>Create > There is no list of existing student from the previous years</b>");
			Base.takeScreenShot();

			Thread.sleep(3000);
			element.waitVisibility(driver, startapplicationbutton, 20);
			Assert.assertTrue(startapplicationbutton.isDisplayed());
			logger.info("Create > Start Application button is displayed");
			Base.extentTest.log(LogStatus.PASS, "Create > Start Application button is displayed");
			Base.takeScreenShot();

			cancelnverifyNewStudentPopUp();
		}
	}

	public void editlatestapplication() throws InterruptedException{
		element.clickByJs(driver, applicationicon);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Applications icon ");

		Thread.sleep(2000);
		element.click(driver, lastactionbutton);
		Actions editapplication = new Actions(driver);
		editapplication.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Base.extentTest.log(LogStatus.PASS, "EDIT application option is selected ");

		newApplicationVerifyTabsStepNumber();
		clickeachtiles();
	}

	public void editapplication() throws InterruptedException{
		element.clickByJs(driver, applicationicon);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Applications icon ");

		element.click(driver, firstactionbuttonwithnoname);
		Actions editapplication = new Actions(driver);
		editapplication.sendKeys(Keys.chord(Keys.ENTER)).perform();
		Base.extentTest.log(LogStatus.PASS, "EDIT application option is selected ");
	}

	public void newApplicationVerifyTabsStepNumber() throws InterruptedException{

		Assert.assertTrue(base.compLocation(studentinfotab,step1tile));
		Base.extentTest.log(LogStatus.PASS, step1tile.getText() + " section is underneath " + studentinfotab.getText() + " tab");
		Base.takeScreenShot();

		Assert.assertTrue(base.compLocation(parentinfotab,step2tile));
		Base.extentTest.log(LogStatus.PASS, step2tile.getText() + " section is underneath " + parentinfotab.getText() + " tab");
		Base.takeScreenShot();

		Assert.assertTrue(base.compLocation(attachmenttab,step3tile));
		Base.extentTest.log(LogStatus.PASS, step3tile.getText() + " section is underneath " + attachmenttab.getText() + " tab");
		Base.takeScreenShot();

		Assert.assertTrue(base.compLocation(signnsubmittab,step4tile));
		Base.extentTest.log(LogStatus.PASS, step4tile.getText() + " section is underneath " + signnsubmittab.getText() + " tab");
		Base.takeScreenShot();
	}

	public void alltilesclickable(WebElement element1,WebElement element2, WebElement element3, WebElement element4){
		if(element1.isDisplayed() && element1.isEnabled() && element1.getSize().getHeight() > 0 && element1.getSize().getWidth() >0)
		{
			Base.extentTest.log(LogStatus.PASS, element1.getText()+" & "+element2.getText()+" & "+element3.getText()+" & "+element4.getText()+" tiles are verified as clickable" + " from "+ element1.getText() + " page");
			Base.takeScreenShot();
		}
	}

	public void clickeachtiles() throws InterruptedException{

		element.clickByJs(driver, parentinfotab);
		Assert.assertTrue(step2tile.isEnabled());
		Base.extentTest.log(LogStatus.PASS, parentinfotab.getText()+" tile is Clicked and "+step2tile.getText() + " is still displayed");
		Base.takeScreenShot();
		alltilesclickable(parentinfotab, attachmenttab, signnsubmittab, studentinfotab);

		element.clickByJs(driver, attachmenttab);
		Assert.assertTrue(step3tile.isEnabled());
		Base.extentTest.log(LogStatus.PASS, attachmenttab.getText()+" tile is Clicked and "+step3tile.getText() + " is still displayed");
		Base.takeScreenShot();
		alltilesclickable(attachmenttab, signnsubmittab, studentinfotab, parentinfotab);

		element.clickByJs(driver, signnsubmittab);
		Assert.assertTrue(step4tile.isEnabled());
		Base.extentTest.log(LogStatus.PASS, signnsubmittab.getText()+" tile is Clicked and "+step4tile.getText() + " is still displayed");
		Base.takeScreenShot();
		alltilesclickable(signnsubmittab, studentinfotab, parentinfotab, attachmenttab);

		element.clickByJs(driver, studentinfotab);
		Assert.assertTrue(step1tile.isEnabled());
		Base.extentTest.log(LogStatus.PASS, studentinfotab.getText()+" tile is Clicked and "+step1tile.getText() + " is still displayed");
		Base.takeScreenShot();
		alltilesclickable(studentinfotab, parentinfotab, attachmenttab, signnsubmittab);
	}

	public String RenewalStudentPopUp() throws  InterruptedException{
			jSWaiter.waitAllRequest();
			Thread.sleep(5000);
			element.waitVisibility(driver, createapplicationbutton, 30);
			Assert.assertTrue(createapplicationbutton.isDisplayed());
			logger.info("Create application button is displayed");
			Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
			Base.takeScreenShot();
			Thread.sleep(3000);

			element.waitVisibleBy(driver, By.xpath("//button[text()[contains(.,'Create application')]])"), 9);

			try{
				element.clickByJs(driver, createapplicationbutton);
			}catch(Exception e){
				Thread.sleep(2000);
				createapplicationbutton.click();
			}

			logger.info("Create application button is Clicked");
			Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
			base.timeinterval(4);
			Base.takeScreenShot();
			Thread.sleep(6000);


			base.waitForElement(typeOfApplicationDropdown);
			element.click(driver, typeOfApplicationDropdown);
			logger.info("Type of application dropdown is Clicked");
			Base.extentTest.log(LogStatus.PASS, "Type of application dropdown is clicked");
			Base.takeScreenShot();

			element.click(driver, renewalOption);
			logger.info("Option selected is "+renewalOption.getText());
			Base.extentTest.log(LogStatus.PASS, "Option selected is "+renewalOption.getText());
			Base.takeScreenShot();
			base.waitForElement(names.get(0));

			String name = element.getValue(names.get(0));
			names.get(0).click();
			logger.info("Select the Student Application for Renewal");
			Base.extentTest.log(LogStatus.PASS, "Select the Student Application for Renewal");
			Base.takeScreenShot();

			element.clickByJs(driver, startapplicationbutton);
			logger.info("Start application button is clicked");
			Base.extentTest.log(LogStatus.PASS, "Start application button is clicked");
			Base.takeScreenShot();
			element.waitVisibility(driver, studentinformation, 20);

			return name;
		}

	public void newStudentPopUp() throws InterruptedException {
		jSWaiter.waitAllRequest();
		Thread.sleep(5000);
		element.waitVisibility(driver, createapplicationbutton, 30);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();
		Thread.sleep(3000);

		element.waitVisibleBy(driver, By.xpath("//button[text()[contains(.,'Create application')]])"), 9);

		try{
			element.clickByJs(driver, createapplicationbutton);
		}catch(Exception e){
			Thread.sleep(2000);
			createapplicationbutton.click();
		}

		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		base.timeinterval(4);
		Base.takeScreenShot();
		Thread.sleep(6000);


		base.waitForElement(typeOfApplicationDropdown);
		element.click(driver, typeOfApplicationDropdown);
		logger.info("Type of application dropdown is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Type of application dropdown is clicked");
		Base.takeScreenShot();

		element.click(driver, initialOption);
		logger.info("Option selected is "+initialOption.getText());
		Base.extentTest.log(LogStatus.PASS, "Option selected is "+initialOption.getText());
		Base.takeScreenShot();


		element.clickByJs(driver, startapplicationbutton);
		logger.info("Start application button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Start application button is clicked");
		Base.takeScreenShot();
		element.waitVisibility(driver, studentinformation, 20);
	}

	public void newStudentPopUp_old() throws InterruptedException {
		jSWaiter.waitAllRequest();
		element.waitVisibility(driver, createapplicationbutton, 30);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();
		Thread.sleep(3000);

		element.waitVisibleBy(driver, By.xpath("//button[text()[contains(.,'Create application')]])"), 9);

		try{
			element.clickByJs(driver, createapplicationbutton);
		}catch(Exception e){
			Thread.sleep(2000);
			createapplicationbutton.click();
		}

		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		base.timeinterval(4);
		Base.takeScreenShot();

		Thread.sleep(3000);
		element.waitVisibility(driver, newstudentbutton, 30);
		Assert.assertTrue(newstudentbutton.isDisplayed());
		logger.info("Create > new student button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create > new student button is displayed");
		Base.takeScreenShot();

		element.click(driver, newstudentbutton);
		logger.info("New student button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "New student button is clicked");
		Base.takeScreenShot();

		element.clickByJs(driver, startapplicationbutton);
		logger.info("Start application button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Start application button is clicked");
		Base.takeScreenShot();
	}

	public void cancelnverifyNewStudentPopUp() throws InterruptedException {

		Assert.assertTrue(nsModelPopUp.isDisplayed());
		logger.info("New Student Popup displayed successfully");
		Base.extentTest.log(LogStatus.PASS, "New Student Popup displayed successfully");
		Base.takeScreenShot();

		Assert.assertTrue(nsCancelButton.isDisplayed());
		logger.info("Cancel button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Cancel button is displayed");
		Base.takeScreenShot();

		nsCancelButton.click();
		logger.info("Cancel button is clicked to cancel New Student Popup");
		Base.extentTest.log(LogStatus.PASS, "Cancel button is clicked to cancel New Student Popup");
		Base.takeScreenShot();
	}

	public void addingStudentInformation() throws InterruptedException{
		Thread.sleep(5000);
		element.waitVisibility(driver, studentinformation, 20);
		Assert.assertTrue(studentinformation.isDisplayed());
		logger.info("Student information is displayed");
		Base.extentTest.log(LogStatus.PASS, "Student information is displayed");
		Base.takeScreenShot();

		Thread.sleep(2000);
		firstname.click();
		firstname.clear();
		firstname.sendKeys("Oliver");
		logger.info("Entered first name");
		Base.extentTest.log(LogStatus.PASS, "Entered first name");
		Base.takeScreenShot();

		lastname.clear();
		lastname.sendKeys("Twist");
		logger.info("Entered last name");
		Base.extentTest.log(LogStatus.PASS, "Entered last name");
		Base.takeScreenShot();

		base.timeinterval(3);
		dob.clear();
		dob.sendKeys("08122011");
		logger.info("Entered DATE OF BIRTH");
		Base.extentTest.log(LogStatus.PASS, "Entered DATE OF BIRTH");
		Base.takeScreenShot();

		Thread.sleep(15000);
		base.timeinterval(3);
		element.selectOption(grade, 1);
		logger.info("Grade selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "Grade selected from dropdown");
//		Thread.sleep(15000);
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictofresidence, 1);
		logger.info("School district of residence selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district of residence selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictIEP, 1);
		logger.info("School district IEP selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district IEP selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schoolname, 1);
		logger.info("School Name selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School Name selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(enrollmenttype, 1);
		logger.info("Enrollment option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment option is selected");
		Base.takeScreenShot();

		//	browserDriver.scrollToBottom();
		browserDriver.scrollToElement(driver, eligibilityverification);
		base.timeinterval(3);
		element.clickByJs(driver, eligibilityverification);
		logger.info("Eligibility verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Eligibility verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver, enrollmentverification);
		logger.info("Enrollment verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  race);
		logger.info(" Race option is selected");
		Base.extentTest.log(LogStatus.PASS, " Race is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  economicallystatus);
		logger.info(" Economically status option is selected");
		Base.extentTest.log(LogStatus.PASS, " Economically status option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}

	public void clickContinue() throws InterruptedException {
		base.timeinterval(3);
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}

	public void addingStudentInformationWithoutIEP() throws InterruptedException{
		Thread.sleep(5000);
		element.waitVisibility(driver, studentinformation, 20);
		Assert.assertTrue(studentinformation.isDisplayed());
		logger.info("Student information is displayed");
		Base.extentTest.log(LogStatus.PASS, "Student information is displayed");
		Base.takeScreenShot();

		firstname.sendKeys("Alexa");
		logger.info("Entered first name");
		Base.extentTest.log(LogStatus.PASS, "Entered first name");
		Base.takeScreenShot();

		lastname.sendKeys("Zooman");
		logger.info("Entered last name");
		Base.extentTest.log(LogStatus.PASS, "Entered last name");
		Base.takeScreenShot();

		base.timeinterval(3);
		dob.sendKeys("08122011");
		logger.info("Entered DATE OF BIRTH");
		Base.extentTest.log(LogStatus.PASS, "Entered DATE OF BIRTH");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(grade, 1);
		logger.info("Grade selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "Grade selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schooldistrictofresidence, 1);
		logger.info("School district of residence selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School district of residence selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(schoolname, 1);
		logger.info("School Name selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "School Name selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.selectOption(enrollmenttype, 1);
		logger.info("Enrollment option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment option is selected");
		Base.takeScreenShot();

		browserDriver.scrollToBottom();
		base.timeinterval(3);
		element.clickByJs(driver, eligibilityverification);
		logger.info("Eligibility verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Eligibility verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver, enrollmentverification);
		logger.info("Enrollment verification option is selected");
		Base.extentTest.log(LogStatus.PASS, "Enrollment verification option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  race);
		logger.info(" Race option is selected");
		Base.extentTest.log(LogStatus.PASS, " Race is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  economicallystatus);
		logger.info(" Economically status option is selected");
		Base.extentTest.log(LogStatus.PASS, " Economically status option is selected");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}

	public void parentinformation() throws InterruptedException {

		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		parentfirstname.clear();
		parentfirstname.sendKeys("Rishabh");
		logger.info("Parent first name entered");
		Base.extentTest.log(LogStatus.PASS, "Parent first name entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		parentlastname.clear();
		parentlastname.sendKeys("Saharan");
		logger.info("Parent second name entered");
		Base.extentTest.log(LogStatus.PASS, "Parent second name entered");
		Base.takeScreenShot();
		base.timeinterval(2);

		parentemailaddress.clear();
		parentemailaddress.sendKeys("test1@gmail.com");
		logger.info("Parent email entered");
		Base.extentTest.log(LogStatus.PASS, "Parent email entered");
		Base.takeScreenShot();
		base.timeinterval(2);

		parentphonenum.clear();
		parentphonenum.sendKeys("2347832123");
		logger.info("Parent phone number entered");
		Base.extentTest.log(LogStatus.PASS, "Parent phone number entered");
		Base.takeScreenShot();
		base.timeinterval(2);

		parentaddress.clear();
		parentaddress.sendKeys("2621 doordash");
		logger.info("Parent address entered");
		Base.extentTest.log(LogStatus.PASS, "Parent address entered");
		Base.takeScreenShot();
		base.timeinterval(2);

		parentcity.clear();
		parentcity.sendKeys("boston");
		logger.info("Parent city name entered");
		Base.extentTest.log(LogStatus.PASS, "Parent city name entered");
		Base.takeScreenShot();
		base.timeinterval(2);

		//Thread.sleep(15000);
		base.waitForElement(parentstate);
		element.selectOption(parentstate, 1);
		logger.info("Parent state name selected");
		Base.extentTest.log(LogStatus.PASS, "Parent state name selected");
		Thread.sleep(15000);
		Base.takeScreenShot();
		base.timeinterval(4);

		parentzipcode.clear();
		Thread.sleep(3000);
		parentzipcode.sendKeys("238191231");
		logger.info("Parent zip code entered");
		Base.extentTest.log(LogStatus.PASS, "Parent zip code entered");
		parentcity.click();
		Thread.sleep(2000);
		Base.takeScreenShot();
		base.timeinterval(3);

		element.clickByJs(driver, parentcontinuebutton);
		logger.info("Clicked on parent continue button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on parent continue button");
		Base.takeScreenShot();
		base.timeinterval(3);

	}

	public void SSN_UnMasking(String SSN) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

	//	browserDriver.scrollToBottom();
Thread.sleep(3000);
		Assert.assertTrue(parentssn.isDisplayed());
	//	((JavascriptExecutor) driver).executeScript("window.scrollTo(parentssn)");
		browserDriver.scrollToElement(driver,parentssn);
		Thread.sleep(3000);
		Base.extentTest.log(LogStatus.PASS, "SSN text field is displayed");
		Base.takeScreenShot();


		parentssn.clear();
		Base.extentTest.log(LogStatus.PASS, "SSN text field is cleared");
		Base.takeScreenShot();
		Thread.sleep(3000);
		base.timeinterval(3);

		//try{
			Actions a = new Actions(driver);
			a.moveToElement(ssnEyeSlash).
					click().build().perform();
			/*a.moveToElement(driver.findElement(By.cssSelector("[data-icon='eye-slash'] > path"))).
					click().build().perform();*/
			base.timeinterval(3);
			Base.extentTest.log(LogStatus.PASS, "Click on eye Slash to UNMASK SSN");
			Base.takeScreenShot();

			parentssn.clear();
			parentssn.sendKeys(SSN);
			logger.info("SSN number entered");
			Base.extentTest.log(LogStatus.PASS, "SSN number entered");
			Base.takeScreenShot();
			base.timeinterval(3);

	/*	}catch (Exception e){
			Base.extentTest.log(LogStatus.PASS, "We are inside catch <b>"+e.getMessage()+"</b>");
		}*/
	}



	public void SSN_Masking(String SSN) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		//	browserDriver.scrollToBottom();
		browserDriver.scrollToElement(driver,parentssn);
		base.timeinterval(3);

	//	try{
			Actions a = new Actions(driver);
			a.moveToElement(ssnEye).
					click().build().perform();
			//		a.moveToElement(driver.findElement(By.cssSelector("[data-icon='eye'] > path"))).
			base.timeinterval(3);
			Base.extentTest.log(LogStatus.PASS, "Click on eye to MASK SSN");
			Base.takeScreenShot();

			parentssn.clear();
			parentssn.sendKeys(SSN);
			logger.info("SSN number entered");
			Base.extentTest.log(LogStatus.PASS, "SSN number entered");
			Base.takeScreenShot();
			base.timeinterval(3);

		/*}catch (Exception e){
			Base.extentTest.log(LogStatus.PASS, "We are inside catch <b>"+e.getMessage()+"</b>");
		}*/
	}



	public void verifySSNErrMsg(String SSN) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);
		try{
			parentssn.sendKeys(SSN);
			logger.info("SSN number entered");
			Base.extentTest.log(LogStatus.PASS, "SSN number entered");
			Base.takeScreenShot();
			base.timeinterval(3);

			submitbutton.click();
			logger.info("Clicked on submit button");
			Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
			Base.takeScreenShot();
			base.timeinterval(3);

			Base.extentTest.log(LogStatus.PASS, "Entered wrong SSN, error displayed is <b>"+ssnErrorMsg.getText()+"</b");
			Base.takeScreenShot();

		}catch (Exception e){
			Base.extentTest.log(LogStatus.PASS, "We are inside catch <b>"+e.getMessage()+"</b>");
		}

	}

	public void verifySSN(String ssn) throws InterruptedException{
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		if(parentssn.getAttribute("type").equals("password"))
			Base.extentTest.log(LogStatus.PASS, "SSN number Masked by Default");
		else
			Base.extentTest.log(LogStatus.FAIL, "SSN number NOT Masked by Default");

		parentssn.sendKeys(ssn);
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("[data-icon='eye-slash'] > path"))).
				click().build().perform();
//		element.clickByJs(driver, driver.findElement(By.cssSelector("[data-icon='eye-slash'] > path")));
		base.timeinterval(3);
		Base.extentTest.log(LogStatus.PASS, "Click on eye Slash to UNMASK SSN");

//		if(parentssn.getAttribute("type").equals("password"))
//			Base.extentTest.log(LogStatus.PASS, "SSN number Masked");
//		else
//			Base.extentTest.log(LogStatus.FAIL, "SSN number NOT Masked");



		if(parentssn.getAttribute("type").equals("text"))
			Base.extentTest.log(LogStatus.PASS, "SSN number UN Masked");
		else
			Base.extentTest.log(LogStatus.FAIL, "SSN number NOT UN Masked");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Base.takeScreenShot();
		base.timeinterval(3);

		backtomyapplicationbutton.click();
		logger.info("Clicked on back to my application button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to my application button");
		Base.takeScreenShot();
		base.timeinterval(3);

		base.timeinterval(5);
		logout.click();
		logger.info("Log out button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Log out button is clicked");
		Base.takeScreenShot();


	}

	public void entersignature(String SSN) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		Thread.sleep(2000);
		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		parentssn.sendKeys(SSN);
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Base.takeScreenShot();
		base.timeinterval(3);

		backtomyapplicationbutton.click();
		logger.info("Clicked on back to my application button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to my application button");
		Base.takeScreenShot();
		base.timeinterval(3);
	}

	public void downloadAndUpdateSignature(String SSN) throws InterruptedException{
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		parentssn.sendKeys(SSN);
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		Thread.sleep(5000);
		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Thread.sleep(10000);
		Base.takeScreenShot();
		base.timeinterval(3);

		File folder = new File(System.getProperty("user.home")+"\\Downloads");
		File[] listOfFiles = folder.listFiles();
		for(File file:listOfFiles){
			if(file.isFile() && file.getName().contains("Oliver Twist"))
				file.delete();
		}
		base.waitForElement(downloads);
		download_attachment(downloads);

		int i = 100;
		while(i<100){
			boolean bool = false;
			File folder1 = new File(System.getProperty("user.home")+"\\Downloads");
			File[] listOfFiles1 = folder1.listFiles();
			for(File file:listOfFiles1) {
				if (file.isFile() && file.getName().contains("Oliver Twist")) {
					bool = true;
					break;
				} else {
					Thread.sleep(1000);
				}
			}
			if (bool)
				break;
		}

		Assert.assertTrue(backtomyapplicationbutton.isDisplayed());
		backtomyapplicationbutton.click();
		logger.info("Clicked on back to my application button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to my application button");
		Base.takeScreenShot();
		base.timeinterval(3);
	}

	public void updateSignature(String SSN) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		parentssn.sendKeys(SSN);
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		Thread.sleep(5000);
		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Thread.sleep(10000);
		Base.takeScreenShot();
		base.timeinterval(3);

		Assert.assertTrue(backtomyapplicationbutton.isDisplayed());
		backtomyapplicationbutton.click();
		logger.info("Clicked on back to my application button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to my application button");
		Base.takeScreenShot();
		base.timeinterval(3);
	}
	public void verifysignature(String SSN) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		parentssn.sendKeys(SSN);
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		Thread.sleep(5000);
		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Thread.sleep(10000);
		Base.takeScreenShot();
		base.timeinterval(3);

		Assert.assertTrue(backtomyapplicationbutton.isDisplayed());
		backtomyapplicationbutton.click();
		logger.info("Clicked on back to my application button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to my application button");
		Base.takeScreenShot();
		base.timeinterval(3);

		base.timeinterval(5);
		logout.click();
		logger.info("Log out button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Log out button is clicked");
		Base.takeScreenShot();
	}


	public void verifynewstudentbutton() throws InterruptedException {


		jSWaiter.waitAllRequest();
		element.waitVisibility(driver, createapplicationbutton, 20);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();
		base.timeinterval(3);

		createapplicationbutton.click();
		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		Base.takeScreenShot();
		base.timeinterval(3);

		element.waitVisibility(driver, newstudentbutton, 20);
		Assert.assertTrue(newstudentbutton.isDisplayed());
		logger.info("Create new student button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create new student button is displayed");
		Base.takeScreenShot();

		element.waitVisibility(driver, cancelbutton, 30);
		Assert.assertTrue(cancelbutton.isDisplayed());
		logger.info("Cancel button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Cancel button is displayed");
		Base.takeScreenShot();

		element.clickByJs(driver, cancelbutton);
		logger.info("Cancel button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Cancel button is clicked");
		Base.takeScreenShot();
	}


	public void verifycreateintialapplication() throws InterruptedException {

		jSWaiter.waitAllRequest();
		element.waitVisibility(driver, createapplicationbutton, 20);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();

		base.timeinterval(3);
		createapplicationbutton.click();
		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		Base.takeScreenShot();

		element.waitVisibility(driver, newstudentbutton, 20);
		Assert.assertTrue(newstudentbutton.isDisplayed());
		logger.info("Create new student button is displayed");
		Base.extentTest.log(LogStatus.PASS, "new student button is displayed");
		Base.takeScreenShot();
		element.clickByJs(driver, newstudentbutton);
		logger.info("new student button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "new student button is clicked");
		Base.takeScreenShot();
		element.clickByJs(driver, startapplicationbutton);
		logger.info("start application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "start application button is clicked");
		Base.takeScreenShot();
	}


		public void VerifyStatus(String name, String strstatus) throws InterruptedException {
	//	Thread.sleep(20000);
		Base.extentTest.log(LogStatus.PASS, "name is ::  "+name);
		Base.takeScreenShot();

		int i = 0;
		while(i < 100){
			if(driver.findElements(By.xpath(status.replace("%s",name))).size() > 0){
				break;
			}else{
				i++;
				Thread.sleep(1000);
			}
		}

		List<WebElement> eles = driver.findElements(By.xpath(status.replace("%s",name)));
/*		Base.extentTest.log(LogStatus.PASS, "New name is ::  "+name);
		Base.extentTest.log(LogStatus.PASS, "Elements size is ::  "+eles.size());
		Base.extentTest.log(LogStatus.PASS, "Elements size is ::  "+eles.get(eles.size()-1));
		Base.extentTest.log(LogStatus.PASS, "Elements size is ::  "+strstatus.trim());*/

		if(eles.get(eles.size()-1).getText().trim().contains(strstatus.trim()))
			Base.extentTest.log(LogStatus.PASS, "application status :: Actual Result : "+eles.get(eles.size()-1).getText().trim()+
					" Expected Result : "+strstatus);
		//Assert.assertTrue(eles.get(eles.size()-1).getText().trim().contains(strstatus.trim()));
		else
			Base.extentTest.log(LogStatus.FAIL, "application status :: Actual Result : "+eles.get(eles.size()-1).getText().trim()+
					" Expected Result : "+strstatus);
	}

	public void clickSubmit() throws InterruptedException {
		element.click(driver, submitbutton);
		Base.extentTest.log(LogStatus.PASS, "Click on Submit");
		Base.takeScreenShot();
		base.timeinterval(5);
		applicationicon.click();
		Base.extentTest.log(LogStatus.PASS, "Click on Application");
		Base.takeScreenShot();
		base.timeinterval(10);
	}

	public void validateError(String strMessage) throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, LNHApplicationsignature);
		logger.info("Scrolled to LNH application");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to LNH application");
		Base.takeScreenShot();

		Actions actions=new Actions(driver);
		actions.dragAndDropBy(LNHApplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		LNHapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		parentssn.sendKeys("");
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		actions.dragAndDropBy(omesapplicationsignature, 50, 60).build().perform();
		logger.info("Signed on LNH");
		Base.extentTest.log(LogStatus.PASS, "Signed on LNH");
		Base.takeScreenShot();
		base.timeinterval(3);

		OMEapplysignatture.click();
		logger.info("Clicked on LNH apply signature");
		Base.extentTest.log(LogStatus.PASS, "Clicked on LNH apply signature");
		Base.takeScreenShot();
		base.timeinterval(3);

		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Base.takeScreenShot();
		base.timeinterval(3);

		String actMessage = Base.driver.findElement(By.xpath("//div[@role='alert']/div[2]")).getText().trim();
		Base.takeScreenShot();
		if(strMessage.trim().contains(actMessage))
			Base.extentTest.log(LogStatus.PASS, "Error Message Displayed :: "+actMessage);
		else
			Base.extentTest.log(LogStatus.FAIL, "Error Message Displayed :: "+actMessage);
	}

	public void verifyButtons() throws InterruptedException {
		if(studentinfotab.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Student Info is Editable :: "+studentinfotab.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Student Info is Editable :: "+studentinfotab.isEnabled());

		if(parentinfotab.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Parent Info is Editable :: "+parentinfotab.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Parent Info is Editable :: "+parentinfotab.isEnabled());

		if(attachmenttab.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Attachment is Editable :: "+attachmenttab.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Attachment is Editable :: "+attachmenttab.isEnabled());

		if(signnsubmittab.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Sign & Submit is Editable :: "+signnsubmittab.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Sign & Submit is Editable :: "+signnsubmittab.isEnabled());

		Base.takeScreenShot();

		if(continuebutton.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Continue is Editable :: "+continuebutton.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Continue is Editable :: "+continuebutton.isEnabled());

		continuebutton.click();
		Base.takeScreenShot();

		if(backtoStudentInfo.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Back to Student Info is Editable :: "+signnsubmittab.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Back to Student Info is Editable :: "+signnsubmittab.isEnabled());

		if(continuebutton.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Continue is Editable :: "+continuebutton.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Continue is Editable :: "+continuebutton.isEnabled());

		continuebutton.click();
		Base.takeScreenShot();

		if(backtoParentInfo.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Back to Parent Info is Editable :: "+backtoParentInfo.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Back to Parent Info is Editable :: "+backtoParentInfo.isEnabled());

		if(continuebutton.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Continue is Editable :: "+continuebutton.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Continue is Editable :: "+continuebutton.isEnabled());

		continuebutton.click();
		Base.takeScreenShot();

		if(backtoAttachments.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Back to Attachments is Editable :: "+backtoAttachments.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Back to Attachments is Editable :: "+backtoAttachments.isEnabled());

		if(submitbutton.isEnabled())
			Base.extentTest.log(LogStatus.PASS, "Submit is Editable :: "+submitbutton.isEnabled());
		else
			Base.extentTest.log(LogStatus.FAIL, "Submit is Editable :: "+submitbutton.isEnabled());

		Base.takeScreenShot();
		applicationicon.click();
		base.timeinterval(5);
	}

    public void verifyUploads() throws InterruptedException {
		Base.extentTest.log(LogStatus.PASS, "We are inside verify uploads");
		Thread.sleep(5000);
		element.click(driver, attachmenttab);
		logger.info("Clicked on Attachments");
		Base.extentTest.log(LogStatus.PASS, "Clicked on Attachments");
		Base.takeScreenShot();

		//Uploading the attachment
		upload_attachment(meegsPdfInput, TestProperties.get("pdfMEEGS"));
		Base.extentTest.log(LogStatus.PASS, "uploaded the attachment successfully");
		Base.takeScreenShot();

		//Download the attachment
		download_attachment(meegsDownloadIcon);
		Thread.sleep(2000);
		Base.extentTest.log(LogStatus.PASS, "Downloaded the attachment successfully");
		Base.takeScreenShot();

		//Remove the attachment
		remove_attachment(meegsRemoveIcon);
		Thread.sleep(2000);
		Base.extentTest.log(LogStatus.PASS, "Removed the attachment successfully");
		Base.takeScreenShot();

		//Verify attachment removed successfully
		Thread.sleep(3000);
		Assert.assertTrue(uploadLink.isDisplayed());
		Base.extentTest.log(LogStatus.PASS, "Attachment is removed successfully");
		Base.takeScreenShot();

		//Uploading unsupported file type attachment
 		Base.extentTest.log(LogStatus.PASS, "Going to verify the invalid type attachment :: "+ TestProperties.get("txtFile"));
		meegsPdfInput.sendKeys(System.getProperty("user.dir")+ File.separator + TestProperties.get("txtFile"));
		Thread.sleep(3000);
		Base.takeScreenShot();
	//	upload_attachment(meegsPdfInput, TestProperties.get("txtFile"));

		//Verifying file type error
		Base.extentTest.log(LogStatus.PASS, "Going to verify the invalid type attachment error");
		if(invalidFileTypeErr.isDisplayed()){
			Base.extentTest.log(LogStatus.PASS, "Error message displayed for wrong file type is <b>Please upload one of the listed file types.</b");
			Base.takeScreenShot();
		}
	}

	public void upload_attachment(WebElement element, String fileName) throws InterruptedException {
		element.sendKeys(System.getProperty("user.dir")+ File.separator + fileName);
		Thread.sleep(15000);
		Base.takeScreenShot();
		Base.extentTest.log(LogStatus.PASS, "Attachment is uploaded");
		Thread.sleep(5000);
	}

	public void download_attachment(WebElement element) throws InterruptedException {
		//browserDriver.scrollToElement(driver, element);
		browserDriver.scrollToBottom();
		Assert.assertTrue(element.isDisplayed());
		Base.extentTest.log(LogStatus.PASS, "Download button is displayed");
		Thread.sleep(5000);
		element.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Download button successfully");
		Thread.sleep(5000);
		logger.info("File downloaded from Attachments");
		Base.extentTest.log(LogStatus.PASS, "File downloaded from Attachments");
		Base.takeScreenShot();
		Thread.sleep(15000);
	}

	public void remove_attachment(WebElement element) throws InterruptedException {
		Assert.assertTrue(element.isDisplayed());
		Base.extentTest.log(LogStatus.PASS, "Trash Icon is displayed");
		Thread.sleep(5000);
		element.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Download trash icon successfully");
		Thread.sleep(5000);
		Base.takeScreenShot();
		removeIconContinueButton.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Download trash > Continue button successfully");
		Thread.sleep(10000);
		Base.takeScreenShot();
	}

	public void clickApplication() throws InterruptedException {
		Thread.sleep(3000);
		applicationicon.click();
		logger.info("Click on Application");
		Base.extentTest.log(LogStatus.PASS, "Click on Application");
		Base.takeScreenShot();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//div[text()[contains(.,'Sign & submit')]]")
	WebElement signAndSubmit;


	public void clickOnSubmit() throws InterruptedException {
		signAndSubmit.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Base.takeScreenShot();
		base.timeinterval(3);

		submitbutton.click();
		logger.info("Clicked on submit button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on submit button");
		Base.takeScreenShot();
		base.timeinterval(3);
		Thread.sleep(30000);
	}

	@FindBy(id="quest-60")
	WebElement renewalNo;

	@FindBy(xpath = "//legend/p[contains(text(),'Renewal Applications Only')]/../..//label/p[text()='No']/../preceding-sibling::div/input")
	WebElement notApplicable;
	public void updateMissingStudentInformation() throws InterruptedException {
		Thread.sleep(5000);
		element.waitVisibility(driver, studentinformation, 20);
		Assert.assertTrue(studentinformation.isDisplayed());
		logger.info("Student information is displayed");
		Base.extentTest.log(LogStatus.PASS, "Student information is displayed");
		Base.takeScreenShot();

		Thread.sleep(15000);
		base.timeinterval(3);
		element.selectOption(grade, 1);
		logger.info("Grade selected from dropdown");
		Base.extentTest.log(LogStatus.PASS, "Grade selected from dropdown");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  renewalNo);
		logger.info("Renewal Applications Only selected NO");
		Base.extentTest.log(LogStatus.PASS, "Renewal Applications Only selected NO");
		Base.takeScreenShot();

		Thread.sleep(15000);
		base.timeinterval(3);
		base.mouseHoverJScript(notApplicable);
		element.sendKeys(notApplicable, "Not Applicable");
		element.sendKeys(notApplicable, String.valueOf(Keys.ENTER));
		logger.info("Enter text in Please explain or enter Not Applicable if there are no changes.");
		Base.extentTest.log(LogStatus.PASS, "Enter text in Please explain or enter Not Applicable if there are no changes.");
		Base.takeScreenShot();

		base.timeinterval(3);
		element.clickByJs(driver,  continuebutton);
		logger.info(" Continue button is Clicked");
		Base.extentTest.log(LogStatus.PASS, " Continue button is Clicked");
		Base.takeScreenShot();
	}

	public void updateMissingparentinformation() throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(30);

		if(parentfirstname.getAttribute("value").equals("")){
			parentfirstname.clear();
			parentfirstname.sendKeys("Rishabh");
			logger.info("Parent first name entered");
			Base.extentTest.log(LogStatus.PASS, "Parent first name entered");
			Base.takeScreenShot();
			base.timeinterval(3);
		}

		if(parentlastname.getAttribute("value").equals("")){
			parentlastname.clear();
			parentlastname.sendKeys("Saharan");
			logger.info("Parent second name entered");
			Base.extentTest.log(LogStatus.PASS, "Parent second name entered");
			Base.takeScreenShot();
			base.timeinterval(2);
		}

		if(parentemailaddress.getAttribute("value").equals("")){
			parentemailaddress.clear();
			parentemailaddress.sendKeys("test1@gmail.com");
			logger.info("Parent email entered");
			Base.extentTest.log(LogStatus.PASS, "Parent email entered");
			Base.takeScreenShot();
			base.timeinterval(2);
		}

		if(parentphonenum.getAttribute("value").equals("")){
			parentphonenum.clear();
			parentphonenum.sendKeys("2347832123");
			logger.info("Parent phone number entered");
			Base.extentTest.log(LogStatus.PASS, "Parent phone number entered");
			Base.takeScreenShot();
			base.timeinterval(2);
		}

		if(parentaddress.getAttribute("value").equals("")){
			parentaddress.clear();
			parentaddress.sendKeys("2621 doordash");
			logger.info("Parent address entered");
			Base.extentTest.log(LogStatus.PASS, "Parent address entered");
			Base.takeScreenShot();
			base.timeinterval(2);
		}

		if(parentcity.getAttribute("value").equals("")){
			parentcity.clear();
			parentcity.sendKeys("boston");
			logger.info("Parent city name entered");
			Base.extentTest.log(LogStatus.PASS, "Parent city name entered");
			Base.takeScreenShot();
			base.timeinterval(2);
		}

		if(parentstate.getAttribute("value").equals("")){
			base.waitForElement(parentstate);
			element.selectOption(parentstate, 1);
			logger.info("Parent state name selected");
			Base.extentTest.log(LogStatus.PASS, "Parent state name selected");
			Thread.sleep(15000);
			Base.takeScreenShot();
			base.timeinterval(4);
		}

		if(parentzipcode.getAttribute("value").equals("")){
			parentzipcode.clear();
			Thread.sleep(3000);
			parentzipcode.sendKeys("238191231");
			logger.info("Parent zip code entered");
			Base.extentTest.log(LogStatus.PASS, "Parent zip code entered");
			parentcity.click();
			Thread.sleep(2000);
			Base.takeScreenShot();
			base.timeinterval(3);
		}

		element.clickByJs(driver, parentcontinuebutton);
		logger.info("Clicked on parent continue button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on parent continue button");
		Base.takeScreenShot();
		base.timeinterval(3);

	}

	@FindBy(xpath = "//div[@class='student-name']")
	List<WebElement> stundentApplications;

	@FindBy(xpath = "//div[text()='Application Type']/following-sibling::div")
	List<WebElement> applcationTypes;

	@FindBy(xpath = "//div[text()='Application Status']/following-sibling::div/span/span")
	List<WebElement> applicationStatus;
	public void verifyApplicationStatusAndType(String name) {
		int index = -1;
		for(int i = 0; i<stundentApplications.size(); i++){
			if(stundentApplications.get(i).getText().equals(name)) {
				index = i;
				break;
			}
		}
		base.mouseHoverJScript(stundentApplications.get(index));
		Assert.assertEquals(applicationStatus.get(index).getText().trim(), "Initial Review");
		Assert.assertEquals(applcationTypes.get(index).getText().trim(), "Renewal");
		Base.takeScreenShot();


	}
	public void checkSSNErrMsg() throws InterruptedException {
		jSWaiter.waitAllRequest();
		base.timeinterval(3);

		browserDriver.scrollToBottom();
		base.timeinterval(3);

		attachmentscontinuebutton.click();
		base.timeinterval(5);

		browserDriver.scrollToElement(driver, parentssn);
		logger.info("Scrolled to parentssn");
		Base.extentTest.log(LogStatus.PASS, "Scrolled to parentssn");
		Base.takeScreenShot();

		ssnErrorvalidate("999-99-9999");
		ssnErrorvalidate("999999999");
		ssnErrorvalidate("999 99 9999");
		ssnErrorvalidate("999.99.9999");

		ssnErrorvalidate("888-77-6666");
		ssnErrorvalidate("888-77-666");


	}

	public void ssnErrorvalidate(String ssn) throws InterruptedException {
		Base.extentTest.log(LogStatus.PASS, "SSN Entered :: "+ssn);
		parentssn.clear();
		parentssn.sendKeys(ssn);
		parentssn.sendKeys(Keys.TAB);
		Thread.sleep(10000);
		logger.info("SSN number entered");
		Base.extentTest.log(LogStatus.PASS, "SSN number entered");
		Base.takeScreenShot();
		base.timeinterval(3);

		if(ssnErrorMsg.isDisplayed())
			Base.extentTest.log(LogStatus.FAIL, "Error Displayed :: "+ssnErrorMsg.getText());
		else
			Base.extentTest.log(LogStatus.PASS, "Error Displayed NOT :: "+ssnErrorMsg.getText());
	}

	public void validateLNHpdf() {
		PDFReader pdf = new PDFReader();
		String pdfString = pdf.readPDFDataFromPath(System.getProperty("user.home")+"\\Downloads\\Oliver Twist LNH Application.pdf");
		String[] pdfdata = pdfString.split("\n");

		Assert.assertTrue(Arrays.stream(pdfdata).filter(e -> e.contains("Oliver Twist")).collect(Collectors.toList()).size()>0);
		Base.extentTest.log(LogStatus.INFO, "Oliver Twist is available in pdf");
	}
}
		
	
