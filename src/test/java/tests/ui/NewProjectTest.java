package tests.ui;

import io.qameta.allure.*;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.commondata.ProjectData;
import testdata.uitestdata.GetLoginModel;
import utilities.Retry;

@Log4j
@Epic("Web test")
public class NewProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("User attempts to create new project")
    @Story("Test for creating new project")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewProjectTest() {
        log.info("createNewProjectTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME
                        , "Private", "Add all")
                .clickCreateProjectButton();

        ProjectData.NUMBER_OF_PROJECT++;

        Assert.assertTrue(repositoryPage.isProjectCreatedMessageDisplayed(ProjectData.PROJECT_NAME)
                , "Project wasn't created");
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("User attempts to create project with an existing name")
    @Story("Test for creating project with an existing name")
    @Severity(SeverityLevel.NORMAL)
    public void createProjectWithTheSameCodeTest() {
        log.info("createProjectWithTheSameCodeTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME
                        , "Private", "Add all")
                .clickCreateProjectButton();

        Assert.assertTrue(newProjectPage.isProjectExistsMessageShown()
                , "Projected is created");
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Test asserts that created project is displayed on Projects Page")
    @Story("Test for verifying that project presents on Page")
    @Severity(SeverityLevel.NORMAL)
    public void verifyProjectIsDisplayedOnProjectPageTest() {
        log.info("verifyProjectIsDisplayedOnProjectPageTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        Assert.assertTrue(projectsPage.isProjectDisplayedOnProjectPage(ProjectData.PROJECT_NAME)
                , "Project wasn't created");
    }
}