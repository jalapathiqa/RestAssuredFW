package practise;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {

	@Test
	void deleteGORESTUser(ITestContext context) throws FileNotFoundException {
		

		String token="d62987759f91db112b187fdad543fb70e554924d689262a0d9871f1641898ed4";
//		int id = (Integer) context.getAttribute("user_id");
		
		int id = (Integer) context.getSuite().getAttribute("user_id");
				given()
					.headers("Authorization", "Bearer "+token)
					.contentType("application/json")
					.pathParam("id", id)
				.when()
					.delete("https://gorest.co.in/public/v2/users/{id}")
				.then()
					.statusCode(204)
					.log().all();
	}

}
