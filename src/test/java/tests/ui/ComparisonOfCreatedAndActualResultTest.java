package tests.ui;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j;
import models.ui.CreateCaseModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.commondata.ProjectData;
import testdata.uitestdata.GetLoginModel;
import utilities.Retry;

@Log4j
@Epic("Web test")
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