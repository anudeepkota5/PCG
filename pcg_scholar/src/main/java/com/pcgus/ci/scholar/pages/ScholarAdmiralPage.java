package com.pcgus.ci.scholar.pages;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.Element;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.pcgus.ci.scholar.testbase.Base.extentTest;
import static com.pcgus.ci.scholar.testbase.Base.takeScreenShot;


public class ScholarAdmiralPage {

    WebDriver driver;
    public Element element;
    JSWaiter jSWaiter = new JSWaiter();
    BrowserDriver browserDriver = new BrowserDriver();
    Base base = new Base();

    String parentuserpwdchange = TestProperties.get("parentuserpwdchange");

    private static Logger logger = LogManager.getLogger(Homepage.class.getName());

    @FindBy(xpath = "//label[text()[contains(., 'Username')]]//input[@type='text']")
    WebElement username;

    @FindBy(xpath = "//label[text()[contains(., 'Password')]]//input[@type='text']")
    WebElement password;

    @FindBy(xpath = "//label[text()[contains(., 'First Name')]]//input[@type='text']")
    WebElement firstname;

    @FindBy(xpath = "//label[text()[contains(., 'Last Name')]]//input[@type='text']")
    WebElement lastname;

    @FindBy(xpath = "//div[@class='log-out']//button")
    WebElement logout;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//button[text()[contains(., 'Save changes')]]")
    WebElement savechanges;

    @FindBy(xpath = "//span[text()='My Info']")
    WebElement infoIcon;

    @FindBy(xpath = "//label[text()[contains(., 'Username')]]")
    WebElement usernameLocation;

    @FindBy(xpath = "//label[text()[contains(., 'Password')]]")
    WebElement passwordLocation;

    @FindBy(xpath = "//label[text()[contains(., 'First Name')]]")
    WebElement firstnameState;

    @FindBy(xpath = "//label[text()[contains(., 'Last Name')]]")
    WebElement lastnameState;

    @FindBy(xpath = "//span[text()[contains(.,'Site Settings')]]")
    WebElement siteSettingIcon;

    @FindBy(xpath = "//div[text()[contains(.,'Users')]]")
    WebElement usersTab;

    @FindBy(xpath = "//div/input[@placeholder='Search']")
    WebElement searchTextbox;

    @FindBy(xpath = "//div[@class[contains(., 'grid grid')]]/span")
    List<WebElement> usersList;

    @FindBy(xpath = "//span[text()[contains(.,'pcgusqa+parent@gmail.com')]]")
    WebElement selectUser;

    @FindBy(xpath = "//a[text()[contains(.,'Pcg Us')]]")
    WebElement openUser;

    @FindBy(xpath = "//button[text()='Change username']")
    WebElement changeUsernameButton;

    @FindBy(xpath = "//button[text()='Change password']")
    WebElement changePasswordButton;

    @FindBy(xpath = "//div[@id='view-change-username']//label[text()[contains(., 'Username')]]/input")
    WebElement existingUsernameTextBox;

    @FindBy(xpath = "//div[@id='view-change-username']//label[text()[contains(., 'New username')]]/input")
    WebElement newUsernameTextBox;

    @FindBy(xpath = "//input[@placeholder='Enter your password']/ancestor::label[text()[contains(., 'New password')]]")
    WebElement newPasswordTextBox;
    @FindBy(xpath = "//input[@placeholder='Enter your password']/ancestor::label[text()[contains(., 'Confirm new password')]]")
    WebElement confirmNewPasswordTextBox;
    @FindBy(xpath = "//button[text()='Reset password']")
    WebElement resetPasswordButton;
    @FindBy(xpath = "//div[@class='Toastify__toast-body']/div[text()[contains(., 'Changes saved.')]]")
    WebElement saveChangesToast;

    @FindBy(xpath = "//div[@class='view-title']/h2")
    WebElement changeUsernameModelWindow;

    @FindBy(css = "h1:nth-child(1) > svg:nth-child(1)")
    private WebElement logo;

    @FindBy(xpath = "//li[@class='selected']/span[contains(text(),'Applications')]")
    WebElement applications;

    @FindBy(xpath = "//span[contains(text(),'Finances')]")
    private WebElement finances;

    @FindBy(xpath = "//span[contains(text(),'Settings')]")
    private WebElement settings;

    @FindBy(xpath = "//span[text()[contains(., 'Log out')]]")
    private WebElement logoutbutton;

    @FindBy(xpath = "//*[@id='view-finances']/div[2]/div/div[3]/span[1]")
    private WebElement studentfirstname;

    @FindBy(xpath = "//button[text()='Annual Statements']")
    private WebElement annualstatement;

    String fname = "//span[text()[contains(., '%s')]]";

    @FindBy(xpath = "//button[@class='actions-button tertiary']")
    private WebElement dropdown;

    @FindBy(xpath = "//ul[@class='actions-dropdown']/li/div")
    private List<WebElement> options;

    @FindBy(xpath = "//button[@class='change-enrollment-button primary']")
    private WebElement changeEnrollmentButton;

    @FindBy(xpath = "//label[text()='Change reason:']/select")
    private WebElement reason;

    @FindBy(css = "[class='react-date-picker__calendar-button__icon react-date-picker__button__icon']")
    private List<WebElement> opencal;

    @FindBy(xpath = "//button[@class='primary']")
    WebElement save;

    @FindBy(xpath = "//label[text()='Entering school:']/following-sibling::*[@class='invalid-reason']")
    WebElement schoolNameError;

    @FindBy(xpath = "//label[text()='Exit date:']/following-sibling::*[@class='invalid-reason']")
    WebElement exitDateError;

    @FindBy(xpath = "//label[text()='Entry date:']/following-sibling::*[@class='invalid-reason']")
    WebElement entryDateError;

    @FindBy(xpath = "//label[text()='Entering school:']/select")
    WebElement enteringSchoolDropdown;

    @FindBy(xpath = "//label[text()='Exit date:']//div[@class='react-calendar__viewContainer']//button[@class='react-calendar__tile react-calendar__month-view__days__day']")
    List<WebElement> exitDates;

    @FindBy(xpath = "//label[text()='Entry date:']//div[@class='react-calendar__viewContainer']//button[@class='react-calendar__tile react-calendar__month-view__days__day']")
    List<WebElement> entryDates;

    @FindBy(xpath = "//span[@colname='Name']/span/a")
    WebElement name;

    @FindBy(xpath = "//label[text()='Organization']/select")
    WebElement organization;

    @FindBy(xpath = "//span[text()='Students']")
    WebElement students;

    @FindBy(xpath = "//label[text()='Status']")
    WebElement status;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    List<WebElement> liststatus;

    @FindBy(xpath = "//h2[text()='Filters']")
    WebElement filters;

    @FindBy(xpath = "//tbody/tr[1]/th[3]/p")
    WebElement userLastName;

    @FindBy(xpath = "//tbody/tr[1]/th[4]/p")
    WebElement userFirstName;

    @FindBy(xpath = "//tbody/tr[1]/th[7]/p")
    WebElement userSchoolName;

    @FindBy(xpath = "//span[contains(text(),'Applications')]")
    WebElement application;

