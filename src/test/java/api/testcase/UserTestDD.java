package api.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {

	@Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd,
			String phone) {

		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(lname);
		userPayload.setPassword(email);
		userPayload.setPhone(phone);

		// call createUser method from UserEndpoints class(UserEndPoints.methodname()

		Response response = UserEndPoints.createUser(userPayload);

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUser(String username) {

		// call getUser method from UserEndpoints class

		Response response = UserEndPoints.getUser(username);

		System.out.println("GET DATA");

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {

		// call getUser method from UserEndpoints class

		Response response = UserEndPoints.deleteUser(username);

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
