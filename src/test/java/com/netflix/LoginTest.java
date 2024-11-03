package com.netflix;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.netflix.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void negativeNoEmailAndPasswordTest() {
        loginPage.clickButtonSignIn();

        Assertions.assertEquals(LoginMessage.NO_EMAIL_OR_PHONE_NUMBER, loginPage.getErrorEmptyEmailOrPhoneNumber());
        Assertions.assertEquals(LoginMessage.NO_PASSWORD, loginPage.getErrorEmptyPassword());
    }

    @Test
    public void negativeNoPasswordTest() {
        loginPage.sendKeysEmailOrPhoneNumber("test@test.com");
        loginPage.clickButtonSignIn();

        Assertions.assertEquals(LoginMessage.NO_PASSWORD, loginPage.getErrorEmptyPassword());
    }

    @Test
    public void negativeNoEmailOrPhoneNumberTest() {
        loginPage.sendKeysPassword("jackrusselterrier@gmail.com");
        loginPage.clickButtonSignIn();

        Assertions.assertEquals(LoginMessage.NO_EMAIL_OR_PHONE_NUMBER, loginPage.getErrorEmptyEmailOrPhoneNumber());
    }

    @Test
    public void negativeWrongCredentialsTest() {
        String email = "jackrusselterrier@gmail.com";
        loginPage.sendKeysEmailOrPhoneNumber(email);
        loginPage.sendKeysPassword("pumbanator3000XXL");
        loginPage.clickButtonSignIn();
        Assertions.assertEquals(LoginMessage.INVALID_PASSWORD + email, loginPage.getErrorInvalidPassword());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
