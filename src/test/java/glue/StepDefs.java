package glue;

import Actions.Actions;
import Pages.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.Is.is;

/**
 * Created by mburunducova on 10/14/2016.
 */
public class StepDefs {
    WebDriver driver = Context.getInstance().getDriver();

    @Given("^user opens app$")
    public void openUrl() {
        String url = Context.getInstance().getMainUrl();
        driver.get(url);
    }

    @When("^page is loaded$")
    public void pageIsLoaded() throws InterruptedException {
        MainPage page = new MainPage();
        page.waitForLoad(driver);
    }

    @Then("^the main page of mobile version is opened$")
    public void mobileVersionIsOpened() {
        Assert.assertThat("Mobile version is loaded", driver.getCurrentUrl(), is(Context
                .getInstance().getMobileUrl()));
    }

    @When("^user logs in with existing credentials$")
    public void userLogsInWithExistingCredentials() {
        Actions actions = new Actions();
        new MainPage().openSidebar(driver);
        actions.login(driver, Context.getInstance().getMainUrl(),
                Context.getInstance().getEmail(), Context.getInstance().getPassword());
    }

    @Then("^user is logged in$")
    public void userIsLoggedIn() {
        MainPage page = new MainPage();
        page.openSidebar(driver);
        Assert.assertThat("User is logged in", page.getUsername(driver), is(Context.getInstance().getUsername()));
    }
}
