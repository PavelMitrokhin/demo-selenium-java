package com.netflix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonSignInTest() {
        By buttonSignInBy = By.xpath(LoginXpath.BUTTON_SIGN_IN_XPATH);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    public void sendKeysEmailOrPhoneNumber(String emailOrPhoneNumber) {
        By inputEmailOrPhoneNumberBy = By.xpath(LoginXpath.INPUT_EMAIL_OR_PHONE_XPATH);
        WebElement inputEmailOrPhoneNumberWebElement = driver.findElement(inputEmailOrPhoneNumberBy);
        inputEmailOrPhoneNumberWebElement.sendKeys(emailOrPhoneNumber);
    }

    public void sendKeysPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_XPATH);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public String getErrorEmailOrNumberTest() {
        By errorEmailOrNumberBy = By.xpath(LoginXpath.INPUT_EMPTY_EMAIL_OR_PHONE_XPATH);
        WebElement errorEmailOrNumberWebElement = driver.findElement(errorEmailOrNumberBy);
        return errorEmailOrNumberWebElement.getText();
    }

    public String getErrorPasswordTest() {
        By errorPasswordBy = By.xpath(LoginXpath.INPUT_EMPTY_PASSWORD_XPATH);
        WebElement errorPasswordWebElement = driver.findElement(errorPasswordBy);
        return errorPasswordWebElement.getText();
    }
}
