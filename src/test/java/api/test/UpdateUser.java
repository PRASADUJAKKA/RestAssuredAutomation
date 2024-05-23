package api.test;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import com.github.javafaker.Faker;

public class UpdateUser {
	@Test
	public void UpdateUser(ITestContext context) {
		String bearerToken = "690c4ecbc4291ce59de28808bbc025d43b8f10a24dc5947c6d3b699e7d6265ad";
		int id = (int) context.getSuite().getAttribute("ID");
		Faker fk = new Faker();
		JSONObject userPayload = new JSONObject();
		userPayload.put("name", "Prasadu");
		userPayload.put("email", fk.internet().emailAddress().toString());
		userPayload.put("gender", "male");
		userPayload.put("status", "inactive");
		
		 given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.body(userPayload.toString())
		.when()
		.put("https://gorest.co.in/public/v2/users/"+id)
		.then()
		.statusCode(200);
		
		
		//System.out.println(context.getSuite().getAttribute("ID"));
	}
}
