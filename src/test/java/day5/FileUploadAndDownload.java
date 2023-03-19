package day5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class FileUploadAndDownload {
	
	@Test(priority=1)
	public void singleFileUpload() {		
		
		File fi=new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Library\\API\\notes.txt");

		given()
			.multiPart(fi).contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		
		.then()
			.statusCode(200)
			.body("fileName", equalTo("notes.txt"))
			.log().all();

		
	}
	
	@Test(priority=2)
	public void multipleFilesUpload() {		
		
		File fi=new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Library\\API\\notes.txt");
		File fis=new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Library\\API\\notes - Copy.txt");

		given()
			.multiPart("files",fi)
			.multiPart("files",fis)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("notes.txt"))
			.body("[1].fileName", equalTo("notes - Copy.txt"))
			.log().all();
		

		
	}


	@Test(enabled = false)
	public void fileArray() {		
		
		File fi=new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Library\\API\\notes.txt");
		File fis=new File("C:\\Users\\kalag\\OneDrive\\Desktop\\Library\\API\\notes - Copy.txt");

		File fileArray[] = {fi, fis};
		
		given()
			.multiPart("files",fileArray)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("notes.txt"))
			.body("[1].fileName", equalTo("notes - Copy.txt"))
			.log().all();
		
	}

	@Test(priority=3)
	void fileDownload() {
		given()
		.when()
			.get("http://localhost:8080/downloadFile/notes.txt")
		.then()
			.statusCode(200)
			.log().body();
		
	}
	
	@Test(priority=4)
	void file2Download() {
		given()
		.when()
			.get("http://localhost:8080/downloadFile/notes - Copy.txt")
		.then()
			.statusCode(200)
			.log().body();
		
	}
	
}
