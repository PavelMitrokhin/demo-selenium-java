package com.netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginTest {

    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("https://www.netflix.com/login");
    }

    @Test
    public void negativeNoEmailAndPasswordTest() {
        loginPage.clickButtonSignIn();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL_OR_PHONE_NUMBER, loginPage.getErrorEmailOrPhoneNumber());
        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getErrorPasswordTest());
    }

    @Test
    public void negativeNoPasswordTest() {
        loginPage.sendKeysEmailOrPhoneNumber("test@test.com");
        loginPage.clickButtonSignIn();

        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getErrorPasswordTest());
    }

    @Test
    public void negativeNoEmailOrPhoneNumberTest() {
        loginPage.sendKeysPassword("kokojumbo123ayaye");
        loginPage.clickButtonSignIn();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL_OR_PHONE_NUMBER, loginPage.getErrorEmailOrPhoneNumber());
    }
}
