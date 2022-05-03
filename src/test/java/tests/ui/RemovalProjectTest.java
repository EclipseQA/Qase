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
    @Description("Test asserts that project is deleted after previous tests")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test for the removal of project")
    public void deleteCreatedProjectTest() {
        log.info("deleteCreatedProjectTest is started");
        loginPage.openPage()
                .login(GetLoginModel.getLoginModelWithValidData());

        projectsPage.clickProjectDropDown(ProjectData.PROJECT_NAME, "Delete")
                .confirmDeleteProjectButton();
        Assert.assertEquals(projectsPage.isProjectDeleted(ProjectData.PROJECT_NAME), true
                , "Project wasn't deleted");
    }
}