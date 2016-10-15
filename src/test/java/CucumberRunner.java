import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by mburunducova on 10/14/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"glue"},
        features = "src/test/resources/features",
        tags = {"~@ignore"},
        plugin = {"pretty", "html:target/cucumber"})
public class CucumberRunner {
}
