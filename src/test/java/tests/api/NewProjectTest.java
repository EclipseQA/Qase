package tests.api;

import com.google.gson.Gson;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.api.NewProjectModel;
import models.api.SuccessResponseNewProjectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;
import testdata.apitestdata.GetNewProjectModel;
import utilities.Retry;

import java.io.FileReader;
import java.io.IOException;

@Epic("API test")
public class NewProjectTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("User attempts to create new project")
    @Story("Test for creating new project")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewProjectTest() throws IOException {
        NewProjectModel projectModel = GetNewProjectModel.getProjectModelWithAllFields();
        SuccessResponseNewProjectModel actualResult = RestAssured
                .given()
                .body(projectModel)
                .contentType(ContentType.JSON)
                .header("Token", API.TOKEN)
                .when()
                .post(API.PROJECTS_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .as(SuccessResponseNewProjectModel.class);

        ProjectData.NUMBER_OF_PROJECT++;

        SuccessResponseNewProjectModel expectedResult
                = new Gson().fromJson(new FileReader(API.SUCCESS_NEW_PROJECT_FILE), SuccessResponseNewProjectModel.class);
        expectedResult.result.code = ProjectData.PROJECT_NAME.toUpperCase();

        Assert.assertEquals(actualResult, expectedResult);
    }
}