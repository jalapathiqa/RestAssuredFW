package apiTesting;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendPOSTRequest_Json {
	
	public static void main(String[] args) {
		
		String requestBody = "{\"name\":\"morpheus\", \"job\": \"leader\"}";
	Response response =	given().contentType(ContentType.JSON).body(requestBody)
			.post("https://reqres.in/api/users");
	
	System.out.println("Status code: "+response.statusCode());
	response.prettyPrint();
	}

}
