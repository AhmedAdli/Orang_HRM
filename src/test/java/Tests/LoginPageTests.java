package Tests;

import Helpers.BaseClass;
import Pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoginPageTests extends BaseClass {
    public LoginPageTests() {
        super();
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.setUserNameField("Admin");
        loginPage.setPasswordField("admin123");
        HomePage homePage=  loginPage.clickLoginButton();
        String actual = homePage.getHeader();
        assertEquals(actual, "Dashboard");
    }

    @Test
    public void loginWithoutCredentials() throws Exception {

        loginPage.clickLoginButton();
        String actual= loginPage.getErrorMsgs().get(0).getText();
        assertEquals(actual,"Required");
    }
    @Test
    public void loginWithoutPassword() {
        loginPage.setUserNameField("Admin");
        loginPage.clickLoginButton();
        String actual= loginPage.getErrorMsgs().get(0).getText();
        assertEquals(actual,"Required");
    }
    @Test
    public void loginWithoutUserName() {
        loginPage.setPasswordField("admin123");
        loginPage.clickLoginButton();
        String actual= loginPage.getErrorMsgs().get(0).getText();
        assertEquals(actual,"Required");
    }

}
