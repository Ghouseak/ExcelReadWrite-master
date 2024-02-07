package tests;

import com.relevantcodes.extentreports.LogStatus;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.excelutils.ExcelUtil;
import utils.extentreports.ExtentTestManager;
import utils.listeners.TestListener;
import org.apache.poi.xssf.usermodel.XSSFRow;


//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("Login Tests")
public class HomeTests extends BaseTest {

    @BeforeTest
    public void setupTestData() {
        //Set Test Data Excel and Sheet
        System.out.println("************Setup Test Level Data**********");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test(priority = 0, description = "Denim URL")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void denimLongNameValidation() throws InterruptedException {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        //extentreports Description
        ExtentTestManager.getTest().setDescription("Denim URL" + homePage.baseURL);
        XSSFRow row = null;



        //launch denim
        homePage.launchDenim();
//        Thread.sleep(3000);
//        homePage.writeText(By.xpath(homePage.requestTextField), homePage.request);
//        Thread.sleep(3000);
        for (int i = 1; i <= 155; i++) {
            row = ExcelUtil.getRowData(i);
            Thread.sleep(5000);
            homePage.click(By.id(homePage.settingIcon));
            homePage.click(By.xpath(homePage.usernameRadioButton));
            //Enter Username(Email)
            homePage.writeText(By.xpath(homePage.userNameInputField), row.getCell(1).toString());
            homePage.click(By.xpath(homePage.saveButton));
            homePage.click(By.id(homePage.sendButton));
            String value = homePage.readText(By.xpath(homePage.response));
            ExcelUtil.setCellData("PASSED", i, 5);
            ExcelUtil.setCellData(value, i, 6);
            //Go to LoginPage
//        homePage.goToLoginPage();
        }
/*
        //Set test row number to 1
        ExcelUtil.setRowNumber(1);

        //Set Test Status Column number to 5
        ExcelUtil.setColumnNumber(5);

        //*************ASSERTIONS***********************
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div")));
        //Verify password message by using excel's 2st row, 5th column
        //Row and Column numbers starting from 0. Thus we need to write 1 and 4, instead of 2 and 5!
        loginPage.verifyLoginPassword(ExcelUtil.getCellData(1, 4));

//        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        //Update the test result on excel sheet
        ExcelUtil.setCellData("PASSED", ExcelUtil.getRowNumber(), ExcelUtil.getColumnNumber());*/
    }

//    @Test (priority = 1, description="Invalid Login Scenario with empty username and password.")
//    @Severity(SeverityLevel.CRITICAL)
//    @Description("Test Description: Login test with empty username and empty password.")
//    @Story("Empty username and password login test")
//    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
//        //extentreports Description
//        ExtentTestManager.getTest().setDescription("Invalid Login Scenario with empty username and password.");
//
//        //*************PAGE INSTANTIATIONS*************
//        HomePage homePage = new HomePage(driver,wait);
//        LoginPage loginPage = new LoginPage(driver,wait);
//
//        //*************PAGE METHODS********************
//        homePage.goToN11();
//        homePage.goToLoginPage();
//
//        //Login to N11 with second row of the login data
//        loginPage.loginToN11(ExcelUtil.getRowData(2));
//
//        //Set test row number to 2
//        ExcelUtil.setRowNumber(2);
//
//        //Set Test Status column number to 5
//        ExcelUtil.setColumnNumber(5);
//
//        //*************ASSERTIONS***********************
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div")));
//        //Verify by 3rd row and 4th column
//        loginPage.verifyLoginUserName(ExcelUtil.getCellData(2,3));
//        //Verify by 3rd row and 5th column
//        loginPage.verifyLoginPassword(ExcelUtil.getCellData(2,4));
//    }

}
