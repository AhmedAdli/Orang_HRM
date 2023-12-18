package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage{

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By header = By.xpath("//h6[text()='Dashboard']");

    public String getHeader() {
        return driver.findElement(header).getText();
    }
}