    @FindBy(xpath = "//th[3][@id='enhanced-table-checkbox-0']/p")
    WebElement clickOnFirstName;

/*	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;*/

    @FindBy(xpath = "//input[@data-form-key='sectionA.studentFirstName']")
    WebElement stuFirstName;

    @FindBy(xpath = "//button[contains(text(),'Actions')]")
    WebElement actionButton;

    @FindBy(xpath = "//*[text()[contains(., 'Section A - Student Information')]]")
    WebElement sectionStudentInformation;

    @FindBy(xpath = "//*[text()[contains(., 'Section B - Parent Information')]]")
    WebElement sectionParentInformation;

    @FindBy(xpath = "//*[text()[contains(., 'Section C - Eligibility Verification')]]")
    WebElement sectionEligibilityVerification;

    @FindBy(xpath = "//*[text()[contains(., 'Section D - Enrollment Verification')]]")
    WebElement sectionEnrollmentVerification;

    @FindBy(xpath = "//*[text()[contains(., 'Documents')]]")
    WebElement sectionDocuments;

    @FindBy(xpath = "//*[text()[contains(., 'LNH Required Data Collection')]]")
    WebElement sectionLNHRequiredDataCollection;

    @FindBy(xpath = "//div[contains(text(),'Edit Status')]")
    WebElement actionsLeadsEditStatusLink;

    @FindBy(xpath = "//*[@id='react-select-3-placeholder]")
    WebElement newStatusDropdown;

    @FindBy(xpath = "//button[@class= 'back-button button-link' and text()='Back to all']")
    WebElement backToAllLink;

    @FindBy(xpath = "//div[@class='current-roster-grid grid-component-container']")
    List<WebElement> studentTables;

    @FindBy(xpath = "//span[@class='current-page-display']")
    List<WebElement> currentpages;

    @FindBy(xpath = "//span[@class='max-page-display']")
    List<WebElement> maxpages;

    @FindBy(xpath = "//button[@class='next-page-button']")
    List<WebElement> nextbuttons;

    @FindBy(xpath = "//button[@colname='StudentName']")
    List<WebElement> studentNames;

    @FindBy(xpath = "//button/p[contains(text(),'Select Actions')]")
    WebElement selectActionsButton;

    @FindBy(xpath = "//button[contains(text(),'Change username')]")
    WebElement changeUsernameOption;

    @FindBy(xpath = "//button[contains(text(),'Change password')]")
    WebElement changePasswordOption;

    @FindBy(xpath = "(//div[contains(@class,'MuiFormControl-root MuiFormControl-fullWidth css-tzsjye')])[1]")
    WebElement schoolYearFinances;

    @FindBy(xpath = "//div[@colname='status']")
    WebElement tableStatusFinances;

    @FindBy(xpath = "//div[@colname='studentName']")
    WebElement tableFinancesName;

    @FindBy(xpath = "//div[contains(@colname,'grade')]")
    WebElement tableFinancesGrade;

    @FindBy(xpath = "//div[@colname='type']")
    WebElement tableFinancesApplicationType;

    @FindBy(xpath = "//div[@colname='total']")
    WebElement tableFinancesTotalAmount;

    @FindBy(xpath = "//div[@colname='tuition']")
    WebElement tableFinancesTuition;

    @FindBy(xpath = "//div[@colname='fees']")
    WebElement tableFinancesFees;

    @FindBy(xpath = "//div[@colname='discount']")
    WebElement tableFinancesDiscount;

    @FindBy(xpath = "//div[@colname='submitted']")
    WebElement tableFinancesDateSubmitted;

    @FindBy(xpath = "//span[@colname='status']")
    List<WebElement> tableStatusFinancesRow;

    @FindBy(xpath = "//span[@colname='studentName']")
    List<WebElement> tableFinancesNameRow;

    @FindBy(xpath = "//span[contains(@colname,'grade')]")
    List<WebElement> tableFinancesGradeRow;

    @FindBy(xpath = "//span[@colname='type']")
    List<WebElement> tableFinancesApplicationTypeRow;

    @FindBy(xpath = "//span[@colname='total']")
    List<WebElement> tableFinancesTotalAmountRow;

    @FindBy(xpath = "//span[@colname='tuition']")
    List<WebElement> tableFinancesTuitionRow;

    @FindBy(xpath = "//span[@colname='fees']")
    List<WebElement> tableFinancesFeesRow;

    @FindBy(xpath = "//span[@colname='discount']")
    List<WebElement> tableFinancesDiscountRow;

    @FindBy(xpath = "//span[@colname='submitted']")
    List<WebElement> tableFinancesDateSubmittedRow;

    @FindBy(xpath = "//button[normalize-space()='Annual Statements']")
    WebElement annualStatementTab;

    @FindBy(xpath = "//span[@colname=\"status\"]//button")
    List<WebElement> createButtonAnnualStatements;

    @FindBy(xpath = "//h2[@class='annual-statements-title']")
    WebElement annualStatementTitle;

    @FindBy(xpath = "//label[normalize-space()='Description']")
    WebElement descriptionHeadingTableAnnualStatement;

    @FindBy(xpath = "//input[contains(@placeholder,'Enter a fee description.')]")
    WebElement descriptionTableTuition;

    @FindBy(xpath = "//div[@class='new-fee']")
    WebElement descriptionTableClickToAddItem;

    @FindBy(xpath = "//button[normalize-space()='Autopopulate table']")
    WebElement descriptionAutoPopulateTable;

    @FindBy(xpath = "//div[normalize-space()='Discount(s)']")
    WebElement discountsTable;

    @FindBy(xpath = "//div[normalize-space()='Total Annual Tuition + Fees + Discount(s)']")
    WebElement discountTotalAnnualTuition;

    @FindBy(xpath = "//input[@placeholder='dd']")
    WebElement dateInputMonth;

    @FindBy(xpath = "//input[@placeholder='mm']")
    WebElement dateInputDate;

    @FindBy(xpath = "//input[@placeholder='yyyy']")
    WebElement dateInputYear;

    @FindBy(xpath = "//select[contains(@id,'labeled-select-id')]")
    WebElement gradeSelectDropDown;

    @FindBy(xpath = "(//div[@class=\"details-panel panel-section\"]//div[1]/span)[4]")
    WebElement nameOnAnnualStatementDetailsPage;

    @FindBy(css = ".back-button.button-link")
    WebElement backButtonToAllAnnualStatement;

    @FindBy(xpath = "//input[@class=\"fee\"]")
    List<WebElement> inputFeeValue;

    @FindBy(xpath = "//button[normalize-space()='Submit statement']")
    WebElement submitChangesButton;

    @FindBy(xpath = "//div[@class='fees-table']//div/div")
    List<WebElement> feesTableDiv;

    @FindBy(xpath = "(//div[@class=\"details-panel panel-section\"]/div[@class=\"panel-section-content\"]/div/span)[2]")
    WebElement studentNameDetailsAnnualStatement;

    @FindBy(xpath = "(//div[@class=\"details-panel panel-section\"]/div[@class=\"panel-section-content\"]/div[2]/span)[2]")
    WebElement studentDOBDetailsAnnualStatement;

    @FindBy(xpath = "(//div[@class=\"details-panel panel-section\"]/div[@class=\"panel-section-content\"]/div[3]/span)[2]")
    WebElement studentStatementDateAnnualStatement;

