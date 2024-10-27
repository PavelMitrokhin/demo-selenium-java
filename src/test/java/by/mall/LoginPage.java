package by.mall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLogin() {
        By buttonLoginInBy = By.xpath(LoginXpath.BUTTON_LOGIN_XPATH);
        WebElement buttonSignInWebElement = driver.findElement(buttonLoginInBy);
        buttonSignInWebElement.click();
    }

    public String getErrorMessage() {
        By errorMessageBy = By.xpath(LoginXpath.OUTPUT_ERROR_MESSAGE_XPATH);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement errorMessageWebElement = driver.findElement(errorMessageBy);
        return errorMessageWebElement.getText();
    }
}
