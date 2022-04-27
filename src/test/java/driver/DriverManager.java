package driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        return driver;
    }

    public void maximized() {
        driver.manage().window().maximize();
    }

    public void setTimeouts() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
    }
}