    @FindBy(xpath = "(//div[@class=\"details-panel panel-section\"]/div[@class=\"panel-section-content\"]/div[4]/span)[2]")
    WebElement parentOrGuardianNameStudentAnnaualStatement;

    @FindBy(xpath = "//label[text()='Grade']")
    private WebElement gradeLabel;

    @FindBy(xpath = "//div[@id='termSelect']")
    private WebElement termSelect;

    @FindBy(xpath = "//*[contains(@href,'/sitesettings/user')]")
    private List<WebElement> nameList;

    @FindBy(xpath = "//div[@class='user-type-selector__indicators css-1wy0on6']")
    WebElement usersTypeDropDownArrow;

    @FindBy(xpath = "//button[contains(text(),'Save changes')]")
    WebElement saveChangesButton;

    @FindBy(xpath = "(//input[@placeholder='Enter your name'])[1]")
    WebElement firstName;

    @FindBy(xpath = "(//input[@placeholder='Enter your name'])[2]")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Enter a 10 digit phone number']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='Enter your email address']")
    WebElement emailAddress;

    @FindBy(xpath = "//label[text()='Organization']//input")
    WebElement organizationField;

    @FindBy(xpath = "//button[text()='Add User']")
    WebElement addUser;

    @FindBy(xpath = "//button[text()='Autopopulate table']")
    WebElement autopopulate;

    public void admiraluserPageDriverRef(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
        PageFactory.initElements(factory, this);
        element = new Element(driver);
    }

    public void verifySettingsPageLoad() {
        settings.click();
        Base.extentTest.log(LogStatus.PASS, "Clicked on Settings icon");
        element.waitVisibility(driver, nameList.get(0), 10);
        Base.takeScreenShot();
    }

    public void verifyFinancePageLoad() {
        finances.click();
        Base.extentTest.log(LogStatus.PASS, "Clicked on Finances icon");
        element.waitVisibility(driver, gradeLabel, 10);
        Base.takeScreenShot();

        annualStatementTab.click();
        Base.extentTest.log(LogStatus.PASS, "Clicked on Annual Statement Tab");
        element.waitVisibility(driver, termSelect, 10);
        Base.takeScreenShot();
    }

    public void verifyPageLoadAfterLogin() {
        element.waitVisibility(driver, userFirstName, 15);
        Base.extentTest.log(LogStatus.PASS, "Verified Scholar Admiral page loaded successfully after login");
        takeScreenShot();
    }

    public void verifyAllPageLoad() {
        verifyPageLoadAfterLogin();
        verifyFinancePageLoad();
        verifySettingsPageLoad();
    }

    public void clickOnSchoolYearFinances(String year) {
        element.waitVisibility(driver, schoolYearFinances, 25);
        schoolYearFinances.click();
        Base.extentTest.log(LogStatus.PASS, "Sucessfully Clicked on school year dropdwon: " + year);
        Base.takeScreenShot();
        String schoolYear = String.format("//li[normalize-space()='%s']", year);
        driver.findElement(By.xpath(schoolYear)).click();
//		element.waitInVisibility(driver, loadingIconFinances, 25);
        Base.extentTest.log(LogStatus.PASS, "Sucessfully Clicked on school year and Selected Year : " + year);
        Base.takeScreenShot();
    }

    public void clickOnTableStatusAnnualStatement() {
        element.waitVisibility(driver, tableStatusFinances, 15);
        tableStatusFinances.click();
        Base.extentTest.log(LogStatus.PASS, "Successfully Clicked status table");
        Base.takeScreenShot();
    }

    public void verifyAllFinancesTableHeader() {
        element.waitVisibility(driver, tableFinancesName, 15);
        element.waitVisibility(driver, tableFinancesGrade, 15);
        element.waitVisibility(driver, tableFinancesApplicationType, 15);
        element.waitVisibility(driver, tableFinancesTotalAmount, 15);
        element.waitVisibility(driver, tableFinancesTuition, 15);
        element.waitVisibility(driver, tableFinancesFees, 15);
        element.waitVisibility(driver, tableFinancesDiscount, 15);
        element.waitVisibility(driver, tableFinancesDateSubmitted, 15);
        element.waitVisibility(driver, tableStatusFinances, 15);
        Base.extentTest.log(LogStatus.PASS, "Table appeared with Annual Statements. <b> Table headers - Student Name, Grade, Application Type, Total Amount, Tuition, Fees, Discount, Date Submitted and Status/Actions. </b>");
        Base.takeScreenShot();
    }

    public void verifyAllAnnualStatementData() {
        if (element.isDisplayed(tableFinancesName)) {
            List<WebElement> allStudentNameList = tableFinancesNameRow;
            List<WebElement> allGradeList = tableFinancesGradeRow;
            List<WebElement> allApplicationTypeList = tableFinancesApplicationTypeRow;
            List<WebElement> allTotalAmountList = tableFinancesTotalAmountRow;
            List<WebElement> allTuitionList = tableFinancesTuitionRow;
            List<WebElement> allFeesList = tableFinancesFeesRow;
            List<WebElement> allDiscountList = tableFinancesDiscountRow;
            List<WebElement> allDateSubmittedList = tableFinancesDateSubmittedRow;
            List<WebElement> allStatusList = tableStatusFinancesRow;
            for (int i = 0; i < allStudentNameList.size(); i++) {
                Base.extentTest.log(LogStatus.INFO, "Annual Statement Table Row : " + i + " : Student Name : " + allStudentNameList.get(i).getText()
                        + "  Grade : " + allGradeList.get(i).getText()
                        + "  Application Type : " + allApplicationTypeList.get(i).getText()
                        + "  Total Amount : " + allTotalAmountList.get(i).getText()
                        + "  Tuition : " + allTuitionList.get(i).getText()
                        + "  Fees : " + allFeesList.get(i).getText()
                        + "  Discount : " + allDiscountList.get(i).getText()
                        + "  Date Submitted : " + allDateSubmittedList.get(i).getText()
                        + "  Status : " + allStatusList.get(i).getText());
                Base.takeScreenShot();
            }
        }
    }

    public void clickOnCreateInStatusColumnAnnualStatement() {
        element.waitVisibility(driver, tableStatusFinances, 15);
        List<WebElement> allStatusList = tableStatusFinancesRow;
        List<WebElement> allStudentNameList = tableFinancesNameRow;
        boolean shouldExit = false;
        for (int i = 1; i < allStatusList.size() && !shouldExit; i++) {
            if (allStatusList.get(i).getText().contains("Not Started")) {
//			if(allStatusList.get(i).getText().contains("Edit")){
                createButtonAnnualStatements.get(i).click();
                element.waitVisibility(driver, annualStatementTitle, 25);
                Base.extentTest.log(LogStatus.PASS, "Successfully clicked on Create Button. ");
                Base.takeScreenShot();
                shouldExit = true;
            }

        }
    }

