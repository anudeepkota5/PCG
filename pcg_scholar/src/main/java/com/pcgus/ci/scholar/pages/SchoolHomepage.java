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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.pcgus.scholar.pages.state.StateHomePage.scrollToElement;

public class SchoolHomepage extends Base {

	WebDriver driver;
	Element element;
	CreateApplicationPage createAppPage;
	BrowserDriver browserDriver = new BrowserDriver();
	MyInfoPage myInfoPage;

	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(SchoolHomepage.class.getName());

	@FindBy(css = "h1:nth-child(1) > svg:nth-child(1)")
	private WebElement logo;

	@FindBy(xpath = "//li[@class='selected']/span[contains(text(),'Students')]")
	WebElement students;

	@FindBy(xpath = "//span[contains(text(),'Finances')]")
	private WebElement finances;

	@FindBy(xpath = "//span[contains(text(),'School Info')]")
	private WebElement schoolInfo;

	@FindBy(xpath = "//span[contains(text(),'My Info')]")
	private WebElement myInfo;

	@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
	private WebElement logoutbutton;

	@FindBy(xpath = "//button[text()='Annual Statements']")
	private WebElement annualStatementTab;

	@FindBy(xpath = "//span[@colname='status']/span[text()='Created']/../preceding-sibling::span[8]")
	private List<WebElement> recordListStatusEdit;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement selectedRecordEditButton;

	@FindBy(xpath = "//*[@class='react-date-picker__clear-button react-date-picker__button']")
	private WebElement entryDateXbutton;

	@FindBy(xpath = "//button[text()[contains(., 'Save changes')]]")
	private WebElement saveChangesButton;

	@FindBy(xpath = "//div[contains(text(),'A date must be selected.')]")
	private WebElement blankDateErrorMsg;

	@FindBy(xpath = "//button[@class='react-date-picker__calendar-button react-date-picker__button']")
	private WebElement calenderIcon;

	String xpathFormat = "//abbr[text()='10']";

	@FindBy(xpath = "//div[text()='New Applications']")
	private WebElement newApplication;

	@FindBy(xpath = "//*[text()='Students.']")
	private WebElement myStudent;

	@FindBy(xpath = "//label[text()='Grade']")
	private WebElement gradeLabel;

	@FindBy(xpath = "//div[@id='termSelect']")
	private WebElement termSelect;

	@FindBy(xpath = "//input[@data-form-key='SchoolName'][@disabled]")
	private WebElement schoolName;

	@FindBy(xpath = "//div[text()='School Review']")
	private WebElement schoolReviewGrid;

	@FindBy(xpath = "//div[text()='School Review']/..//button[@colname='StudentName']")
	private List<WebElement> userName;

	@FindBy(xpath = "//div[text()='School Review']/..//span[@colname='Grade']")
	private List<WebElement> userGrade;

	@FindBy(xpath = "//div[text()='School Review']/..//span[@colname='ParentName']")
	private List<WebElement> parentName;

	@FindBy(xpath = "//div[text()='School Review']/..//span[@colname='Submitted']")
	private List<WebElement> dateSubmitted;

	@FindBy(xpath = "//button[@class='actions-button tertiary']")
	private WebElement actionDropdown;

	@FindBy(xpath = "//div[@class='review-message']")
	private WebElement reviewMessageGrid;

	@FindBy(xpath = "//div[@class='review-message']/div[1]")
	private WebElement reviewMessage;

	@FindBy(xpath = "//div[@class='signature-container']")
	private WebElement signatureContainer;

	@FindBy(xpath = "//div[@class='message-container']")
	private WebElement messageContainer;

	@FindBy(xpath = "//button[@class='actions-button tertiary']")
	private WebElement userActionButton;

	@FindBy(xpath = "//*[contains(text(),'Edit Status')]")
	private WebElement editStatusAction;

	@FindBy(xpath = "//div[text()='Select...']")
	private WebElement dropdownOnEditStatus;

	@FindBy(xpath = "//textarea[@aria-required='true'] | //textarea[@aria-required='false']")
	private WebElement textAreaStatusChange;

	@FindBy(xpath = "//button[text()='Update Status']")
	private WebElement updateStatusButton;

	@FindBy(xpath = "//span[@class='status-component']")
	private WebElement statusValue;

	@FindBy(xpath = "//*[@data-icon='chevron-circle-down']")
	private WebElement downArrowWithData;

	@FindBy(xpath = "//*[@data-icon='chevron-circle-up']")
	private WebElement upArrowWithoutData;

