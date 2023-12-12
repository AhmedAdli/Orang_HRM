package Tests;

import Helpers.BaseClass;
import Pages.ForgotPasswordPage;
import Pages.ResetLinkSentPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordPageTests extends BaseClass {
    @Test
    public void resetPassword(){
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        forgotPasswordPage.setUserNameField("Admin");
        ResetLinkSentPage resetLinkSentPage = forgotPasswordPage.clickResetPasswordButton();
        String actual = resetLinkSentPage.resetLinkSent();
        assertEquals(actual,"Reset Password link sent successfully ");
    }
}
