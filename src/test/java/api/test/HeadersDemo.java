package api.test;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	@Test
	public void getHeaders() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2&id=3")
		.then()
		.header("Content-Type", "application/json; charset=utf-8")
		.header("Server", "cloudflare")
		.header("Content-Encoding", "gzip");
	}
	
	@Test
	public void getHeader2() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2&id=3")
		.then()
		.log().headers();
	}
	
	
	@Test
	public void getHeaders3() {
		Response res = given()
		.when()
		.get("https://reqres.in/api/users?page=2&id=3");
		
		Headers hs = res.getHeaders();
		for(Header head: hs) {
			System.out.println(head.getName()+"   "+head.getValue());
		}
	}
	
	
}
