package practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class POST_createRequestBody_HashMap {

	@Test
	public void testPostUsingHashmap() {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map.put("name", "morpheus");
	map.put("job", "leader");
	
//	String courseArr[] = {"C", "C++"};
//	map.put("Courses", courseArr);
	
	
	given()
		.contentType("application/json")
		.body(map)
	
	.when()
		.post("https://reqres.in/api/users")

	.then()
		.statusCode(201)
		.body("name", equalTo("morpheus"))
		.body("job", equalTo("leader"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	
	
	}
}