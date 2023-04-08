package practise;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class UpdateUser {

	@Test
	void updateGORESTUser(ITestContext context) throws FileNotFoundException {
		

		Faker faker=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "Active");

		String token="d62987759f91db112b187fdad543fb70e554924d689262a0d9871f1641898ed4";
//		int id = (Integer) context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		
				given()
					.headers("Authorization", "Bearer "+token)
					.contentType("application/json")
					.body(data.toString())
					.pathParam("id", id)
				.when()
					.put("https://gorest.co.in/public/v2/users/{id}")
				.then()
					.statusCode(200)
					.log().all();
	}

}
