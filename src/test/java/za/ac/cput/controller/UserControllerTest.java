package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String Base_URL = "http://localhost:8080/shopping_store_db/user";

    private static User user;

    @BeforeAll
    public static void setup(){
        user = UserFactory.buildingUser("UD666", "Semoshwe", "Mapokgole", "peoplelll", "moshwe2@gmail.com", "00567","Low Str","Woodstock","Gauteng","2390");
    }

    @Test
    void a_create() {
        String url = Base_URL + "/create";
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        User userSaved = postResponse.getBody();
        assertEquals(user.getUserID(), userSaved.getUserID());
        System.out.println("Saved data :" + userSaved);
    }

    @Test
    void b_read() {
        String url = Base_URL + "/read/" +user.getUserID();
        System.out.println("URL:"+ url);
        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
        assertEquals(user.getUserID(), response.getBody().getUserID());
        System.out.println("Read :" + response.getBody());
    }

    @Test
    void c_update() {
        String url = Base_URL + "/update";
        User newUser = new User.Builder()
                .copy(user)
                .setUserID("UD567")
                .build();
        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, newUser, User.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        User userUpdated = postResponse.getBody();
        assertEquals(newUser.getUserID(), userUpdated.getUserID());
        System.out.println("Updated employee: " + userUpdated);
    }


//    @Test
//    void delete() {
//    }

    @Test
    void d_getall() {
        String url = Base_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,  String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }
}
