package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    private By forgotPasswordBtn = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    private By validationMsg = By.xpath("//span[text()='Required']");

    public void setUserNameField(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        driver.findElement(forgotPasswordBtn).click();
        return new ForgotPasswordPage(driver);
    }

    public List<WebElement> getErrorMsgs() {
        return driver.findElements(validationMsg);
    }


}
