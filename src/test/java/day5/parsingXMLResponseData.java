package day5;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class parsingXMLResponseData {

	
	@Test
	public void testJsonResponse() {
		
		
	given().contentType(ContentType.JSON)
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.travelers.Travelerinformation[2].name", equalTo("vano"))
			.log().all();
			


	}
	
	
}
