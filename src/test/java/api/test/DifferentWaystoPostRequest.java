package api.test;

import org.testng.annotations.Test;

import api.payload.POJO_ReqRes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static io.restassured.RestAssured.*;

public class DifferentWaystoPostRequest {

	//post the request using Hashmap
	@Test(priority = 1)
	public void postUser() {
		HashMap ddd = new HashMap();
		ddd.put("name", "Prasad");
		ddd.put("job", "SDET");
		
		        given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(ddd)
				.when()
				.post("https://reqres.in/api/users")
				.then()
				.statusCode(201)
				.log().all();
	}
	
	//post the request using the org.json 
	@Test(priority=2, dependsOnMethods="postUser")
	public void postUser2() {
		JSONObject js = new JSONObject(); 
		js.put("name", "Prasadu");
		js.put("job", "SDET");
		
		given()
		.contentType(ContentType.JSON)
		.body(js.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("Prasadu"));
		
	}
	
	
	//post the request using reading the external json file
	@Test(priority=3, dependsOnMethods="postUser2")
	public void postUser3() throws FileNotFoundException {
		//File fs = new File("C:\\Users\\prasa\\eclipse-workspace\\RestAssuredAutomation\\src\\test\\resources\\studentJson.json");
		//File fs = new File("src/test/resources/studentJson.json");
		File fs = new File(".\\studentJson.json");
		FileReader fr = new FileReader(fs);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject js = new JSONObject(jt);
		
		given()
		.contentType(ContentType.JSON)
		.body(js.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("Prasadu"))
		.log().all();
		
	}
	
	//post the request using POJO class created
	@Test(priority=4, dependsOnMethods="postUser3")
	public void postUser4() {
		POJO_ReqRes pr = new POJO_ReqRes();
		pr.setJob("Automation Test Engineer");
		pr.setName("SVVDPrasadu");
		given()
		.contentType(ContentType.JSON)
		.body(pr)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("SVVDPrasadu"))
		.body("job", equalTo("Automation Test Engineer"))
		.log().all();
		
	}

	
}
