package tests.api;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.api.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;
import utilities.Retry;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

@Epic("API test")
public class ComparisonOfCreatedAndActualResultTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Test asserts that created Test case corresponds to actual result")
    @Story("Test for comparing actual and expected Test case model")
    @Severity(SeverityLevel.CRITICAL)
    public void compareElementsOfCreatedTestCaseAndActualResultTest() {
        List<Step> listOfSteps = RestAssured
                .given()
                .header("Token", API.TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get(API.CASE_URL + ProjectData.PROJECT_NAME.toUpperCase() + "/1")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .assertThat()
                .body("result.title", equalTo(API.TEST_CASE_MODEL.getTitle()))
                .body("result.description", equalTo(API.TEST_CASE_MODEL.getDescription()))
                .body("result.severity", equalTo(API.TEST_CASE_MODEL.getSeverity()))
                .and()
                .extract().jsonPath().getList("result.steps", Step.class);
        listOfSteps.stream().forEach(x -> Assert.assertNotNull(x.getPosition()));
    }
}