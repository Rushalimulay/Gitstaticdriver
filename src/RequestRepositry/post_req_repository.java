package RequestRepositry;

import java.io.IOException;
import java.util.ArrayList;

import comman_Api_method.common_utility_method;

public class post_req_repository {
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
		
	}
	public static String Post_Resourse() {
		String Post_Resourse = "api/users";
		return Post_Resourse;
		
	}
	public static String Post_Req_TC1() throws IOException {
		ArrayList<String> req_data=common_utility_method.ReadDataExcel("post_TC", "TC1");
		//System.out.println(req_data);
		String req_name=req_data.get(1);
		String req_job=req_data.get(2);
		//String req_Salary=req_data.get(3);
		//String req_City=req_data.get(4);
		
		
		String RequestBody="{\r\n"
				+ "    \"name\": \""+req_name+"\",\r\n"
				+ "    \"job\": \""+req_job+"\"\r\n"
				//+ "    \"Salary\": \""+req_Salary+"\",\r\n"
				//+ "    \"City\": \""+req_City+"\"\r\n"
				+ "}";
		return RequestBody;
	}

}
