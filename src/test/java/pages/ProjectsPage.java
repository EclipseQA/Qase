package pages;

import elements.ListOfProjects;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProjectsPage extends BasePage {

    private By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    private By DELETE_PROJECT_BUTTON = By.xpath("//button[@type='submit']");
    private String PROJECT_XPATH = "//tr[contains(.,'%s')]";

    public void clickCreateNewProjectButton() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
    }

    public ProjectsPage clickProjectDropDown(String projectName, String option) {
        new ListOfProjects(driver, projectName).clickProjectDropDown(option);
        return this;
    }

    public boolean isProjectDeleted(String projectName) {
        PROJECT_XPATH = String.format(PROJECT_XPATH, projectName);
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PROJECT_XPATH)));
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void confirmDeleteProjectButton() {
        driver.findElement(DELETE_PROJECT_BUTTON).click();
    }

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
}