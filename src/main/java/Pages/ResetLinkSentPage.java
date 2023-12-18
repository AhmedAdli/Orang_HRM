package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetLinkSentPage {
    private final WebDriver driver;

    public ResetLinkSentPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By resetLinkSent = By.xpath("//h6[text()='Reset Password link sent successfully']");

    public String resetLinkSent() {
        return driver.findElement(resetLinkSent).getText();
    }

}
