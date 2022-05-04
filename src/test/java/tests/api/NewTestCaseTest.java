package tests.api;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;
import utilities.Retry;

@Epic("API test")
public class NewTestCaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Test asserts that user is able to create 'test case'")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Test for creating Test case")
    public void createNewTestCaseTest() {
        RestAssured
                .given()
                .body(API.TEST_CASE_MODEL)
                .contentType(ContentType.JSON)
                .header("Token", API.TOKEN)
                .when()
                .post(API.CASE_URL + ProjectData.PROJECT_NAME.toUpperCase())
                .then()
                .assertThat()
                .statusCode(200);
    }
}