package api.test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class JsonParserDemo {
@Test
	public void jsonParserDemo() {
		given()
		.when()
		.get("https://fakestoreapi.com/products/1")
		.then()
		.log().body();
	}
@Test
public void jsonParserDemo2() {
	given()
	.when()
	.get("https://fakestoreapi.com/products/1")
	.then()
	.body("rating.rate", equalTo(3.9F));
	
	when()
	.get("https://fakestoreapi.com/carts")
	.then()
	.log().body()
	.body("[0].products[0].productId", equalTo(1));
}

@Test
public void jsonParserDemo3() {
	Response res = given()
	.when()
	.get("https://fakestoreapi.com/products/1");
	
	double rate = res.jsonPath().getDouble("rating.rate");
	Assert.assertEquals(rate, 3.9);
}


}
