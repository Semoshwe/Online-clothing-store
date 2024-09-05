/*
 * CategoryControllerTest.java
 * Controller test class for the Category
 * Author: Mthandeni Mbobo (218223579)
 * Date: 23 May 2024
 * */

package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/shopping_store/category";
    private static Category category;

    @BeforeAll
    public static void setup(){
        category = CategoryFactory.buildCategory("1", "Men");
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Category> postResponse = restTemplate.postForEntity(url, category, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Category categorySaved = postResponse.getBody();
        assertEquals(category.getCategoryID(), categorySaved.getCategoryID());
        System.out.println("Create: " + categorySaved);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + category.getCategoryID();
        System.out.println("URL: " + url);
        ResponseEntity<Category> response = restTemplate.getForEntity(url, Category.class);
        assertEquals(category.getCategoryID(), response.getBody().getCategoryID());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        Category newCategory = new Category.Builder().copy(category).setCategoryName("Mens").build();
        ResponseEntity<Category> postResponse = restTemplate.postForEntity(url, newCategory, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Category updatedCategory = postResponse.getBody();
        assertEquals(category.getCategoryID(), updatedCategory.getCategoryID());
        System.out.println("Update: " + updatedCategory);
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/findAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}