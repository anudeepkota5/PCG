package com.pcgus.ci.scholar.testcases.privateschool;

import com.pcgus.ci.BrowserDriver;
import com.pcgus.ci.TestProperties;
import com.pcgus.ci.scholar.pages.Homepage;
import com.pcgus.ci.scholar.pages.Loginpage;
import com.pcgus.ci.scholar.pages.ScholarAdmiralPage;
import com.pcgus.ci.scholar.testbase.Base;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class School_Finance_AnnualStatement_CreateAndSubmitStatementTest extends  Base{

    private static final String TEST_ID ="z74xhwawesmgrpe6cqnqiqyajddq4t3t";

    Loginpage loginPage=new Loginpage();
    Base scholarbase=new Base();

    Homepage homePage = new Homepage();

    ScholarAdmiralPage admiralpage = new ScholarAdmiralPage();

    @Test
    public void school_finance_annualstatement_createandsubmitstatement_z74xhwawesmgrpe6cqnqiqyajddq4t3t12_test() throws InterruptedException {
        setTestId(TEST_ID);
        BrowserDriver.setDriver(Base.driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Private School - Finances - Annual Statements - Create and Submit Statement");
        loginPage.LoginPageDriverRef(Base.driver);
        admiralpage.admiraluserPageDriverRef(Base.driver);
        homePage.HomePageDriverRef(Base.driver);

        scholarbase.loginToPCGScholarPortal(TestProperties.get("privateSchoolEmail"), TestProperties.get("password"));
        extentTest.log(LogStatus.PASS, "Verified : Logged in as Parent user account");

        admiralpage.click_finance_icon();
        extentTest.log(LogStatus.PASS, "Verified: Successfully clicked on Finances Icon");

        admiralpage.click_annualstatement_tab();
        extentTest.log(LogStatus.PASS, "Verified: Successfully clicked on Annual Statement");

        admiralpage.clickOnSchoolYearFinances(TestProperties.get("annualStatementYear"));
        extentTest.log(LogStatus.PASS, "Verified: Successfully clicked on Year");

        admiralpage.verifyAllFinancesTableHeader();
        extentTest.log(LogStatus.PASS, "Verified: Annual Statement table's header ");

        admiralpage.verifyAllAnnualStatementData();
        extentTest.log(LogStatus.PASS, "Verified: Annual Statement table's data ");

        admiralpage.clickOnCreateInStatusColumnAnnualStatement();
        extentTest.log(LogStatus.PASS, "Verified: Successfully clicked on Create in Annual Statement table ");

        admiralpage.verifyAllDetailsOnAnnualStatementDetails();
        extentTest.log(LogStatus.PASS, "Verified: Successfully landed on Annual Statement Details Page");

        admiralpage.verifyStudentDetailsAreReadonly();
        extentTest.log(LogStatus.PASS, "Verified: Student details table is readonly.");

        admiralpage.enterDateInAnnualStatement(TestProperties.get("date"), TestProperties.get("monthNumeric"), TestProperties.get("year"));
        extentTest.log(LogStatus.PASS, "Verified: Successfully entered the date on Annual Statement Details Page");

        admiralpage.changeGrade(TestProperties.get("grade"));
        extentTest.log(LogStatus.PASS, "Verified: Successfully changed the grade on Annual Statement Details Page");

        admiralpage.enterAllDescriptionRequiredDataAndSubmit(TestProperties.get("feesName1"), TestProperties.get("feesName2"));
        extentTest.log(LogStatus.PASS, "Verified: Successfully added new fees in fees table and submitted the changes on Annual Statement Details Page");
    }
}
