package pages;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    public String baseURL = "https://tst-denim.prv.ciqdev.com/browser/index.html";//tst
//    public String baseURL = "https://stg-denim.prv.ciqdev.com/browser/index.html";//stg
//    public String baseURL = "https://dr-denim.prv.capiqinc.com/browser/index.html";//dr
//    public String baseURL = "https://prd-denim.prv.capiqinc.com/browser/index.html";
//public String baseURL ="https://dr-denim.prv.capiqinc.com/browser/index.html"; // dr cloud


    //*********Web Elements*********
    public String signInButtonClass = "btnSignIn";
    public String settingIcon = "query-config-btn";
    public String usernameRadioButton = "//*[@value='username']";
    public String userNameInputField = "(//*[@value='username']/following-sibling::*)[2]";
    public String saveButton = "//*[text()='Save']";
    public String sendButton = "query-btn";
    public String requestTextField = "//*[@class='CodeMirror cm-s-default']";
    public String request = "[{Symbol : \"msft\",Metric : \"IQ_COMPANY_ID\"}]";
    public String response = "(//*[@ng-repeat='colName in $ctrl.results.table.headers[1]'])[3]";


    //*********Page Methods*********

    //Go to Homepage
    @Step("Open N11 Step...")
    public void launchDenim (){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    public void setSettingIcon (){
//        ExcelUtil.getRowData(1)
//        click(By.id(settingIcon));
//        click(By.xpath(usernameRadioButton));
//        //Enter Username(Email)
//        writeText(By.id(userNameInputField),row.getCell(1).toString());
//        click(By.xpath(saveButton));
    }
    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }



}
