package api.test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class DiffWaysToQueryAndPathParameters {

	@Test
	public void QueryAndPathParams() {
		
		given()
		.pathParam("mypath", "users")
		.queryParam("page",2)
		.queryParam("id",4)
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.log().body();
	}
	
	
	@Test
public void QueryAndPathParams2() {
		
		HashMap query = new HashMap();
		query.put("page",2);
		query.put("id",4);
		given()
		.pathParam("mypath", "users")
		.queryParams(query)
		.when()
		.get("https://reqres.in/api/{mypath}")
		.then()
		.log().body();
	}
}
