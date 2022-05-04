package pages;

import elements.TestCaseBasicElements;
import elements.TestCaseConditionalsElements;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.ui.CreateCaseModel;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

@Log4j
public class CreateTestCasePage extends BasePage {

    private By TITLE_INPUT = By.id("title");
    private By DESCRIPTION_INPUT = By.xpath("//label[contains(text(), 'Description')]/parent::div//p");
    private By SAVE_BUTTON = By.id("save-case");
    private By ADD_ATTACHMENT_BUTTON = By.xpath("//button[contains(@class, 'add-attachment')]");
    private By DROP_FILE_FORM = By.className("attach-new-form");

    public CreateTestCasePage inputBasicFields(CreateCaseModel model) {
        inputTitleName(model.getTitle());
        inputDescription(model.getDescription());
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
        new TestCaseConditionalsElements(driver, "Pre-conditions").sendKeys(preConditional);
        return this;
    }

    @Step("Input data in Post-conditions field")
    public CreateTestCasePage inputPostConditionalField(String postConditional) {
        new TestCaseConditionalsElements(driver, "Post-conditions").sendKeys(postConditional);
        return this;
    }

    @Step("Input {0} in Title field")
    public CreateTestCasePage inputTitleName(String title) {
        log.info(title + " to Title field");
        driver.findElement(TITLE_INPUT).sendKeys(title);
        return this;
    }

    @Step("Input {0} in Description field")
    public CreateTestCasePage inputDescription(String title) {
        log.info(title + " to Description field");
        driver.findElement(DESCRIPTION_INPUT).sendKeys(title);
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
        log.info("Click on 'Add attachment' button");
        WebElement addAttachElement = driver.findElement((ADD_ATTACHMENT_BUTTON));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addAttachElement);
        return this;
    }

    @Step("Send attachment")
    public CreateTestCasePage sendAttachment(String pathToAttachment) throws Exception {
        log.info("Send attachment located " + pathToAttachment);
        driver.findElement(DROP_FILE_FORM).click();
        Thread.sleep(2000);
        Robot robot = new Robot();
        Toolkit.getDefaultToolkit()
                .getSystemClipboard()
                .setContents(new StringSelection(pathToAttachment), null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        return this;
    }

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }
}
