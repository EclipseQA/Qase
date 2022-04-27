package pages;

import elements.TestCaseBasicElements;
import elements.TestCaseConditionalsElements;
import io.qameta.allure.Step;
import models.CreateCaseModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CreateTestCasePage extends BasePage {

    private By TITLE_INPUT = By.id("title");
    private By SAVE_BUTTON = By.id("save-case");
    private By ADD_ATTACHMENT_BUTTON = By.xpath("//button[contains(@class, 'add-attachment')]");
    private By DROP_FILE_FORM = By.className("attach-new-form");
    private By UPLOADED_FILES_XPATH = By.xpath("//p[contains(text(), '.png') or contains(text(), '.jpg')]");

    public CreateTestCasePage inputBasicFields(CreateCaseModel model) {
        inputTitleName(model.getTitle());
        selectSeverityOption(model.getSeverity());
        selectPriorityOption(model.getPriority());
        selectTypeOption(model.getType());
        selectBehaviorOption(model.getBehavior());
        selectAutomationStatusOption(model.getAutomationStatus());
        return this;
    }

    public CreateTestCasePage inputAllFields(CreateCaseModel model) {
        inputBasicFields(model);
        inputPreConditionalsField(model.getPreConditions());
        inputPostConditionalField(model.getPostConditionals());
        return this;
    }

    @Step("Input data about browser and OC in Pre-conditions field")
    public CreateTestCasePage inputPreConditionalsField(String preConditional) {
        new TestCaseConditionalsElements(driver, "Pre").sendKeys(preConditional);
        return this;
    }

    @Step("Input data in Post-conditions field")
    public CreateTestCasePage inputPostConditionalField(String postConditional) {
        new TestCaseConditionalsElements(driver, "Post").sendKeys(postConditional);
        return this;
    }

    @Step("Input {0} in Title field")
    public CreateTestCasePage inputTitleName(String title) {
        driver.findElement(TITLE_INPUT).sendKeys(title);
        return this;
    }

    @Step("Select '{0}' option in Severity")
    public CreateTestCasePage selectSeverityOption(String severity) {
        new TestCaseBasicElements(driver, "Severity").selectOption(severity);
        return this;
    }

    @Step("Select '{0}' option in Priority")
    public CreateTestCasePage selectPriorityOption(String priority) {
        new TestCaseBasicElements(driver, "Priority").selectOption(priority);
        return this;
    }

    @Step("Select '{0}' option in Type")
    public CreateTestCasePage selectTypeOption(String type) {
        new TestCaseBasicElements(driver, "Type").selectOption(type);
        return this;
    }

    @Step("Select '{0}' option in Behavior")
    public CreateTestCasePage selectBehaviorOption(String behaviour) {
        new TestCaseBasicElements(driver, "Behavior").selectOption(behaviour);
        return this;
    }

    @Step("Select '{0}' option in Automation status")
    public CreateTestCasePage selectAutomationStatusOption(String automationStatus) {
        new TestCaseBasicElements(driver, "Automation status").selectOption(automationStatus);
        return this;
    }

    @Step("Click 'Save' button")
    public void clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Click 'Add attachment'")
    public CreateTestCasePage clickAddAttachmentButton() {
        try {
            driver.findElement(ADD_ATTACHMENT_BUTTON).click();
        } catch (UnhandledAlertException e) {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.dismiss();
            } catch (NoAlertPresentException f) {
                System.out.println("Получается нет алерта");
            }
        }
        return this;
    }

    @Step("Send attachment")
    public CreateTestCasePage sendAttachment(String pathToAttachment) {
        driver.findElement(DROP_FILE_FORM).sendKeys(pathToAttachment);
        return this;
    }

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }
}
