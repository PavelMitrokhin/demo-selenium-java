package gov.login.secure;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");

        String buttonLocator = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonLocator);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        String errorMessageEmptyXpath = "//div[@class='usa-error-message']";
        WebElement messageLocatorWebElement = driver.findElement(By.xpath(errorMessageEmptyXpath));

        Assertions.assertEquals("This field is required", messageLocatorWebElement.getText());
    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");

        String inputEmailLocator = "//input[@name='user[email]']";
        By inputEmailBy = By.xpath(inputEmailLocator);
        WebElement inputEmailWebElement = driver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys("testA@test.com");

        String buttonLocator = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonLocator);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        String errorMessageEmptyXpath = "//div[@class='usa-error-message']";
        WebElement messageLocatorWebElement = driver.findElement(By.xpath(errorMessageEmptyXpath));

        Assertions.assertEquals("This field is required", messageLocatorWebElement.getText());
    }

    @Test
    public void test3(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");

        String inputPasswordLocator = "//input[@name='user[password]']";
        By inputPasswordBy = By.xpath(inputPasswordLocator);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys("1q2w#E4r");

        String buttonLocator = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonLocator);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        String errorMessageEmptyXpath = "//div[@class='usa-error-message']";
        WebElement messageLocatorWebElement = driver.findElement(By.xpath(errorMessageEmptyXpath));

        Assertions.assertEquals("This field is required", messageLocatorWebElement.getText());
    }

    @Test
    public void test4(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String inputEmailLocator = "//input[@name='user[email]']";
        By inputEmailBy = By.xpath(inputEmailLocator);
        WebElement inputEmailWebElement = driver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys("testB@test.com");

        String inputPasswordLocator = "//input[@name='user[password]']";
        By inputPasswordBy = By.xpath(inputPasswordLocator);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys("a1S@d3F$");

        String buttonLocator = "//button[@name='button']";
        By buttonSignInBy = By.xpath(buttonLocator);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();

        String errorMessageInvalidXpath = "/html/body/main/div/div[1]/div/p";
        WebElement messageInvalidWebElement = driver.findElement(By.xpath(errorMessageInvalidXpath));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Assertions.assertEquals("The email or password you’ve entered is wrong. Try resetting your password.",
                messageInvalidWebElement.getText());

    }
}
