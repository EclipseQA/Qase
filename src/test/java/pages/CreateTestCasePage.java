package pages;

import elements.CreateTestCaseSuiteElements;
import models.CreateCaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTestCasePage extends BasePage {

    private By TITLE_INPUT = By.id("title");
    private By SAVE_BUTTON = By.id("save-case");

    public CreateTestCasePage inputAllFields(CreateCaseModel model) {
        driver.findElement(TITLE_INPUT).sendKeys(model.getTitle());
        new CreateTestCaseSuiteElements(driver, "Severity").selectOption(model.getSeverity());
        new CreateTestCaseSuiteElements(driver, "Priority").selectOption(model.getPriority());
        new CreateTestCaseSuiteElements(driver, "Type").selectOption(model.getType());
        new CreateTestCaseSuiteElements(driver, "Behavior").selectOption(model.getBehavior());
        new CreateTestCaseSuiteElements(driver, "Automation status").selectOption(model.getAutomationStatus());
        return this;
    }

    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }
}
