package framework;

import java.time.LocalDateTime;
import static io.restassured.RestAssured.given;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.config.SSLConfig;
import org.testng.annotations.Test;

public class put_ref {
	public static void main(String[] args) {

		String BaseURI = "https://reqres.in/";
		String requestBody = "{\r\n" + "    \"name\": \"morpheus\",\r\n" + "    \"job\": \"zion resident\"\r\n" + "}";
		RestAssured.baseURI = BaseURI;
		JsonPath JspRequest = new JsonPath(requestBody);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate = LocalDateTime.now();
		String expecteddate = currentdate.toString().substring(0, 11);

		String responseBody = given().config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
				.header("Content-Type", "application/json").body(requestBody).when().put("/api/users/2").then()
				.extract().response().asString();
		System.out.println(responseBody);
		JsonPath JspResponse = new JsonPath(responseBody);
		String Res_name = JspResponse.getString("name");
		String Res_job = JspResponse.getString("job");
		String Res_updatedAt = JspResponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0, 11);

		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_job, Req_job);
		Assert.assertEquals(Res_updatedAt, expecteddate);

	}

}
