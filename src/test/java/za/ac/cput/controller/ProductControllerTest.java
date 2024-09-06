package za.ac.cput.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Product product;

    @BeforeEach
    void setUp() {
        // Initialize a Product object before each test
        product = new Product.Builder()
                .setProductId(28L)
                .setName("African head")
                .setDescription("This is a test product")
                .setPrice(10.99)
                .setStockQuantity(10)
                .setCategoryId(1L)
                .setCreatedAt(LocalDate.now().atStartOfDay())
                .setUpdatedAt(LocalDate.now().atStartOfDay())
                .setImagePath("path/to/image.jpg")
                .build();
    }

    @Test
    void createProduct() {
        // Test creating a new product
        ResponseEntity<Product> response = restTemplate.postForEntity("/store/api/products", product, Product.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getName(), response.getBody().getName());
    }

    @Test
    void getProductById() {
        // Test retrieving a product by its ID
        Product createdProduct = restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product> response = restTemplate.getForEntity("/store/api/products/" + createdProduct.getProductId(), Product.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(createdProduct.getProductId(), response.getBody().getProductId());
    }

    @Test
    void updateProduct() {
        // Test updating an existing product
        Product createdProduct = restTemplate.postForObject("/store/api/products", product, Product.class);
        createdProduct = new Product.Builder().copy(createdProduct).setName("Updated Product").build();
        HttpEntity<Product> requestUpdate = new HttpEntity<>(createdProduct);
        ResponseEntity<Product> response = restTemplate.exchange("/store/api/products", HttpMethod.PUT, requestUpdate, Product.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    void deleteProduct() {
        // Test deleting a product
        Product createdProduct = restTemplate.postForObject("/store/api/products", product, Product.class);
        restTemplate.delete("/store/api/products/" + createdProduct.getProductId());
        ResponseEntity<Product> response = restTemplate.getForEntity("/store/api/products/" + createdProduct.getProductId(), Product.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getAllProducts() {
        // Test retrieving all products
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products", Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    void getProductsByName() {
        // Test retrieving products by name
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/name/" + product.getName(), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getName(), response.getBody()[0].getName());
    }

    @Test
    void getProductsByCategoryId() {
        // Test retrieving products by category ID
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/category/" + product.getCategoryId(), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getCategoryId(), response.getBody()[0].getCategoryId());
    }

    @Test
    void getProductsByPriceRange() {
        // Test retrieving products within a price range
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/price-range?minPrice=10.00&maxPrice=11.00", Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getPrice() >= 10.00 && response.getBody()[0].getPrice() <= 11.00);
    }

    @Test
    void getProductsByStockQuantityGreaterThan() {
        // Test retrieving products by stock quantity greater than a specified value
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/stock-quantity-greater-than?stockQuantity=5", Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getStockQuantity() > 5);
    }

    @Test
    void getProductsCreatedAfter() {
        // Test retrieving products created after a specific date
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/created-after?createdAt=" + LocalDate.now().minusDays(1), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getCreatedAt().isAfter(LocalDate.now().minusDays(1).atStartOfDay()));
    }

    @Test
    void getProductsUpdatedBefore() {
        // Test retrieving products updated before a specific date
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/updated-before?updatedAt=" + LocalDate.now(), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getUpdatedAt().isBefore(ChronoLocalDateTime.from(LocalDate.now().plusDays(1))));
    }

    @AfterEach
    void tearDown() {
        // Cleanup after each test if necessary
    }
}
