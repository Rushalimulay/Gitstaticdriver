package comman_Api_method;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class put_API_method {
	public static int responsestatuscode(String baseURI, String resource, String RequestBody) {
		RestAssured.baseURI = baseURI;
		int statuscode = given().header("Content-Type", "application/json").body(RequestBody).when().put("/api/users/2")
				.then().extract().statusCode();
		return statuscode;
	}

	public static String ResponseBody(String baseURI, String resourse, String RequestBody) {
		RestAssured.baseURI = baseURI;

		String responseBody = given().header("Content-Type", "application/json").body(RequestBody).when()
				.put("/api/users/2").then().extract().response().asString();
		return responseBody;
	}

}
