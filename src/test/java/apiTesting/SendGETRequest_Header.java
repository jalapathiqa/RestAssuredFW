package apiTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendGETRequest_Header {
	
	/*
	 * Set Authentication:- Basic Auth / Bearer token using headers
	 * Request:- set of request specifications
	 * 
	 * 
	 * Response:- do validations
	 */
	
	public static void main (String[]args) {
	
	Response response=	given().header("Authorization", "Bearer sk_test_Hrs6SAopgFPF0bZXSN3f6ELN").get("https://api.stripe.com/v1/customers");
//	response.prettyPrint();
	System.out.println("Status code:..."+response.statusCode());
		
		
	}

}
