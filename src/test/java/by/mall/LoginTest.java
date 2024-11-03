package by.mall;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginTest {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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

    @Test
    public void negativeNoPhoneNumberTest() {
        loginPage.sendPassword("aisdkp323");
        loginPage.clickButtonLogin();

        Assertions.assertEquals(LoginMessage.ERROR_NO_PHONE_NUMBER, loginPage.getErrorMessage());
    }

    @Test
    public void negativeIncorrectPasswordOrPhoneNumberTest() {
        loginPage.sendPhoneNumber("299339393");
        loginPage.sendPassword("aisdkp323");
        loginPage.clickButtonLogin();

        Assertions.assertEquals(LoginMessage.ERROR_INCORRECT_PHONE_NUMBER_OR_PASSWORD, loginPage.getErrorMessage());
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
