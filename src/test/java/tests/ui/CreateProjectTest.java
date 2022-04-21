package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewProjectPage;
import pages.ProjectRepositoryPage;
import pages.ProjectsPage;
import testdata.GetLoginModel;
import utilities.DataFaker;

public class CreateProjectTest extends BaseTest {

    private String projectName;

    @Test
    public void createNewProjectTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProjectsPage projectsPage = new ProjectsPage(driver);
        NewProjectPage newProjectPage = new NewProjectPage(driver);
        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);

        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickCreateNewProjectButton();

        projectName = DataFaker.getProjectName();
        newProjectPage.inputProjectFields(projectName)
                .clickCreateProjectButton();

        Assert.assertEquals(repositoryPage.isProjectCreated(projectName), true
                , "Project wasn't created");
    }

    @Test(dependsOnMethods = "createNewProjectTest")
    public void createProjectWithTheSameCodeTest() {
        ProjectsPage projectsPage = new ProjectsPage(driver);
        NewProjectPage newProjectPage = new NewProjectPage(driver);
        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);

        repositoryPage.clickTabElement("Projects");
        projectsPage.clickCreateNewProjectButton();

        newProjectPage.inputProjectFields(projectName)
                .clickCreateProjectButton();

        Assert.assertEquals(newProjectPage.isProjectExistsMessageShown(), true
                , "Projected is created");
    }

    @Test(dependsOnMethods = {"createProjectWithTheSameCodeTest", "createNewProjectTest"})
    public void deleteCreatedProjectTest() {
        ProjectRepositoryPage repositoryPage = new ProjectRepositoryPage(driver);
        ProjectsPage projectsPage = new ProjectsPage(driver);

        repositoryPage.clickTabElement("Projects");
        projectsPage.clickProjectDropDown(projectName, "Delete")
                .confirmDeleteProjectButton();
        Assert.assertEquals(projectsPage.isProjectDeleted(projectName), true
                , "Project wasn't deleted");
    }
}