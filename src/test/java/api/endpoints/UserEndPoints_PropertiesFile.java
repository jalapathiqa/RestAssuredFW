package api.endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.ResourceBundle;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.User;
import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

/*
 *UserEndPoints.java
 *Created to perform Crea, Read, Update, Delete requests to the user API 
 *
 */
public class UserEndPoints_PropertiesFile {
	
	public static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("routes");
		return routes;
	}
	
	

	public static Response createUser(User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.post_url);
		return response;
	}

	public static Response readUser(String userName) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).when().get(Routes.get_url);
		return response;
	}
 
	public static Response updateUser(String userName, User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
					.pathParam("username", userName)
					.body(payload)
				.when()
					.put(Routes.update_url);
		return response;
	}

	public static Response deleteUser(String userName) {

		Response response = given()
					.pathParam("username", userName)
				.when()
					.delete(Routes.delete_url);
		return response;
	}
}
