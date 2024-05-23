package api.test;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import java.util.List;

public class XmlParserDemo {

	@Test(priority=1)
	public void demoOfXML() {
		given()
		.when()
		.get("https://ergast.com/api/f1/2017/circuits.xml")
		.then()
		.log().body()
		.body("MRData.CircuitTable.Circuit[0].CircuitName", equalTo("Albert Park Grand Prix Circuit"));
	}
	
	@Test(priority=2)
	public void demoOfXML2() {
		given()
		.when()
		.get("https://ergast.com/api/f1/2017/circuits.xml")
		.then()
		.log().body()
		.statusCode(200)
		.body("MRData.CircuitTable.Circuit[18].Location.Locality", equalTo("Montreal"))
		.body("MRData.CircuitTable.Circuit[18].Location.Country", equalTo("Canada"));
	}
	
	@Test(priority=3)
	public void demoOfXML3() {
		Response res = given()
		.when()
		.get("https://ergast.com/api/f1/2017/circuits.xml");
		
		XmlPath xmlObj= new XmlPath(res.asString());
		List<String> circuitList = xmlObj.getList("MRData.CircuitTable.Circuit");
		Assert.assertEquals(circuitList.size(), 20);
		List<String> circuitNameList = xmlObj.getList("MRData.CircuitTable.Circuit.CircuitName");
		for(String ss: circuitNameList) {
			System.out.println(ss);
		}
	}
}
