package tests.ui;

import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetCreateCaseModel;
import testdata.GetLoginModel;
import utilities.Retry;

@Epic("Creation of Test Case")
public class CreateTestCaseTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "case")
    public void createTestCaseTest() throws InterruptedException {

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.openProjectsPage()
                .navigateToProjectRepository(ProjectData.PROJECT_NAME);

        repositoryPage.clickCreateCaseButton();

        testCasePage.inputAllFields(GetCreateCaseModel.getCreateCaseModel())
                .clickSaveButton();

        Assert.assertEquals(repositoryPage.isTestCaseCreated(), true
                , "Test case wasn't created");
    }
}