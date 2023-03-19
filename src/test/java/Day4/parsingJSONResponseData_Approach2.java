package day4;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class parsingJSONResponseData_Approach2 {

	
	@Test
	public void testJsonResponse() {
		
		
		
	Response response=given()
			.contentType("ContentType.JSON")
		
		.when()
		.get("https://reqres.in/api/users?page=2");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		
		String url =response.jsonPath().get("support.url").toString();
		Assert.assertEquals(url, "https://reqres.in/#support-heading");
		
		String first0Name = response.jsonPath().get("data[0].last_name").toString();
		Assert.assertEquals(first0Name, "Michael");
		response.prettyPrint();
	}
	
	
}
