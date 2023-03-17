package apiTesting;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class GET_Call {
	
	public static void main(String[] args) {
		
		Response response=	given().get("https://reqres.in/api/users?page=2");

//		Response response=	given().auth().basic("sk_test_4eC39HqLyjWDarjtT1zdp7dc", "").get("https://api.stripe.com/v1/customers/cus_4QFOF3xrvBT2nU");
		System.out.println("Status code:..."+response.statusCode());
		response.prettyPrint();
		
	}

}
