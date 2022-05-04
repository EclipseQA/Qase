package driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.PropertiesManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
        PropertiesManager propertiesManager = new PropertiesManager();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);
        try {
            driver = new RemoteWebDriver(new URL(propertiesManager.get("REMOTEDRIVER_URL"))
                    , browserOptions);
        } catch (MalformedURLException e) {
            System.err.println("Check your URL to RemoteDriver / RemoteDriver is expired");
        }
    }
}