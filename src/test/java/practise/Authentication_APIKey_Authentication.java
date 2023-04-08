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

public class Authentication_APIKey_Authentication {

	@Test
	void testOAuth2Authentication() {


		//Method: 1
//				given()
//					.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c") //appdi is APIKey
//				.when()
//					.get("http://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
//					
//				.then()
//					.statusCode(200)
//					.log().all();

				
				
		//Method: 2
				given()
					.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c") //appdi is APIKey
					.pathParam("mypath", "data/2.5/forecast/daily")
					.queryParam("q", "Delhi")
					.queryParam("units", "metric")
					.queryParam("cnt", "7")
				.when()
					.get("http://api.openweathermap.org/{mypath}")
					
				.then()
					.statusCode(200)
					.log().all();
	}

}
