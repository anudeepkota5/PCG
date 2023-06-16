package com.pcgus.ci.scholar.pages;


import com.pcgus.ci.BrowserDriver;
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

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Homepage extends Base {

	WebDriver driver;
	Element element;
	CreateApplicationPage createAppPage;
	BrowserDriver browserDriver = new BrowserDriver();
	MyInfoPage myInfoPage;

	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(Homepage.class.getName());

	@FindBy(xpath = "//*[@id='nav-bar']/ul/li[1]")
	WebElement applicationbutton;

	@FindBy(xpath = "//button[text()[contains(., 'Create application')]]")
	WebElement createapplicationbutton;

	@FindBy(xpath = "//button[text()[contains(., 'Create application')]]")
	static WebElement createappbutton;

	@FindBy(xpath = "//span[text()[contains(., 'My Info')]]")
	WebElement myinfobutton;

	@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
	private WebElement logoutbutton;

	@FindBy(xpath = "//*[@class='panel']//strong")
	private WebElement welcometexttitle;

	@FindBy(xpath = "//div[@class='no-app-instances']")
	private WebElement welcomebody1;

	@FindBy(xpath = "//*[@class='panel']//p[2]")
	private WebElement welcomebody2;

	@FindBy(xpath = "//button[@colname='StudentName']")
	private List<WebElement> students;

	@FindBy(xpath = "//div[@class='student-name']")
	private List<WebElement> parentStudent;

	@FindBy(xpath = "//span[contains(text(),'Applications')]")
	private WebElement applications;

	@FindBy(css = "h1:nth-child(1) > svg:nth-child(1)")
	private WebElement logo;

	@FindBy(xpath = "//span[contains(text(),'My Info')]")
	private WebElement myInfo;

	@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@class='review message']")
	private WebElement reviewMessage;

	@FindBy(xpath = "//div[@class='review message']")
	private List<WebElement> reviewMessageList;

	@FindBy(xpath = "//div[@class='student-name']")
	private List<WebElement> userApplicationList;

	@FindBy(xpath = "//*[contains(text(),'Edit application')]")
	private WebElement editApplicationLink;

	@FindBy(xpath = "//div[normalize-space()='Sign & submit']")
	private WebElement signNSubmitButton;

	@FindBy(xpath = "//button[@class='submit primary']//div")
	private WebElement submitButton;

	@FindBy(xpath = "//button[@class='back-to-apps primary']")
	private WebElement backToApplicationButton;

	@FindBy(xpath="//button[@class='save-button primary']")
	WebElement saveChangesButton;

	@FindBy(xpath = "//*[contains(text(),'View application')]")
	private WebElement viewApplicationLink;

	@FindBy(xpath = "//*[contains(text(),'Delete application')]")
	private WebElement deleteApplicationLink;

	@FindBy(xpath = "//span[text()='Settings']")
	private WebElement settingsIcon;

	@FindBy(xpath = "//span[text()='Site Settings']")
	private WebElement siteSettingsIcon;

	@FindBy(xpath="//h3[text()[contains(.,'Student Information')]]")
	WebElement studentinformation;

	public void HomePageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
		createAppPage = new CreateApplicationPage();
		myInfoPage = new MyInfoPage();
	}

	public void verifyApplicationsTab(){
		element.waitVisibility(driver, applications, 20);
		element.click(driver, applications);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Applications tab");
		Base.takeScreenShot();

		element.waitVisibility(driver, userApplicationList.get(0), 10);
		Base.extentTest.log(LogStatus.PASS, "Applications page loaded successfully");
		Base.takeScreenShot();
	}

	public void EditApplication(String user) throws InterruptedException {
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathAction = "//div[contains(text(), '" + user + "')]/..//span[contains(text(),'Actions')]";
		driver.findElement(By.xpath(xpathAction)).click();
		Thread.sleep(1000);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Action dropdown for user: " + user);
		Base.takeScreenShot();

		element.waitVisibility(driver, editApplicationLink, 10);
		element.click(driver, editApplicationLink);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Edit application link for user: " + user);
		Base.takeScreenShot();

		Thread.sleep(3000);
		element.waitVisibility(driver, studentinformation, 20);
		Base.extentTest.log(LogStatus.PASS, "Edit application page opened for user: " + user);
		Base.takeScreenShot();
	}

	public void clickOnSiteSetting_icon() throws InterruptedException {
		element.click(driver, siteSettingsIcon);
		logger.info("Clicked on settings icon");
		Base.extentTest.log(LogStatus.PASS, "Verified clicked on settings icon");
		Base.takeScreenShot();
		Thread.sleep(10000);
	}

	public void clickOnSetting_icon() throws InterruptedException {
		element.click(driver, settingsIcon);
		logger.info("Clicked on settings icon");
		Base.extentTest.log(LogStatus.PASS, "Verified clicked on settings icon");
		Base.takeScreenShot();
		Thread.sleep(10000);
	}


	public void verifyActionDropdown(String user){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathAction = "//div[contains(text(), '"+user+"')]/..//span[contains(text(),'Actions')]";
		element.waitVisibleBy(driver, By.xpath(xpathAction), 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of Action dropdown");
		Base.takeScreenShot();

		driver.findElement(By.xpath(xpathAction)).click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Action dropdown for user: "+user);
		Base.takeScreenShot();

		element.waitVisibility(driver, viewApplicationLink, 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of View application link for user: "+user);
		Base.takeScreenShot();

		Assert.assertFalse(element.isDisplayed(deleteApplicationLink));
		Base.extentTest.log(LogStatus.PASS, "Verified Delete application link not present under Actions dropdown");
		Base.takeScreenShot();
	}

	public String getPDFUploadDate(String user, String dateTitle){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathPDFDate = "//div[contains(text(), '"+user+"')]/..//span[text()='"+dateTitle+"']/..//div";
		String pdfDate = driver.findElement(By.xpath(xpathPDFDate)).getAttribute("title");
		Base.extentTest.log(LogStatus.PASS, "Verified PDF file Date title displayed as: "+pdfDate);
		Base.takeScreenShot();
		return pdfDate;
	}

	public void verifyPDFUploadDate(String user, HashMap<String, String> dates){
		String meegsDate = getPDFUploadDate(user, TestProperties.get("pdfMEEGSFileName"));
		Assert.assertEquals(meegsDate, dates.get(TestProperties.get("pdfMEEGSFileName")));

		String psalDate = getPDFUploadDate(user, TestProperties.get("pdfSALFileName"));
		Assert.assertEquals(psalDate, dates.get(TestProperties.get("pdfSALFileName")));

		String iepDate = getPDFUploadDate(user, TestProperties.get("pdfIEPFileName"));
		Assert.assertEquals(iepDate, dates.get(TestProperties.get("pdfIEPFileName")));

		String miscDate = getPDFUploadDate(user, TestProperties.get("pdfMISCFileName"));
		Assert.assertEquals(miscDate, dates.get(TestProperties.get("pdfMISCFileName")));
	}
	public void verifyPDFAttachmentLabel(String user, String label){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathPDFLabel = "//div[contains(text(), '"+user+"')]/../div[4]/div[1]";
		String pdfLabel = element.getValue(driver.findElement(By.xpath(xpathPDFLabel))).trim();
		Assert.assertEquals(pdfLabel, label);
		Base.extentTest.log(LogStatus.PASS, "Verified Application PDFs and Attachments label displayed as: "+pdfLabel);
		Base.takeScreenShot();
	}

	public void verifyPDFFileLabel(String user, String label){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathPDFLabel = "//div[contains(text(), '"+user+"')]/..//label[contains(text(), '"+label+"')]";
		String pdfLabel = element.getValue(driver.findElement(By.xpath(xpathPDFLabel))).trim();
		Assert.assertEquals(pdfLabel, label);
		Base.extentTest.log(LogStatus.PASS, "Verified PDF file label displayed as: "+pdfLabel);
		Base.takeScreenShot();
	}

	public void verifyPDFFileLName(String user, String label){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathPDFLabel = "//div[contains(text(), '"+user+"')]/..//span[contains(text(), '"+label+"')]";
		String pdfLabel = element.getValue(driver.findElement(By.xpath(xpathPDFLabel))).trim();
		Assert.assertEquals(pdfLabel, label);
		Base.extentTest.log(LogStatus.PASS, "Verified PDF file label displayed as: "+pdfLabel);
		Base.takeScreenShot();
	}

	public void verifyPDFFileDetails(String user){
		verifyPDFAttachmentLabel(user, TestProperties.get("pdfAttachmentLabel"));
		verifyPDFFileLabel(user, TestProperties.get("iepLabel"));
		verifyPDFFileLabel(user, TestProperties.get("meegLabel"));
		verifyPDFFileLabel(user, TestProperties.get("psalLabel"));
		verifyPDFFileLabel(user, TestProperties.get("miscLabel"));
		verifyPDFFileLName(user, TestProperties.get("pdfMEEGSFileName"));
		verifyPDFFileLName(user, TestProperties.get("pdfIEPFileName"));
		verifyPDFFileLName(user, TestProperties.get("pdfMISCFileName"));
		verifyPDFFileLName(user, TestProperties.get("pdfSALFileName"));
	}
	public void verifyScholarShipAmount(String user, String amount){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathSchAmount = "//div[contains(text(), '"+user+"')]/../div[3]/div[3]/div[2]";
		String schAmount = element.getValue(driver.findElement(By.xpath(xpathSchAmount))).trim();
		Assert.assertEquals(schAmount, amount);
		Base.extentTest.log(LogStatus.PASS, "Verified Scholarship Amount displayed as: "+schAmount);
		Base.takeScreenShot();
	}

	public void verifySchoolYear(String user, String schoolYear){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathSchYear = "//div[contains(text(), '"+user+"')]/../div[2]";
		String schYear = element.getValue(driver.findElement(By.xpath(xpathSchYear))).trim();
		Assert.assertEquals(schYear, schoolYear);
		Base.extentTest.log(LogStatus.PASS, "Verified School Year displayed as: "+schYear);
		Base.takeScreenShot();
	}
	public void clickOnapplication_icon(){
		element.click(driver, applications);
		logger.info("Clicked on application icon");
		Base.extentTest.log(LogStatus.PASS, "Verified Clicked on application icon");
		Base.takeScreenShot();
	}

	public void verifyMyInfoTab(){
		element.waitVisibility(driver, myInfo, 20);
		element.click(driver, myInfo);
		Base.extentTest.log(LogStatus.PASS, "Clicked on My Info tab");
		Base.takeScreenShot();

		element.waitVisibility(driver, saveChangesButton, 10);
		Base.extentTest.log(LogStatus.PASS, "My Info page loaded successfully");
		Base.takeScreenShot();
	}

	public void download_attachment(WebElement element) throws InterruptedException {
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

	public void verifyDownloads(String user) throws InterruptedException {
		String xPathMeegsDownloadIcon = "//*[contains(text(), '"+user+"')]/../div[4]//label[contains(text(),'MEEG')]/../div/div/div[2]";
		download_attachment(driver.findElement(By.xpath(xPathMeegsDownloadIcon)));

		String xPathPsalDownloadIcon = "//*[contains(text(), '"+user+"')]/../div[4]//label[contains(text(),'PSAL')]/../div/div/div[2]";
		download_attachment(driver.findElement(By.xpath(xPathPsalDownloadIcon)));

		String xPathMiscDownloadIcon = "//*[contains(text(), '"+user+"')]/../div[4]//label[contains(text(),'MISC')]/../div/div/div[2]";
		download_attachment(driver.findElement(By.xpath(xPathMiscDownloadIcon)));

		String xPathIepDownloadIcon = "//*[contains(text(), '"+user+"')]/../div[4]//label[contains(text(),'IEP')]/../div/div/div[2]";
		download_attachment(driver.findElement(By.xpath(xPathIepDownloadIcon)));
	}
	public void verifyStudentName(String studentName) throws InterruptedException {
		Thread.sleep(10000);
		Base.takeScreenShot();
		element.waitVisibility(driver, userApplicationList.get(0), 30);
		String xpathStudentName = "//*[@class='student-name'][text()='"+studentName+" "+studentName+"']";
		element.waitVisibility(driver, driver.findElement(By.xpath(xpathStudentName)), 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of Student Name as: "+studentName+ " "+studentName);
		Base.takeScreenShot();
	}

	public void verifyPrivateSchoolName(String user, String schoolName){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathSchoolName = "//div[contains(text(), '"+user+"')]/../div[3]/div[4]/div[2]";
		String pvtSchoolName = element.getValue(driver.findElement(By.xpath(xpathSchoolName))).trim();
		Assert.assertEquals(pvtSchoolName, schoolName);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of Private School Name as: "+pvtSchoolName);
		Base.takeScreenShot();
	}

	public void verifyEnrollmentStatus(String user, String status){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathStatus = "//div[contains(text(), '"+user+"')]/../div[3]/div[5]/div[2]";
		String enrollStatus = element.getValue(driver.findElement(By.xpath(xpathStatus))).trim();
		Assert.assertEquals(enrollStatus, status);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of Enrollment Status as: "+enrollStatus);
		Base.takeScreenShot();
	}

	public void verifyApplicationType(String user, String appType){
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathAppType = "//div[contains(text(), '"+user+"')]/../div[3]/div[6]/div[2]";
		String applicationType = element.getValue(driver.findElement(By.xpath(xpathAppType))).trim();
		Assert.assertEquals(applicationType, appType);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of Application Type as: "+applicationType);
		Base.takeScreenShot();
	}

	public void verifyStudentDetails(String user) throws InterruptedException {
		verifyStudentName(user);
		verifyApplicationStatus(user, "Initial Review");
		verifyPrivateSchoolName(user, TestProperties.get("privateSchool"));
		verifyEnrollmentStatus(user, TestProperties.get("enrollmentStatus"));
		verifyApplicationType(user, TestProperties.get("applicationStatus"));
	}

	public void verifyReviewMessage(String value){
		element.waitVisibility(driver, reviewMessageList.get(0), 10);
		for(int i=0;i<reviewMessageList.size();i++){
			String reviewMessage = element.getValue(reviewMessageList.get(i));
			if(reviewMessage.contains(value)) {
				Assert.assertEquals(reviewMessage, "Attention! "+value+" "+value+"'s " +
						"application has been returned. Select 'Edit application' from the Actions menu to see more information.");
				Base.extentTest.log(LogStatus.PASS, "Verified review message populated as: "+reviewMessage);
				Base.takeScreenShot();
			}
		}
	}

	public void verifyApplicationStatus(String user, String status) throws InterruptedException {
		Thread.sleep(5000);
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathStatus = "//div[@class='student-name'][contains(text(), '"+user+"')]/../div[3]/div[2]/div[2]/span[1]";
		String applicationStatus = element.getValue(driver.findElement(By.xpath(xpathStatus))).trim();
		Assert.assertEquals(applicationStatus, status);
		Base.extentTest.log(LogStatus.PASS, "Verified Application status displayed as: "+applicationStatus);
		Base.takeScreenShot();
	}

	public void updateApplicationStatus(String value) throws InterruptedException {
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		String xpathAction = "//div[@class='student-name'][contains(text(), '"+value+"')]/../div[5]//span[contains(text(),'Actions')]";
		driver.findElement(By.xpath(xpathAction)).click();
		element.waitVisibility(driver, editApplicationLink, 10);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Action dropdown for user: "+value);
		Base.takeScreenShot();

	//	element.selectVisibleOption(driver.findElement(By.xpath(xpathAction)), "Edit application");
		Thread.sleep(10000);
		element.click(driver, editApplicationLink);
		element.waitVisibility(driver, signNSubmitButton, 10);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Edit application for user: "+value);
		Base.takeScreenShot();

		element.click(driver, signNSubmitButton);
		element.waitVisibility(driver, submitButton, 10);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Sign n Submit Button for user: "+value);
		Base.takeScreenShot();

		element.click(driver, submitButton);
		element.waitVisibility(driver, backToApplicationButton, 10);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Submit Button for user: "+value);
		Base.takeScreenShot();

		element.click(driver, backToApplicationButton);
		element.waitVisibility(driver, userApplicationList.get(0), 10);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Back to Application Button");
		Base.takeScreenShot();
	}



	public void verify_parent_homepage_icons() throws InterruptedException {
		homepage_logo_icon();
		application_icon();
		myinfo_icon();
		logout_icon();
	}
	public void homepage_logo_icon(){
		element.waitVisibility(driver, logoutbutton, 15);
		String logo_data_name = logo.getAttribute("data-name");
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar logo on Parent homepage as " +logo_data_name);
		Base.takeScreenShot();
	}

	public void application_icon(){
		element.waitVisibility(driver, applications, 15);
		String application_icon = applications.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>application icon</b> on Parent homepage as "+application_icon);
		Base.takeScreenShot();
	}

	public void myinfo_icon(){
		element.waitVisibility(driver, myInfo, 15);
		String myinfo_icon = myInfo.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>myinfo icon</b>  on Parent homepage as "+myinfo_icon);
		Base.takeScreenShot();
	}

	public void logout_icon(){
		element.waitVisibility(driver, logoutbutton, 15);
		String logout_icon = logoutbutton.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>logout icon</b>  on Parent homepage as "+logout_icon);
		Base.takeScreenShot();
	}


	public List<String> getParentStudents(){
		return parentStudent.stream().map(e->e.getText()).collect(Collectors.toList());
	}
	public List<String> getStudents(){
		return students.stream().map(e->e.getText()).collect(Collectors.toList());
	}

	public void logout() throws InterruptedException {
		element.waitVisibility(driver, logoutbutton, 15);
		try {
			element.clickByJs(driver, logoutbutton);
		}catch (Exception e)
		{
			element.click(driver, logoutbutton);
		}
		driver.navigate().refresh();
		Thread.sleep(3000);
		Base.extentTest.log(LogStatus.PASS, "Log out button is clicked");
		Base.takeScreenShot();
	}

	public void verifyNoApplicationDashboard(String dashboardTitle, String body1, String body2){

		Assert.assertTrue(base.compareStrings(welcometexttitle.getText(), TestProperties.get(dashboardTitle)));
		logger.info("Dashboard title is correct which is <b>"+welcometexttitle.getText()+"</b");
		Base.extentTest.log(LogStatus.PASS, "Dashboard title is correct which is <b>"+welcometexttitle.getText()+"</b>");
		Base.takeScreenShot();

/*		Assert.assertTrue(base.compareStrings(welcomebody1.getText(), TestProperties.get(body1)));
		logger.info("Dashboard body is correct which is <b>"+welcomebody1.getText()+"</b");
		Base.extentTest.log(LogStatus.PASS, "Dashboard body is correct which is <b>"+welcomebody1.getText()+"</b>");
		Base.takeScreenShot();*/

		Assert.assertTrue(base.compareStrings(welcomebody2.getText(), TestProperties.get(body2)));
		logger.info("Dashboard continued body is correct which is <b>"+welcomebody2.getText()+"</b");
		Base.extentTest.log(LogStatus.PASS, "Dashboard continued body is correct which is <b>"+welcomebody2.getText()+"</b>");
		Base.takeScreenShot();
	}


	public static void clickCreateApplicationButton(){
		createappbutton.click();
	}


	public void verifyhomepage() throws InterruptedException {
		element.waitVisibility(driver, createapplicationbutton, 20);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Thread.sleep(4000);
		Base.takeScreenShot();

		element.waitVisibility(driver, applicationbutton, 20);
		Assert.assertTrue(applicationbutton.isDisplayed());
		logger.info("Application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Application button is displayed in the navigation bar");
		Base.takeScreenShot();

		element.waitVisibility(driver, myinfobutton, 20);
		Assert.assertTrue(myinfobutton.isDisplayed());
		logger.info("My Info button is displayed");
		Base.extentTest.log(LogStatus.PASS, "My Info button is displayed in the navigation bar");
		Base.takeScreenShot();

		element.waitVisibility(driver, logoutbutton, 20);
		Assert.assertTrue(logoutbutton.isDisplayed());
		logger.info("Logout button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Logout button is displayed in the navigation bar");
		Base.takeScreenShot();
	}
	
	public void verifyHomeapagebuttons() throws InterruptedException {

		jSWaiter.waitAllRequest();
		element.waitVisibility(driver, createapplicationbutton, 20);
		Assert.assertTrue(createapplicationbutton.isDisplayed());
		logger.info("Create application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Create application button is displayed");
		Base.takeScreenShot();

		base.timeinterval(4);
		createapplicationbutton.click();
		logger.info("Create application button is Clicked");
		Base.extentTest.log(LogStatus.PASS, "Create application button is clicked");
		base.timeinterval(4);
		Base.takeScreenShot();

	//	createAppPage.cancelnverifyNewStudentPopUp();
	}

	public void verifyparentsystemlogo() throws InterruptedException {
		base.timeinterval(3);
		element.waitVisibility(driver, applicationbutton, 20);
		Assert.assertTrue(applicationbutton.isDisplayed());
		logger.info("Application button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Application button is displayed");
		Base.takeScreenShot();

//		base.timeinterval(5);
		element.waitVisibility(driver, myinfobutton, 20);
		Assert.assertTrue(myinfobutton.isDisplayed());
		logger.info("My Info button is displayed");
		Base.extentTest.log(LogStatus.PASS, "My Info button is displayed");
		Base.takeScreenShot();

//		base.timeinterval(5);
		element.waitVisibility(driver, logoutbutton, 20);
		Assert.assertTrue(logoutbutton.isDisplayed());
		logger.info("Logout button is displayed");
		Base.extentTest.log(LogStatus.PASS, "Logout button is displayed");
		Base.takeScreenShot();

//		base.timeinterval(5);
		element.clickByJs(driver, logoutbutton);
		logger.info("Log out button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Log out button is clicked");
		Base.takeScreenShot();
	}
}
