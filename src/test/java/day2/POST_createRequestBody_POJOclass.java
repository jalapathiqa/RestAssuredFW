package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class POST_createRequestBody_POJOclass {

	@Test
	public void testPostUsingHashmap() {
		
		
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("Fleetwood");
		data.setJob("QA");

		given()
			.contentType("application/json")
			.body(data)

			.when()
				.post("https://reqres.in/api/users")

			.then()
				.statusCode(201)
				.body("name", equalTo("Fleetwood"))
				.body("job", equalTo("QA"))			
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}
}