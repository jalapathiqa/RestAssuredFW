package apiTesting;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class SendPOSTRequest {
	
	public static void main(String[] args) {
		
	Response response =	given().auth().basic("sk_test_Hrs6SAopgFPF0bZXSN3f6ELN", "")
		.formParam("name", "Rahul Arora").formParam("email", "reddy@gmail.com")
		.formParam("description", "New post request")
		.post("https://api.stripe.com/v1/customers");
	
	System.out.println("Status code: "+response.statusCode());
	response.prettyPrint();
	}

}
