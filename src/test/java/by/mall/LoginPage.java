package by.mall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLogin() {
        By buttonLoginInBy = By.xpath(LoginXpath.BUTTON_LOGIN_XPATH);
        WebElement buttonSignInWebElement = driver.findElement(buttonLoginInBy);
        buttonSignInWebElement.click();
    }

    public String getErrorMessage() {
        By errorMessageBy = By.xpath(LoginXpath.OUTPUT_ERROR_MESSAGE_XPATH);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageBy));
        WebElement errorMessageWebElement = driver.findElement(errorMessageBy);
        return errorMessageWebElement.getText();
    }

    public void sendPhoneNumber(String phoneNumber) {
        By phoneNumberBy = By.xpath(LoginXpath.INPUT_PHONE_NUMBER_XPATH);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement phoneNumberWebElement = driver.findElement(phoneNumberBy);
        phoneNumberWebElement.sendKeys(phoneNumber);
    }

    public void sendPassword(String password) {
        By passwordBy = By.xpath(LoginXpath.INPUT_PASSWORD_XPATH);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement passwordWebElement = driver.findElement(passwordBy);
        passwordWebElement.sendKeys(password);
    }
}
