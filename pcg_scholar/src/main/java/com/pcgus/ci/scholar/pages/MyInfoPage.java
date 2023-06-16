package com.pcgus.ci.scholar.pages;


import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
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


public class MyInfoPage extends Base {

	WebDriver driver;
	Element element;
	CreateApplicationPage createAppPage;
	BrowserDriver browserDriver = new BrowserDriver();

	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	private static Logger logger = LogManager.getLogger(MyInfoPage.class.getName());

	@FindBy(xpath = "//span[text()[contains(., 'My Info')]]")
	WebElement myinfobutton;

	@FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
	private WebElement logoutbutton;

	@FindBy(xpath="//div[@class='labeled-input ']/label[text()='First Name']")
	private WebElement firstNameLabel;

	@FindBy(xpath = "//input[@placeholder='Enter your first name.']")
	private WebElement firstName;

	@FindBy(xpath="//div[@class='labeled-input ']/label[text()='Last Name']")
	private WebElement lastNameLabel;

	@FindBy(xpath = "//*[@placeholder='Enter your last name']")
	private WebElement lastName;

	@FindBy(xpath = "//*[@placeholder='Enter your email address']")
	private WebElement email;

	@FindBy(xpath = "//*[@placeholder='Enter a 10 digit phone number']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//*[@placeholder='Enter your username.']")
	private WebElement disabledUsername;

	@FindBy(xpath="//div[@class='labeled-input ']/label[text()='Username']")
	private WebElement userNameLabel;

	@FindBy(xpath = "//*[@placeholder='Enter your password']")
	private WebElement disabledPassword;

	@FindBy(xpath="//div[@class='labeled-input ']/label[text()='Password']")
	private WebElement passwordLabel;

	@FindBy(xpath = "//button[text()[contains(.,'Change password')]]")
	private WebElement changePasswordButton;

	@FindBy(xpath = "//button[text()[contains(.,'Save changes')]]")
	private WebElement saveChangesButton;

	@FindBy(xpath = "//label[text()[contains(.,'Current Password')]]//input[@placeholder[contains(.,'Enter your password')]]")
	private WebElement currentPasswordTextbox;

	@FindBy(xpath = "//label[text()[contains(.,'New password')]]//input[@placeholder[contains(.,'Enter your password')]]")
	private WebElement newPasswordTextbox;

	@FindBy(xpath = "//label[text()[contains(.,'Confirm new password')]]//input[@placeholder[contains(.,'Enter your password')]]")
	private WebElement confirmPasswordTextbox;

	@FindBy(xpath = "//div[@class='button-container']/button[text()[contains(.,'Change password')]]")
	private WebElement changePwdSaveChangesButton;

	@FindBy(xpath="//div[@class='Toastify__toast-body']/div[text()[contains(., 'Changes saved.')]]")
	WebElement saveChangesToast;

