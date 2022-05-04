package elements;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class ListOfProjects {

    private WebDriver driver;
    private String ProjectDropDownListButton = "//tr[contains(.,\'%s\')]//a[@data-bs-toggle='dropdown']";
    private String DropDownListOptions = "/following-sibling::div//a[text()=\'%s\']";
    private String label;

    public ListOfProjects(WebDriver driver, String projectName) {
        this.driver = driver;
        this.label = projectName;
    }

    public void clickProjectDropDown(String option) {
        log.info("Open DropDown section of '" + label + "' name");
        ProjectDropDownListButton = String.format(ProjectDropDownListButton, label);
        driver.findElement(By.xpath(ProjectDropDownListButton)).click();
        log.info("Click on " + option + " option");
        DropDownListOptions = String.format(ProjectDropDownListButton.concat(DropDownListOptions), option);
        driver.findElement(By.xpath(DropDownListOptions)).click();
    }
}