    public void verifyAllDetailsOnAnnualStatementDetails() {
        element.waitVisibility(driver, discountTotalAnnualTuition, 15);
        element.waitVisibility(driver, discountsTable, 15);
        element.waitVisibility(driver, descriptionAutoPopulateTable, 15);
        element.waitVisibility(driver, descriptionTableClickToAddItem, 15);
        element.waitVisibility(driver, gradeSelectDropDown, 15);
        element.waitVisibility(driver, descriptionTableTuition, 15);
        element.waitVisibility(driver, descriptionHeadingTableAnnualStatement, 15);
        Base.extentTest.log(LogStatus.PASS, "Successfully landed on Annual Statement Details Page");
        Base.takeScreenShot();
    }

    public void enterDateInAnnualStatement(String date, String monthNumeric, String year) {
        element.waitVisibility(driver, dateInputMonth, 25);
        browserDriver.scrollToElement(driver, dateInputDate);
        dateInputDate.sendKeys(date);
        dateInputMonth.sendKeys(monthNumeric);
        dateInputYear.sendKeys(year);
        Base.extentTest.log(LogStatus.PASS, "Successfully Entered the date");
        Base.takeScreenShot();
    }

    public void changeGrade(String grade) {
        element.waitVisibility(driver, gradeSelectDropDown, 15);
        Select select = new Select(gradeSelectDropDown);
        select.selectByValue(grade);
        Base.extentTest.log(LogStatus.PASS, "Successfully Entered the date");
        Base.takeScreenShot();
    }

    public void verifyStudentDetailsAreReadonly() {
        element.waitVisibility(driver, parentOrGuardianNameStudentAnnaualStatement, 15);
        boolean studentNameReadonly = false;
        boolean studentStatementDateReadonly = false;
        boolean studentDOBReadonly = false;
        boolean studentparentOrGurdianNameReadonly = false;

        try {
            parentOrGuardianNameStudentAnnaualStatement.sendKeys("New Parent Name");
        } catch (Exception e) {
            studentparentOrGurdianNameReadonly = true;
        }

        if (studentparentOrGurdianNameReadonly) {
            Base.extentTest.log(LogStatus.PASS, "Student's parent or guradian name field is readonly.");
            Base.takeScreenShot();
        }

        try {
            studentStatementDateAnnualStatement.sendKeys("New Statement Date");
        } catch (Exception e) {
            studentStatementDateReadonly = true;
        }

        if (studentStatementDateReadonly) {
            Base.extentTest.log(LogStatus.PASS, "Student's Submitted Date field is readonly.");
            Base.takeScreenShot();
        }

        try {
            studentDOBDetailsAnnualStatement.sendKeys("New DOB Date");
        } catch (Exception e) {
            studentDOBReadonly = true;
        }

        if (studentDOBReadonly) {
            Base.extentTest.log(LogStatus.PASS, "Student's DOB date field is readonly.");
            Base.takeScreenShot();
        }

        try {
            studentNameDetailsAnnualStatement.sendKeys("New Student Name");
        } catch (Exception e) {
            studentNameReadonly = true;
        }

        if (studentNameReadonly) {
            Base.extentTest.log(LogStatus.PASS, "Student Name field is readonly.");
            Base.takeScreenShot();
        }

    }

    public void enterAllDescriptionRequiredDataAndSubmit(String feesName1, String feesName2) throws InterruptedException {
        String studentNameAnnualStatement = nameOnAnnualStatementDetailsPage.getText();
        browserDriver.scrollToElement(driver, descriptionTableClickToAddItem);
        descriptionTableClickToAddItem.click();
        Base.extentTest.log(LogStatus.PASS, "Successfully Clicked on Click to add item");
        Base.takeScreenShot();

        int sizeOfFeesDiv = feesTableDiv.size();
        WebElement element1 = driver.findElement(By.xpath("(//div[@class='fees-table']//div/div)" + "[" + (sizeOfFeesDiv - 3) + "]"));
        element1.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(element1, feesName1, Keys.ENTER).perform();
        Base.extentTest.log(LogStatus.PASS, "Successfully Entered the new Fees named : " + feesName1);
        Base.takeScreenShot();

        descriptionTableClickToAddItem.click();
        Base.extentTest.log(LogStatus.PASS, "Successfully Clicked on Click to add item");
        Base.takeScreenShot();

        sizeOfFeesDiv = feesTableDiv.size();
        WebElement element2 = driver.findElement(By.xpath("(//div[@class='fees-table']//div/div)" + "[" + (sizeOfFeesDiv - 3) + "]"));
        element2.click();
        actions.sendKeys(element2, feesName2, Keys.ENTER).perform();
        Base.extentTest.log(LogStatus.PASS, "Successfully Entered the new Fees named : " + feesName2);
        Base.takeScreenShot();

        for (int i = 1; i < inputFeeValue.size(); i++) {
            inputFeeValue.get(i - 1).click();
            inputFeeValue.get(i - 1).sendKeys("400");
        }
        Base.extentTest.log(LogStatus.PASS, "Successfully Entered the new Fees Amount ");
        Thread.sleep(2000);
        Base.takeScreenShot();

        submitChangesButton.click();
        Base.extentTest.log(LogStatus.PASS, "Successfully Clicked on Submit changes");
        Thread.sleep(2000);
        Base.takeScreenShot();

        backButtonToAllAnnualStatement.click();
        Thread.sleep(2000);
        Base.extentTest.log(LogStatus.PASS, "Successfully Clicked on back to all annual statement");
        Base.takeScreenShot();

        element.waitVisibility(driver, tableFinancesName, 25);
        List<WebElement> allStatusList = tableStatusFinancesRow;
        List<WebElement> allStudentNameList = tableFinancesNameRow;
        for (int i = 1; i < tableFinancesNameRow.size(); i++) {
            if (allStudentNameList.get(i).getText().contains(studentNameAnnualStatement)) {
                if (allStatusList.get(i).getText().contains("Submitted")) {
                    logger.info("Rajaji");
                    Base.extentTest.log(LogStatus.PASS, "Successfully verified the submitted the changes for Student Name : " + studentNameAnnualStatement);
                    Base.takeScreenShot();
                }
            }
        }
    }


