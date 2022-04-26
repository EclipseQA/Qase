package pages;

import elements.TabElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectRepositoryPage extends BasePage {

    private String ALERT_PROJECT_CREATED = "//span[contains(.,'Project \"%s\" was created successfully!')]";
    private By CREATE_CASE_BUTTON = By.id("create-case-button");
    private By ALERT_TEST_CASE_CREATED = By.xpath("//span[text()='Test case was created successfully!']");


    public boolean isProjectCreated(String projectName) {
        String xpathAlertMessage = String.format(ALERT_PROJECT_CREATED, projectName);
        return driver.findElement(By.xpath(xpathAlertMessage)).isDisplayed();
    }

    public boolean isTestCaseCreated() {
        return driver.findElement(ALERT_TEST_CASE_CREATED).isDisplayed();
    }

    public void clickCreateCaseButton() {
        driver.findElement(CREATE_CASE_BUTTON).click();
    }

    public ProjectRepositoryPage clickTabElement(String tabName) {
        new TabElements(driver, tabName).clickTabElement();
        return this;
    }

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }
}