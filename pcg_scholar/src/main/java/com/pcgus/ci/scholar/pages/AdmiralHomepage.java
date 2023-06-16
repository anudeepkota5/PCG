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
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AdmiralHomepage extends Base {

	WebDriver driver;
	Element element;
	CreateApplicationPage createAppPage;
	BrowserDriver browserDriver = new BrowserDriver();
	MyInfoPage myInfoPage;
	AdmiralHomepage admiralHomepage;

	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(AdmiralHomepage.class.getName());

	@FindBy(css = "h1:nth-child(1) > svg:nth-child(1)")
	private WebElement logo;

	@FindBy(xpath = "//li[@class='selected']/span[contains(text(),'Students')]")
	WebElement students;

	@FindBy(xpath = "//span[contains(text(),'Site Settings')]")
	private WebElement siteSettings;

	@FindBy(xpath = "//span[contains(text(),'My Info')]")
	private WebElement myInfo;

	@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
	private WebElement logoutbutton;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTextBox;

	@FindBy(xpath = "//span[@colname='Name']/span/a")
	WebElement searchedUser;

	@FindBy(xpath="//div[text()[contains(.,'Users')]]")
	WebElement usersTab;

	@FindBy(xpath="//div[@class='user-type-selector__indicators css-1wy0on6']")
	WebElement usersTypeDropDownArrow;

	@FindBy(xpath="//*[@id='Path-3']")
	WebElement selectValue;

	@FindBy(xpath="//div[@class='user-type-selector__control css-13cymwt-control")
	WebElement usersTypeDropDown;

	@FindBy(xpath="//button[contains(text(),'Save changes')]")
	WebElement saveChangesButton;

	@FindBy(xpath="//span[contains(text(),'%s')]")
	WebElement selectItem;

	@FindBy(xpath="//div[text()='Private Schools']")
	WebElement privateSchoolsTab;

	@FindBy(xpath="//div[text()='My Organization']")
	WebElement myOrganizationTab;

	@FindBy(xpath = "//button[@class='next-page-button']")
	WebElement nextPageButton;

	@FindBy(xpath = "//button[@class='next-page-button'][@disabled]")
	WebElement nextPageButtonDisabled;

	@FindBy(xpath = "//span[@colname='UserType']//span")
	private List<WebElement> userTypeList;

	@FindBy(xpath = "//span[@colname='UserType']/div[1]")
	private List<WebElement> userTypeColorList;

	@FindBy(xpath = "//div[@class='page-buttons-container']/span[3]")
	WebElement numberOfPages;

	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchBox;

	@FindBy(xpath="//*[@id='client-picker']")
	WebElement siteDropDown;

	@FindBy(xpath="//div[contains(text(),'Name')]")
	WebElement headerName;

	@FindBy(xpath="//div[contains(text(),'Phone Number')]")
	WebElement headerPhoneNumber;

	@FindBy(xpath="//div[contains(text(),'Email Address')]")
	WebElement headerEmailAddress;

	@FindBy(xpath="//div[contains(text(),'User Type')]")
	WebElement headerUserType;

	@FindBy(xpath="//div[contains(text(),'Last Updated')]")
	WebElement headerLastUpdated;

	@FindBy(xpath = "//*[contains(@href,'/sitesettings/user')]")
	private List<WebElement> nameList;

	@FindBy(xpath = "//span[@colname='PhoneNumber']/span")
	private List<WebElement> phoneNumberList;

	@FindBy(xpath = "//span[@colname='EmailAddress']")
	private List<WebElement> emailAddressList;

	@FindBy(xpath = "//span[@colname='LastUpdated']/div")
	private List<WebElement> lastUpdatedList;

	@FindBy(xpath = "//label[normalize-space()='First name']/input")
	WebElement firstName;

	@FindBy(xpath = "//label[normalize-space()='Last name']/input")
	WebElement lastName;

	@FindBy(xpath = "//label[normalize-space()='Created date']/input")
	WebElement createdDate;

	@FindBy(xpath = "//label[normalize-space()='Last updated date']/input")
	WebElement lastUpdatedDate;

	@FindBy(xpath = "//label[normalize-space()='Phone number']/input")
	WebElement phoneNo;

	@FindBy(xpath = "//label[normalize-space()='Email address']/input")
	WebElement emailId;

	@FindBy(xpath = "//span[contains(text(),'Parent')]")
	WebElement userType;

	@FindBy(xpath = "//button[normalize-space()='Back to all users']")
	WebElement backToAllUsers;

	@FindBy(xpath = "//span[normalize-space()='ID']")
	WebElement idStudentAssociation;

	@FindBy(xpath = "//button[@class='prev-page-button']")
	WebElement prevPageButton;

	@FindBy(xpath = "//button[@class='prev-page-button'][@disabled]")
	WebElement prevPageButtonDisabled;

	@FindBy(xpath = "//span[@colname='Name']/span")
	List<WebElement> getNameList;

	@FindBy(xpath = "//span[@colname='PhoneNumber']/span")
	List<WebElement> getPhoneNumberList;

	@FindBy(xpath = "//span[@colname='EmailAddress']")
	List<WebElement> getEmailAddressListcol;

	@FindBy(xpath = "//label[text()='Status']/select")
	WebElement userStatus;


	public void AdmiralHomePageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
		createAppPage = new CreateApplicationPage();
		admiralHomepage = new AdmiralHomepage();
		myInfoPage = new MyInfoPage();
	}

	public void selectUserStatus(String strStatus) throws InterruptedException {
		waitForElement(userStatus);
		element.selectVisibleOption(userStatus, strStatus);
		Base.takeScreenShot();
		Base.extentTest.log(LogStatus.PASS, "User Status Updated to "+strStatus);
	}

	public void clickSaveChanges(){
		saveChangesButton.click();
		logger.info("Clicked on Save Changes Button");
		extentTest.log(LogStatus.PASS, "Clicked on Save Changes Button");
		takeScreenShot();
	}

	public void verifySearchByName(String value){
		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();
		element.waitVisibility(driver, nameList.get(0), 15);
		boolean validSearch = false;
		for(int i=0;i<nameList.size();i++){
			String name = nameList.get(i).getText();
			if(name.contains(value)){
				validSearch = true;
			}
			Assert.assertTrue(validSearch);
			Base.extentTest.log(LogStatus.PASS, "User name correctly searched as "+name);
		}
		Base.takeScreenShot();
		element.clear(searchBox);
		element.waitVisibility(driver, nameList.get(0), 15);
	}

	public void verifySearchByPhoneNumber(String value){
		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();
		element.waitVisibility(driver, phoneNumberList.get(0), 15);
		boolean validSearch = false;
		for(int i=0;i<phoneNumberList.size();i++){
			String phoneNumber = phoneNumberList.get(i).getText();
			if(phoneNumber.contains(value)){
				validSearch = true;
			}
			Assert.assertTrue(validSearch);
			Base.extentTest.log(LogStatus.PASS, "Phone Number correctly searched as "+phoneNumber);
		}
		Base.takeScreenShot();
		element.clear(searchBox);
		element.waitVisibility(driver, phoneNumberList.get(0), 15);
	}

	public void verifySearchByEmailAddress(String value){
		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();
		element.waitVisibility(driver, emailAddressList.get(0), 15);
		for(int i=0;i<emailAddressList.size();i++){
			String emailAddress = emailAddressList.get(i).getText();
			Assert.assertTrue(emailAddress.contains(value));
			Base.extentTest.log(LogStatus.PASS, "Email Address correctly searched as "+emailAddress);
		}
		Base.takeScreenShot();
		element.clear(searchBox);
		element.waitVisibility(driver, emailAddressList.get(0), 15);
	}

	public void verifyUserDetails(String value){
		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();

		element.waitVisibility(driver, emailAddressList.get(0), 15);
		String[] name = element.getValue(nameList.get(0)).split(" ");
		String phoneNumber = element.getValue(phoneNumberList.get(0));
		String emailAddress = element.getValue(emailAddressList.get(0));
		String usrType = element.getValue(userTypeList.get(0));
		String lastUpdated = element.getValue(lastUpdatedList.get(0));

		element.click(driver, nameList.get(0));
		element.waitVisibility(driver, idStudentAssociation, 15);
		Base.extentTest.log(LogStatus.PASS, "Clicked on searched User");
		Base.takeScreenShot();

		Assert.assertEquals(firstName.getAttribute("value"), name[0]);
		Assert.assertEquals(lastName.getAttribute("value"), name[1]);
		Assert.assertEquals(phoneNo.getAttribute("value"), phoneNumber);
		Assert.assertEquals(emailId.getAttribute("value"), emailAddress);
		Assert.assertEquals(userType.getText(), usrType);
		Assert.assertTrue(checkIfDateIsValid(lastUpdatedDate.getAttribute("value").
				replaceAll("CST","").replaceAll("CDT","").trim()));
		Assert.assertTrue(checkIfDateIsValid(createdDate.getAttribute("value").
				replaceAll("CST","").replaceAll("CDT","").trim()));
		Base.extentTest.log(LogStatus.PASS, "Verified User information from User details page");
		Base.takeScreenShot();

		element.click(driver, backToAllUsers);
		element.waitVisibility(driver, emailAddressList.get(0), 15);
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to all users link");
		Base.takeScreenShot();
		element.clear(searchBox);
		searchBox.sendKeys(Keys.ENTER);
		element.waitVisibility(driver, nextPageButton, 15);
		Base.extentTest.log(LogStatus.PASS, "Cleared the search result");
		Base.takeScreenShot();
	}

	public void verifyPageLoadAfterLogin(){
		element.waitVisibility(driver, saveChangesButton, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified Admiral page loaded successfully after login");
		takeScreenShot();
	}

	public void verifySiteSettingsPageLoad(){
		element.click(driver, siteSettings);
		element.waitVisibility(driver, nameList.get(0), 15);
		Base.extentTest.log(LogStatus.PASS, "Verified Site Setting page loaded successfully");
		takeScreenShot();
	}

	public void verifyAllPageLoad(){
		verifyPageLoadAfterLogin();
		verifySiteSettingsPageLoad();
	}

	public void traverseUserList(String value){
		element.waitVisibility(driver, siteDropDown, 15);
		element.selectVisibleOption(siteDropDown, value);
		element.waitVisibility(driver, prevPageButtonDisabled, 15);
		Base.extentTest.log(LogStatus.PASS, "Site Dropdown value selected as: " + value);
		Base.takeScreenShot();

		int pages = Integer.parseInt(numberOfPages.getText());
		for(int i=1;i<pages;i++){
			Base.extentTest.log(LogStatus.PASS, "Number of records in Page " +i+": "+nameList.size());
			element.click(driver, nextPageButton);
			element.waitVisibility(driver, prevPageButton,15);
			Base.extentTest.log(LogStatus.PASS, "Clicked on Next page button");
			Base.takeScreenShot();
			if(i==1)
				Assert.assertFalse(element.isDisplayed(prevPageButtonDisabled));
			if(i==pages-1)
				Assert.assertTrue(element.isDisplayed(nextPageButtonDisabled));
		}
		//Traverse back to previous pages
		for(int i=pages-1;i>0;i--){
			element.click(driver, prevPageButton);
			element.waitVisibility(driver, nextPageButton,15);
			Base.extentTest.log(LogStatus.PASS, "Clicked on Previous page button");
			Base.takeScreenShot();
			if(i==pages-1)
				Assert.assertFalse(element.isDisplayed(nextPageButtonDisabled));
			if(i==1)
				Assert.assertTrue(element.isDisplayed(prevPageButtonDisabled));
		}
	}
	public void verifyUserBasedOnClient() throws InterruptedException {
		element.waitVisibility(driver, siteDropDown, 15);
		List<String> siteDropDownValues = element.getAllDropDownValues(siteDropDown);
		for(String value: siteDropDownValues) {
			element.selectVisibleOption(siteDropDown, value);
			Thread.sleep(5000);
			if (nameList.size()>0) {
				element.waitVisibility(driver, nameList.get(0), 15);
				Base.extentTest.log(LogStatus.PASS, "Dropdown value selected as: " + value + " and User record found");
				Base.takeScreenShot();
			} else {
				Base.extentTest.log(LogStatus.PASS, "Dropdown value selected as: " + value + " and User record not found");
				Base.takeScreenShot();
			}
		}
	}
	private static boolean checkIfDateIsValid(String date) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy, hh:mm a");
		format.setLenient(false);
		try {
			format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}


	public void verifyUserDetails(){
		int index = 0;
		for(int i = 0; i<getNameList.size() - 1 ; i++){
			if(!getNameList.get(0).getAttribute("class").equalsIgnoreCase("inactive")){
				index = i;
				break;
			}
		}
		String value = getNameList.get(index).findElement(By.xpath("//a")).getText();
		value = value.split(" ")[0];

		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();

		element.waitVisibility(driver, emailAddressList.get(0), 15);
		String[] name = element.getValue(nameList.get(0)).split(" ");
		String phoneNumber = element.getValue(phoneNumberList.get(0));
		String emailAddress = element.getValue(emailAddressList.get(0));
		String usrType = element.getValue(userTypeList.get(0));
		String lastUpdated = element.getValue(lastUpdatedList.get(0));

		element.click(driver, nameList.get(0));
		element.waitVisibility(driver, idStudentAssociation, 15);
		Base.extentTest.log(LogStatus.PASS, "Clicked on searched User");
		Base.takeScreenShot();

		Assert.assertEquals(firstName.getAttribute("value"), name[0]);
		Assert.assertEquals(lastName.getAttribute("value"), name[1]);
		Assert.assertEquals(phoneNo.getAttribute("value"), phoneNumber);
		Assert.assertEquals(emailId.getAttribute("value"), emailAddress);
		Assert.assertEquals(userType.getText(), usrType);
		Assert.assertTrue(checkIfDateIsValid(lastUpdatedDate.getAttribute("value").
				replaceAll("CST","").replaceAll("CDT","").trim()));
		Assert.assertTrue(checkIfDateIsValid(createdDate.getAttribute("value").
				replaceAll("CST","").replaceAll("CDT","").trim()));

		element.click(driver, backToAllUsers);
		element.waitVisibility(driver, emailAddressList.get(0), 15);
		element.clear(searchBox);
		searchBox.sendKeys(Keys.ENTER);
		element.waitVisibility(driver, nextPageButton, 15);
		Base.extentTest.log(LogStatus.PASS, "Clicked on back to all users link");
		Base.takeScreenShot();
	}

	public void typeSearchBox(String value){
		element.waitVisibility(driver, searchBox, 15);
		element.sendKeys(searchBox, value);
		Base.extentTest.log(LogStatus.PASS, "Typed value in SearchBox as "+value);
		Base.takeScreenShot();
	}

	public void verifySearchByName(){
		Base.extentTest.log(LogStatus.INFO, "verifySearchByNames");
		int index = 0;
		for(int i = 0; i<getNameList.size() - 1 ; i++){
			if(!getNameList.get(0).getAttribute("class").equalsIgnoreCase("inactive")){
				index = i;
				break;
			}
		}
		String value = getNameList.get(index).findElement(By.xpath("//a")).getText();
		value = value.split(" ")[0];
		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();
		element.waitVisibility(driver, nameList.get(0), 15);
		boolean validSearch = false;
		for(int i=0;i<nameList.size();i++){
			String name = nameList.get(i).getText().toLowerCase();
			if(name.contains(value.toLowerCase())){
				validSearch = true;
			}
			Assert.assertTrue(validSearch);
			Base.extentTest.log(LogStatus.PASS, "User name correctly searched as "+name);
		}
		Base.takeScreenShot();
		element.clear(searchBox);
		element.waitVisibility(driver, nameList.get(0), 15);
	}

	public void verifySearchByPhoneNumber(){
		int index = 0;
		for(int i = 0; i<getNameList.size() - 1 ; i++){
			if(!getNameList.get(0).getAttribute("class").equalsIgnoreCase("inactive")){
				index = i;
				break;
			}
		}
		String value = getPhoneNumberList.get(index).getText();
		value = value.split("-", 2)[1];
		typeSearchBox(value.replaceAll("\\D+", ""));
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();
		element.waitVisibility(driver, phoneNumberList.get(0), 15);
		boolean validSearch = false;
		for(int i=0;i<phoneNumberList.size();i++){
			String phoneNumber = phoneNumberList.get(i).getText();
			if(phoneNumber.contains(value)){
				validSearch = true;
			}
			Assert.assertTrue(validSearch);
			Base.extentTest.log(LogStatus.PASS, "Phone Number correctly searched as "+phoneNumber);
		}
		Base.takeScreenShot();
		element.clear(searchBox);
		element.waitVisibility(driver, phoneNumberList.get(0), 15);
	}

	public void verifySearchByEmailAddress(){
		int index = 0;
		for(int i = 0; i<getNameList.size() - 1 ; i++){
			if(!getNameList.get(0).getAttribute("class").equalsIgnoreCase("inactive")){
				index = i;
				break;
			}
		}
		String value = getEmailAddressListcol.get(index).getText();
		typeSearchBox(value);
		searchBox.sendKeys(Keys.ENTER);
		Base.extentTest.log(LogStatus.PASS, "Clicked on enter button");
		Base.takeScreenShot();
		element.waitVisibility(driver, emailAddressList.get(0), 15);
		for(int i=0;i<emailAddressList.size();i++){
			String emailAddress = emailAddressList.get(i).getText();
			Assert.assertTrue(emailAddress.contains(value));
			Base.extentTest.log(LogStatus.PASS, "Email Address correctly searched as "+emailAddress);
		}
		Base.takeScreenShot();
		element.clear(searchBox);
		element.waitVisibility(driver, emailAddressList.get(0), 15);
	}


	public void verifyUserTypeColor(){
		element.waitClickable(driver, nextPageButton, 15);
		int pages = Integer.parseInt(numberOfPages.getText());
		int a=0, b=0, c=0, d=0;
		while(pages-1>0){
			for(int i=0;i<userTypeList.size();i++){
				String color = Color.fromString(userTypeColorList.get(i).getCssValue("background-color")).asHex();
				String userTypeText = userTypeList.get(i).getText();
				if(userTypeText.equals("Parent")){
					Assert.assertEquals(color,TestProperties.get("userTypeGreen"));
					a=a+1;
				}
				if(userTypeText.equals("School Admin")){
					Assert.assertEquals(color,TestProperties.get("userTypePurple"));
					b=b+1;
				}
				if(userTypeText.equals("Scholarship Admin")){
					Assert.assertEquals(color,TestProperties.get("userTypeBlue"));
					c=c+1;
				}
				if(userTypeText.equals("Admiral")){
					Assert.assertEquals(color,TestProperties.get("userTypeYellow"));
					d=d+1;
				}
				if(a>0 && b>0 && c>0 && d>0)
					break;
			}
			element.click(driver, nextPageButton);
			Base.extentTest.log(LogStatus.PASS, "Next Page button clicked");
			Base.takeScreenShot();
			pages = pages-1;
			if(a>0 && b>0 && c>0 && d>0)
				break;
		}
	}

	public void verifySearchBox(){
		element.waitVisibility(driver, searchBox, 15);
		String search_Box = searchBox.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Search box</b> on Users page as "+search_Box);
		Base.takeScreenShot();
	}

	public void verifySiteDropDown(){
		element.waitVisibility(driver, siteDropDown, 15);
		String siteDrop_Down = siteDropDown.getText();
		logger.info("Verified <b>Site Drop Down box</b> on Users page as "+siteDrop_Down);
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Site Drop Down box</b> on Users page as "+siteDrop_Down);
		Base.takeScreenShot();
	}

	public void verifyUserTableHeader(){
		element.waitVisibility(driver, headerName, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Header Name</b> on Users table as "+headerName.getText());
		element.waitVisibility(driver, headerPhoneNumber, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Header Phone Number</b> on Users table as "+headerPhoneNumber.getText());
		element.waitVisibility(driver, headerEmailAddress, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Header Email Address</b> on Users table as "+headerEmailAddress.getText());
		element.waitVisibility(driver, headerUserType, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Header User Type</b> on Users table as "+headerUserType.getText());
		element.waitVisibility(driver, headerLastUpdated, 15);
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Header Last Updated</b> on Users table as "+headerLastUpdated.getText());
		Base.takeScreenShot();
	}

	public void verifyUserTable(){
		for(int j = 0;j<nameList.size();j++){
			element.waitClickable(driver, nameList.get(j), 15);
			Base.extentTest.log(LogStatus.PASS, "Verified <b>User name</b> on Users table as "+nameList.get(j).getText());
			element.waitVisibility(driver, phoneNumberList.get(j), 15);
			Base.extentTest.log(LogStatus.PASS, "Verified <b>Phone Number</b> on Users table as "+phoneNumberList.get(j).getText());
			element.waitVisibility(driver, emailAddressList.get(j), 15);
			Base.extentTest.log(LogStatus.PASS, "Verified <b>Phone Number</b> on Users table as "+emailAddressList.get(j).getText());
			element.waitVisibility(driver, userTypeList.get(j), 15);
			Base.extentTest.log(LogStatus.PASS, "Verified <b>Phone Number</b> on Users table as "+userTypeList.get(j).getText());
			element.waitVisibility(driver, lastUpdatedList.get(j), 15);
			Base.extentTest.log(LogStatus.PASS, "Verified <b>Phone Number</b> on Users table as "+lastUpdatedList.get(j).getText());
		}
		Base.takeScreenShot();
	}



	public void myOrganizationTab(){
		element.waitVisibility(driver, myOrganizationTab, 15);
		String myOrganization_Tab = myOrganizationTab.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>My Organization tab</b> on Site Settings page as "+myOrganization_Tab);
		Base.takeScreenShot();
	}

	public void usersTab(){
		element.waitVisibility(driver, usersTab, 15);
		String users_Tab = usersTab.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Users tab</b> on Site Settings page as "+users_Tab);
		Base.takeScreenShot();
	}

	public void privateSchoolsTab(){
		element.waitVisibility(driver, privateSchoolsTab, 15);
		String privateSchools_Tab = privateSchoolsTab.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>Private Schools tab</b> on Site Settings page as "+privateSchools_Tab);
		Base.takeScreenShot();
	}


	public void verifySiteSettingsTab() throws InterruptedException {
		Thread.sleep(5000);
	//	myOrganizationTab(); // As confirmed by Marta, this tab is removed
		usersTab();
	//	privateSchoolsTab(); // As confirmed by Marta, this tab is removed
	}

	public void itemToBESelected(String itmName){
		String fname = String.format("//span[contains(text(),'%s')]",itmName);
		driver.findElement(By.xpath(fname)).click();
		logger.info("Value selected from the dropdown is "+itmName);
		Base.extentTest.log(LogStatus.PASS, "Value selected from the dropdown is "+itmName);
		takeScreenShot();
	}

	public void selectUserTypeDropDownValue(String uType) throws InterruptedException {
/*		element.waitVisibility(driver, usersTypeDropDownArrow, 15);
		usersTypeDropDownArrow.click();
		logger.info("Clicked on User Type dropdown arrow");
		extentTest.log(LogStatus.PASS, "Clicked on User Type dropdown arrow");
		takeScreenShot();

		// Create a Select object
		Select dropdown = new Select(usersTypeDropDown);

		// Select an option by visible text
		dropdown.selectByVisibleText("School Admin");
Thread.sleep(3000);
		logger.info("Clicked on User Type dropdown Value");
		extentTest.log(LogStatus.PASS, "Clicked on User Type dropdown Value");
		takeScreenShot();*/
	//	usersTypeDropDownArrow.sendKeys("");

		usersTypeDropDownArrow.click();
		logger.info("Clicked on User Type dropdown arrow");
		extentTest.log(LogStatus.PASS, "Clicked on User Type dropdown arrow");
		takeScreenShot();

		itemToBESelected(uType);

		Thread.sleep(2000);
	//	usersTypeDropDownArrow.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
	//	Thread.sleep(3000);
	//	usersTypeDropDownArrow.sendKeys(Keys.ARROW_DOWN);
	//	Thread.sleep(3000);
	//	usersTypeDropDownArrow.sendKeys(Keys.ENTER);
	//	Thread.sleep(3000);

	//	Thread.sleep(3000);
		logger.info("Clicked on User Type dropdown Value");
		extentTest.log(LogStatus.PASS, "Clicked on User Type dropdown Value");
		takeScreenShot();

		saveChangesButton.click();
		logger.info("Clicked on Save Changes Button");
		extentTest.log(LogStatus.PASS, "Clicked on Save Changes Button");
		takeScreenShot();

	//	selectValue

	}

	public void clickSearchedUser() throws InterruptedException {
		element.waitVisibility(driver, searchedUser, 15);
		searchedUser.click();
		logger.info("Clicked on Searched User");
		extentTest.log(LogStatus.PASS, "Clicked on Searched User");
		Thread.sleep(5000);
		takeScreenShot();
	}

	public void clickSettingsIcon() throws InterruptedException {
		element.waitVisibility(driver, siteSettings, 15);
		siteSettings.click();
		logger.info("Clicked on Settings Icon");
		extentTest.log(LogStatus.PASS, "Clicked on Settings Icon");
		takeScreenShot();
	}

	public void clickUsersTab() throws InterruptedException {
		Thread.sleep(2000);
		element.waitVisibility(driver, usersTab, 15);
		element.clickByJs(driver, usersTab);
	//	usersTab.click();
		logger.info("Clicked on Users tab");
		extentTest.log(LogStatus.PASS, "Clicked on Users Tab");
		takeScreenShot();
	}

	public void enterInSearchTextBox(String text) throws InterruptedException {
		Thread.sleep(3000);
		element.waitVisibility(driver, searchTextBox, 15);
		searchTextBox.click();
		logger.info("Clicked on Search Text box");
		extentTest.log(LogStatus.PASS, "Clicked on Search Text box");

		searchTextBox.clear();
		searchTextBox.sendKeys(text+ Keys.ENTER);
		Thread.sleep(2000);
		logger.info("Entered "+text+" into search text box and searched for it");
		extentTest.log(LogStatus.PASS, "Entered "+text+" into search text box and searched for it");
		takeScreenShot();
	}

	public void changeUserType(String user,String userType) throws InterruptedException {
		clickSettingsIcon();
		clickUsersTab();
		enterInSearchTextBox(user);
		clickSearchedUser();
		selectUserTypeDropDownValue(userType);
		}

	public void verify_admiral_homepage_icons() throws InterruptedException {
		Thread.sleep(5000);
		homepage_logo_icon();
		site_settings_icon();
		myinfo_icon();
		logout_icon();
	}

	public void homepage_logo_icon(){
		element.waitVisibility(driver, logo, 15);
		String logo_data_name = logo.getAttribute("data-name");
		Base.extentTest.log(LogStatus.PASS, "Verified logo on Admiral homepage as "+logo_data_name);
		Base.takeScreenShot();
	}

	public void site_settings_icon(){
		element.waitVisibility(driver, siteSettings, 15);
		String siteSettings_icon = siteSettings.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>school info icon</b> on Admiral homepage as "+siteSettings_icon);
		Base.takeScreenShot();
	}

	public void myinfo_icon(){
		element.waitVisibility(driver, myInfo, 15);
		String myinfo_icon = myInfo.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>my info icon</b>  on Admiral homepage as "+myinfo_icon);
		Base.takeScreenShot();
	}

	public void logout_icon(){
		element.waitVisibility(driver, logoutbutton, 15);
		String logout_icon = logoutbutton.getText();
		Base.extentTest.log(LogStatus.PASS, "Verified <b>logout icon</b>  on Admiral homepage as "+logout_icon);
		Base.takeScreenShot();
	}

}
