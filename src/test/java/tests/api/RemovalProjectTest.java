package tests.api;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;
import utilities.Retry;

@Epic("API test")
public class RemovalProjectTest {

    @Test(retryAnalyzer = Retry.class, groups = "removal")
    @Description("Test asserts that project is deleted")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test for the removal of project")
    public void removeProjectByCodeTest() {
        RestAssured
                .given()
                .header("Token", API.TOKEN)
                .when()
                .delete(API.PROJECTS_URL + ProjectData.PROJECT_NAME.toUpperCase())
                .then()
                .assertThat()
                .statusCode(200);
    }
}