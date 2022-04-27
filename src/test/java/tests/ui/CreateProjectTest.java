package tests.ui;

import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetLoginModel;
import utilities.Retry;

@Epic("Creation of Project Test")
public class CreateProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "project")
    public void createNewProjectTest() throws InterruptedException {

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME)
                .clickCreateProjectButton();

        Assert.assertEquals(repositoryPage.isProjectCreated(ProjectData.PROJECT_NAME), true
                , "Project wasn't created");
    }

    @Test(dependsOnMethods = "createNewProjectTest", retryAnalyzer = Retry.class, groups = "project")
    public void createProjectWithTheSameCodeTest() {

        repositoryPage.clickTabElement("Projects");
        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME)
                .clickCreateProjectButton();

        Assert.assertEquals(newProjectPage.isProjectExistsMessageShown(), true
                , "Projected is created");
    }

//    @Test(dependsOnMethods = {"createProjectWithTheSameCodeTest", "createNewProjectTest"},
//    retryAnalyzer = Retry.class)
//    public void deleteCreatedProjectTest() {
//
//        repositoryPage.clickTabElement("Projects");
//        projectsPage.clickProjectDropDown(ProjectData.PROJECT_NAME, "Delete")
//                .confirmDeleteProjectButton();
//        Assert.assertEquals(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME), true
//                , "Project wasn't deleted");
//    }
}