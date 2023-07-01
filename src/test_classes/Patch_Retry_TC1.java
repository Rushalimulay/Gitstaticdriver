package test_classes;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import RequestRepositry.Patch_req_repository;
import RequestRepositry.post_req_repository;
import comman_Api_method.API_method;
import comman_Api_method.common_utility_method;
import io.restassured.path.json.JsonPath;
public class Patch_Retry_TC1 {
	@Test
	public static void execute() throws IOException {
		for(int i=0; i<5; i++) {
			int statuscode= API_method.responseStatusCode(post_req_repository.baseURI(), post_req_repository.Post_Resourse(), 
				post_req_repository.Post_Req_TC1());
			System.out.println(statuscode);
			if(statuscode==200)
			{
			String ResponseBody = API_method.ResponseBody(Patch_req_repository.baseURI(), Patch_req_repository.Patch_Resourse(), 
						Patch_req_repository.patch_TC1());
			System.out.println(ResponseBody);
			String RequestBody=API_method.ResponseBody(Patch_req_repository.baseURI(), Patch_req_repository.Patch_Resourse(),Patch_req_repository.patch_TC1());
			common_utility_method.EvidenceCreator("Patch_Retry_TC1", RequestBody, ResponseBody, statuscode);
				System.out.println(ResponseBody);
				validator(RequestBody,ResponseBody);
				break;
			}
			else 
			{
				System.out.println("statuscode invalid");
			}
		}	
	}
	public static void validator(String Request, String Response) {
		JsonPath JspRequest =new JsonPath(Request);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate= LocalDateTime.now();
		String expecteddate= currentdate.toString().substring(0,11);
		JsonPath JspResponse= new JsonPath(Response);
		String Res_name =JspResponse.getString("name");
		String Res_Job = JspResponse.getString("job");
		String Res_updatedAt = JspResponse.getString("updatedAt");
		Res_updatedAt = Res_updatedAt.substring(0,11);
		//validate the response
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_Job, Req_job);
		Assert.assertEquals(Res_updatedAt, expecteddate);
	}

	
		
	}

