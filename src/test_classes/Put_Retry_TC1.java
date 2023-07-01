package test_classes;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import RequestRepositry.Put_req_repository;
import RequestRepositry.post_req_repository;
import comman_Api_method.API_method;
import comman_Api_method.common_utility_method;
import comman_Api_method.put_API_method;
import io.restassured.path.json.JsonPath;
public class Put_Retry_TC1 {
	@Test
	public static void execute() throws IOException {
		for(int i=0; i<5; i++) {
			int statuscode= put_API_method.responsestatuscode(Put_req_repository.baseURI(), Put_req_repository.Put_Resourse(),Put_req_repository.put_Req_TC1());
		
			System.out.println(statuscode);
			if(statuscode==200)
			{
			String ResponseBody = put_API_method.ResponseBody(Put_req_repository.baseURI(), Put_req_repository.Put_Resourse(), Put_req_repository.put_Req_TC1());
			System.out.println(ResponseBody);
			String RequestBody= Put_req_repository.put_Req_TC1();
			common_utility_method.EvidenceCreator("put_Retry_TC1", RequestBody, ResponseBody, statuscode);
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
		//declear expected result
		JsonPath JspRequest =new JsonPath(Request);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate= LocalDateTime.now();
		String expecteddate= currentdate.toString().substring(0,11);
		
		//create an object of json path to parse the responsebody
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


