package tests.ui;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.commondata.ProjectData;
import testdata.uitestdata.GetLoginModel;
import utilities.Retry;

import java.util.Locale;

@Log4j
@Epic("Web test")
public class NewTestCaseTest extends BaseTest {

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

        Assert.assertTrue(repositoryPage.isTestCaseCreated()
                , "Test case wasn't created");
    }

    @Test
    public void verifyTestCaseIsDisplayedOnProjectRepositoryPageTest() {
        log.info("verifyTestCaseIsDisplayedOnProjectRepositoryPageTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.openProjectsPage()
                .navigateToProjectRepository(ProjectData.PROJECT_NAME);

        Assert.assertTrue(repositoryPage.isTestCaseDisplayed(ProjectData.TEST_CASE_NAME)
                , "Test case wasn't created");
    }
}