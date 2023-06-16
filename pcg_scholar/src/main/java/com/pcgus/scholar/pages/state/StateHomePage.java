package com.pcgus.scholar.pages.state;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StateHomePage extends Base {

		WebDriver driver;
		Element element;
		BrowserDriver browserDriver = new BrowserDriver();
		Base base = new Base();
		JSWaiter jSWaiter = new JSWaiter();
		private static Logger logger = LogManager.getLogger(StateHomePage.class.getName());

		@FindBy(xpath = "//*[@id='nav-bar']/ul/li[1]")
		WebElement applicationbutton;

		@FindBy(xpath = "//label[text()[contains(.,'Status')]]")
		WebElement statusbutton;
		
		@FindBy(xpath = "//*[@id='applications-scholarship-component']//span[1]/a")
		WebElement student;

		@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
		private WebElement logoutbutton;
		
		@FindBy(xpath = "//div[@class='student-info-grid']//label[text()[contains(., 'First Name:')]]")
		private WebElement firstname;

		@FindBy(xpath = "//div[@class='student-info-grid']//label[text()[contains(., 'First Name:')]]/input")
		private WebElement firstnameValue;

		@FindBy(xpath = "//*/tbody[@class='MuiTableBody-root css-1xnox0e']/tr[1]/th[4]")
		private WebElement studentfirstname;

		@FindBy(xpath = "//*/tbody[@class='MuiTableBody-root css-1xnox0e']/tr[1]/th[8]")
		private WebElement appType;

		@FindBy(xpath = "//input[@placeholder='Search']")
		private WebElement searchBox;

		@FindBy(xpath = "//button[@class='actions-button tertiary']")
		private WebElement userActionButton;

		@FindBy(xpath = "//textarea[@aria-required='true']")
		private WebElement textAreaStatusChange;

		@FindBy(xpath = "//button[text()='Update Status']")
		private WebElement updateStatusButton;

		@FindBy(xpath = "//span[@class='status-component']")
		private WebElement statusValue;

		@FindBy(xpath = "//div[normalize-space()='Edit Status']")
		private WebElement editStatusAction;

		@FindBy(xpath = "//div[text()='Select...']")
		private WebElement dropdownOnEditStatus;

		@FindBy(xpath = "//tbody/tr[1]/th[3]/p")
		private WebElement stuLastName;

		@FindBy(xpath = "//button[contains(text(),'Actions')]")
		WebElement ActionsButton;

		@FindBy(xpath = "//div[contains(text(),'View history')]")
		WebElement viewHistoryLink;

		@FindBy(xpath = "//h2[contains(text(),'System history')]")
		WebElement systemHistory;

		@FindBy(xpath = "//span[text()[contains(.,'Applications')]]")
		WebElement applicationsIcon;

		@FindBy(xpath = "//h1[normalize-space()='Applications.']")
		WebElement applicationsHeading;

		@FindBy(xpath = "(//div[@id='termSelect'])[1]")
		WebElement termSelectDropDown;

		@FindBy(xpath = "(//div[@id='termSelect'])[4]")
		WebElement applicationStatus;

		@FindBy(xpath = "//*[name()='circle' and contains(@class,'MuiCircula')]")
		WebElement loadingIcon;

		@FindBy(xpath = "//tbody/tr[2]")
		WebElement applicationsTableFirstRow;

		@FindBy(xpath = "//tbody/tr[1]/th[4]//p")
		WebElement firstUserApplications;

		@FindBy(xpath = "(//div[@id='termSelect'])[3]")
		WebElement privateSchoolDropdown;

		@FindBy(xpath = "//ul[@role='listbox']")
		WebElement ulDropdown;

		@FindBy(xpath = "//span[text()[contains(.,'Students')]]")
		WebElement studentsIcon;

		@FindBy(xpath = "//span[normalize-space()='My']")
		WebElement studentsHeading;

		@FindBy(xpath = "//div[text()[contains(.,'Loading')]]")
		WebElement loadingIconEnroll;

		@FindBy(xpath = "//div[contains(@class,'current-roster-grid grid-container')]//span[contains(@class,'max-page-display')]")
		WebElement maxSearchResultPage;

		@FindBy(xpath = "//div[@class='current-roster-grid grid-container']//button[@colname=\"StudentName\"]")
		List<WebElement> studentNameList;

		@FindBy(xpath = "//div[contains(@class,'current-roster')]/div[contains(@class,'page')]/button[@class='next-page-button']")
		WebElement nextButtonPage;



	@FindBy(xpath = "//label[text()[contains(.,'Exit date')]]")
	WebElement schoolExitDate;

	@FindBy(xpath = "//label[text()[contains(.,'Entry date')]]")
	WebElement schoolEntryDate;

	@FindBy(xpath = "//label[text()[contains(.,'Entering school')]]")
	WebElement enteringSchoolLabel;

	@FindBy(xpath = "(//select[contains(@id,'labeled-select-id')])[3]")
	WebElement enteringSchoolDropdown;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[contains(text(),'Incomplete required fields, please review, correct')]")
	WebElement incompleteRequiredFieldsPopup;

	@FindBy(xpath = "(//input[@placeholder='mm'])[1]")
	WebElement exitDateMonth;

	@FindBy(xpath = "(//input[@placeholder='dd'])[1]")
	WebElement exitDateDate;

	@FindBy(xpath = "(//input[@placeholder='yyyy'])[1]")
	WebElement exitDateYear;

	@FindBy(xpath = "(//input[@placeholder='mm'])[2]")
	WebElement entryDateMonth;

	@FindBy(xpath = "(//input[@placeholder='mm'])[2]")
	WebElement entryDateDate;

	@FindBy(xpath = "(//input[@placeholder='mm'])[2]")
	WebElement entryDateYear;

	@FindBy(xpath = "//button[@class='actions-button tertiary']")
	WebElement actionButtonApplications;

	@FindBy(xpath = "//tbody/tr[1]/th[3]")
	WebElement lastNameUserApplication;

	@FindBy(xpath = "//div[normalize-space()='Change enrollment']")
	WebElement changeEnrollment;

	@FindBy(xpath = "//button[@class=\"change-enrollment-button primary\"][normalize-space()='Add enrollment change']")
	WebElement addEnrollmentChangeButton;

	@FindBy(xpath = "//select[contains(@id,'labeled-select-id')]")
	WebElement changeReasonDropdown;

	@FindBy(xpath = "//option[@value='3']")
	WebElement schoolTransferReason;

	@FindBy(xpath = "//label[text()[contains(.,'Exiting school')]]")
	WebElement exitingSchoolLabel;

	@FindBy(xpath = "//span[normalize-space()='Transfer to new school']")
	WebElement enrollmentHistoryTableReason;

	@FindBy(xpath = "//button[@class='back-button button-link']")
	WebElement backToApplicationButton;

	@FindBy(xpath = "//button[@class='save-button primary']")
	WebElement saveChangesButton;

	@FindBy(xpath = "//div[contains(text(),'Changes saved.')]")
	WebElement saveChangedPopup;


	public void StateHomePageDriverRef(WebDriver driver) {
			this.driver = driver;
			AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
			PageFactory.initElements(factory, this);
			element = new Element(driver);
			JSWaiter.setDriver(driver);
	}

	public boolean verifyApplicationExists(){
		boolean flag = false;
		element.waitVisibility(driver, firstUserApplications, 15);
		try {
			String StudentName = firstUserApplications.getText() + " " + lastNameUserApplication.getText();
			Base.extentTest.log(LogStatus.INFO, "Applications Exists and Student Name from applications list. Student Name :"+StudentName);
			Base.takeScreenShot();
			flag = true;
		}
		catch (NoSuchElementException e){
			Assert.fail("Application list is empty");
			Base.extentTest.log(LogStatus.INFO, "No application is present.");
			Base.takeScreenShot();
		}
		return flag;
	}


	public String changeEnrollmentOfStudent (String schoolNameToSelect) throws InterruptedException{
		element.waitVisibility(driver, firstUserApplications, 15);
		String StudentName= firstUserApplications.getText() + " " +lastNameUserApplication.getText();
		firstUserApplications.click();
		Base.extentTest.log(LogStatus.INFO, "Click on Student Name from applications list. Student Name :"+StudentName);
		Base.takeScreenShot();
		element.waitVisibility(driver, actionButtonApplications, 15);
		actionButtonApplications.click();
		Base.extentTest.log(LogStatus.INFO, "Click on ACTIONS button");
		Base.takeScreenShot();
		element.waitVisibility(driver, changeEnrollment, 15);
		changeEnrollment.click();
		Base.extentTest.log(LogStatus.INFO, "Clicked  on Change Enrollment");
		Base.takeScreenShot();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(loadingIconEnroll));

		element.waitVisibility(driver, addEnrollmentChangeButton, 15);
		addEnrollmentChangeButton.click();
		Base.extentTest.log(LogStatus.INFO, "Clicked  on Add Enrollment change button");
		Base.takeScreenShot();
		element.waitVisibility(driver, changeReasonDropdown, 15);
		changeReasonDropdown.click();
		Base.extentTest.log(LogStatus.INFO, "Clicked  on change reason dropdown");
		Base.takeScreenShot();
		Select dropdownReason = new Select(changeReasonDropdown);
		dropdownReason.selectByValue("3");
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();

//        element.waitVisibility(driver, schoolTransferReason, 15);
//        schoolTransferReason.click();
		Base.extentTest.log(LogStatus.INFO, "Selected school transfer");
		Base.takeScreenShot();
		element.waitVisibility(driver, exitingSchoolLabel, 15);
		Base.extentTest.log(LogStatus.INFO, "Student current school field is visible");
		Base.takeScreenShot();
		element.waitVisibility(driver, schoolExitDate, 15);
		Base.extentTest.log(LogStatus.INFO, "Exit date field is visible");
		Base.takeScreenShot();
		element.waitVisibility(driver, schoolEntryDate, 15);
		Base.extentTest.log(LogStatus.INFO, "Entry date field is visible");
		Base.takeScreenShot();
		element.waitVisibility(driver, enteringSchoolLabel, 15);
		Base.extentTest.log(LogStatus.INFO, "Entering school field is visible");
		Base.takeScreenShot();

		Select dropdown = new Select(enteringSchoolDropdown);
		// Selecting specific school due to login with that school to complete TC
		dropdown.selectByVisibleText(schoolNameToSelect);
		Base.extentTest.log(LogStatus.INFO, "Entering school name selected"+enteringSchoolDropdown.getText());
		Base.takeScreenShot();
		saveButton.click();
		Base.extentTest.log(LogStatus.INFO, "Clicked on save button");
		Base.takeScreenShot();
		element.waitVisibility(driver, incompleteRequiredFieldsPopup, 15);
		Base.extentTest.log(LogStatus.INFO, "Incomplete required fields, please review, correct Popup displayed");
		Base.takeScreenShot();

		LocalDate currentDate = LocalDate.now();
		String currentMonth = currentDate.format(DateTimeFormatter.ofPattern("MM"));
		String currentDay = currentDate.format(DateTimeFormatter.ofPattern("dd"));
		String currentYear = currentDate.format(DateTimeFormatter.ofPattern("yyyy"));

		exitDateMonth.sendKeys(currentMonth);
		exitDateDate.sendKeys(currentDay);
		exitDateYear.sendKeys(currentYear);
		Base.extentTest.log(LogStatus.INFO, "Successfully entered current system date in exit date field :"+ currentDay + "-"+currentMonth+ "-"+currentYear);
		Base.takeScreenShot();

		entryDateMonth.sendKeys(currentMonth);
		entryDateDate.sendKeys(currentDay);
		entryDateYear.sendKeys(currentYear);
		Base.extentTest.log(LogStatus.INFO, "Successfully entered current system date in entry date field:"+ currentDay + "-"+currentMonth+ "-"+currentYear);
		Base.takeScreenShot();

		saveButton.click();
		Base.extentTest.log(LogStatus.INFO, "Clicked on save button");
		Base.takeScreenShot();

		element.waitVisibility(driver, enrollmentHistoryTableReason, 25);
		Base.extentTest.log(LogStatus.INFO, "Enrollment history table is visible. Reason :"+ enrollmentHistoryTableReason.getText());
		Base.takeScreenShot();

		Thread.sleep(10000);
		element.waitVisibility(driver, backToApplicationButton, 15);
		backToApplicationButton.click();
		Base.extentTest.log(LogStatus.INFO, "Click on back to application button");
		Base.takeScreenShot();

		element.waitVisibility(driver, actionButtonApplications, 25);
		saveChangesButton.click();
		Base.extentTest.log(LogStatus.INFO, "Clicked on save changes button");
		Base.takeScreenShot();

		element.waitVisibility(driver, saveChangedPopup, 25);
		Base.extentTest.log(LogStatus.INFO, "Changes saved and popup displayed.");
		Base.takeScreenShot();
		return StudentName;
	}


	public boolean verifyStudentNameExists(String name){
		boolean flagName = false;
		String maxPage = maxSearchResultPage.getText();
		int maxNumPage = Integer.parseInt(maxPage);
		for (int i=1;i<maxNumPage;i++){
			List<WebElement> allUserTypeList = studentNameList;
			for (WebElement element :  allUserTypeList){
				if (element.getText().equals(name)){
					flagName = true;
					Base.extentTest.log(LogStatus.PASS, "Student name exist on Page Number "+ i);
					Base.takeScreenShot();
				}
			}
			Base.extentTest.log(LogStatus.PASS, "Checked the Student Name on Page Number "+ i);
			Base.takeScreenShot();
			browserDriver.scrollToElement(driver, nextButtonPage);
			nextButtonPage.click();
		}
		return flagName;
	}


	public void clickOnStudentsIcon(){
		element.waitVisibility(driver, studentsIcon, 15);
		studentsIcon.click();
		element.waitVisibility(driver, studentsHeading, 15);
		Base.extentTest.log(LogStatus.INFO, "Successfully landed on students page");
		Base.takeScreenShot();
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center', inline: 'center' });", element);
	}

	public void selectPrivateSchool(String schoolName) throws InterruptedException{
		element.waitVisibility(driver, firstUserApplications, 15);
		// Locate the ul dropdown element
		privateSchoolDropdown.click();
		WebElement dropdownElement = ulDropdown;
		String xpathExpression = String.format("//li[normalize-space()='%s']", schoolName);
		WebElement listItemElement = dropdownElement.findElement(By.xpath(xpathExpression));
		scrollToElement(driver, listItemElement);
		Thread.sleep(1000);
		listItemElement.click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).perform();
		Base.extentTest.log(LogStatus.INFO, "Successfully selected the private school. School Name :"+ schoolName);
		Base.takeScreenShot();
	}
	public boolean applicationsList(){
		boolean bool = false;
		try {
			element.waitVisibility(driver, applicationsTableFirstRow, 15);
			Base.extentTest.log(LogStatus.INFO, "Applications list displayed");
			Base.takeScreenShot();
			bool = true;
		} catch (Exception e){
			Base.extentTest.log(LogStatus.INFO, "Applications list is empty kindly use different account");
			Base.takeScreenShot();
		}
		return bool;
	}

		public void selectApplicationStatus(String status) throws InterruptedException{
			element.waitVisibility(driver, applicationStatus, 15);
			applicationStatus.click();
			Thread.sleep(1000);
			String xpathExpression = String.format("//li[normalize-space()='%s']", status);
			driver.findElement(By.xpath(xpathExpression)).click();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE).perform();
			Base.extentTest.log(LogStatus.INFO, "Successfully selected appliction status :"+ status);
			Base.takeScreenShot();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.invisibilityOf(loadingIcon));
			logger.info("accepted selected");
		}

		public void termSelect(String yearRange){
			element.waitVisibility(driver, termSelectDropDown, 15);
			termSelectDropDown.click();
			String xpathExpression = String.format("//li[normalize-space()='%s']", yearRange);
			driver.findElement(By.xpath(xpathExpression)).click();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE).perform();
			Base.extentTest.log(LogStatus.INFO, "Successfully selected term year range :"+ yearRange);
			Base.takeScreenShot();
			logger.info("term selected");
		}

		public void clickOnApplicationsIcon(){
			element.waitVisibility(driver, applicationsIcon, 15);
			applicationsIcon.click();
			element.waitVisibility(driver, applicationsHeading, 15);
			Base.extentTest.log(LogStatus.INFO, "Successfully landed on applications page");
			Base.takeScreenShot();
		}
		public void clickViewHistoryLink() throws InterruptedException {
			browserDriver.scrollToElement(driver, viewHistoryLink);
			element.waitVisibility(driver, viewHistoryLink, 15);
			viewHistoryLink.click();
			Base.extentTest.log(LogStatus.PASS, "View History Link is clicked");
			Thread.sleep(5000);
			takeScreenShot();

			Assert.assertTrue(systemHistory.getText().contains("System history for "),"History section is not present after clicking on <b>view history</b> button");
			Base.extentTest.log(LogStatus.PASS, "Modal displays with history view on the right side of the page");
		}
		public void selectAnyStudentApplication() throws InterruptedException {
			Thread.sleep(10000);
			element.waitVisibility(driver, stuLastName, 15);
			element.click(driver, stuLastName);
			Base.extentTest.log(LogStatus.PASS, "First student from the list is selected");
			Thread.sleep(15000);
			takeScreenShot();
		}

		public void clickActionsButton(){
			browserDriver.scrollToElement(driver, ActionsButton);
			element.waitVisibility(driver, ActionsButton, 15);
			ActionsButton.click();
			Base.extentTest.log(LogStatus.PASS, "Select Actions button is clicked");
			takeScreenShot();
		}
		public void logout(){
			element.waitVisibility(driver, logoutbutton, 10);
			element.click(driver, logoutbutton);
			Base.extentTest.log(LogStatus.PASS, "Log out button is clicked");
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
			element.waitVisibleBy(driver, By.xpath("//div[text()='"+value+"']"), 20);
			Base.extentTest.log(LogStatus.PASS, "Selected new status for dropdown as "+value);
			Base.takeScreenShot();

			driver.findElement(By.xpath("//*[contains(text(),'"+value+"')]")).click();
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

		public void searchUser(String value) throws InterruptedException{
			element.waitVisibility(driver, searchBox, 20);
			element.sendKeys(searchBox,value);
			element.waitVisibleBy(driver, By.xpath("//p[normalize-space()='"+value+"']"), 20);
			Base.extentTest.log(LogStatus.PASS, "Searched with user name: "+value);
			Base.takeScreenShot();
		}

		public void verifyApplicationReturnedToParent(String value) throws InterruptedException {
			Thread.sleep(5000);
			Base.takeScreenShot();
			element.waitVisibility(driver, studentfirstname, 20);
			searchUser(value);

			element.click(driver, studentfirstname);
			element.waitVisibility(driver, userActionButton, 20);
			Base.extentTest.log(LogStatus.PASS, "Clicked on searched user: "+value);
			Base.takeScreenShot();

			editStatusAction("Returned to Parent");
		}

		public void selectFirstRowAnsValidateData() throws InterruptedException {

			driver.navigate().refresh();
			element.waitVisibility(driver, studentfirstname, 20);

			Thread.sleep(10000);
			appType.click();

			Thread.sleep(1000);
			logger.info("Student row is selected");
			Base.extentTest.log(LogStatus.PASS, "Student row is selected");
			Base.takeScreenShot();

			element.waitVisibility(driver, studentfirstname, 20);
			String nameTBV = studentfirstname.getText();
			String fname = String.format("//p[text()[contains(., '%s')]]",nameTBV);

			driver.findElement(By.xpath(fname)).click();
			logger.info("Student is clicked");
			Base.extentTest.log(LogStatus.PASS, "Student is clicked");
			Thread.sleep(12000);
			Base.takeScreenShot();

			element.waitVisibility(driver, firstname, 30);

			Base.extentTest.log(LogStatus.PASS, "Expected value is <b>"+ firstnameValue.getAttribute("value")+"</b> and actual value is <b>"+nameTBV+"</b>");
			Assert.assertTrue(firstnameValue.getAttribute("value").equalsIgnoreCase(nameTBV));
			logger.info("Student Data is displayed accurately");
			Base.extentTest.log(LogStatus.PASS, "Student Data is displayed accurately");
			Base.takeScreenShot();
		}


		public void verifyhomepage() throws InterruptedException {

			element.waitVisibility(driver, applicationbutton, 20);
			Assert.assertTrue(applicationbutton.isDisplayed());
			logger.info("application button is displayed");
			Base.extentTest.log(LogStatus.PASS, "application button is displayed");
			Base.takeScreenShot();
			element.clickByJs(driver, applicationbutton);
			logger.info("clicked on applications button");
			Base.extentTest.log(LogStatus.PASS, "clicked on applications button");
			Base.takeScreenShot();
			element.waitVisibility(driver, statusbutton, 20);
			Assert.assertTrue(statusbutton.isDisplayed());
			logger.info("status button is displayed");
			Base.extentTest.log(LogStatus.PASS, "status button is displayed");
			Base.takeScreenShot();

			Thread.sleep(15000);
			element.waitVisibility(driver, student, 20);
			Assert.assertTrue(student.isDisplayed());
			logger.info("student name is displayed");
			Base.extentTest.log(LogStatus.PASS, "student name is displayed");
			Base.takeScreenShot();
			element.clickByJs(driver, student);
			logger.info("clicked on student");
			Base.extentTest.log(LogStatus.PASS, "clicked on student");
			Base.takeScreenShot();

			Thread.sleep(10000);
			element.waitVisibility(driver, firstname, 20);
			Assert.assertTrue(firstname.isDisplayed());
			logger.info("firstname name is displayed");
			Base.extentTest.log(LogStatus.PASS, "firstname name is displayed");
			Base.takeScreenShot();
		}


		@FindBy(xpath = "//tr[1]/th/span[@role='button']")
		List<WebElement> colHeaders;
    public void VerifyColumnsHeaders(String[] columns) throws InterruptedException {
		base.waitForElement(colHeaders.get(0));
		Thread.sleep(5000);
		List<String> actualList = colHeaders.stream().map(e -> e.getText().trim()).collect(Collectors.toList());
		for(int i = 0; i < columns.length; i++){
			boolean bool = false;
			int j = 0;
			for(j = 0; i<actualList.size(); j++){
				if(actualList.get(j).contains(columns[i])) {
					bool = true;
					break;
				}
			}
			if(bool)
				extentTest.log(LogStatus.PASS, "Actual Result ::" +actualList.get(j)+" Expected Result :: "+columns[i]);
			else
				extentTest.log(LogStatus.FAIL, "Actual Result ::" +actualList.get(j)+" Expected Result :: "+columns[i]);
		}
		Base.takeScreenShot();
    }

	String xpath = "//tbody/tr[1]/th[count(//th/span[@role='button' and text()='%S']/../preceding-sibling::th) + 1]//p";
	public HashMap<String, String> getUserData() {
		String[] columns = {"ID","Last Name","First Name","Term","DOB","Private School","Type","Username","Status"};
		HashMap<String, String> map = new HashMap<>();
		for(String column:columns){
			System.out.println(column +" :: " +driver.findElement(By.xpath(xpath.replace("%S",column))).getText());
			map.put(column, driver.findElement(By.xpath(xpath.replace("%S",column))).getText());
		}
		driver.findElement(By.xpath(xpath.replace("%S","Last Name"))).click();
		return map;
	}

	@FindBy(xpath = "//h2[@class='record-view-title']")
	WebElement id;

	@FindBy(xpath = "//input[@data-form-key='sectionA.studentFirstName']")
	WebElement firstName;

	@FindBy(xpath = "//input[@data-form-key='sectionA.studentLastName']")
	WebElement lastName;

	@FindBy(xpath = "//input[@aria-label='DOB:']")
	WebElement dob;

	@FindBy(xpath = "//span[@class='status-component']")
	WebElement status;

	@FindBy(xpath = "//label[text()='Private School:']/select")
	WebElement school;

	@FindBy(xpath = "//div[text()='Application Type']/following-sibling::div")
	WebElement type;

	public void compareUserdata(HashMap<String, String> tabledata) throws InterruptedException {
		base.waitForElement(firstName);
		Assert.assertTrue(id.getText().contains(tabledata.get("ID")));
		extentTest.log(LogStatus.INFO,"ID Table Page ::"+id.getText()+"Detail Page ::"+tabledata.get("ID"));
		Assert.assertTrue(status.getText().contains(tabledata.get("Status")));
		extentTest.log(LogStatus.INFO,"STATUS Table Page ::"+status.getText()+"Detail Page ::"+tabledata.get("Status"));
		Assert.assertTrue(lastName.getAttribute("value").equals(tabledata.get("Last Name")));
		extentTest.log(LogStatus.INFO,"Last Name Table Page ::"+lastName.getAttribute("value")+"Detail Page ::"+tabledata.get("Last Name"));
		Assert.assertTrue(firstName.getAttribute("value").equals(tabledata.get("First Name")));
		extentTest.log(LogStatus.INFO,"First Name Table Page ::"+firstName.getAttribute("value")+"Detail Page ::"+tabledata.get("First Name"));
		Assert.assertTrue(type.getText().contains(tabledata.get("Type")));
		extentTest.log(LogStatus.INFO,"ID Table Page ::"+type.getText()+"Detail Page ::"+tabledata.get("Type"));
		base.takeScreenShot();
		String[] tabledate = tabledata.get("DOB").split("/");
		String[] detaildate = dob.getAttribute("value").split("-");
		Assert.assertTrue(tabledate[2].contains(detaildate[0]));
		Assert.assertTrue(tabledate[1].contains(detaildate[2]));
		Assert.assertTrue(tabledate[0].contains(detaildate[1]));
		extentTest.log(LogStatus.INFO,"ID Table Page ::"+dob.getAttribute("value")+"Detail Page ::"+tabledata.get("DOB"));
		base.mouseHoverJScript(school);
		Assert.assertTrue(element.getFirstOptionValue(school).trim().contains(tabledata.get("Private School").trim()));
		extentTest.log(LogStatus.INFO,"ID Table Page ::"+element.getFirstOptionValue(school).trim()+"Detail Page ::"+tabledata.get("Private School"));

	}
}


