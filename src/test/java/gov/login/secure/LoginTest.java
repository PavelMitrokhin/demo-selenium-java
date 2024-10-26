package gov.login.secure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://secure.login.gov/");
        String buttonSignInXpath = "//*[@id=\"new_user\"]/lg-captcha-submit-button/lg-spinner-button/button/span[1]";
        By buttonSignInBy = By.xpath(buttonSignInXpath);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }
}
