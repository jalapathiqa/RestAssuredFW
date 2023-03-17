package apiTesting;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendPOSTRequest_HashMap {
	
	public static void main(String[] args) {
		
//		String requestBody = "{\"name\":\"morpheus\", \"job\": \"leader\"}";
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "Surrey1");
		map.put("email", "surrey1@gmail.com");
		
	Response response =	given().contentType(ContentType.JSON).body(map)
			.post("https://reqres.in/api/users");
	
	System.out.println("Status code: "+response.statusCode());
	response.prettyPrint();
	}

}
