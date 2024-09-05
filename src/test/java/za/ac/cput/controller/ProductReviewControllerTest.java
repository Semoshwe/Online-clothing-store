/*
 * ProductReviewControllerTest.java
 * Controller test class for the ProductReview
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
import za.ac.cput.domain.ProductReview;
import za.ac.cput.factory.ProductReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductReviewControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/shopping_store/productreview";
    private static ProductReview productReview;

    @BeforeAll
    public static void setup(){
        productReview = ProductReviewFactory.buildProductReview("1","1","1", "Good product", 3);
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<ProductReview> postResponse = restTemplate.postForEntity(url, productReview, ProductReview.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ProductReview productReviewSaved = postResponse.getBody();
        assertEquals(productReview.getProductReviewID(), productReviewSaved.getProductReviewID());
        System.out.println("Create: " + productReviewSaved);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + productReview.getProductReviewID();
        System.out.println("URL: " + url);
        ResponseEntity<ProductReview> response = restTemplate.getForEntity(url, ProductReview.class);
        assertEquals(productReview.getProductReviewID(), response.getBody().getProductReviewID());
        System.out.println("Read: " + response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        ProductReview newProductReview = new ProductReview.Builder().copy(productReview).setReview("Bad product").setRating(1).build();
        ResponseEntity<ProductReview> postResponse = restTemplate.postForEntity(url, newProductReview, ProductReview.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ProductReview updatedProductReview = postResponse.getBody();
        assertEquals(productReview.getProductReviewID(), updatedProductReview.getProductReviewID());
        System.out.println("Update: " + updatedProductReview);
    }

    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}