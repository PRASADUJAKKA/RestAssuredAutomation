package api.test;
import org.testng.annotations.Test;

import api.payload.POJO_ReqRes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.hamcrest.Matcher;
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

public class JsonSchemaValidator {

	//post the request using Hashmap
	@Test(priority = 1)
	public void jsonScehma() {
		
		
		        given()
				.when()
				.get("https://ergast.com/api/f1/2017/circuits.xml")
				.then()
				.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonScehma.json"));
	}

	private static Matcher<?> matchesJsonSchemaInClasspath(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