	@FindBy(xpath = "//div[@class='signature-container']/div")
	private WebElement dateTimeContainer;

	@FindBy(xpath = "//div[@class='school-review-grid grid-container']//button[@class='next-page-button']")
	WebElement nextPageReviewButton;

	@FindBy(xpath = "//div[@class='school-review-grid grid-container']//div[@class='page-buttons-container']/span[3]")
	WebElement numberOfPagesInReview;

	@FindBy(xpath = "//div[@class='new-applications-grid grid-container']//button[@class='next-page-button']")
	WebElement nextPageNewAppButton;

	@FindBy(xpath = "//div[@class='new-applications-grid grid-container']//div[@class='page-buttons-container']/span[3]")
	WebElement numberOfPagesInNewApp;

	@FindBy(xpath = "//div[text()='New Applications']/..//button[@colname='StudentName']")
	private List<WebElement> userInNewApplications;

	@FindBy(xpath = "//div[text()='New Applications']/..//span[contains(@class,'status')]")
	private List<WebElement> applicationStatus;

	@FindBy(xpath = "//tbody/tr[1]/th[4]//p")
	WebElement firstUserApplications;

	@FindBy(xpath = "//tbody/tr[1]/th[3]")
	WebElement lastNameUserApplication;

	@FindBy(xpath = "//div[@class='school-review-grid grid-container']/div[3]/button")
	private List<WebElement> studentNameReviewList;

	@FindBy(xpath = "//div[@class='change-reason-container']/div[@class='signature-container']/div")
	public WebElement reviewMessageTime;

	@FindBy(xpath = "(//*[name()='svg'][contains(@class,'chevron-circle-down')])")
	public WebElement reviewMessageChevronButton;

	@FindBy(xpath = "//span[contains(@class,'blue-text')]")
	WebElement acceptanceLetterUploadButton;

	@FindBy(xpath = "//div[contains(@class,'remove-icon')]//*[name()='svg']")
	WebElement acceptanceLetterDeleteIcon;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement acceptanceLetterDeleteContinue;

	@FindBy(xpath = "//div[@class='type-icon']")
	WebElement acceptanceLetterDownloadButton;

	@FindBy(xpath = "//div[contains(@class,'documents panel-section')]//div[contains(@class,'placeholder shimmer')]")
	WebElement acceptanceLetterDeleteContinueLoading;

	@FindBy(xpath = "//div[@class='parent-record-doc file-drop']")
	WebElement getAcceptanceLetterDragAndDrop;

	@FindBy(xpath = "//span[text()='School Information']")
	WebElement schoolInformation;

	@FindBy(xpath = "//span[text()='Contact Information']")
	WebElement contactInformation;

	@FindBy(xpath = "//span[text()='Quarter Information']")
	WebElement quarterInformation;

	@FindBy(xpath = "//span[text()='Tuition and Fees']")
	WebElement tuitionNFees;

	@FindBy(xpath = "//input[@placeholder='Enter the official email for your school']")
	WebElement emailAddress;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter the URL for your school')]")
	WebElement webSite;

	@FindBy(xpath = "//input[@value='Annual Tuition'][@disabled]")
	WebElement annualTuition;

