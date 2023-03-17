package apiTesting;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class User_PassJsonUsingPOJO {

	public static void main(String[] args) {
		
		User_JsonOnRunTimePOJOclasses user = new User_JsonOnRunTimePOJOclasses("jp@gmail.com", "jp", "reddy");
		
		Response response = given().contentType(ContentType.JSON).body(user).post("http://localhost:8080/api/users");
		System.out.println("Status code:..."+response);
		response.prettyPrint();
	}
}
