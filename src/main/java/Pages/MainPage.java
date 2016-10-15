package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Properties;

/**
 * Created by mburunducova on 10/14/2016.
 */
public class MainPage {

    private static final String sidebarXpath = "//div[@class='toggle_sidebar']";
    private static final String usernameXpath = "//span[@class='username']";

    public void openSidebar(WebDriver driver) {
        driver.findElement(By.xpath(sidebarXpath)).click();
    }

    public String getUsername(WebDriver driver){
        return driver.findElement(By.xpath(usernameXpath)).getText();
    }

    public void waitForLoad(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sidebarXpath)));
    }
}
