package practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;


public class POST_createRequestBody_Orj_Json {

	@Test
	public void testPostUsingHashmap() {

		JSONObject data = new JSONObject();

		data.put("name", "Canada");
		data.put("job", "Surrey");
	
//	String courseArr[] = {"C", "C++"};
//	data.put("Courses", courseArr);
	
	
	given()
		.contentType("application/json")
		.body(data.toString())
	
	.when()
		.post("https://reqres.in/api/users")

	.then()
		.statusCode(201)
		.body("name", equalTo("Canada"))
		.body("job", equalTo("Surrey"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	
	
	}
}