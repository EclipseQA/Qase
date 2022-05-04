package elements;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class TestCaseBasicElements {

    private WebDriver driver;
    private String optionXpath = "//div[contains(@id, 'option') and contains(.,'%s')]";
    private String dropDownXpath = "(//label[contains(text(), '%s')]/parent::div//div)[1]";
    private String label;

    public TestCaseBasicElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.info("Select '" + option + "' in '" + label + "' dropdown");
        String formattedDropDownXpath = String.format(dropDownXpath, label);
        driver.findElement(By.xpath(formattedDropDownXpath)).click();
        String formattedOptionXpath = String.format(optionXpath, option);
        driver.findElement(By.xpath(formattedOptionXpath)).click();
    }
}