package apiTesting;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SendPOSTRequest_JsonFile {
	
	public static void main(String[] args) {
		
	Response response =	given().contentType(ContentType.JSON).body(new File("./users.json"))
			.post("https://reqres.in/api/users");
	
	System.out.println("Status code: "+response.statusCode());
	response.prettyPrint();
	}

}
