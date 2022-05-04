package elements;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class TestCaseConditionalsElements {

    private WebDriver driver;
    private String xpathConditionals = "//label[contains(text(),'%s')]/parent::div//p";
    private String label;

    public TestCaseConditionalsElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void sendKeys(String key) {
        log.info("Send to '" + label + "' field '" + key + "'");
        String formattedXpath = String.format(xpathConditionals, label);
        driver.findElement(By.xpath(formattedXpath)).sendKeys(key);
    }
}