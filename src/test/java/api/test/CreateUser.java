package api.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateUser {
	@Test
	public void createUser(ITestContext context) {
		String bearerToken = "690c4ecbc4291ce59de28808bbc025d43b8f10a24dc5947c6d3b699e7d6265ad";
		Faker fk = new Faker();
		JSONObject userPayload = new JSONObject();
		userPayload.put("name", "Prasadu");
		userPayload.put("email", fk.internet().emailAddress().toString());
		userPayload.put("gender", "male");
		userPayload.put("status", "active");
		
		int id = given()
		.headers("Authorization", "Bearer "+bearerToken)
		.contentType("application/json")
		.body(userPayload.toString())
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		context.getSuite().setAttribute("ID", id);
		//System.out.println(context.getSuite().getAttribute("ID"));
	}
}
