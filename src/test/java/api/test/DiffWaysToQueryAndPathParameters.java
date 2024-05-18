package api.test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

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
		.log().all();
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
		.log().body()
		.body("data.id", equalTo(4))
		.and()
		.body("support.url", equalTo("https://reqres.in/#support-heading"));
	}

@Test 
public void QueryAndPathParams3() {
	
	HashMap query = new HashMap();
	query.put("page",2);
	query.put("id",4);
	Response res = given()
	.pathParam("mypath", "users")
	.queryParams(query)
	.when()
	.get("https://reqres.in/api/{mypath}");
	
	int id = res.jsonPath().getInt("data.id");
	System.out.println(id +"  This id is extracted from the json ");
	
	
	JsonPath json = new JsonPath(res.toString());
	
}
}
