package practise;
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
public class Authentication_BearerToken {

	
	
	@Test
	void testBearerToken_Authentication() {
		
		String bearerToken = "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";
		given()
			.headers("Authorization", "Bearer "+bearerToken)
		
		.when()
		
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	// OAuth1.0 authentication
	@Test(enabled = false)
	void testOAuth1Authentication() {
		
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecrete")
		
		.when()
		
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	// OAuth2.0 authentication
		@Test
		void testOAuth2Authentication() {
			
			given()
				.auth().oauth2("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")
			
			.when()
			
				.get("https://api.github.com/users")
			.then()
				.statusCode(200)
				.log().all();
			
		}
	
}
