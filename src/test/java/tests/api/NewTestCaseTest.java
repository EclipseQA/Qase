package tests.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;

public class NewTestCaseTest {

    @Test
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