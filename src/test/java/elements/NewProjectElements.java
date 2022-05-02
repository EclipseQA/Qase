package elements;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class NewProjectElements {

    private WebDriver driver;
    private String label;
    private String inputsXpath = "//div[contains(.,'%s')]//label[contains(.,\"%s\")]/preceding-sibling::input";

    public NewProjectElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        log.info("Select '" + option + "' in " + label + " section");
        inputsXpath = String.format(inputsXpath, label, option);
        driver.findElement(By.xpath(inputsXpath)).click();
    }
}