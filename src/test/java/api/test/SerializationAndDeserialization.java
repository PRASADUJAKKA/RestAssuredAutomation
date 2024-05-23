package api.test;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.payload.User;

public class SerializationAndDeserialization {

	@Test()
	public void pojo2Json() throws JsonProcessingException {
		User us = new User();
		Faker jf = new Faker();

		us.setId(jf.idNumber().hashCode());
		us.setUsername(jf.name().username());
		us.setFirstName(jf.name().firstName());
		us.setLastName(jf.name().lastName());
		us.setEmail(jf.internet().safeEmailAddress());
		us.setPassword(jf.internet().password(5, 10));
		us.setPhone(jf.phoneNumber().cellPhone());

		ObjectMapper om = new ObjectMapper();
		String userJSon = om.writerWithDefaultPrettyPrinter().writeValueAsString(us);
		System.out.println(userJSon);
	}

	@Test
	public void Json2pojo() throws JsonMappingException, JsonProcessingException {

		String userJson = "{\r\n" + "  \"id\" : 782505238,\r\n" + "  \"username\" : \"savannah.kohler\",\r\n"
				+ "  \"firstName\" : \"Lorilee\",\r\n" + "  \"lastName\" : \"Crist\",\r\n"
				+ "  \"email\" : \"julia.ondricka@example.com\",\r\n" + "  \"password\" : \"1bvgr\",\r\n"
				+ "  \"phone\" : \"(773) 589-2836\",\r\n" + "  \"userStatus\" : 0\r\n" + "}";
		ObjectMapper om = new ObjectMapper();
		User us = om.readValue(userJson, User.class);
		System.out.println(us.getId());
		System.out.println(us.getUsername());
		System.out.println(us.getFirstName());
		System.out.println(us.getLastName());
		System.out.println(us.getEmail());
		System.out.println(us.getPassword());
		System.out.println(us.getPhone());
		System.out.println(us.getUserStatus());

	}
}
