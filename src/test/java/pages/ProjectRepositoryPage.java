package pages;

import elements.TabElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectRepositoryPage extends BasePage {

    private String ALERT_SUCCESS_MESSAGE_XPATH = "//span[contains(.,'Project \"%s\" was created successfully!')]";

    public boolean isProjectCreated(String projectName) {
        String xpathAlertMessage = String.format(ALERT_SUCCESS_MESSAGE_XPATH, projectName);
        return driver.findElement(By.xpath(xpathAlertMessage)).isDisplayed();
    }

    public ProjectRepositoryPage clickTabElement(String tabName) {
        new TabElements(driver, tabName).clickTabElement();
        return this;
    }

    public ProjectRepositoryPage(WebDriver driver) {
        super(driver);
    }
}