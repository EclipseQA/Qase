package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import models.CreateCaseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetLoginModel;
import utilities.Retry;

@Log4j
public class ComparisonOfCreatedAndActualResultTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "assertion")
    @Description("Test asserts that created Test case corresponds to actual result")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for comparing actual and expected Test case model")
    public void compareElementsOfCreatedTestCaseAndActualResultTest() {
        log.info("compareElementsOfCreatedTestCaseAndActualResultTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.navigateToProjectRepository(ProjectData.PROJECT_NAME);

        repositoryPage.clickOnTestCase(ProjectData.PROJECT_NAME.toUpperCase());
        CreateCaseModel expectedModel =
                repositoryFormPage.getActualModelOfTestCase(ProjectData.TEST_CASE_NAME);

        Assert.assertEquals(expectedModel, ProjectData.EXPECTED_CASE_MODEL);
    }
}