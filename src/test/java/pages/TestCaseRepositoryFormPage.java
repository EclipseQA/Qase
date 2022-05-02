package pages;

import elements.RepositoryTestCaseElements;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import models.CreateCaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j
public class TestCaseRepositoryFormPage extends BasePage {

    private String ACTUAL_TEST_TITLE = "//h1//div[contains(text(), '%s')]";

    @Step("Getting actual result elements of Test Case {0}")
    public CreateCaseModel getActualModelOfTestCase(String nameOfTestCase) {
        log.info("Collect actual information about " + nameOfTestCase + " test case");
        String formattedXpath = String.format(ACTUAL_TEST_TITLE, nameOfTestCase);
        return CreateCaseModel.builder()
                .title(driver.findElement(By.xpath(formattedXpath)).getText())
                .description(new RepositoryTestCaseElements(driver, "Description").getGeneralActualResult())
                .severity(new RepositoryTestCaseElements(driver, "Severity").getDropDownActualResult())
                .priority(new RepositoryTestCaseElements(driver, "Priority").getDropDownActualResult())
                .type(new RepositoryTestCaseElements(driver, "Type").getDropDownActualResult())
                .behavior(new RepositoryTestCaseElements(driver, "Behavior").getDropDownActualResult())
                .automationStatus(new RepositoryTestCaseElements(driver, "Automation").getDropDownActualResult())
                .preConditions(new RepositoryTestCaseElements(driver, "Preconditions").getGeneralActualResult())
                .postConditionals(new RepositoryTestCaseElements(driver, "Postconditions").getGeneralActualResult())
                .build();
    }

    public TestCaseRepositoryFormPage(WebDriver driver) {
        super(driver);
    }
}