    public String changeUsername() throws InterruptedException {
        String newUsernameValue;

        String ExistingPassword = TestProperties.get("password");
        Base.extentTest.log(LogStatus.PASS, "Existing Password is :: " + ExistingPassword);

        element.waitVisibility(driver, siteSettingIcon, 15);
        element.clickByJs(driver, siteSettingIcon);
        Base.extentTest.log(LogStatus.PASS, "Site Settings icon is clicked");
        takeScreenShot();

        element.waitVisibility(driver, usersTab, 15);
        element.clickByJs(driver, usersTab);
        Base.extentTest.log(LogStatus.PASS, "User tab is clicked successfully");
        takeScreenShot();

        element.waitVisibility(driver, searchTextbox, 15);
        element.clickByJs(driver, searchTextbox);
        searchTextbox.sendKeys(TestProperties.get("parentuserpwdchange"));
        Actions hitEnter = new Actions(driver);
        hitEnter.sendKeys(Keys.chord(Keys.ENTER)).perform();
        Base.extentTest.log(LogStatus.PASS, "User is searched successfully");
        takeScreenShot();

        element.clickByJs(driver, openUser);
        Base.extentTest.log(LogStatus.PASS, "User is selected successfully");
        takeScreenShot();

	/*	element.waitVisibility(driver, changePasswordButton, 15);
		Base.extentTest.log(LogStatus.PASS, "User is selected successfully");
		takeScreenShot();*/


        browserDriver.scrollToElement(driver, selectActionsButton);
        element.waitVisibility(driver, selectActionsButton, 15);
        selectActionsButton.click();
        Base.extentTest.log(LogStatus.PASS, "Select Actions button is clicked");
        takeScreenShot();

        element.waitVisibility(driver, changeUsernameButton, 15);
        changeUsernameButton.click();
        Base.extentTest.log(LogStatus.PASS, "Change Username option is clicked");
        takeScreenShot();

        Thread.sleep(3000);
        String ExistingUsername = existingUsernameTextBox.getAttribute("value");
        if (ExistingUsername.contains("updated")) {
            newUsernameValue = base.splitUsername(ExistingUsername, "updated");
            Base.extentTest.log(LogStatus.PASS, "New Username value is " + newUsernameValue);

        } else {
            newUsernameValue = base.updateUsername(ExistingUsername, "updated");
            Base.extentTest.log(LogStatus.PASS, "New Username value is " + newUsernameValue);
        }
        element.enterValue(newUsernameTextBox, newUsernameValue);
        Base.extentTest.log(LogStatus.PASS, "New Username entered in New Username text field is <b>" + newUsernameValue + "</b>");
        takeScreenShot();
        changeUsernameModelWindow.click();
        Thread.sleep(5000);

        element.waitVisibility(driver, saveButton, 15);
        element.clickByJs(driver, saveButton);
        Base.extentTest.log(LogStatus.PASS, "Save button is clicked");
        takeScreenShot();

        Thread.sleep(8000);
        element.waitVisibility(driver, savechanges, 15);
        savechanges.click();
        //	element.clickByJs(driver, savechanges);
        Base.extentTest.log(LogStatus.PASS, "Save Changes button is clicked");
        takeScreenShot();

        Thread.sleep(2000);
        return newUsernameValue;
    }

    public void ActionButton() throws InterruptedException {
        Thread.sleep(15000);
        element.click(driver, actionButton);
        takeScreenShot();
    }

    public void checkApplicationStatuses() throws InterruptedException {
        selectAcceptedApplication();
        extentTest.log(LogStatus.PASS, "Verified : Selected an Accepted Application");

        element.waitVisibility(driver, clickOnFirstName, 20);
        extentTest.log(LogStatus.PASS, "Selecting the student named " + clickOnFirstName.getText());
        clickOnFirstName.click();
        takeScreenShot();

        //Clicking on Actions button
        actionButton.click();
        extentTest.log(LogStatus.PASS, "Clicked on Actions button");
        takeScreenShot();

        //Clicking on Edit Status link
        actionsLeadsEditStatusLink.click();
        extentTest.log(LogStatus.PASS, "Clicked on Edit Status Link");
        takeScreenShot();

        //Clicking on New Status
        newStatusDropdown.click();
        extentTest.log(LogStatus.PASS, "Clicked on Edit Status Link");
        takeScreenShot();


    }

    public void revertstudentData(String revertText) {
        extentTest.log(LogStatus.PASS, "Selecting the student named " + clickOnFirstName.getText());
        clickOnFirstName.click();
        takeScreenShot();

        // Editing the form
        browserDriver.scrollToElement(driver, stuFirstName);
        element.waitVisibility(driver, stuFirstName, 30);
        stuFirstName.clear();
        stuFirstName.sendKeys(revertText);
        String updatedFirstName = stuFirstName.getText();
        extentTest.log(LogStatus.PASS, "The updated first name of the student before edit is :: " + updatedFirstName);
        savechanges.click();
        extentTest.log(LogStatus.PASS, "Clicked on <b>Save Changes</b> button");
        takeScreenShot();

        //Clicking on Back to all link
        clickSelectToAllLink();
    }

    public void clickSelectToAllLink() {
        element.waitVisibility(driver, backToAllLink, 20);
        backToAllLink.click();
        logger.info("Clicked on <b>Back to all</b> link");
        extentTest.log(LogStatus.PASS, "Clicked on <b>Back to all</b> link");
        takeScreenShot();
    }

    public String ApplicationStatement(String updatedText) throws InterruptedException {
        application.click();
        extentTest.log(LogStatus.PASS, "Clicked on application icon");
        String stuOriginalFirstName = clickOnFirstName.getText();
        extentTest.log(LogStatus.PASS, "The actual first name of the student before edit is :: " + stuOriginalFirstName);
        takeScreenShot();

        //	browserDriver.scrollToElement(driver, clickOnFirstName);
        extentTest.log(LogStatus.PASS, "Selecting the student named " + clickOnFirstName.getText());
        clickOnFirstName.click();
        takeScreenShot();

        //Verifying the headings from the page
        //Application Information section
        extentTest.log(LogStatus.PASS, "Application Information section is read only");
        takeScreenShot();

        // Verifying SECTION A - STUDENT INFORMATION
        browserDriver.scrollToElement(driver, sectionStudentInformation);
        Assert.assertTrue(sectionStudentInformation.isDisplayed());
        extentTest.log(LogStatus.PASS, "SECTION A - STUDENT INFORMATION is available");
        takeScreenShot();

        // Verifying SECTION B - PARENT INFORMATION
        browserDriver.scrollToElement(driver, sectionParentInformation);
        Assert.assertTrue(sectionParentInformation.isDisplayed());
        extentTest.log(LogStatus.PASS, "SECTION A - PARENT INFORMATION is available");
        takeScreenShot();

        // Verifying SECTION C - ELIGIBILITY VERIFICATION
        browserDriver.scrollToElement(driver, sectionEligibilityVerification);
        Assert.assertTrue(sectionEligibilityVerification.isDisplayed());
        extentTest.log(LogStatus.PASS, "SECTION C - ELIGIBILITY VERIFICATION is available");
        takeScreenShot();

        // Verifying SECTION D - ENROLLMENT VERIFICATION
        browserDriver.scrollToElement(driver, sectionEnrollmentVerification);
        Assert.assertTrue(sectionEnrollmentVerification.isDisplayed());
        extentTest.log(LogStatus.PASS, "SECTION D - ENROLLMENT VERIFICATION is available");
        takeScreenShot();

        // Verifying DOCUMENTS
        browserDriver.scrollToElement(driver, sectionDocuments);
        Assert.assertTrue(sectionDocuments.isDisplayed());
        extentTest.log(LogStatus.PASS, "DOCUMENTS is available");
        takeScreenShot();

        // Verifying LNH REQUIRED DATA COLLECTION
        browserDriver.scrollToElement(driver, sectionLNHRequiredDataCollection);
        Assert.assertTrue(sectionLNHRequiredDataCollection.isDisplayed());
        extentTest.log(LogStatus.PASS, "LNH REQUIRED DATA COLLECTION is available");
        takeScreenShot();

        // Editing the form
        browserDriver.scrollToElement(driver, stuFirstName);
        element.waitVisibility(driver, stuFirstName, 30);
        stuFirstName.clear();
        stuFirstName.sendKeys(updatedText);
        String updatedFirstName = stuFirstName.getText();
        extentTest.log(LogStatus.PASS, "The updated first name of the student before edit is :: " + updatedFirstName);
        savechanges.click();
        extentTest.log(LogStatus.PASS, "Clicked on <b>Save Changes</b> button");
        takeScreenShot();

        return stuOriginalFirstName;
    }

