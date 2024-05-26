package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Admin: java
 * Admin: Controller Test Class
 * Author: Luke Duffell
 * Date: 26 May 2024
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/shopping_store_db/admin";
    private static Admin admin;

    @BeforeAll
    public static void setUp() {
        admin = AdminFactory.buildAdmin("9775", "Happiness");
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(url, admin, Admin.class);
        assertNotNull(postResponse.getBody());
        assertEquals(admin.getAdminId(), postResponse.getBody().getAdminId());
        System.out.println(postResponse.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read" + admin.getAdminId();
        ResponseEntity<Admin> response = restTemplate.getForEntity(url, Admin.class);
        assertEquals(admin.getAdminId(), response.getBody().getAdminId());
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        Admin newAdmin = new Admin.Builder().copy(admin).setPrivileges("Sadness").build();
        ResponseEntity<Admin> postResponse = restTemplate.postForEntity(url, newAdmin, Admin.class);
        assertNotNull(postResponse.getBody());
        assertEquals(newAdmin.getAdminId(), postResponse.getBody().getAdminId());
        System.out.println(postResponse.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,  String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }
}