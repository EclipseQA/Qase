package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class NewProjectElements {

    private WebDriver driver;
    private String label;
    private String inputsXpath = "//div[contains(.,'%s')]//label[contains(.,\"%s\")]/preceding-sibling::input";
    private String[] options = {"Private", "Public", "Add all", "Add members", "Don't add"};
    private String[] labels = {"Project access", "Members access"};

    public NewProjectElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public NewProjectElements(WebDriver driver) {
        this.driver = driver;
        label = labels[new Random().nextInt(labels.length)];
        this.label = label;
    }

    public void selectOption(String option) {
        inputsXpath = String.format(inputsXpath, label, option);
        driver.findElement(By.xpath(inputsXpath)).click();
    }

    public void selectOption() {
        String option = options[new Random().nextInt(options.length)];
        inputsXpath = String.format(inputsXpath, label, option);
        driver.findElement(By.xpath(inputsXpath)).click();
    }
}