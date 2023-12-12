package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameField = By.name("username");
    private By ressetPasswordButton = By.xpath("//button[@type='submit']");

    public void setUserNameField(String username) {
        driver.findElement(userNameField).sendKeys(username);
    }
    public ResetLinkSentPage clickResetPasswordButton() {
        driver.findElement(ressetPasswordButton).click();
        return new ResetLinkSentPage(driver);
    }


}
