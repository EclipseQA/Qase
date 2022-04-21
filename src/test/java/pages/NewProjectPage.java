package pages;

import elements.NewProjectElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends BasePage {

    private By PROJECT_NAME_INPUT = By.id("inputTitle");
    private By CREATE_PROJECT_BUTTON = By.xpath("//button[@type='submit']");
    private By PROJECT_EXISTS_MESSAGE = By.xpath("//span[text()=' Project with the same code already exists.']");

    public NewProjectPage inputProjectName(String projectName) {
        driver.findElement(PROJECT_NAME_INPUT).sendKeys(projectName);
        return this;
    }

    public NewProjectPage inputProjectFields(String projectName) {
        inputProjectName(projectName);
        new NewProjectElements(driver, "Project access type").selectOption("Private");
        new NewProjectElements(driver, "Members access").selectOption("Don't add");
        return this;
    }

    public void clickCreateProjectButton() {
        driver.findElement(CREATE_PROJECT_BUTTON).click();
    }

    public boolean isProjectExistsMessageShown() {
        return driver.findElement(PROJECT_EXISTS_MESSAGE).isDisplayed();
    }

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
}