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

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductReviewControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/shopping_store/productReview";
    private static ProductReview productReview;
    private static ProductReview productReview2;

    @BeforeAll
    public static void setup(){
        productReview = ProductReviewFactory.buildProductReview(66L,18L,23L, "Good product", 3);
        productReview2 = ProductReviewFactory.buildProductReview( 19L, 24L, "Great product", 5);
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

        ResponseEntity<ProductReview> postResponse2 = restTemplate.postForEntity(url, productReview2, ProductReview.class);
        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());
        ProductReview productReviewSaved2 = postResponse2.getBody();
        assertEquals(productReview2.getProductReviewID(), productReviewSaved2.getProductReviewID());
        System.out.println("Create2: " + productReviewSaved2);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + productReview.getProductReviewID();
        System.out.println("URL: " + url);
        ResponseEntity<ProductReview> response = restTemplate.getForEntity(url, ProductReview.class);
        assertEquals(productReview.getProductReviewID(), response.getBody().getProductReviewID());
        System.out.println("Read: " + response.getBody());

        String url2 = BASE_URL + "/read/" + productReview2.getProductReviewID();
        System.out.println("\nURL: " + url2);
        ResponseEntity<ProductReview> response2 = restTemplate.getForEntity(url2, ProductReview.class);
        assertEquals(productReview2.getProductReviewID(), response2.getBody().getProductReviewID());
        System.out.println("Read2: " + response2.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        ProductReview newProductReview = new ProductReview.Builder().copy(productReview).setReview("Bad product").setRating(1).build();
        ResponseEntity<ProductReview> postResponse = restTemplate.postForEntity(url, newProductReview, ProductReview.class);
        assertNotNull(postResponse);
        assertEquals(productReview.getProductReviewID(), Objects.requireNonNull(postResponse.getBody()).getProductReviewID());
        System.out.println("Updated: " + postResponse.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        System.out.println("URL: " + url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Get all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

//    @Test
//    @Order(5)
//    void delete() {
//        String url = BASE_URL + "/delete/" + productReview.getProductReviewID();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//    }
}