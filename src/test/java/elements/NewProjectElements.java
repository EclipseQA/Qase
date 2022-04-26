package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewProjectElements {

    private WebDriver driver;
    private String label;
    private String inputsXpath = "//div[contains(.,'%s')]//label[contains(.,\"%s\")]/preceding-sibling::input";

    public NewProjectElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectOption(String option) {
        inputsXpath = String.format(inputsXpath, label, option);
        driver.findElement(By.xpath(inputsXpath)).click();
    }
}