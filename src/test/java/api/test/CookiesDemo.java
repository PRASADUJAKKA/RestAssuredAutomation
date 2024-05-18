package api.test;
import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	@Test
	public void getCookies() {
		Response res = given()
		.when()
		.get("www.google.com");
		
		Map<String,String> cook = res.getCookies();
		System.out.println(cook.containsKey("JSESSIONID.ab82ba05"));
	}
	@Test
	public void getCookies2() {
		given()
		.when()
		.get("www.google.com")
		.then()
		.log().cookies();
	}
	
	@Test
	public void getCookies3() {
		Response res = given()
		.when()
		.get("www.google.com");
		
		Map<String, String> cook = res.getCookies();

		for(String ck: cook.keySet()) {
			String cookie_value = res.getCookie(ck);
			System.out.println(ck+"  cookie value is "+cookie_value);
		}
		
		System.out.println("cookies size in this request is "+cook.size());
	}
}
