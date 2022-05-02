package tests.ui;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j;
import models.CreateCaseModel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetLoginModel;
import utilities.Retry;
import utilities.TestListeners;

@Log4j
@Epic("Creation of Test Case")
@Listeners(TestListeners.class)
public class CreateTestCaseTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "case")
    @Description("Test asserts that user is able to create 'test case'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for creating Test case")
    public void createTestCaseTest() throws Exception {
        log.info("createTestCaseTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.openProjectsPage()
                .navigateToProjectRepository(ProjectData.PROJECT_NAME);

        repositoryPage.clickCreateCaseButton();

        testCasePage.inputAllFields(ProjectData.EXPECTED_CASE_MODEL)
                .clickAddAttachmentButton()
                .sendAttachment("D:\\Qase\\src\\test\\resources\\fileToAttach.jpg")
                .clickSaveButton();

        Assert.assertEquals(repositoryPage.isTestCaseCreated(), true
                , "Test case wasn't created");
    }

    @Test(dependsOnMethods = "createTestCaseTest")
    @Description("Test asserts that created Test case corresponds to actual result")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for comparing actual and expected Test case model")
    public void compareElementsOfCreatedTestCaseAndActualResultTest() {
        log.info("compareElementsOfCreatedTestCaseAndActualResultTest is started");
        repositoryPage.clickOnTestCase(ProjectData.PROJECT_NAME.toUpperCase());
        CreateCaseModel expectedModel =
                repositoryPage.getActualModelOfTestCase(ProjectData.TEST_CASE_NAME);

        Assert.assertEquals(expectedModel, ProjectData.EXPECTED_CASE_MODEL);
    }

    @Test(dependsOnMethods = "createTestCaseTest",
            retryAnalyzer = Retry.class)
    @Description("Test asserts that project is deleted after previous tests")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test for the removal of project")
    public void deleteCreatedProjectTest() {
        log.info("deleteCreatedProjectTest is started");
        repositoryPage.closeTestCaseForm()
                .clickTabElement("Projects");
        projectsPage.clickProjectDropDown(ProjectData.PROJECT_NAME, "Delete")
                .confirmDeleteProjectButton();
        Assert.assertEquals(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME), true
                , "Project wasn't deleted");
    }
}