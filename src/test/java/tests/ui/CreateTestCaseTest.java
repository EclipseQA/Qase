package tests.ui;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j;
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
}