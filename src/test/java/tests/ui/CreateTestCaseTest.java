package tests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetCreateCaseModel;
import testdata.GetLoginModel;
import utilities.Retry;
import utilities.TestListeners;

@Epic("Creation of Test Case")
@Listeners(TestListeners.class)
public class CreateTestCaseTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "case")
    @Description("Test asserts that user is able to create 'test case'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for creating Test case")
    public void createTestCaseTest() {

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.openProjectsPage()
                .navigateToProjectRepository("Greenlam");

        repositoryPage.clickCreateCaseButton();

        testCasePage.inputAllFields(GetCreateCaseModel.getCreateCaseModel())
                .clickAddAttachmentButton()
                .sendAttachment("D:\\Qase\\src\\test\\resources\\fileToAttach.jpg")
                .clickSaveButton();

        Assert.assertEquals(repositoryPage.isTestCaseCreated(), true
                , "Test case wasn't created");
    }

    @Test(dependsOnMethods = "createTestCaseTest",
            retryAnalyzer = Retry.class, enabled = false)
    @Description("Test asserts that project is deleted after previous tests")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test for the removal of project")
    public void deleteCreatedProjectTest() {

        repositoryPage.clickTabElement("Projects");
        projectsPage.clickProjectDropDown(ProjectData.PROJECT_NAME, "Delete")
                .confirmDeleteProjectButton();
        Assert.assertEquals(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME), true
                , "Project wasn't deleted");
    }
}