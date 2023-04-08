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
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CreateUser_ExternalFile {

	@Test
	void createGORESTUser() throws FileNotFoundException {
		
		File fin = new File("./GoREST_User.json");
		FileReader fr=new FileReader(fin);
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);

		String token="d62987759f91db112b187fdad543fb70e554924d689262a0d9871f1641898ed4";
		
				given()
					.headers("Authorization", "Bearer "+token)
					.contentType("application/json")
					.body(data.toString())
				.when()
					.post("https://gorest.co.in/public/v2/users")
				.then()
					.statusCode(201)
					.log().all();

	}

}
