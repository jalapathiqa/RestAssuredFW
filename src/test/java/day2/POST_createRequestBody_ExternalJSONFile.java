package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class POST_createRequestBody_ExternalJSONFile {

	@Test
	public void testPostUsingHashmap() throws FileNotFoundException {
		
		
		File f=new File("./users.json");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);
		given()
			.contentType("application/json")
			.body(data.toString())

			.when()
				.post("https://reqres.in/api/users")

			.then()
				.statusCode(201)
				.body("name", equalTo("morpheus1"))
				.body("job", equalTo("leader1"))			
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();

	}
}