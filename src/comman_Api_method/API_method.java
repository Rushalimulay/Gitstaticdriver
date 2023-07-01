package comman_Api_method;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import RequestRepositry.post_req_repository;

public class API_method {
			
				
			public static int responseStatusCode(String baseURI,String resourse,String RequestBody) {
				RestAssured.baseURI=baseURI;
				
				int statuscode=given().header("Content-Type","application/json").body(RequestBody).
						when().post("/api/users").then().extract().statusCode();
				return statuscode;
			}
			public static String ResponseBody(String baseURI,String resourse,String RequestBody) {
				RestAssured.baseURI=baseURI;
				
				String responseBody = given().header("Content-Type","application/json").body(RequestBody).
						when().post("/api/users").then().extract().response().asString();
				return responseBody;
			}
			
		}

		
	
		


