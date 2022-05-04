package tests.api;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;
import utilities.Retry;

import static org.hamcrest.Matchers.equalTo;

@Epic("API test")
public class QuantityProjectTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Test asserts that the number of projects corresponds to actual result")
    @Severity(SeverityLevel.NORMAL)
    @Story("Test for verifying the number of projects")
    public void getAllProjectTest() {
        RestAssured
                .given()
                .contentType("application/json")
                .and()
                .header("Token", API.TOKEN)
                .when()
                .get(API.PROJECTS_URL)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("result.total", equalTo(ProjectData.NUMBER_OF_PROJECT));
    }
}