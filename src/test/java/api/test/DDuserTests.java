package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDuserTests {
	
	public Logger logger;
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testpostUserwithDataProviders(String userId, String userName, String fname, String lName, String email,
			String pwd, String phn) {
	    
		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setLastName(pwd);
		userPayload.setPhone(pwd);

		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		logger = LogManager.getLogger(this.getClass());
		
		logger.info("**************Data Providers Execution is completed**********");
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testGetUserWithDD(String userName) {
		logger.info("**********userNames with DD is Started***********");
		Response response = UserEndPoints.readUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********userNames with DD is Completed***********");
	}
}
