package api.test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {

	@Test(priority=1)
	public void testBasicAuthentication() {
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test(priority=2)
	public void testDigesticAuthentication() {
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	

	@Test(priority=3)
	public void testPreemptiveAuthentication() {
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test(priority=4)
	public void testBearerTokenAuthentication() {
		String bearerToken = "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";
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
	
	public void testOAuth1Authentication() {
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecrete")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=5)
	public void testOAuth2Authentication() {
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	public void testAPIKeyuthentication() {
		given()
		.queryParam("appId", "9a9547e72f50a6668e9ac2596eedb093")
		.pathParam("myPath", "data/2.5/forecast/daily")
		.queryParam("lat", "44.34")
		.queryParam("lon", "10.99")
		.queryParam("cnt", "7")
		.when()
		.get("https://api.openweathermap.org/{myPath}")
		.then()
		.statusCode(200)
		.log().all();
	}
}
