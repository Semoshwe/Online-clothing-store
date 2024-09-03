package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
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
import za.ac.cput.domain.ProductImage;
import za.ac.cput.factory.ProductImageFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductImageControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    private static ProductImage productImage;

    @BeforeEach
    void setup(){
        byte[] photo = new byte[0];
        this.productImage = ProductImageFactory.createProductImage("1",photo);
        this.baseUrl = "http://localhost:8080/shopping_store/productImage";
    }
    @Test
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<ProductImage> postResponse = restTemplate.postForEntity(url, productImage, ProductImage.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ProductImage productImageCreated = postResponse.getBody();
        assertEquals(productImage.getImageID(), productImageCreated.getImageID());
        System.out.println("Created: "+ productImageCreated);
    }

    @Test
    void read() {
        String url = baseUrl + "/read/" + productImage.getImageID();
        ResponseEntity<ProductImage> response = restTemplate.getForEntity(url, ProductImage.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(productImage.getImageID(), response.getBody().getImageID());
        System.out.println("Read: "+ response.getBody());
    }

    @Test
    void update() {
        String url = baseUrl + "/update";
        byte[] photo = new byte[0];
        //ProductImage updateProductImage = new ProductImage().Builder().copy(productImage).setImage(photo).build();
//        ProductImage updateProductImage =new ProductImage().Builder().copy(productImage).setImage(photo).build();
//        ResponseEntity<ProductImage> postResponse = restTemplate.postForEntity(url, updateProductImage, ProductImage.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        ProductImage productImageUpdated = postResponse.getBody();
//        assertEquals(updateProductImage.getImageID(), productImageUpdated.getImageID());
//        System.out.println("Updated product image: "+ productImageUpdated);
    }

    @Test
    void getAll() {
        String url = baseUrl + "/findAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Showing all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}