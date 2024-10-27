package com.netflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

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
    public void negativeNoEmailAndPassword() {
        loginPage.clickButtonSignInTest();

        Assertions.assertEquals(LoginMessage.INVALID_EMAIL_OR_PHONE_NUMBER, loginPage.getErrorEmailOrNumberTest());
        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD, loginPage.getErrorPasswordTest());
    }


}
