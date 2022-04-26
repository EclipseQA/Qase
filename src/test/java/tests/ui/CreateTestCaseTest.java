package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateTestCasePage;
import pages.LoginPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import staticdata.ProjectData;
import testdata.GetCreateCaseModel;
import testdata.GetLoginModel;
import utilities.Retry;

public class CreateTestCaseTest extends BaseTest {

    @Test(groups = "case", dependsOnGroups = {"project"}, retryAnalyzer = Retry.class)
    public void createTestCaseTest() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.openPage()
//                .login(GetLoginModel.getLoginModelWithValidData());

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.openProjectsPage()
                .navigateToProjectRepository(ProjectData.PROJECT_NAME);

        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);
        repositoryPage.clickCreateCaseButton();

        CreateTestCasePage testCasePage = new CreateTestCasePage(driver);
        testCasePage.inputAllFields(GetCreateCaseModel.getCreateCaseModel())
                .clickSaveButton();

        Assert.assertEquals(repositoryPage.isTestCaseCreated(), true
                , "Test case wasn't created");
    }
}