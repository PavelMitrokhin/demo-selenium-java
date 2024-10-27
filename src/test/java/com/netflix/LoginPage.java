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

    public String getErrorEmailOrNumberTest() {
        By errorEmailOrNumberBy = By.xpath(LoginMessage.INVALID_EMAIL_OR_PHONE_NUMBER);
        WebElement errorEmailOrNumberWebElement = driver.findElement(errorEmailOrNumberBy);
        return errorEmailOrNumberWebElement.getText();
    }

    public String getErrorPasswordTest() {
        By errorPasswordBy = By.xpath(LoginMessage.INVALID_PASSWORD);
        WebElement errorPasswordWebElement = driver.findElement(errorPasswordBy);
        return errorPasswordWebElement.getText();
    }
}