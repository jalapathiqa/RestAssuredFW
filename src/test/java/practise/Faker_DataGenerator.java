package practise;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class Faker_DataGenerator {

	
	
	@Test
	void FakerDataGeneratorTest() {
		
		Faker faker=new Faker();
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String userName = faker.name().username();
		String pwd = faker.internet().password();
		String Cnum = faker.phoneNumber().cellPhone();
		String email = faker.internet().safeEmailAddress();
		
		System.out.println(fullName);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(userName);
		System.out.println(pwd);
		System.out.println(pwd);
		System.out.println(Cnum);
		System.out.println(email);


		
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
