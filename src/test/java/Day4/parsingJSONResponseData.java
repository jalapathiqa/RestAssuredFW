package Day4;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;
public class parsingJSONResponseData {

	
	@Test
	public void testJsonResponse() {
		
		
		
		given()
			.contentType("ContentType.JSON")
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json; charset=utf-8")
		
		// approach 1:
		.body("data[0].first_name", equalTo("Michael"))
		.body("data[1].first_name", equalTo("Lindsay"))
		.body("data[2].first_name", equalTo("Tobias"))

		
		
	
		.log().all();
	}
	
	
}
