package apiTesting;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendGETRequest_Auth_Basic {
	
	/*
	 * Set Authentication:- Basic Auth / Bearer token using headers
	 * Request:- set of request specifications
	 * 
	 * 
	 * Response:- do validations
	 */
	
	public static void main (String[]args) {
	Response response =	given().param("limit", "1").auth().basic("sk_test_Hrs6SAopgFPF0bZXSN3f6ELN", "")
						.get("https://api.stripe.com/v1/customers");
	System.out.println("Response code: ..."+response.statusCode());
	response.prettyPrint();
	String jasonResponse = response.toString();
		System.out.println("jasonResponse:..." +jasonResponse);
//		given().contentType(ContentType.JSON);
//		given().contentType("application/json");
//		given().header("content-type", "application/json").auth().basic(DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH);
		
		
	}

}
