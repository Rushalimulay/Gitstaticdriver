package test_classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import RequestRepositry.Patch_req_repository;
import RequestRepositry.Put_req_repository;
import comman_Api_method.patch_API_method;
import comman_Api_method.put_API_method;
import io.restassured.path.json.JsonPath;

public class put_TC1 {
	@Test
	public static void extractor() {
		int statuscode =put_API_method.responsestatuscode(Put_req_repository.baseURI(),Put_req_repository.Put_Resourse(), Put_req_repository.put_Req_TC1());
		System.out.println(statuscode);
		String ResponseBody = put_API_method.ResponseBody(Put_req_repository.baseURI(), Put_req_repository.Put_Resourse(), Put_req_repository.put_Req_TC1());
		System.out.println(ResponseBody);
		
		JsonPath jspresponse = new JsonPath(ResponseBody);
		String Res_name = jspresponse.getString("name");
		
		Assert.assertEquals(Res_name, "morpheus");
		
		
		
	}

}
