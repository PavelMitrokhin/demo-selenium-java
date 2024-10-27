package by.mall;

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
        driver.get("https://emall.by/login/password");
    }

    @Test
    public void negativeNoCredentialsLoginTest() {
        loginPage.clickButtonLogin();

        Assertions.assertEquals(LoginMessage.ERROR_NO_CREDENTIALS, loginPage.getErrorMessage());
    }

    @Test
    public void negativeNoPasswordTest() {
        loginPage.sendPhoneNumber("299339393");
        loginPage.clickButtonLogin();

        Assertions.assertEquals(LoginMessage.ERROR_NO_PASSWORD, loginPage.getErrorMessage());
    }
}
