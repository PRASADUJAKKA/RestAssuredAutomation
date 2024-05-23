package api.test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class FileUploadAndDownload {

	@Test(priority=1)
	public void FileUpload() {
		File fm = new File("C:\\Users\\prasa\\Downloads\\sample1.txt");
		given()
		.multiPart("file",fm)
		.contentType("multipart/form-data")
		.when()
		.post("https://the-internet.herokuapp.com/upload")
		.then()
		.log().body();
	}
	
	@Test(priority=2)
	public void FileDownload() {
		
		given()
		.when()
		.post("https://the-internet.herokuapp.com/download/logo.png")
		.then()
		.statusCode(404)
		.log().body();
		
	}
}
