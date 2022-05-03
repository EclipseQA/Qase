package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.api.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class ComparisonOfCreatedAndActualResultTest {

    @Test
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