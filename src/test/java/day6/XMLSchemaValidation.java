package day6;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class XMLSchemaValidation {

	@Test
	void jsonSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/store")
		.then();
//			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("users.json"));
		
	}
}
