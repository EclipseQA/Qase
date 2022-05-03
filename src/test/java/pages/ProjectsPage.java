package pages;

import elements.ListOfProjects;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import staticdata.WebUrl;

import java.util.concurrent.TimeUnit;

@Log4j
public class ProjectsPage extends BasePage {

    private By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private By DELETE_PROJECT_BUTTON = By.xpath("//button[@type='submit']");
    private String PROJECT_XPATH = "//tr[contains(.,'%s')]//a[@class='project-name']";

    @Step("Click on 'Create new project' button")
    public void clickCreateNewProjectButton() {
        log.info("Click on 'Create new project' button");
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
    }

    @Step("Click on 'Drop down settings of {0}' and select {1} option")
    public ProjectsPage clickProjectDropDown(String projectName, String option) {
        new ListOfProjects(driver, projectName).clickProjectDropDown(option);
        return this;
    }

    @Step("Open {0} project repository")
    public void navigateToProjectRepository(String projectName) {
        log.info("Open '" + projectName + "' repository");
        String formattedProjectXpath = String.format(PROJECT_XPATH, projectName);
        driver.findElement(By.xpath(formattedProjectXpath)).click();
    }

    @Step("User is on Projects Page")
    public ProjectsPage openProjectsPage() {
        log.info("Open Projects page");
        driver.get(WebUrl.QASE_PROJECTS);
        return this;
    }

    @Step("Verify that projected is deleted")
    public boolean isProjectDeleted(String projectName) {
        log.info("Check if project '" + projectName + "' is deleted");
        String formattedProjectXpath = String.format(PROJECT_XPATH, projectName);
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(formattedProjectXpath)));
        } catch (NoSuchElementException e) {
            return true;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @Step("Confirm the removal of project")
    public void confirmDeleteProjectButton() {
        log.info("Click on 'Delete project' button");
        driver.findElement(DELETE_PROJECT_BUTTON).click();
    }

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
}