    public void changeEnrollement() throws InterruptedException {
        element.click(driver, dropdown);
        extentTest.log(LogStatus.PASS, "Clicked on dropdown");
        takeScreenShot();
        options.stream().filter(e -> e.getText().contains("Change enrollment"))
                .collect(Collectors.toList()).get(0).click();
        Thread.sleep(5000);
        extentTest.log(LogStatus.PASS, "Selected an option Change Enrollment");
        takeScreenShot();
        element.click(driver, changeEnrollmentButton);
        extentTest.log(LogStatus.PASS, "Click on Change Enrollment");
        Thread.sleep(10000);
    }

    public void selectFirstStudentName() throws InterruptedException {
        element.waitVisibility(driver, studentfirstname, 30);
        String nameTBV = studentfirstname.getText();
        String studentName = String.format(fname, nameTBV);
        driver.findElement(By.xpath(studentName)).click();
        logger.info("Student is clicked");
        Base.extentTest.log(LogStatus.PASS, "Student is clicked");
        takeScreenShot();
    }

    public void verify_state_homepage_icons() throws InterruptedException {
        Thread.sleep(5000);
        state_homepage_logo_icon();
        applications_icon();
        finances_icon();
        settings_icon();
        logout_icon();
    }


    public void logout_icon() {
        element.waitVisibility(driver, logoutbutton, 15);
        String finances_data_name = logoutbutton.getText();
        Base.extentTest.log(LogStatus.PASS, "Verified <b>logout icon</b> on State homepage as " + finances_data_name);
        takeScreenShot();
    }

    public void settings_icon() {
        element.waitVisibility(driver, settings, 15);
        String settings_data_name = settings.getText();
        Base.extentTest.log(LogStatus.PASS, "Verified <b>Settings icon</b> on State homepage as " + settings_data_name);
        takeScreenShot();
    }

    public void finances_icon() {
        element.waitVisibility(driver, finances, 15);
        String finances_data_name = finances.getText();
        Base.extentTest.log(LogStatus.PASS, "Verified <b>Finance icon</b> on State homepage as " + finances_data_name);
        takeScreenShot();
    }

    public void click_finance_icon() throws InterruptedException {
        finances.click();
        Base.extentTest.log(LogStatus.PASS, "Finance icon is clicked ");
        Thread.sleep(3000);
        takeScreenShot();
    }

    public void click_annualstatement_tab() {
        element.waitVisibility(driver, annualstatement, 15);
        annualstatement.click();
        Base.extentTest.log(LogStatus.PASS, "Annual Statement Tab is clicked ");
        takeScreenShot();
    }

    public void applications_icon() {
        element.waitVisibility(driver, applications, 15);
        String applications_data_name = applications.getText();
        Base.extentTest.log(LogStatus.PASS, "Verified <b>Applications icon</b> on State homepage as " + applications_data_name);
        takeScreenShot();
    }

    public void state_homepage_logo_icon() {
        element.waitVisibility(driver, logo, 15);
        String logo_data_name = logo.getAttribute("data-name");
        Base.extentTest.log(LogStatus.PASS, "Verified Scholar logo on State homepage as " + logo_data_name);
        takeScreenShot();
    }

    public String changeUserPassword() throws InterruptedException {
        String ExistingPassword = TestProperties.get("password");
        Base.extentTest.log(LogStatus.PASS, "Existing Password is :: " + ExistingPassword);

        //	element.waitVisibleBy(driver, By.xpath("//span[text()[contains(.,'Site Settings')]]"), 15);
        element.waitVisibility(driver, siteSettingIcon, 15);
        element.clickByJs(driver, siteSettingIcon);
        Base.extentTest.log(LogStatus.PASS, "Site Settings icon is clicked");
        takeScreenShot();

        element.waitVisibility(driver, usersTab, 15);
        element.clickByJs(driver, usersTab);
        Base.extentTest.log(LogStatus.PASS, "User tab is clicked successfully");
        takeScreenShot();

        element.waitVisibility(driver, searchTextbox, 15);
        element.clickByJs(driver, searchTextbox);
        searchTextbox.sendKeys(TestProperties.get("parentuserpwdchange"));
        Actions hitEnter = new Actions(driver);
        hitEnter.sendKeys(Keys.chord(Keys.ENTER)).perform();
        Base.extentTest.log(LogStatus.PASS, "User is searched successfully");
        takeScreenShot();

        element.clickByJs(driver, openUser);
        Base.extentTest.log(LogStatus.PASS, "User is selected successfully");
        takeScreenShot();


        browserDriver.scrollToElement(driver, selectActionsButton);
        element.waitVisibility(driver, selectActionsButton, 15);
        selectActionsButton.click();
        Base.extentTest.log(LogStatus.PASS, "Select Actions button is clicked");
        takeScreenShot();
        ;

        element.clickByJs(driver, changePasswordButton);
        element.waitVisibility(driver, newPasswordTextBox, 15);
        Base.extentTest.log(LogStatus.PASS, "Change Password Button is clicked");
        takeScreenShot();

        Base.extentTest.log(LogStatus.PASS, "Password before change is :: " + ExistingPassword);
        String newPasswordValue = base.getNewPassword(ExistingPassword);
        Base.extentTest.log(LogStatus.PASS, "Change password would be :: " + newPasswordValue);

        element.clickByJs(driver, newPasswordTextBox);
        // element.enterValue(newPasswordTextBox, TestProperties.get("password"));
        element.enterValue(newPasswordTextBox, newPasswordValue);
        Base.extentTest.log(LogStatus.PASS, "New Password is entered in New Password text field is " + newPasswordValue);
        takeScreenShot();

        element.clickByJs(driver, confirmNewPasswordTextBox);
        element.enterValue(confirmNewPasswordTextBox, newPasswordValue);
        Base.extentTest.log(LogStatus.PASS, "New Password is entered in Confirm New Password text field is " + newPasswordValue);
        takeScreenShot();

        element.waitVisibility(driver, resetPasswordButton, 15);
        element.clickByJs(driver, resetPasswordButton);
        element.waitVisibility(driver, saveChangesToast, 15);
        Base.extentTest.log(LogStatus.PASS, "Reset Password Button is clicked");
        element.waitVisibility(driver, savechanges, 15);
        takeScreenShot();

        //	element.clickByJs(driver,savechanges);
        savechanges.click();
        element.waitVisibility(driver, saveChangesToast, 15);
        Base.extentTest.log(LogStatus.PASS, "Save Changes button is clicked");
        takeScreenShot();

        return newPasswordValue;
    }

