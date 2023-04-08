package practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class parsingXMLResponseData_Approach2 {

	@Test
	public void testXMLResponse() {

		Response response = given().contentType("ContentType.JSON").when()
				.get("http://restapi.adequateshop.com/api/Traveler");

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/xml; charset=utf-8");
		String traveler2Name = response.xmlPath()
				.get("TravelerinformationResponse.travelers.Travelerinformation[2].name").toString();
		System.out.println(traveler2Name);

	}

}
