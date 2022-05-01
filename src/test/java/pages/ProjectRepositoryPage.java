package pages;

import elements.RepositoryTestCaseElements;
import elements.TabElements;
import io.qameta.allure.Step;
import models.CreateCaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ProjectRepositoryPage extends BasePage {

    private String ALERT_PROJECT_CREATED = "//span[contains(.,'Project \"%s\" was created successfully!')]";
    private By CREATE_CASE_BUTTON = By.id("create-case-button");
    private By ALERT_TEST_CASE_CREATED = By.xpath("//span[text()='Test case was created successfully!']");
    private String TEST_CASE_XPATH = "//a[contains(text(), '%s')]";
    private String ACTUAL_TEST_TITLE = "//h1//div[contains(text(), '%s')]";
    private By CLOSE_BUTTON = By.xpath("//button[@class='style_closeBtn-1izrl']");

    @Step("Verify that '{0}' project is created")
    public boolean isProjectCreated(String projectName) {
        String xpathAlertMessage = String.format(ALERT_PROJECT_CREATED, projectName);
        return driver.findElement(By.xpath(xpathAlertMessage)).isDisplayed();
    }

    @Step("Verify that Test Case is created")
    public boolean isTestCaseCreated() {
        return driver.findElement(ALERT_TEST_CASE_CREATED).isDisplayed();
    }

    @Step("Click '+Case' button")
    public void clickCreateCaseButton() {
        driver.findElement(CREATE_CASE_BUTTON).click();
    }

    @Step("Navigate to Projects Page")
    public void clickTabElement(String tabName) {
        new TabElements(driver, tabName).clickTabElement();
    }

    @Step("Select '{0}' Test case")
    public void clickOnTestCase(String nameOfTestCase) {
        String formattedXpath = String.format(TEST_CASE_XPATH, nameOfTestCase);
        driver.findElement(By.xpath(formattedXpath)).click();
    }

    @Step("Getting actual result elements of Test Case {0}")
    public CreateCaseModel getActualModelOfTestCase(String nameOfTestCase) {
        String formattedXpath = String.format(ACTUAL_TEST_TITLE, nameOfTestCase);
        return CreateCaseModel.builder()
                .title(driver.findElement(By.xpath(formattedXpath)).getText())
                .description(new RepositoryTestCaseElements(driver, "Description").getGeneralActualResult())
                .severity(new RepositoryTestCaseElements(driver, "Severity").getDropDownActualResult())
                .priority(new RepositoryTestCaseElements(driver, "Priority").getDropDownActualResult())
                .type(new RepositoryTestCaseElements(driver, "Type").getDropDownActualResult())
                .behavior(new RepositoryTestCaseElements(driver, "Behavior").getDropDownActualResult())
                .automationStatus(new RepositoryTestCaseElements(driver, "Automation").getDropDownActualResult())
                .preConditions(new RepositoryTestCaseElements(driver, "Preconditions").getGeneralActualResult())
                .postConditionals(new RepositoryTestCaseElements(driver, "Postconditions").getGeneralActualResult())
                .build();
    }

    @Step("Close Test Case form")
    public ProjectRepositoryPage closeTestCaseForm(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(CLOSE_BUTTON));
        return this;
    }

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }
}