    public void verifyinfopage() throws InterruptedException {

        base.timeinterval(3);
        element.isDisplayed(infoIcon);

        Assert.assertTrue(infoIcon.isDisplayed());
        Base.extentTest.log(LogStatus.PASS, "My info is an option on the nav bar");
        takeScreenShot();

        infoIcon.click();
        Base.extentTest.log(LogStatus.PASS, "My info icon is clicked and Page loads with accurate information, same as it was used to create the account. ");
        takeScreenShot();
        base.timeinterval(3);

        Assert.assertFalse(username.isEnabled());
        Base.extentTest.log(LogStatus.PASS, "Username is read only");
        takeScreenShot();
        base.timeinterval(3);

        Assert.assertFalse(password.isEnabled());
        Base.extentTest.log(LogStatus.PASS, "Password is read only");
        takeScreenShot();
        base.timeinterval(3);

        Assert.assertTrue(base.compLocation(usernameLocation, passwordLocation));
        Base.extentTest.log(LogStatus.PASS, passwordLocation.getText() + " section is underneath " + usernameLocation.getText() + " section");
        takeScreenShot();
    }

    public void saveEditChanges() throws InterruptedException {
        firstname.clear();
        Base.extentTest.log(LogStatus.PASS, "firstname cleared");
        takeScreenShot();
        base.timeinterval(3);

        firstname.sendKeys("Andrew");
        Base.extentTest.log(LogStatus.PASS, "firstname entered");
        //base.timeinterval(3);
        takeScreenShot();

        lastname.clear();
        Base.extentTest.log(LogStatus.PASS, "lastname cleared");
        base.timeinterval(3);
        takeScreenShot();

        lastname.sendKeys("Ramjas");
        Base.extentTest.log(LogStatus.PASS, "lastname entered");
        takeScreenShot();

        element.isDisplayed(savechanges);
        Assert.assertTrue(savechanges.isDisplayed());
        logger.info("Save changes is displayed");
        Base.extentTest.log(LogStatus.PASS, "Save changes is displayed");
        takeScreenShot();

        base.timeinterval(5);
        savechanges.click();
        takeScreenShot();
        Base.extentTest.log(LogStatus.PASS, "Above image shows that Save changes button is clicked and verbiage of Save Changes button after clicked is " + savechanges.getText() + ".");

        if (firstnameState.isEnabled() && lastnameState.isEnabled()) {
            Base.extentTest.log(LogStatus.PASS, firstnameState.getText() + " and " + lastnameState.getText() + " are disabled during saving changes");
        } else {
            Base.extentTest.log(LogStatus.PASS, firstnameState.getText() + " and " + lastnameState.getText() + " are not disabled during saving changes");
        }
        takeScreenShot();
    }

    public void admiralLogout() throws InterruptedException {
        element.isDisplayed(logout);
        Assert.assertTrue(logout.isDisplayed());
        logger.info("logout button is displayed");
        Base.extentTest.log(LogStatus.PASS, "log out button is displayed");
        takeScreenShot();

        base.timeinterval(3);
        logout.click();
        logger.info("log out button is clicked");
        Base.extentTest.log(LogStatus.PASS, "log out button is clicked");
        takeScreenShot();
    }

    public void SelectChangeReason(String changereason) throws InterruptedException {
        element.selectVisibleOption(reason, changereason);
        Thread.sleep(5000);
        logger.info("Select Change Reason " + changereason);
        Base.extentTest.log(LogStatus.PASS, "Select Change Reason " + changereason);
        takeScreenShot();

        if (changereason.equals("Withdrawal")) {
            Actions act = new Actions(driver);
            act.moveToElement(opencal.get(0)).click().build().perform();
            logger.info("Open Calender ICON");
            Base.extentTest.log(LogStatus.PASS, "Open Calender ICON");
            takeScreenShot();

            element.click(driver, exitDates.get(0));
            logger.info("Select Exist Date");
            Base.extentTest.log(LogStatus.PASS, "Select Exist Date");
            takeScreenShot();

            element.click(driver, save);
            Thread.sleep(5000);
            logger.info("Click on Save");
            Base.extentTest.log(LogStatus.PASS, "Click on Save");
            takeScreenShot();
        } else {
            element.click(driver, save);
            logger.info("Click on Save");
            Base.extentTest.log(LogStatus.PASS, "Click on Save");
            takeScreenShot();

            extentTest.log(LogStatus.PASS, "Verified : Error Message:: " + element.getValue(schoolNameError));
            extentTest.log(LogStatus.PASS, "Verified : Error Message:: " + element.getValue(exitDateError));
            extentTest.log(LogStatus.PASS, "Verified : Error Message:: " + element.getValue(entryDateError));
            logger.info("Verify all the Errors");
            Base.extentTest.log(LogStatus.PASS, "Verify all the errors");
            takeScreenShot();

            element.selectVisibleOption(enteringSchoolDropdown, "The Academy of Classical Christian Studies ");
            logger.info("Select Entring School:: The Academy of Classical Christian Studies");
            Base.extentTest.log(LogStatus.PASS, "Select Entring School:: The Academy of Classical Christian Studies");
            takeScreenShot();

            Actions act = new Actions(driver);
            act.moveToElement(opencal.get(0)).click().build().perform();
            element.click(driver, exitDates.get(0));
            logger.info("Select Exit Date");
            Base.extentTest.log(LogStatus.PASS, "Select Exit Date");
            takeScreenShot();

            act.moveToElement(opencal.get(1)).click().build().perform();
            element.click(driver, entryDates.get(0));
            logger.info("Select Entry Date");
            Base.extentTest.log(LogStatus.PASS, "Select Entry Date");
            takeScreenShot();

            element.click(driver, save);
            logger.info("Click on Save");
            Base.extentTest.log(LogStatus.PASS, "Click on Save");
            takeScreenShot();
            Thread.sleep(5000);
        }
    }

    public void assignSchoolToSTateUser(String oldschool) throws InterruptedException {
        Thread.sleep(5000);
        element.waitVisibility(driver, siteSettingIcon, 15);
        element.clickByJs(driver, siteSettingIcon);
        Base.extentTest.log(LogStatus.PASS, "Site Settings icon is clicked");
        takeScreenShot();

        element.waitVisibility(driver, usersTab, 15);
        element.clickByJs(driver, usersTab);
        Base.extentTest.log(LogStatus.PASS, "User tab is clicked successfully");
        takeScreenShot();

        element.waitVisibility(driver, searchTextbox, 15);
        element.clickByJs(driver, searchTextbox);
        searchTextbox.sendKeys("saharanqa2023+sch1@gmail.com" + Keys.ENTER);

        element.click(driver, name);
        Base.extentTest.log(LogStatus.PASS, "Select user successfully");
        takeScreenShot();
        Thread.sleep(5000);

        element.selectVisibleOption(organization, oldschool);
        Base.extentTest.log(LogStatus.PASS, "Select OLD SCHOOL " + oldschool);
        takeScreenShot();

        element.waitVisibility(driver, savechanges, 15);
        element.clickByJs(driver, savechanges);
        Base.extentTest.log(LogStatus.PASS, "Save Changes button is clicked");
        takeScreenShot();
        Thread.sleep(5000);
    }

