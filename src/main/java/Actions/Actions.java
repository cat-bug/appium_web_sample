package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mburunducova on 10/14/2016.
 */
public class Actions {
    private String loginXpath = "//a[@href='%url%auth/login/']";
    private final String emailInputXpath = "//input[@name='email']";
    private final String passInputXpath = "//input[@name='password']";
    private final String loginButtonXpath = "//button[@type='submit']";

    public void login(WebDriver driver, String url, String email, String password){
        driver.findElement(By.xpath(loginXpath.replace("%url%", url))).click();
        driver.findElement(By.xpath(emailInputXpath)).sendKeys(email);
        driver.findElement(By.xpath(passInputXpath)).sendKeys(password);
        driver.findElement(By.xpath(loginButtonXpath)).click();
    }
}
