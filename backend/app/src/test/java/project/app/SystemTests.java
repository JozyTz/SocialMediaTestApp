package project.app;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import project.app.model.User;
import project.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)
public class SystemTests {

  @LocalServerPort
	int port;
  
  	@Autowired
  	private UserRepository userRepo;

	@Before
	public void setUp() {
		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}
	
	
	@Test
	public void addFriendTest() {
	
		//initialize friend status as not friends
		unfriend("1","2");
		
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
		unfriend("1","2");
	}
	
	
	@Test
	public void removeFriendTest() {
	
		//initialize user1 and user2 status as friends
		friend("1","2");
		
		//unfriend user1 and user2
		RestAssured.given()
			.pathParam("userId", "1")
			.pathParam("friendId", "2")
		.when()
			.post("users/{userId}/removeFriend/{friendId}")
				
		//Assert success status, unfriended user username and id
		.then()
			.assertThat()
				.statusCode(200)
				.body(("item.id"),equalTo(2))
				.body(("item.username"),equalTo("user2test"))
				.body("successStatus",equalTo(true));
	}
	
	@Test
	public void getFriendsTest() {
		
		//variable to check against no friends assertion
		ArrayList<String> noFriendTest = new ArrayList<String>();
	
		//initialize user1 and user2 and user3 as not friends
		unfriend("1","2");
		unfriend("2","3");
		unfriend("1","3");
		
		//assert user 1 has no friends
		RestAssured.given()
			.pathParam("userId", "1")
			.when()
				.get("users/{userId}/friends")
			.then()
				.assertThat()
					.statusCode(200)
					.body(("$."),equalTo(noFriendTest));
		
		//assert user 2 has no friends
		RestAssured.given()
			.pathParam("userId", "1")
			.when()
				.get("users/{userId}/friends")
			.then()
				.assertThat()
					.statusCode(200)
					.body(("$."),equalTo(noFriendTest));
		
		//assert user 3 has no friends
		RestAssured.given()
			.pathParam("userId", "1")
			.when()
				.get("users/{userId}/friends")
			.then()
				.assertThat()
					.statusCode(200)
					.body(("$."),equalTo(noFriendTest));
		
		//set user 1/2 as friends, user 2/3 as friends
		friend("1","2");
		friend("2","3");
		
		//assert user 1 is friends with user 2, not user 3
		RestAssured.given()
		.pathParam("userId", "1")
		.when()
			.get("users/{userId}/friends")
		.then()
			.assertThat()
				.statusCode(200)
				.body(("id"),hasItem(2))
				.body(("username"),hasItem("user2test"))
				.body(("id"), not(hasItem(3)))
				.body(("username"), not(hasItem("user3test")));
		
		//assert user 2 is friends with user 1 and user 3
		RestAssured.given()
		.pathParam("userId", "2")
		.when()
			.get("users/{userId}/friends")
		.then()
			.assertThat()
				.statusCode(200)
				.body(("id"),hasItem(1))
				.body(("username"),hasItem("user1test"))
				.body(("id"), hasItem(3))
				.body(("username"), hasItem("user3test"));
				
		//assert user 3 is friends with user 2, not user 1
		RestAssured.given()
		.pathParam("userId", "3")
		.when()
			.get("users/{userId}/friends")
		.then()
			.assertThat()
				.statusCode(200)
				.body(("id"),hasItem(2))
				.body(("username"),hasItem("user2test"))
		
				.body(("id"), not(hasItem(1)))
				.body(("username"), not(hasItem("user1test")));
	}
	
	
	@Test
	public void getAllUsersTest() {
		RestAssured.when()
			.get("/users")
		.then()
			.assertThat()
				.statusCode(200)
				.body(("id"),hasItem(1))
				.body(("id"),hasItem(2))
				.body(("id"),hasItem(3))
				.body(("username"),hasItem("user1test"))
				.body(("username"),hasItem("user2test"))
				.body(("username"),hasItem("user3test"));
	}
	
	@Test
	public void findUserByIdTest() {
		RestAssured.given()
		.pathParam("userId", "2")
		.when()
			.get("/users/{userId}")
		.then()
			.assertThat()
				.statusCode(200)
		
				.body(("id"),equalTo(2))
				.body(("username"),equalTo("user2test"))
				
				.body(("id"),not(equalTo(1)))
				.body(("username"),not(equalTo("user1test")));
	}
	
	@Test
	public void createAndDeleteUserTest() {
		
		//mock up new user
		String newUserTest = "{\"username\":\"NEWUSERTEST\",\"password\":\"NEW USER TEST PASS\",\"email\":\"NEWUSER@MAIL\"}";
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(newUserTest)
		.when()
			.post("/users/create")
		.then()
			.assertThat()
				.statusCode(200)
				.body(("username"),equalTo("NEWUSERTEST"))
				.body(("password"),equalTo("NEW USER TEST PASS"))
				.body(("email"),equalTo("NEWUSER@MAIL"));
		
		Long newUserId = userRepo.findByUsernameAndPassword("NEWUSERTEST", "NEW USER TEST PASS").getID();
		userRepo.deleteById(newUserId);
	}
	
	@Test
	public void loginTest() {
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("username", "user1test");
		data.put("password", "1234");

		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(data)
		.when()
			.post("/login")
		.then()
			.assertThat()
				.statusCode(200)
				.body("successStatus",equalTo(true))
				.body(("item.username"),equalTo("user1test"));
	}
	


	
	
	
	//========================================================================
	//=====							Helper Methods						 =====
	//========================================================================
	
	/**
	 * unfriends user1
	 */
	public void unfriend(String id1, String id2)
	{
		RestAssured.given()
			.pathParam("userId", id1)
			.pathParam("friendId", id2)
		.post("users/{userId}/removeFriend/{friendId}");
	}
	
	public void friend(String id1, String id2)
	{
		RestAssured.given()
			.pathParam("userId", id1)
			.pathParam("friendId", id2)
		.post("users/{userId}/addFriend/{friendId}");
	}
}
