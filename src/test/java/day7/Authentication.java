package day7;
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
public class Authentication {

	
	
	@Test
	void testBasicAuthentication() {
		
		
		given()
		.auth().basic("postman", "Selenium@****")
		
		.when()
		
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	
	@Test
	void testDigestAuthentication() {
		
		
		given()
		.auth().digest("postman", "Selenium@****")
		
		.when()
		
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
	
	@Test
	void testPreemptiveAuthentication() {
		
		
		given()
		.auth().preemptive().basic("Postman", "****")
		
		.when()
		
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
}
