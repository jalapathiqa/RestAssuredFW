package practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetUserDetails {

	@Test
	void testGetGORESTUser(ITestContext context) {

//		int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
		String token="d62987759f91db112b187fdad543fb70e554924d689262a0d9871f1641898ed4";
		
				given()
					.headers("Authorization", "Bearer "+token)
					.pathParam("id", id)
				.when()
					.get("https://gorest.co.in/public/v2/users/{id}")
					
				.then()
					.statusCode(200)
					.log().all();
	}

}
