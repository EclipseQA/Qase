package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.ProjectData;
import testdata.GetLoginModel;
import utilities.Retry;

@Log4j
public class DeleteCreatedProjectTest extends BaseTest {

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