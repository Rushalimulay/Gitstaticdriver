package RequestRepositry;

public class Put_req_repository {
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
		
	}
	public static String Put_Resourse() {
		String put_Resourse= "api/users/2";
		return  put_Resourse;
		
	}
	public static String put_Req_TC1() {
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return RequestBody;
	}

}



