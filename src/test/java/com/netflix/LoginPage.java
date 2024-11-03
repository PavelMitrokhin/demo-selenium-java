package com.netflix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonSignIn() {
        By buttonSignInBy = By.xpath(LoginXpath.BUTTON_SIGN_IN_XPATH);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    public void sendKeysEmailOrPhoneNumber(String emailOrPhoneNumber) {
        By inputEmailOrPhoneNumberBy = By.xpath(LoginXpath.INPUT_EMAIL_OR_PHONE_NUMBER_XPATH);
        WebElement inputEmailOrPhoneNumberWebElement = driver.findElement(inputEmailOrPhoneNumberBy);
        inputEmailOrPhoneNumberWebElement.sendKeys(emailOrPhoneNumber);
    }

    public void sendKeysPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_XPATH);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public String getErrorEmptyEmailOrPhoneNumber() {
        By errorEmptyEmailOrNumberBy = By.xpath(LoginXpath.OUTPUT_EMPTY_EMAIL_OR_PHONE_NUMBER_XPATH);
        WebElement errorEmptyEmailOrNumberWebElement = driver.findElement(errorEmptyEmailOrNumberBy);
        return errorEmptyEmailOrNumberWebElement.getText();
    }

    public String getErrorEmptyPassword() {
        By errorEmptyPasswordBy = By.xpath(LoginXpath.OUTPUT_EMPTY_PASSWORD_XPATH);
        WebElement errorEmptyPasswordWebElement = driver.findElement(errorEmptyPasswordBy);
        return errorEmptyPasswordWebElement.getText();
    }

    public String getErrorInvalidPassword() {
        By errorInvalidPasswordBy = By.xpath(LoginXpath.OUTPUT_INVALID_PASSWORD_XPATH);
        WebElement errorInvalidPasswordWebElement = driver.findElement(errorInvalidPasswordBy);
        return errorInvalidPasswordWebElement.getText();
    }
}
