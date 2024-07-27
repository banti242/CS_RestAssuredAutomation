package api.testcase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	// Fake data generate

	Faker faker;
	User userPayload;
	public static Logger logger;

	@BeforeClass
	public void generateTestData() {

		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// obtain logger
		logger = LogManager.getLogger("RestAssuredAutomation");
	}

	@Test(priority = 1)
	public void testCreateUser() {

		// call createUser method from UserEndpoints class(UserEndPoints.methodname()

		Response response = UserEndPoints.createUser(userPayload);

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

		// log

		logger.info("create user executed");

	}

	@Test(priority = 2)
	public void testGetUser() {

		// call getUser method from UserEndpoints class

		Response response = UserEndPoints.getUser(this.userPayload.getUsername());

		System.out.println("GET DATA");

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

		// log
		logger.info("Get user executed");

	}

	@Test(priority = 3)
	public void testUpdateUser() {

		// call updateUser method from UserEndpoints class

		userPayload.setUsername(faker.name().username());

		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

		// read user data afterUpdate

		Response responsePostUpdate = UserEndPoints.getUser(this.userPayload.getUsername());

		System.out.println("Afetr update user data");

		responsePostUpdate.then().log().all();

		// log

		logger.info("update user executed");
	}

	@Test(priority = 4)
	public void testdeleteUser() {

		// call seleteUser method from UserEndpoints class

		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());

		// log response

		response.then().log().all();

		// validation

		Assert.assertEquals(response.getStatusCode(), 200);

		// log

		logger.info("delete user executed");

	}

}
