package pages;

import elements.TabElements;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

@Log4j
public class ProjectRepositoryPage extends BasePage {

    private String ALERT_PROJECT_CREATED = "//span[contains(.,'Project \"%s\" was created successfully!')]";
    private By CREATE_CASE_BUTTON = By.id("create-case-button");
    private By ALERT_TEST_CASE_CREATED = By.xpath("//span[text()='Test case was created successfully!']");
    private String TEST_CASE_XPATH = "//a[contains(text(), '%s')]";
    private By CLOSE_BUTTON = By.xpath("//button[@class='style_closeBtn-1izrl']");

    @Step("Verify that '{0}' project is created")
    public boolean isProjectCreated(String projectName) {
        log.info("Check if the message 'Project " + projectName + " was created' is displayed");
        String xpathAlertMessage = String.format(ALERT_PROJECT_CREATED, projectName);
        return driver.findElement(By.xpath(xpathAlertMessage)).isDisplayed();
    }

    @Step("Verify that Test Case is created")
    public boolean isTestCaseCreated() {
        log.info("Check if the message 'Test case was created' is displayed");
        return driver.findElement(ALERT_TEST_CASE_CREATED).isDisplayed();
    }

    @Step("Click '+Case' button")
    public void clickCreateCaseButton() {
        log.info("Click on '+Case' button");
        driver.findElement(CREATE_CASE_BUTTON).click();
    }

    @Step("Navigate to Projects Page")
    public void clickTabElement(String tabName) {
        new TabElements(driver, tabName).clickTabElement();
    }

    @Step("Select '{0}' Test case")
    public void clickOnTestCase(String nameOfTestCase) {
        log.info("Open '" + nameOfTestCase + "' test case form");
        String formattedXpath = String.format(TEST_CASE_XPATH, nameOfTestCase);
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Close Test Case form")
    public ProjectRepositoryPage closeTestCaseForm() {
        log.info("Close test case form");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(CLOSE_BUTTON));
        return this;
    }

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }
}