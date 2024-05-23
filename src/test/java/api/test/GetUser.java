package api.test;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GetUser {
	@Test
	public void getUser(ITestContext context) {
		String bearerToken = "690c4ecbc4291ce59de28808bbc025d43b8f10a24dc5947c6d3b699e7d6265ad";
		
		int id = (int) context.getSuite().getAttribute("ID");
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.when()
		.get("https://gorest.co.in/public/v2/users/"+id)
		.then()
		.statusCode(200);
		//System.out.println(context.getSuite().getAttribute("ID"));
	}
}
