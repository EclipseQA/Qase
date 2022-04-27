package tests.ui;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

public class BaseTest {

    protected WebDriver driver;
    protected DriverManager driverManager;
    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected NewProjectPage newProjectPage;
    protected ProjectRepositoryPage repositoryPage;
    protected CreateTestCasePage testCasePage;

    @BeforeClass
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getDriverManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.setTimeouts();
        driverManager.maximized();
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        newProjectPage = new NewProjectPage(driver);
        repositoryPage = new ProjectRepositoryPage(driver);
        testCasePage = new CreateTestCasePage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
