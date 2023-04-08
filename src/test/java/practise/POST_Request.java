package practise;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class POST_Request {

	@Test
	void createUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Surrey");
		data.put("job", "fleetwood");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	
}
