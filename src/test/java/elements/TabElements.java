package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabElements {

    private WebDriver driver;
    private String xpathTab = "//ul[contains(@class, 'nav')]//a[contains(.,'%s')]";
    private String label;

    public TabElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickTabElement() {
        String xpathElementTab = String.format(xpathTab, label);
        driver.findElement(By.xpath(xpathElementTab)).click();
    }
}