	@FindBy(xpath = "//input[@data-form-key='PhoneNumber']")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@data-form-key='Address1']")
	WebElement address;

	@FindBy(xpath = "//input[@data-form-key='City']")
	WebElement city;

	@FindBy(xpath = "//select[@data-form-key='StateAbbrev']")
	WebElement state;

	@FindBy(xpath = "//input[@data-form-key='ZipCode']")
	WebElement zipCode;

	@FindBy(xpath = "//input[@data-form-key='ContactName']")
	WebElement contactName;

	@FindBy(xpath = "//input[@data-form-key='ContactEmail']")
	WebElement contactEmail;

	@FindBy(xpath = "//input[@data-form-key='ContactPhoneNumber']")
	WebElement contactPhoneNumber;

	@FindBy(xpath = "//div[@class='react-date-picker__wrapper']")
	private List<WebElement> quarterDates;

	@FindBy(xpath = "//input[@data-form-key='Quarter1NumDays']")
	WebElement firstQuarterDays;

	@FindBy(xpath = "//input[@data-form-key='Quarter2NumDays']")
	WebElement secondQuarterDays;

	@FindBy(xpath = "//input[@data-form-key='Quarter3NumDays']")
	WebElement thirdQuarterDays;

	@FindBy(xpath = "//input[@data-form-key='Quarter4NumDays']")
	WebElement fourthQuarterDays;

	@FindBy(xpath = "//input[@value='Annual Tuition']/../../div[2]//input")
	WebElement tuitionFeeAmount;

	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> gradeLevelCheckBoxes;

	@FindBy(xpath = "//span[text()='Status:']")
	private WebElement status;

	@FindBy(xpath = "//span[text()='Submitted on:']")
	private WebElement submittedOn;

	@FindBy(xpath = "//span[text()='Submitted by:']")
	private WebElement SubmittedBy;

	@FindBy(xpath = "//span[text()='Student Name']")
	private WebElement StudentName;

	@FindBy(xpath = "//span[text()='Student DOB']")
	private WebElement StudentDOB;

	@FindBy(xpath = "//span[text()='Statement Date']")
	private WebElement StatementDate;

	@FindBy(xpath = "//span[text()='Parent/Guardian Name']")
	private WebElement ParentGuardianName;


	public void SchoolHomePageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
		createAppPage = new CreateApplicationPage();
		myInfoPage = new MyInfoPage();
	}

	public void verifyEditableFieldsForSchool() {
		scrollToElement(driver, emailAddress);
		Assert.assertTrue(emailAddress.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Email address field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(webSite.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Website field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(phoneNumber.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Phone Number field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(address.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Address field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(city.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified City field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(state.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified State field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(zipCode.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified ZipCode field is editable");
		Base.takeScreenShot();

		scrollToElement(driver, contactName);
		Assert.assertTrue(contactName.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Contact name field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(contactEmail.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Contact Email field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(contactPhoneNumber.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Contact Phone Number field is editable");
		Base.takeScreenShot();

		scrollToElement(driver, firstQuarterDays);
		for(int i=0; i<quarterDates.size();i++){
			Assert.assertTrue(quarterDates.get(i).isEnabled());
			Base.extentTest.log(LogStatus.PASS, "Verified Date "+i+ " field is editable");
			Base.takeScreenShot();
		}

		Assert.assertTrue(firstQuarterDays.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Quarter 1 Days field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(secondQuarterDays.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Quarter 2 Days field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(thirdQuarterDays.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Quarter 3 Days field is editable");
		Base.takeScreenShot();

		Assert.assertTrue(fourthQuarterDays.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Quarter 4 Days field is editable");
		Base.takeScreenShot();

		scrollToElement(driver, quarterInformation);
		for(int i=0; i<gradeLevelCheckBoxes.size();i++){
			Assert.assertTrue(gradeLevelCheckBoxes.get(i).isEnabled());
			Base.extentTest.log(LogStatus.PASS, "Verified Grade Level Checkbox "+i+ " is editable");
			Base.takeScreenShot();
		}

		scrollToElement(driver, tuitionFeeAmount);
		Assert.assertTrue(tuitionFeeAmount.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified Tuition Fee Amount field is editable");
		Base.takeScreenShot();
	}


	public void verifyDisabledFieldsForSchool() {
		scrollToElement(driver, schoolName);
		Assert.assertFalse(schoolName.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified presence of School Name disabled field");
		Base.takeScreenShot();

		scrollToElement(driver, annualTuition);
		Assert.assertFalse(annualTuition.isEnabled());
		Base.extentTest.log(LogStatus.PASS, "Verified presence of Annual Tuition disabled field");
		Base.takeScreenShot();
	}


	public void verifySchoolDetailsLabel(){
		scrollToElement(driver, schoolInformation);
		element.waitVisibility(driver, schoolInformation, 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of School Information label");
		Base.takeScreenShot();

		scrollToElement(driver, contactInformation);
		element.waitVisibility(driver, contactInformation, 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of School Information label");
		Base.takeScreenShot();

		scrollToElement(driver, quarterInformation);
		element.waitVisibility(driver,quarterInformation, 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of School Information label");
		Base.takeScreenShot();

		scrollToElement(driver, tuitionNFees);
		element.waitVisibility(driver, tuitionNFees, 10);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of School Information label");
		Base.takeScreenShot();
	}

	public void verifyReviewMessageTime(){
		element.waitVisibility(driver, actionDropdown, 15);
		String dateTime = reviewMessageTime.getText();
		String dateTimeRegex = "^(January|February|March|April|May|June|July|August|September|October|November|December)\\s\\d{1,2}(st|nd|rd|th),\\s\\d{4}\\sat\\s\\d{1,2}:\\d{2}\\s(AM|PM)\\sGMT([-+])\\d{1,2}$";

		Pattern pattern = Pattern.compile(dateTimeRegex);
		Matcher matcher = pattern.matcher(dateTime);

		if (matcher.matches()) {
			System.out.println("The date time format is valid.");
			Base.extentTest.log(LogStatus.INFO, "Date and time format of review message is correct");
			Base.takeScreenShot();
		} else {
			System.out.println("The date time format is invalid.");
			Base.extentTest.log(LogStatus.FAIL, "Date and time format of review message is incorrect");
			Base.takeScreenShot();
		}
	}

	public void verifyAttentionNotificationAndContent() throws InterruptedException {
		element.waitVisibility(driver, actionDropdown, 15);
		Thread.sleep(15000);
		verifyReviewMessageColor();
		verifyReviewMessageTime();
		element.waitVisibility(driver, reviewMessageChevronButton, 15);
		reviewMessageChevronButton.click();
		Base.extentTest.log(LogStatus.PASS, "Review message is collapsed");
		Base.takeScreenShot();
	}

	public void uploadAcceptanceLetter(String filePath){
		element.waitVisibility(driver, acceptanceLetterUploadButton, 15);
		try {
			if (acceptanceLetterDeleteIcon.isDisplayed()) {
				scrollToElement(driver, acceptanceLetterDeleteIcon);
				acceptanceLetterDeleteIcon.click();
				element.waitVisibility(driver, acceptanceLetterDeleteContinue, 25);
				acceptanceLetterDeleteContinue.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.invisibilityOf(acceptanceLetterDeleteContinueLoading));
			}
		}catch (Exception e ){
			Base.extentTest.log(LogStatus.INFO, "Acceptance letter is not present we need to upload it");
			Base.takeScreenShot();
		}
		scrollToElement(driver, getAcceptanceLetterDragAndDrop);
//		getAcceptanceLetterDragAndDrop.sendKeys(filePath);
		acceptanceLetterUploadButton.sendKeys(filePath);
		element.waitVisibility(driver, acceptanceLetterDownloadButton, 15);
	}
	public void verifyStudentNameExistsReviewListAndClick(String studentName){
		element.waitVisibility(driver, students, 15);
		students.click();
		element.waitVisibility(driver, schoolReviewGrid, 15);

		int pages = Integer.parseInt(numberOfPagesInReview.getText());
		boolean studentPresent = false;
		while(pages>0){
			List <WebElement> allStudentNameList = studentNameReviewList;
			for (WebElement studName :  allStudentNameList){
				String user = studName.getText();
				if (user.equals(studentName)){
					studName.click();
					element.waitVisibility(driver, actionDropdown, 15);
					Base.extentTest.log(LogStatus.PASS, "Student name exist in School Review list ");
					Base.takeScreenShot();
					studentPresent = true;
					break;
				}
			}
			if(studentPresent==true)
				break;
			element.click(driver, nextPageReviewButton);
			Base.extentTest.log(LogStatus.PASS, "Next Page button clicked");
			Base.takeScreenShot();
			pages = pages-1;
		}
		Assert.assertTrue(studentPresent);
	}

	public String studentNameClicked(){
		element.waitVisibility(driver, firstUserApplications, 15);
		String StudentName= firstUserApplications.getText() + " " +lastNameUserApplication.getText();
		firstUserApplications.click();
		Base.extentTest.log(LogStatus.INFO, "Click on Student Name from applications list. Student Name :"+StudentName);
		Base.takeScreenShot();
		return StudentName;
	}

	public void verifyReviewMessageDetails(HashMap<String, String> userDetails) throws ParseException {
		verifyReviewMessageColor();
		verifyReviewMessage();
		verifyParentName(userDetails);
		verifyMessageContainerPresence();
		verifyReviewMessageDate(userDetails);
		verifyArrowKey();
	}


	public void verifySchoolName(String name) throws InterruptedException {
		schoolInfo.click();
		while(true){
			if(!schoolName.getAttribute("value").equals("")){
				break;
			}else {
				Thread.sleep(1000);
			}
		}
		Base.extentTest.log(LogStatus.PASS, "Clicked on School Info icon");
		element.waitVisibility(driver, schoolName, 10);
		Base.takeScreenShot();

		String schName = schoolName.getAttribute("value");
		Assert.assertEquals(name, schName);
	}
	public void verifyReviewMessageDate(HashMap<String, String> userDetails) throws ParseException {
		element.waitVisibility(driver, dateTimeContainer, 20);
		DateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
		DateFormat targetFormat = new SimpleDateFormat("MMM dd, yyyy");
		Date date = originalFormat.parse(userDetails.get("date"));
		String messageDate = targetFormat.format(date);
		logger.info(messageDate);
		String reviewMsgDate = element.getValue(dateTimeContainer).replace("th","")
				.replace("rd","").replace("st","")
				.replace("nd","");
		logger.info(reviewMsgDate);
		Assert.assertTrue(reviewMsgDate.contains("CDT"));
		Base.extentTest.log(LogStatus.INFO, "Verified review message date");
		Base.takeScreenShot();
	}
	public void verifyApplicationRemovedFromReview(HashMap<String, String> userDetails){
		element.click(driver, students);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Students link from side Nav-bar");
		Base.takeScreenShot();

		element.waitVisibility(driver, newApplication, 15);
		element.waitClickable(driver, nextPageReviewButton, 15);
		int pages = Integer.parseInt(numberOfPagesInReview.getText());
		boolean isApplicationRemoved = true;
		while(pages-1>0){
			for(int i=0;i<userName.size();i++){
				String updatedUser = userName.get(i).getText();
				if(updatedUser.equals(userDetails.get("user"))){
					isApplicationRemoved = false;
					break;
				}
			}
			element.click(driver, nextPageReviewButton);
			Base.extentTest.log(LogStatus.PASS, "Next Page button clicked");
			Base.takeScreenShot();
			pages = pages-1;
			if(isApplicationRemoved==false)
				break;
		}
		Assert.assertTrue(isApplicationRemoved);
	}

	public void verifyApplicationPresentInNewAppGrid(HashMap<String, String> userDetails){
		element.waitVisibility(driver, newApplication, 15);
		element.waitClickable(driver, nextPageNewAppButton, 15);
		int pages = Integer.parseInt(numberOfPagesInNewApp.getText());
		boolean isApplicationPresent = false;
		logger.info(userDetails.get("user"));
		while(pages-1>0){
			for(int i=0;i<userInNewApplications.size();i++){
				String updatedUser = userInNewApplications.get(i).getText();
				if(updatedUser.equals(userDetails.get("user"))){
					Assert.assertTrue(element.getValue(applicationStatus.get(i)).contains(TestProperties.get("initialReview")));
					isApplicationPresent = true;
					break;
				}
			}
			if(isApplicationPresent==true)
				break;
			element.click(driver, nextPageNewAppButton);
			Base.extentTest.log(LogStatus.PASS, "Next Page button clicked");
			Base.takeScreenShot();
			pages = pages-1;
		}
		Assert.assertTrue(isApplicationPresent);
	}

	public void verifyArrowKey(){
		element.waitVisibility(driver, downArrowWithData, 10);
		element.waitVisibility(driver, dateTimeContainer, 20);
		element.click(driver, downArrowWithData);
		Base.extentTest.log(LogStatus.INFO, "Down arrow clicked to hide data");
		Base.takeScreenShot();

		element.waitVisibility(driver, upArrowWithoutData, 10);
		Assert.assertFalse(element.isDisplayed(downArrowWithData));
		Assert.assertFalse(element.isDisplayed(dateTimeContainer));

		element.click(driver, upArrowWithoutData);
		Base.extentTest.log(LogStatus.INFO, "Up arrow clicked to show data again");
		Base.takeScreenShot();

		element.waitVisibility(driver, downArrowWithData, 10);
		Assert.assertTrue(element.isDisplayed(downArrowWithData));
		Assert.assertTrue(element.isDisplayed(dateTimeContainer));
	}

	public void verifyReviewMessageColor(){
		element.waitVisibility(driver, actionDropdown, 20);
		String color = Color.fromString(reviewMessageGrid.getCssValue("background-color")).asHex();
		Assert.assertEquals(color,TestProperties.get("userTypePurple"));
		Base.extentTest.log(LogStatus.INFO, "Background color of review message is purple");
		Base.takeScreenShot();
	}

	public void verifyReviewMessage(){
		element.waitVisibility(driver, reviewMessageGrid, 20);
		Assert.assertTrue(element.getValue(reviewMessage).contains(TestProperties.get("reviewMessage")));
		Base.extentTest.log(LogStatus.INFO, "Background color of review message is purple");
		Base.takeScreenShot();
	}

	public void verifyParentName(HashMap<String, String> userDetails){
		element.waitVisibility(driver, reviewMessageGrid, 20);
		String parent = element.getValue(signatureContainer);
		Base.extentTest.log(LogStatus.INFO, "Parent name for review message: "+userDetails.get("parent"));
		Base.takeScreenShot();
		Assert.assertTrue(parent.contains(userDetails.get("parent")));
	}

	public void verifyMessageContainerPresence(){
		element.waitVisibility(driver, messageContainer, 20);
		Base.extentTest.log(LogStatus.INFO, "Verified presence of message container");
		Base.takeScreenShot();
	}

	public void editStatusAction(String value) throws InterruptedException{
		element.waitVisibility(driver, userActionButton, 20);
		element.click(driver, userActionButton);
		element.waitVisibility(driver, editStatusAction, 20);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Action button for selected user");
		Base.takeScreenShot();

		element.click(driver, editStatusAction);
		element.waitVisibility(driver, dropdownOnEditStatus, 20);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Edit-status for selected user");
		Base.takeScreenShot();

		element.click(driver, dropdownOnEditStatus);
		Thread.sleep(2000);
		element.waitVisibleBy(driver, By.xpath("//*[text()='"+value+"']"), 20);
		Base.extentTest.log(LogStatus.PASS, "Selected new status for dropdown as "+value);
		Base.takeScreenShot();

		driver.findElement(By.xpath("//*[text()='"+value+"']")).click();
		Thread.sleep(4000);
		element.waitVisibleBy(driver, By.xpath("//div[text()='"+value+"']"), 20);
		Base.extentTest.log(LogStatus.PASS, "Selected new status for dropdown as "+value);
		Base.takeScreenShot();

		element.sendKeys(textAreaStatusChange, value);
		Base.extentTest.log(LogStatus.PASS, "Entered reason for status change as "+value);
		Base.takeScreenShot();

		element.click(driver, updateStatusButton);
		Thread.sleep(12000);
		element.waitVisibility(driver, statusValue, 20);
		Base.extentTest.log(LogStatus.PASS, "Clicked on Update status button");
		Base.takeScreenShot();

		Assert.assertTrue(statusValue.getText().contains(value));
		Base.extentTest.log(LogStatus.PASS, "Status updated successfully with "+value);
		Base.takeScreenShot();
	}


	public void clickFirstUser() throws InterruptedException {
		element.waitVisibility(driver, schoolReviewGrid, 10);
		element.click(driver, userName.get(0));
		element.waitVisibility(driver, actionDropdown, 20);
		Thread.sleep(1000);
		Base.extentTest.log(LogStatus.INFO, "Clicked first user from School review grid");
		Base.takeScreenShot();
	}

	public HashMap<String,String> getFirstUserDetails(){
		HashMap<String, String> userDetails = new HashMap();
		userDetails.put("user", element.getValue(userName.get(0)));
		userDetails.put("grade", element.getValue(userGrade.get(0)));
		userDetails.put("parent", element.getValue(parentName.get(0)));
		userDetails.put("date", element.getValue(dateSubmitted.get(0)));
		return userDetails;
	}
	public boolean verifySchoolReviewGridPresence(){
		element.waitVisibility(driver, newApplication,15);
		Base.extentTest.log(LogStatus.INFO, "Private School page loaded");
		Base.takeScreenShot();
		return element.isDisplayed(schoolReviewGrid);
	}
	public void verifyMyInfoPageLoad() throws InterruptedException {
		myInfo.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on My Info icon");
		Base.takeScreenShot();
		element.waitVisibility(driver, saveChangesButton, 10);
		Base.extentTest.log(LogStatus.PASS, "My Info page loaded successfully");
		Base.takeScreenShot();
	}
	public void verifySchoolInfoPageLoad() throws InterruptedException {
		schoolInfo.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on School Info icon");
		element.waitVisibility(driver, schoolName, 10);
		Base.takeScreenShot();
	}
	public void verifyFinancePageLoad() throws InterruptedException {
		finances.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Finances icon");
		element.waitVisibility(driver, gradeLabel, 10);
		Base.takeScreenShot();

		annualStatementTab.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Annual Statement Tab");
		element.waitVisibility(driver, termSelect, 10);
		Base.takeScreenShot();
	}

	public void verifyMyStudentText(){
		element.waitVisibility(driver, myStudent, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of My Student label");
		Base.takeScreenShot();
	}
	public void verifyNewApplicationText(){
		element.waitVisibility(driver, newApplication, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified presence of New application details");
		Base.takeScreenShot();
	}
	public void verifyAllPageLoad() throws InterruptedException {
		verifyMyStudentText();
		verifyNewApplicationText();
		verifyFinancePageLoad();
		verifySchoolInfoPageLoad();
		verifyMyInfoPageLoad();
	}

	public void verify_entryDateFieldForInitialApplication() throws InterruptedException {
		finances.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Finances icon");
		Thread.sleep(2000);
		Base.takeScreenShot();

		annualStatementTab.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Annual Statement Tab");
		Thread.sleep(5000);
		Base.takeScreenShot();

		Assert.assertTrue(recordListStatusEdit.get(0).getText().length()>0,"Account with status reqired does not exist");

		String name = recordListStatusEdit.get(0).getText();
		extentTest.log(LogStatus.INFO, "Name of the first record with Edit status is :: <b>"+name+"</b>");

		searchBox.sendKeys(name+ Keys.ENTER);
		Thread.sleep(3000);
		Base.takeScreenShot();

		element.waitVisibility(driver, selectedRecordEditButton, 20);
		selectedRecordEditButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on first Edit link");
		Thread.sleep(8000);
		Base.takeScreenShot();

		browserDriver.scrollToElement(driver,entryDateXbutton);
		extentTest.log(LogStatus.INFO, "Scrolled to Entry Date element");
		Base.takeScreenShot();

		Actions act = new Actions(driver);
		act.moveToElement(entryDateXbutton).click().build().perform();
		extentTest.log(LogStatus.INFO, "Removed Date from the Date Entry text field");
		Base.takeScreenShot();


		saveChangesButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on <b>Save changes</b> button");
		Base.takeScreenShot();

		Assert.assertTrue(blankDateErrorMsg.isDisplayed());
		String blankDateErrMsg = blankDateErrorMsg.getText();
		extentTest.log(LogStatus.INFO, "Error message displayed while entering blank date is :: <b>"+blankDateErrMsg+"</b>");
		Base.takeScreenShot();
		Thread.sleep(5000);

	//	act.moveToElement(calenderIcon).click().build().perform();
		selectDateFromCalender("10");
		extentTest.log(LogStatus.INFO, "Added new date to Entry date successfully");
		Base.takeScreenShot();

		Assert.assertTrue(saveChangesButton.isDisplayed());
		extentTest.log(LogStatus.INFO, "<b>Save changes</b> button is displayed");
		saveChangesButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on <b>Save changes</b> button");
		Base.takeScreenShot();
		Thread.sleep(5000);

		//changing the correct date
		selectDateFromCalender("5");
		extentTest.log(LogStatus.INFO, "Edited the date successfully");
		Base.takeScreenShot();

		Assert.assertTrue(saveChangesButton.isDisplayed());
		extentTest.log(LogStatus.INFO, "<b>Save changes</b> button is displayed");
		saveChangesButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on <b>Save changes</b> button");
		Thread.sleep(2000);
		Base.takeScreenShot();
	}


	public void selectDateFromCalender(String theDate) throws InterruptedException {
		calenderIcon.click();
		extentTest.log(LogStatus.PASS, "Clicked on Calender icon");
		Base.takeScreenShot();

		String xpath = String.format(xpathFormat, theDate);
		Thread.sleep(3000);
		WebElement calenderDate = driver.findElement(By.xpath(xpath));

		calenderDate.click();
		extentTest.log(LogStatus.PASS, "Selected date from the calender is "+ theDate);
		Base.takeScreenShot();
		Thread.sleep(1000);
	}

	public void verify_school_homepage_icons() throws InterruptedException {
		Thread.sleep(5000);
		homepage_logo_icon();
		students_icon();
		finances_icon();
		schoolInfo_icon();
		myinfo_icon();
		logout_icon();
	}

	public void homepage_logo_icon(){
		element.waitVisibility(driver, logo, 15);
		String logo_data_name = logo.getAttribute("data-name");
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar logo on Parent homepage as "+logo_data_name);
		Base.takeScreenShot();
	}

	public void students_icon(){
		element.waitVisibility(driver, students, 15);
		String students_icon = students.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>students icon</b> on School homepage as "+students_icon);
		Base.takeScreenShot();
	}

	public void finances_icon(){
		element.waitVisibility(driver, finances, 15);
		String finances_icon = finances.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>finances icon</b> on School homepage as "+finances_icon);
		Base.takeScreenShot();
	}

	public void schoolInfo_icon(){
		element.waitVisibility(driver, schoolInfo, 15);
		String schoolInfo_icon = schoolInfo.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>school info icon</b> on Parent homepage as "+schoolInfo_icon);
		Base.takeScreenShot();
	}

	public void myinfo_icon(){
		element.waitVisibility(driver, myInfo, 15);
		String myinfo_icon = myInfo.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>my info icon</b>  on Parent homepage as "+myinfo_icon);
		Base.takeScreenShot();
	}

	public void logout_icon(){
		element.waitVisibility(driver, logoutbutton, 15);
		String logout_icon = logoutbutton.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified Scholar <b>logout icon</b>  on Parent homepage as "+logout_icon);
		Base.takeScreenShot();
	}

	public void logout() throws InterruptedException {
		element.waitVisibility(driver, logoutbutton, 15);
		element.clickByJs(driver, logoutbutton);
		driver.navigate().refresh();
		Thread.sleep(3000);
		Base.extentTest.log(LogStatus.PASS, "Log out button is clicked");
		Base.takeScreenShot();
	}
	public void verify_VerifyStatusActionsEditApplication() throws InterruptedException {
		finances.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Finances icon");
		Thread.sleep(2000);
		Base.takeScreenShot();

		annualStatementTab.click();
		Base.extentTest.log(LogStatus.PASS, "Clicked on Annual Statement Tab");
		Thread.sleep(5000);
		Base.takeScreenShot();

		String name = recordListStatusEdit.get(0).getText();
		extentTest.log(LogStatus.INFO, "Name of the first record with Edit status is :: <b>"+name+"</b>");

		searchBox.sendKeys(name+ Keys.ENTER);
		Thread.sleep(3000);
		Base.takeScreenShot();

		element.waitVisibility(driver, selectedRecordEditButton, 20);
		selectedRecordEditButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on first Edit link");
		Thread.sleep(8000);
		Base.takeScreenShot();

		element.waitVisibility(driver, status, 20);
		Assert.assertTrue(status.isDisplayed());
		Base.takeScreenShot();

		element.waitVisibility(driver, submittedOn, 20);
		Assert.assertTrue(submittedOn.isDisplayed());
		Base.takeScreenShot();

		element.waitVisibility(driver, SubmittedBy, 20);
		Assert.assertTrue(SubmittedBy.isDisplayed());
		Base.takeScreenShot();

		element.waitVisibility(driver, StatementDate, 20);
		Assert.assertTrue(StudentName.isDisplayed());
		Base.takeScreenShot();

		element.waitVisibility(driver, StatementDate, 20);
		Assert.assertTrue(StudentDOB.isDisplayed());
		Base.takeScreenShot();

		element.waitVisibility(driver, StudentDOB, 20);
		Assert.assertTrue(StatementDate.isDisplayed());
		Base.takeScreenShot();

		element.waitVisibility(driver,  ParentGuardianName, 20);
		Assert.assertTrue(ParentGuardianName.isDisplayed());
		Base.takeScreenShot();

		browserDriver.scrollToElement(driver,entryDateXbutton);
		extentTest.log(LogStatus.INFO, "Scrolled to Entry Date element");
		Base.takeScreenShot();

		Actions act = new Actions(driver);
		act.moveToElement(entryDateXbutton).click().build().perform();
		extentTest.log(LogStatus.INFO, "Removed Date from the Date Entry text field");
		Base.takeScreenShot();

		saveChangesButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on <b>Save changes</b> button");
		Base.takeScreenShot();

		Assert.assertTrue(blankDateErrorMsg.isDisplayed());
		String blankDateErrMsg = blankDateErrorMsg.getText();
		extentTest.log(LogStatus.INFO, "Error message displayed while entering blank date is :: <b>"+blankDateErrMsg+"</b>");
		Base.takeScreenShot();
		Thread.sleep(5000);

		selectDateFromCalender("10");
		extentTest.log(LogStatus.INFO, "Added new date to Entry date successfully");
		Base.takeScreenShot();

		Assert.assertTrue(saveChangesButton.isDisplayed());
		extentTest.log(LogStatus.INFO, "<b>Save changes</b> button is displayed");
		saveChangesButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on <b>Save changes</b> button");
		Base.takeScreenShot();
		Thread.sleep(5000);

		selectDateFromCalender("5");
		extentTest.log(LogStatus.INFO, "Edited the date successfully");
		Base.takeScreenShot();

		Assert.assertTrue(saveChangesButton.isDisplayed());
		extentTest.log(LogStatus.INFO, "<b>Save changes</b> button is displayed");
		saveChangesButton.click();
		extentTest.log(LogStatus.INFO, "Clicked on <b>Save changes</b> button");
		Thread.sleep(2000);
		Base.takeScreenShot();
	}

}
