package APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssureTest {

    @Test
    public void RestATest()
    {
        RestAssured.baseURI="https://api.coindesk.com";
        Response response=given().when().get("/v1/bpi/currentprice.json").then().extract().response();
        System.out.println(response);

    }
}
