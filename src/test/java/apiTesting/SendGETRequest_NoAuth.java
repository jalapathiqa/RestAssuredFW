package apiTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendGETRequest_NoAuth {
	
	
	
	public static void main (String[]args) {
	
	Response response = given().get("https://reqres.in/api/users?page=2");
		System.out.println("Status: "+response.statusCode());
		response.prettyPrint();
	}

}
