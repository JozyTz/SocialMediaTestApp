package project.app;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)
public class SystemTests {

  @LocalServerPort
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}
	
	
	@Test
	public void addFriendTest() {
	
		//initialize friend status as not friends
		unfriend();
		
		//friend user1 and user2 together
		RestAssured.given()
			.pathParam("userId", "1")
			.pathParam("friendId", "2")
		.when()
			.post("users/{userId}/addFriend/{friendId}")
				
		//Assert success status, friend username and friend id
		.then()
			.assertThat()
				.statusCode(200)
				.body(("item.id"),equalTo(2))
				.body(("item.username"),equalTo("user2test"))
				.body("successStatus",equalTo(true));
		
		//reset back to not friends
		unfriend();
	}
	
	
	
	//========================================================================
	//=====							Helper Methods						 =====
	//========================================================================
	
	/**
	 * unfriends user1
	 */
	public void unfriend()
	{
		RestAssured.given()
			.pathParam("userId", "1")
			.pathParam("friendId", "2")
		.post("users/{userId}/removeFriend/{friendId}");
	}
}
