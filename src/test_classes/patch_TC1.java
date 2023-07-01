package test_classes;

import org.testng.Assert;
import org.testng.annotations.Test;

import RequestRepositry.Patch_req_repository;
import RequestRepositry.post_req_repository;
import comman_Api_method.API_method;
import comman_Api_method.patch_API_method;
import io.restassured.path.json.JsonPath;

public class patch_TC1 {
	@Test
	public static void extractor() {
		int statuscode = patch_API_method.responsestatuscode(Patch_req_repository.baseURI(), Patch_req_repository.Patch_Resourse()
				, Patch_req_repository.patch_TC1());
		System.out.println(statuscode);
		String ResponseBody = patch_API_method.ResponseBody(Patch_req_repository.baseURI(), Patch_req_repository.Patch_Resourse(), 
				Patch_req_repository.patch_TC1());
		System.out.println(ResponseBody);
		
		JsonPath jspresponse = new JsonPath(ResponseBody);
		String Res_name = jspresponse.getString("name");
		
		Assert.assertEquals(Res_name, "morpheus");
		
		
		
	}
	

}