	public void MyInfoDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
		createAppPage = new CreateApplicationPage();
	}

	public void enterTextInTextBox(WebElement ele, String text) throws InterruptedException {
		element.waitVisibility(driver, ele, 30);
		ele.sendKeys(text);
	}

	public void clickChangePasswordBtn(){
		element.waitVisibility(driver, changePasswordButton, 15);
	//	changePasswordButton.click();
		element.clickByJs(driver,changePasswordButton);
		logger.info("Change Password button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Change Password button is clicked");
		Base.takeScreenShot();
	}
	public void clickmyinfoicon(){
		element.waitVisibility(driver, myinfobutton, 30);
		Assert.assertTrue(myinfobutton.isDisplayed());
		logger.info("My Info button is displayed");
		Base.extentTest.log(LogStatus.PASS, "My Info button is displayed");
		Base.takeScreenShot();

		myinfobutton.click();
		logger.info("My Info button is clicked");
		Base.extentTest.log(LogStatus.PASS, "My Info button is clicked");
		Base.takeScreenShot();
	}

	public String changepassword(String ExistingPassword) throws InterruptedException{

		clickmyinfoicon();

		clickChangePasswordBtn();

	//	String ExistingPassword = TestProperties.get("password");

		Base.extentTest.log(LogStatus.PASS, "Current Password is :: "+ExistingPassword);
		String newPasswordValue = getNewPassword(ExistingPassword);
		Base.extentTest.log(LogStatus.PASS, "Change/New password would be :: "+newPasswordValue);

		enterTextInTextBox(currentPasswordTextbox, ExistingPassword);
		logger.info("Current password entered successfully");
		Base.extentTest.log(LogStatus.PASS, "Current password entered successfully");
		Base.takeScreenShot();

		Thread.sleep(3000);
		enterTextInTextBox(newPasswordTextbox, newPasswordValue);
		logger.info("New password entered successfully");
		Base.extentTest.log(LogStatus.PASS, "New password "+newPasswordValue+" is entered successfully");
		Base.takeScreenShot();

		Thread.sleep(3000);
		enterTextInTextBox(confirmPasswordTextbox, newPasswordValue);
		logger.info("Confirm password entered successfully");
		Base.extentTest.log(LogStatus.PASS, "Confirm password "+newPasswordValue+" is entered successfully");
		Base.takeScreenShot();

		element.waitVisibility(driver, changePwdSaveChangesButton, 15);
		element.clickByJs(driver, changePwdSaveChangesButton);
		logger.info("Save Changes button is clicked");
		Base.extentTest.log(LogStatus.PASS, "Save Changes button from reset password pop-up is clicked");
		Base.takeScreenShot();

		element.waitVisibility(driver, saveChangesButton, 15);
		element.clickByJs(driver,saveChangesButton);
		//saveChangesButton.click();
		Base.extentTest.log(LogStatus.PASS, "Save Changes button from My Info page is clicked");
		Base.takeScreenShot();

/*		element.waitVisibility(driver, saveChangesToast, 15);
		Assert.assertTrue(saveChangesToast.isDisplayed());
		Base.extentTest.log(LogStatus.PASS, "Password is changed, need to save the changes now");
		Base.takeScreenShot();*/

		base.timeinterval(4);
		element.isDisplayed(logoutbutton);
		Assert.assertTrue(logoutbutton.isDisplayed());
		Base.extentTest.log(LogStatus.PASS, "Log out button is displayed");
		Base.takeScreenShot();
		return newPasswordValue;
	}

	public void validateInfoPage() throws InterruptedException {

		element.click(driver, myinfobutton);

		// Updating First Name

		String firstNameExistingText =firstName.getAttribute("value");
		String firstNameNewText = " updated";
		String firstNameFinalText=firstNameExistingText + firstNameNewText;
		logger.info("Existing Value of <b>"+firstNameLabel.getText()+"</b> was <b>"+ firstNameExistingText+"</b>");
		Base.extentTest.log(LogStatus.PASS, "Existing Value of <b>"+firstNameLabel.getText()+"</b> was <b>"+ firstNameExistingText+"</b>");
		Base.takeScreenShot();

		element.clear(firstName);
		element.enterValue(firstName, firstNameFinalText);
		logger.info("Updated Value of <b>"+firstNameLabel.getText()+ "</b> is now <b>"+ firstNameFinalText+"</b>");
		Base.extentTest.log(LogStatus.PASS, "Updated Value of <b>"+firstNameLabel.getText()+ "</b> is now <b>"+ firstNameFinalText+"</b>");
		Base.takeScreenShot();

		// Updating Last Name
		String lastNameExistingText =lastName.getAttribute("value");
		String lastNameNewText = " updated";
		String lastNameFinalText=lastNameExistingText + lastNameNewText;
		logger.info("Existing Value of <b>"+lastNameLabel.getText()+"</b> was <b>"+ lastNameExistingText+"</b>");
		Base.extentTest.log(LogStatus.PASS, "Existing Value of <b>"+lastNameLabel.getText()+"</b> was <b>"+ lastNameExistingText+"</b>");
		Base.takeScreenShot();

		element.clear(lastName);
		element.enterValue(lastName, lastNameFinalText);
		logger.info("Updated Value of <b>"+lastNameLabel.getText()+ "</b> is now <b>"+ lastNameFinalText+"</b>");
		Base.extentTest.log(LogStatus.PASS, "Updated Value of <b>"+lastNameLabel.getText()+ "</b> is now <b>"+ lastNameFinalText+"</b>");
		Base.takeScreenShot();

		//Validating location of Username and Password - Password should be below username
		Assert.assertTrue(base.compLocation(userNameLabel,passwordLabel));
		logger.info("Field <b>"+passwordLabel.getText()+ "</b> is under <b>"+ userNameLabel.getText()+"</b>");
		Base.extentTest.log(LogStatus.PASS, "Field <b>"+passwordLabel.getText()+ "</b> is under <b>"+ userNameLabel.getText()+"</b>");
		Base.takeScreenShot();

		element.click(driver, saveChangesButton);
		logger.info("Clicked on Save changes button");
		Base.extentTest.log(LogStatus.PASS, "Clicked on Save Changes button");
//		Thread.sleep(1000);
		Base.takeScreenShot();
		Thread.sleep(3000);

		//Revert the changes for firstname field
		revertChanges(firstName, firstNameExistingText, saveChangesButton);
		logger.info("Changes are reverted for "+firstNameLabel.getText()+"field");
		Base.extentTest.log(LogStatus.PASS, "Changes are reverted for "+firstNameLabel.getText()+"field");
		Thread.sleep(1000);
		Base.takeScreenShot();

		//Revert the changes for lastname field
		revertChanges(lastName, lastNameExistingText, saveChangesButton);
		logger.info("Changes are reverted for "+lastNameLabel.getText()+"field");
		Base.extentTest.log(LogStatus.PASS, "Changes are reverted for "+lastNameLabel.getText()+"field");
		Thread.sleep(1000);
		Base.takeScreenShot();

	}

	public void revertChanges(WebElement ele,String oldText, WebElement ele2){
		ele.clear();
		ele.sendKeys(oldText);
		element.click(driver, ele2);
	}


}
