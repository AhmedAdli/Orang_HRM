package Tests;

import Helpers.BaseClass;
import Pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTests extends BaseClass {
    public LoginPageTests() {
        super();
    }

    @Test
    public HomePage loginWithValidCredentials() {
        loginPage.setUserNameField("Admin");
        loginPage.setPasswordField("admin123");
        HomePage homePage = loginPage.clickLoginButton();
        String actual = homePage.getHeader();
        assertEquals(actual, "Dashboard");
        //        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);

        return homePage;
    }

    @Test
    public void loginWithInValidUserName() {
        loginPage.setUserNameField("AdminHH");
        loginPage.setPasswordField("admin123");
        loginPage.clickLoginButton();
        String actual = loginPage.getInvalidCredentialMsg();
        assertEquals(actual, "Invalid credentials");
        //        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);

    }

    @Test
    public void loginWithInValidPassword() {
        loginPage.setUserNameField("Admin");
        loginPage.setPasswordField("admin12345");
        loginPage.clickLoginButton();
        String actual = loginPage.getInvalidCredentialMsg();
        assertEquals(actual, "Invalid credentials");
        //        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);

    }

    @Test
    public void loginWithoutCredentials() {

        loginPage.clickLoginButton();
        String actual = loginPage.getErrorMsg().get(0).getText();
        assertEquals(actual, "Required");
        //        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);

    }

    @Test
    public void loginWithoutPassword() {
        loginPage.setUserNameField("Admin");
        loginPage.clickLoginButton();
        String actual = loginPage.getErrorMsg().get(0).getText();
        assertEquals(actual, "Required");
        //        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);

    }

    @Test
    public void loginWithoutUserName() {
        loginPage.setPasswordField("admin123");
        loginPage.clickLoginButton();
        String actual = loginPage.getErrorMsg().get(0).getText();
        assertEquals(actual, "Required");
        //        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);

    }
    @Test
    public void checkFooterLink(){
        loginPage.getWindowHandle();
        loginPage.clickOrangeHrmLink();
        String actual = loginPage.SwitchToNewWindow();
        String expected = "https://www.orangehrm.com/";
        assertEquals(actual, expected);
//        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);
    }
    @Test
    public void checkLinkedInIcon() {
        loginPage.getWindowHandle();
        loginPage.clickLinkedIn();
        String actual = loginPage.SwitchToNewWindow();
        String expected = "https://www.linkedin.com/company/orangehrm";
        assertEquals(actual, expected);
//        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);
    }

    @Test
    public void checkFacebookIcon() {
        loginPage.getWindowHandle();
        loginPage.clickFacebook();
        String actual = loginPage.SwitchToNewWindow();
        String expected = "https://www.facebook.com/OrangeHRM/ء";
        assertEquals(actual, expected);
//        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);
    }

    @Test
    public void checkTwitterIcon() {
        loginPage.getWindowHandle();
        loginPage.clickTwitter();
        String actual = loginPage.SwitchToNewWindow();
        String expected = "https://twitter.com/orangehrm?lang=en";
        assertEquals(actual, expected);
//        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);
    }

    @Test
    public void checkYoutubeIcon() {
        loginPage.getWindowHandle();
        loginPage.clickYoutube();
        String actual = loginPage.SwitchToNewWindow();
        String expected = "https://www.youtube.com/c/OrangeHRMIncD";
        assertEquals(actual, expected);
//        System.out.println("Actual: " + actual + "\n" + "expected: " + expected);
    }

}
