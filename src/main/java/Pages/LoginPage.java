package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By userNameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    private final By forgotPasswordBtn = By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']");
    private final By validationMsg = By.xpath("//span[text()='Required']");
    private final By invalidCredentialsMsg = By.xpath("//p[text()='Invalid credentials']");

    private final By linkedInBtn = By.xpath("//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']//*[name()='svg']");
    private final By facebookBtn = By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']//*[name()='svg']");
    private final By twitterBtn = By.xpath("//a[@href='https://twitter.com/orangehrm?lang=en']//*[name()='svg']");
    private final By youtubeBtn = By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']//*[name()='svg']");
    private final By OrangeFooterLink = By.linkText("OrangeHRM, Inc");


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

    //Click a Link
    public void clickLink(By element) {
        driver.findElement(element).click();
    }
    //Get Error message of login form when one or more fields are empty
    public List<WebElement> getErrorMsg() {
        return driver.findElements(validationMsg);
    }

    //Get Error message of login form when one or more fields are invalid
    public String getInvalidCredentialMsg() {
        return driver.findElement(invalidCredentialsMsg).getText();
    }

    //Get Window ID
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    //Switch to a new window
    public String SwitchToNewWindow() {

        //Get All opened windows IDs
        Set<String> handles = driver.getWindowHandles();

        //Loop through opened windows
        for (String handle : handles) {

            //Check if current window ID is not equal to original window ID
            if (!handle.equals(getWindowHandle())) {

                //Switch to a specified window
                driver.switchTo().window(handle);
            }
        }
        return driver.getCurrentUrl();
    }

    public void clickOrangeHrmLink() {
        clickLink(OrangeFooterLink);
    }

    public void clickLinkedIn() {
        clickLink(linkedInBtn);
    }

    public void clickFacebook() {
        clickLink(facebookBtn);
    }

    public void clickTwitter() {
        clickLink(twitterBtn);
    }

    public void clickYoutube() {
        clickLink(youtubeBtn);
    }


}
