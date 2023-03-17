package day1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class POST_Request_PUT {
int id;
	@Test(priority=1)
	void createUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Surrey");
		data.put("job", "fleetwood");
		
		id=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
//		.then()
//			.statusCode(201)
//			.log().all();
		
	}
	
	@Test(priority=2, dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Fleetwood38");
		data.put("job", "edgeWoord8277");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users/"+id)
			
		.then()
		.statusCode(201)
		.log().all();
		
	}
	
	@Test(priority=3)
	void deleteUser() {
		
			
		given()
					
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
		.statusCode(204)
		.log().all();
		
	}
	
}
