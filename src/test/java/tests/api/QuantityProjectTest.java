package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import staticdata.apidata.API;

import static org.hamcrest.Matchers.equalTo;

public class QuantityProjectTest {

    @Test
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
                .body("result.total", equalTo(3));
    }
}