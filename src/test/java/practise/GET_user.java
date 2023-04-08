package practise;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GET_user {

	@Test
	void getUser() {
		
	
		when()
			.get("https://reqres.in/api/users/3")
		
		.then()
			.statusCode(200)
//			.body("page", equalTo(2))
			.log().all();
		
	}
	
	
}
