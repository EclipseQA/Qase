package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCaseConditionalsElements {

    private WebDriver driver;
    private String xpathConditionals = "//label[contains(text(),'%s')]/parent::div//p";
    private String label;

    public TestCaseConditionalsElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void sendKeys(String key){
        String formattedXpath = String.format(xpathConditionals, label);
        driver.findElement(By.xpath(formattedXpath)).sendKeys(key);
    }
}