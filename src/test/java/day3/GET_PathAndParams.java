package day3;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;


public class GET_PathAndParams {

	@Test
	public void testGET_PathAndParameters() {
	
		//https://reqres.in/api/users?page=2&id=5
		
	given()
		.pathParam("mypath", "users") //path parameters
		.queryParam("page", 2) // query parameters
		.queryParam("id", 5) // query parameters
	
	.when()
		.get("https://reqres.in/api/{mypath}")

	.then()
		.statusCode(200)
//		.body("page", equalTo(2))
//		.body("id", equalTo(5))
		.log().all();
	
	
	}
}