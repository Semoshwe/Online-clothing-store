package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    private static Product product;


    @BeforeEach
    void setUp() {
        this.product = ProductFactory.createProduct("1", "Hoodie", "White medium Hoodie.", 300, 50, "1","1");
        this.baseUrl = "http:/localhost:8080/online-clothing-store/product";
    }

    @Order(1)
    @Test
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Product productCreated = postResponse.getBody();
        assertEquals(product.getProductID(), productCreated.getProductID());
        System.out.println("Created: "+ productCreated);
    }

    @Order(2)
    @Test
    void read() {
        String url = baseUrl + "/read/" + product.getProductID();
        System.out.println("URL: "+ url);
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        assertEquals(product.getProductID(), response.getBody().getProductID());
        System.out.println("Read: "+ response.getBody());
    }

    @Order(3)
    @Test
    void update() {
        String url = baseUrl + "/update";
        Product updateProduct = new Product.Builder().copy(product).setDescription("Black medium hoodie.").build();
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, updateProduct, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Product productUpdated = postResponse.getBody();
        assertEquals(updateProduct.getProductID(), productUpdated.getProductID());
        System.out.println("Updated product: "+ productUpdated);
    }

    @Order(4)
    @Test
    void getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Showing all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}