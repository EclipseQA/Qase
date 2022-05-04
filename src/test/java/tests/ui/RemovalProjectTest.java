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
public class RemovalProjectTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, groups = "removal")
    @Description("Test asserts that project is deleted and is not displayed on Projects Page")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test for the removal of project")
    public void deleteCreatedProjectTest() {
        log.info("deleteCreatedProjectTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickProjectDropDown(ProjectData.PROJECT_NAME, "Delete")
                .confirmDeleteProjectButton();
        Assert.assertTrue(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME)
                , "Project wasn't deleted");
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Test asserts that project is deleted and is not displayed on Project Page")
    @Story("Test for verifying that project doesn't present on Page")
    @Severity(SeverityLevel.NORMAL)
    public void verifyProjectIsDeletedTest(){
        log.info("verifyProjectIsDeletedTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        Assert.assertTrue(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME)
                , "Project wasn't deleted");
    }
}