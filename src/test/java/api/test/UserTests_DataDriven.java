package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utils.DataProviders;
import io.restassured.response.Response;

public class UserTests_DataDriven {

	User userPayload;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String Execute,String UserID, String UserName, String FirstName, String LastName, String Email,
			String Password, String Phone) {
		
		 userPayload = new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUserName(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);

		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testGetUser(String Execute,String UserID, String UserName, String FirstName, String LastName, String Email,
			String Password, String Phone) {

	Response respone=	UserEndPoints.readUser(UserName);
	respone.getStatusCode();
	}

	@Test(priority = 3, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String Execute,String UserID, String UserName, String FirstName, String LastName, String Email,
			String Password, String Phone) {

	Response respone=	UserEndPoints.deleteUser(UserName);
	respone.getStatusCode();
	}
}
