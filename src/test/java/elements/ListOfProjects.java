package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        ProjectDropDownListButton = String.format(ProjectDropDownListButton, label);
        driver.findElement(By.xpath(ProjectDropDownListButton)).click();
        DropDownListOptions = String.format(ProjectDropDownListButton.concat(DropDownListOptions), option);
        driver.findElement(By.xpath(DropDownListOptions)).click();
    }
}