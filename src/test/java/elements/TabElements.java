package elements;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class TabElements {

    private WebDriver driver;
    private String xpathTab = "//ul[contains(@class, 'nav')]//a[contains(.,'%s')]";
    private String label;

    public TabElements(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickTabElement() {
        log.info("Click on '" + label + "' tab");
        String xpathElementTab = String.format(xpathTab, label);
        driver.findElement(By.xpath(xpathElementTab)).click();
    }
}