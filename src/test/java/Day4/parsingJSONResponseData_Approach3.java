package day4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class parsingJSONResponseData_Approach3 {

	@Test
	public void testJsonResponse() {

		Response response = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2");

		JSONObject jobj = new JSONObject(response.asString());

//		for (int i = 0; i < jobj.getJSONArray("data").length(); i++) {
//
//			String firstName = jobj.getJSONArray("data").getJSONObject(i).get("first_name").toString();
//			String lastName = jobj.getJSONArray("data").getJSONObject(i).get("last_name").toString();
//			System.out.println(firstName+ " " +lastName);
//
//		}
		
		boolean status=false;

		for (int i = 0; i < jobj.getJSONArray("data").length(); i++) {

			String firstName = jobj.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			String lastName = jobj.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println(firstName+ " " +lastName);
			
			if (firstName.equals("Michael")) {
				status=true;
				break;
				
			}
			System.out.println("*****************************************************************");
			Assert.assertEquals(status, true);
			
			
			
//			if (firstName.equals("Michael")) {
//				System.out.println("program executed succesfully");
//				
//			}
//			else {
//				System.out.println("program execution failed");
//
//			}
		}
		
		double sumOfIDs = 0;
			for (int i = 0; i < jobj.getJSONArray("data").length(); i++) {

				String ids = jobj.getJSONArray("data").getJSONObject(i).get("id").toString();
				
				sumOfIDs=sumOfIDs+Double.parseDouble(ids);			
		}
			
			System.out.println("Total sum of Ids:..."+sumOfIDs);
			Assert.assertEquals(sumOfIDs, 57.0);

	}
}
