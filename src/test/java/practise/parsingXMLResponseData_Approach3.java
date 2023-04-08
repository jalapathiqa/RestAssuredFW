package practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class parsingXMLResponseData_Approach3 {

	@Test
	public void testXMLResponse() {

		Response response = given().contentType("ContentType.JSON").get("http://restapi.adequateshop.com/api/Traveler");

		XmlPath xmlObj = new XmlPath(response.asString());

		List<String> travellers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");

		System.out.println(travellers.size());

		Assert.assertEquals(travellers.size(), 10);

		List<String> travellerName = xmlObj
				.getList("TravelerinformationResponse.travelers.Travelerinformation.name[2]");
		System.out.println(travellerName);

		List<String> allTravellerNames = xmlObj
				.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		for (String travellerNames : allTravellerNames) {
			System.out.println(travellerNames);

		}
		
		System.out.println("*******************************************************************");
		boolean status=false;
		for (String names : allTravellerNames) {
			if (names.equals("vano")) {
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
	}
}
