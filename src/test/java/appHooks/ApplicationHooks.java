package appHooks;


import com.factory.DriverFactory;
import com.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
    // to read the config file we r creating this class

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    //No testNG annotations used here - hooks r used for giving the same annotations like TestNG
    @Before(order = 0)    // Ascending order hooks
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop(); // to call this method from ConfigReader
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        DriverFactory driverFactory = new DriverFactory();
        DriverFactory.init_driver(browserName);             // to call the method init_driver

    }

    @After(order = 0)  //After hooks having descending order
    public void quitMethod() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String dest = scenario.getName();
            byte[] source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source,"image.png",dest);
        }
    }
}



