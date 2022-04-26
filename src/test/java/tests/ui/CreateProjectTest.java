package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import staticdata.ProjectData;
import testdata.GetLoginModel;
import utilities.Retry;

public class CreateProjectTest extends BaseTest {

    @Test(groups = "project", retryAnalyzer = Retry.class)
    public void createNewProjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        NewProjectPage newProjectPage = new NewProjectPage(driver);
        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(ProjectData.PROJECT_NAME)
                .clickCreateProjectButton();

        Assert.assertEquals(repositoryPage.isProjectCreated(ProjectData.PROJECT_NAME), true
                , "Project wasn't created");
    }

    @Test(groups = "project", dependsOnMethods = "createNewProjectTest", retryAnalyzer = Retry.class)
    public void createProjectWithTheSameCodeTest() {
        ProjectsPage projectsPage = new ProjectsPage(driver);
        NewProjectPage newProjectPage = new NewProjectPage(driver);
        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);

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
//        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);
//        ProjectsPage projectsPage = new ProjectsPage(driver);
//
//        repositoryPage.clickTabElement("Projects");
//        projectsPage.clickProjectDropDown(ProjectData.PROJECT_NAME, "Delete")
//                .confirmDeleteProjectButton();
//        Assert.assertEquals(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME), true
//                , "Project wasn't deleted");
//    }
}