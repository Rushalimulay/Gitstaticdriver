package RequestRepositry;

public class Patch_req_repository {
	public static String baseURI() {
		String baseURI="https://reqres.in/";
		return baseURI;
		
	}
	public static String Patch_Resourse() {
		String Post_Resourse = "api/users/2";
		return Post_Resourse;
		
	}
		public static String patch_TC1() {
		String RequestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		return RequestBody;
	}

}

