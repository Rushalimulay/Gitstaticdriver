
package test_classes;
import java.io.IOException;
import java.time.LocalDateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

import RequestRepositry.post_req_repository;
import comman_Api_method.API_method;
import comman_Api_method.common_utility_method;
import io.restassured.path.json.JsonPath;
public class Post_Retry_TC1 {
	@Test (priority= 2)
	public static void execute() throws IOException {
		System.out.println("execute method call");
		for(int i=0; i<5; i++) {
			int statuscode= API_method.responseStatusCode(post_req_repository.baseURI(), post_req_repository.Post_Resourse(), 
				post_req_repository.Post_Req_TC1());
			System.out.println(statuscode);
			if(statuscode==201)
			{
			String ResponseBody = API_method.ResponseBody(post_req_repository.baseURI(), post_req_repository.Post_Resourse(), 
						post_req_repository.Post_Req_TC1());
			System.out.println(ResponseBody);
			String RequestBody= post_req_repository.Post_Req_TC1();
			common_utility_method.EvidenceCreator("Post_Retry_TC1", RequestBody, ResponseBody, statuscode);
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
	@Test (priority= 1)
	public static void validator(String Request, String Response) {
		System.out.println("validator method call");
		JsonPath JspRequest =new JsonPath(Request);
		String Req_name = JspRequest.getString("name");
		String Req_job = JspRequest.getString("job");
		LocalDateTime currentdate= LocalDateTime.now();
		String expecteddate= currentdate.toString().substring(0,11);
		JsonPath JspResponse= new JsonPath(Response);
		String Res_name =JspResponse.getString("name");
		String Res_Job = JspResponse.getString("job");
		String Res_createdAt = JspResponse.getString("createdAt");
		Res_createdAt= Res_createdAt.substring(0,11);
		//validate the response
		Assert.assertEquals(Res_name, Req_name);
		Assert.assertEquals(Res_Job, Req_job);
		Assert.assertEquals(Res_createdAt, expecteddate);
	}

	
		
	}


