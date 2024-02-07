package pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Click Method
    public void click (By elementLocation) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation)).click();

//        driver.findElement(elementLocation).click();
    }

    //Write Text
    public void writeText (By elementLocation, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation)).clear();
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Read Text
    public String readText (By elementLocation) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation)).getText();
    }
}