    public void isStudentExists(String name) throws InterruptedException {
        element.click(driver, students);
        Base.extentTest.log(LogStatus.PASS, "Students Tab is clicked");
        takeScreenShot();
        Thread.sleep(5000);
        boolean bool = false;
        Actions act = new Actions(driver);
        if (currentpages.size() == 0) {
            int matchCount = studentNames.stream().filter(e -> e.getText().equalsIgnoreCase(name)).collect(Collectors.toList()).size();
            if (matchCount != 0) {
                bool = true;
            }
        } else {
            for (int i = 0; i < studentTables.size(); i++) {
                for (int j = 0; j < studentNames.size(); j++) {
                    System.out.println(studentNames.get(j).getText());
                    if (name.equalsIgnoreCase(studentNames.get(j).getText())) {
                        System.out.println("Old name :: " + name);
                        System.out.println("New name :: " + studentNames.get(j).getText());
                        bool = true;
                        studentNames.get(j).click();
                        takeScreenShot();
                    }
                    if (currentpages.get(j).getText() != maxpages.get(j).getText()) {
                        nextbuttons.get(j).click();
                    } else {
                        break;
                    }
                }

            }
        }
        if (bool)
            extentTest.log(LogStatus.PASS, "Verified : User available after Withdraw");
        else
            extentTest.log(LogStatus.FAIL, "Verified : User NOT available after Withdraw");
        takeScreenShot();
    }

    public void verifyStudentExists(String name) throws InterruptedException {
        element.click(driver, students);
        Base.extentTest.log(LogStatus.PASS, "Students Tab is clicked");
        takeScreenShot();
        Thread.sleep(5000);
        boolean bool = false;

        if (currentpages.size() == 0) {
            int matchCount = studentNames.stream().filter(e -> e.getText().equalsIgnoreCase(name)).collect(Collectors.toList()).size();
            if (matchCount != 0) {
                bool = true;
            }
        } else {
            for (int i = 0; i < studentTables.size(); i++) {
                for (int j = 0; j < studentNames.size(); j++) {
                    System.out.println(studentNames.get(j).getText());
                    if (name.equalsIgnoreCase(studentNames.get(j).getText())) {
                        System.out.println("Old name :: " + name);
                        System.out.println("New name :: " + studentNames.get(j).getText());
                        bool = true;
                        studentNames.get(j).click();
                        takeScreenShot();
                    }
                }
                if (currentpages.get(i).getText().equalsIgnoreCase(maxpages.get(i).getText())) {
                    break;
                } else {
                    nextbuttons.get(i).click();
                    Thread.sleep(1000);
                }

            }
        }
        if (bool)
            extentTest.log(LogStatus.FAIL, "Verified : User available after Withdraw");
        else
            extentTest.log(LogStatus.PASS, "Verified : User NOT available after Withdraw");
        takeScreenShot();
    }

    public HashMap<String, String> selectAcceptedApplication() throws InterruptedException {
        HashMap<String, String> map = new HashMap<>();
        Thread.sleep(5000);
        Actions a = new Actions(driver);
        a.moveToElement(status).click().build().perform();
        Thread.sleep(3000);
        a.moveToElement(liststatus.stream().filter(e -> e.getText().contains("Accepted")).collect(Collectors.toList()).get(0)).click().build().perform();

        a.moveToElement(filters).click().build().perform();
        Thread.sleep(5000);

        map.put("lName", userLastName.getText());
        extentTest.log(LogStatus.PASS, "User Last Name is :: " + userLastName.getText());
        map.put("fname", userFirstName.getText());
        extentTest.log(LogStatus.PASS, "User First Name is :: " + userFirstName.getText());
        map.put("oldschool", userSchoolName.getText());
        extentTest.log(LogStatus.PASS, "School User Name is :: " + userSchoolName.getText());

        element.click(driver, userLastName);
        Thread.sleep(15000);

        return map;
    }

    public void verifyChangeUserType(String uType) throws InterruptedException {
        element.waitVisibility(driver, siteSettingIcon, 15);
        element.clickByJs(driver, siteSettingIcon);
        Base.extentTest.log(LogStatus.PASS, "Site Settings icon is clicked");
        takeScreenShot();

        Thread.sleep(9000);
        element.waitVisibility(driver, usersTab, 15);
        element.clickByJs(driver, usersTab);
        Base.extentTest.log(LogStatus.PASS, "User tab is clicked successfully");
        takeScreenShot();

        Thread.sleep(9000);
        element.waitVisibility(driver, addUser, 15);
        element.clickByJs(driver, addUser);
        Base.extentTest.log(LogStatus.PASS, "Add User button is clicked successfully");
        takeScreenShot();

        Thread.sleep(9000);
        element.waitVisibility(driver, usersTypeDropDownArrow, 15);
        usersTypeDropDownArrow.click();
        logger.info("Clicked on User Type dropdown arrow");
        extentTest.log(LogStatus.PASS, "Clicked on User Type dropdown arrow");
        takeScreenShot();

        itemToBESelected(uType);
        Thread.sleep(2000);
        logger.info("Clicked on User Type dropdown Value");
        extentTest.log(LogStatus.PASS, "Clicked on User Type dropdown Value");
        takeScreenShot();

        firstName.clear();
        firstName.sendKeys("Karjun");
        logger.info("Entered first name");
        Base.extentTest.log(LogStatus.PASS, "Entered first name");
        Base.takeScreenShot();

        if (uType.equalsIgnoreCase("Scholarship Admin")) {
            Assert.assertFalse(organizationField.isEnabled());
            extentTest.log(LogStatus.PASS, "organization Field is not editable");
            takeScreenShot();
        }
        lastName.clear();
        lastName.sendKeys("Zooman");
        logger.info("Entered last name");
        Base.extentTest.log(LogStatus.PASS, "Entered last name");
        Base.takeScreenShot();

        phoneNumber.clear();
        phoneNumber.sendKeys("9011223344");
        logger.info("Entered last name");
        Base.extentTest.log(LogStatus.PASS, "Entered Phone Number");
        Base.takeScreenShot();

        emailAddress.clear();
        String email = base.getSaltString();
        emailAddress.sendKeys(email + "@gmail.com");
        logger.info("Entered last name");
        Base.extentTest.log(LogStatus.PASS, "Entered Email Address");
        Base.takeScreenShot();

        element.waitVisibility(driver, saveChangesButton, 15);
        element.clickByJs(driver, saveChangesButton);
        Base.extentTest.log(LogStatus.PASS, "Save button is clicked");
        takeScreenShot();

        element.waitVisibility(driver, saveChangesButton, 15);
        element.clickByJs(driver, saveChangesButton);
        Base.extentTest.log(LogStatus.PASS, "Save button is clicked");
        takeScreenShot();

	/*	Thread.sleep(8000);
		element.waitVisibility(driver,savechanges,15);
		savechanges.click();
		Base.extentTest.log(LogStatus.PASS, "Save Changes button is clicked");
		takeScreenShot();*/

        Thread.sleep(2000);
    }

    public void itemToBESelected(String itmName) {
        String fname = String.format("//span[contains(text(),'%s')]", itmName);
        driver.findElement(By.xpath(fname)).click();
        logger.info("Value selected from the dropdown is " + itmName);
        Base.extentTest.log(LogStatus.PASS, "Value selected from the dropdown is " + itmName);
        takeScreenShot();
    }

    public void clickOnAutopopulate() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", autopopulate);

        element.waitVisibility(driver, autopopulate, 15);
        autopopulate.click();
        Base.extentTest.log(LogStatus.PASS, "Clicked on Autopopulate Button");
        Base.takeScreenShot();
    }
}
