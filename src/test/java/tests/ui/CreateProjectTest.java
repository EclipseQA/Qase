package tests.ui;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetLoginModel;
import utilities.Retry;

@Epic("Creation of Project Test")
public class CreateProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "project")
    @Description("User attempts to create new project")
    @Story("Test for creating new project")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewProjectTest() {

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME
                        , "Private", "Add all")
                .clickCreateProjectButton();

        Assert.assertEquals(repositoryPage.isProjectCreated(ProjectData.PROJECT_NAME), true
                , "Project wasn't created");
    }

    @Test(dependsOnMethods = "createNewProjectTest", retryAnalyzer = Retry.class, groups = "project")
    @Description("User attempts to create project with an existing name(depends on 'createNewProjectTest')")
    @Story("Test for creating project with an existing name")
    @Severity(SeverityLevel.NORMAL)
    public void createProjectWithTheSameCodeTest() {

        repositoryPage.clickTabElement("Projects");
        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME
                        , "Private", "Add all")
                .clickCreateProjectButton();

        Assert.assertEquals(newProjectPage.isProjectExistsMessageShown(), true
                , "Projected is created");
    }
}