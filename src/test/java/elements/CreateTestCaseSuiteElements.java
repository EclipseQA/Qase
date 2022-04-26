package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateTestCaseSuiteElements {

    private WebDriver driver;
    private String optionXpath = "//div[contains(@id, 'option') and contains(.,'%s')]";
    private String dropDownXpath = "(//label[contains(text(), '%s')]/parent::div//div)[1]";
    private String label;

    public CreateTestCaseSuiteElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option){
        String formattedDropDownXpath = String.format(dropDownXpath, label);
        driver.findElement(By.xpath(formattedDropDownXpath)).click();
        String formattedOptionXpath = String.format(optionXpath, option);
        driver.findElement(By.xpath(formattedOptionXpath)).click();
    }
}