//package za.ac.cput.controller;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import za.ac.cput.domain.User;
//import za.ac.cput.factory.UserFactory;
//
//import java.time.LocalDate;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class UserControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private final String Base_URL = "http://localhost:8080/shopping_store_db/user";
//
//    private static User user;
//
//    @BeforeAll
//    public static void setup(){
//        user = UserFactory.createUser( "Semoswe", "Mapokgole", "peoplelll", "moshwe2@gmail.com", LocalDate.of(1991,03,03), Set.of("USER"),"1234567890","password2");
//    }
//
//    @Order(1)
//    @Test
//    void create() {
//        String url = Base_URL + "/create";
//        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, user, User.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        User userSaved = postResponse.getBody();
//        assertEquals(user.getUserID(), userSaved.getUserID());
//        System.out.println("Saved data :" + userSaved);
//    }
//
//    @Order(2)
//    @Test
//    void b_read() {
//        String url = Base_URL + "/read/" +user.getUserID();
//        System.out.println("URL:"+ url);
//        ResponseEntity<User> response = restTemplate.getForEntity(url, User.class);
//        assertEquals(user.getUserID(), response.getBody().getUserID());
//        System.out.println("Read :" + response.getBody());
//    }
//
//    @Order(3)
//    @Test
//    void c_update() {
//        String url = Base_URL + "/update";
//        User newUser = new User.Builder()
//                .copy(user).setLastName("linfi")
//                .build();
//        ResponseEntity<User> postResponse = restTemplate.postForEntity(url, newUser, User.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        User userUpdated = postResponse.getBody();
//        assertEquals(newUser.getLastName(), userUpdated.getUserID());
//        System.out.println("Updated employee: " + userUpdated);
//    }
//
//    @Order(4)
//    @Test
//    void delete() {
//    }
//
//    @Order(5)
//    @Test
//    void d_getall() {
//        String url = Base_URL + "/getall";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,  String.class);
//        assertNotNull(response.getBody());
//        System.out.println(response.getBody());
//    }
//}
