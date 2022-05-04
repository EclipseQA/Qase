package tests.ui;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

public class BaseTest {

    protected WebDriver driver;
    protected DriverManager driverManager;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected NewProjectPage newProjectPage;
    protected ProjectRepositoryPage repositoryPage;
    protected CreateTestCasePage testCasePage;
    protected TestCaseRepositoryFormPage repositoryFormPage;

    @BeforeClass
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        DriverFactory factory = new DriverFactory();
        if (browser.equalsIgnoreCase("chrome")) {
            driverManager = factory.getDriverManager(DriverType.CHROME);
        } else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")) {
            driverManager = factory.getDriverManager(DriverType.MOZILLA);
        } else if (browser.equalsIgnoreCase("edge")) {
            driverManager = factory.getDriverManager(DriverType.EDGE);
        } else if (browser.equalsIgnoreCase("remote")) {
            driverManager = factory.getDriverManager(DriverType.REMOTE);
        } else {
            throw new IllegalStateException("Unknown browser");
        }
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.setTimeouts();
        driverManager.maximized();
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        newProjectPage = new NewProjectPage(driver);
        repositoryPage = new ProjectRepositoryPage(driver);
        testCasePage = new CreateTestCasePage(driver);
        repositoryFormPage = new TestCaseRepositoryFormPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
