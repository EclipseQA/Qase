package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RepositoryTestCaseElements {

    private WebDriver driver;
    private String xpathOfDropDownElement = "(//span[text()='%s']/parent::div//div)[1]";
    private String label;
    private String xpathOfGeneralElement = "//h3[contains(text(),'%s')]/parent::section//p";

    public RepositoryTestCaseElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public String getDropDownActualResult() {
        String formattedXpath = String.format(xpathOfDropDownElement, label);
        return driver.findElement(By.xpath(formattedXpath)).getText();
    }

    public String getGeneralActualResult() {
        String formattedXpath = String.format(xpathOfGeneralElement, label);
        return driver.findElement(By.xpath(formattedXpath)).getText();
    }
}
