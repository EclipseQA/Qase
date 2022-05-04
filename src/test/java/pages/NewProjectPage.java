package pages;

import elements.NewProjectElements;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class NewProjectPage extends BasePage {

    private By PROJECT_NAME_INPUT = By.id("inputTitle");
    private By CREATE_PROJECT_BUTTON = By.xpath("//button[@type='submit']");
    private By PROJECT_EXISTS_MESSAGE = By.xpath("//span[text()=' Project with the same code already exists.']");

    @Step("Input {0} in Project name field")
    public NewProjectPage inputProjectName(String projectName) {
        log.info("Send " + projectName + " to 'Project name'");
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(projectName);
        return this;
    }

    public NewProjectPage inputProjectFields(String projectName,
                                             String projectAccessType,
                                             String memberAccessType) {
        inputProjectName(projectName);
        selectProjectAccessType(projectAccessType);
        selectMemberAccess(memberAccessType);
        return this;
    }

    @Step("Select '{0}' Project access type ")
    public NewProjectPage selectProjectAccessType(String projectAccessType) {
        new NewProjectElements(driver, "Project access type").selectOption(projectAccessType);
        return this;
    }

    @Step("Select '{0}' Member access type")
    public NewProjectPage selectMemberAccess(String memberAccessType) {
        new NewProjectElements(driver, "Members access").selectOption(memberAccessType);
        return this;
    }

    @Step("Click 'Create project' button")
    public void clickCreateProjectButton() {
        log.info("Click on 'Create project' button");
        driver.findElement(CREATE_PROJECT_BUTTON).click();
    }

    @Step("Verify that 'Project with the same code already exists.' message is shown")
    public boolean isProjectExistsMessageShown() {
        log.info("Check if the message 'Project with the same code exists' is displayed");
        return driver.findElement(PROJECT_EXISTS_MESSAGE).isDisplayed();
    }

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
}