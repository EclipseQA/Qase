package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import staticdata.apidata.API;
import staticdata.commondata.ProjectData;

public class RemovalProjectTest {

    @Test
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