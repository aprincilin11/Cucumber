package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/LoginPage.feature"

        ,glue = {"stepDefinitions","appHooks"}
        ,plugin = {"pretty",} //,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdaptor:",}

)
public class TestRunner {
}
