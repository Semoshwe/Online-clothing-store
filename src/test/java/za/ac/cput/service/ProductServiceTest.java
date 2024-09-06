package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product.Builder()
                .setProductId(1L)
                .setName("African head ")
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
    void create() {
        Product createdProduct = productService.create(product);
        assertNotNull(createdProduct);
        assertEquals(product.getName(), createdProduct.getName());
    }

    @Test
    void read() {
        Product createdProduct = productService.create(product);
        Product readProduct = productService.read(createdProduct.getProductId());
        assertNotNull(readProduct);
        assertEquals(createdProduct.getProductId(), readProduct.getProductId());
    }

    @Test
    void update() {
        Product createdProduct = productService.create(product);
        createdProduct = new Product.Builder()
                .copy(createdProduct)
                .setName("Updated Test Product")
                .build();
        Product updatedProduct = productService.update(createdProduct);
        assertNotNull(updatedProduct);
        assertEquals("Updated Test Product", updatedProduct.getName());
    }

    @Test
    void findAll() {
        productService.create(product);
        List<Product> products = productService.findAll();
        assertFalse(products.isEmpty());
    }

    @Test
    void findByName() {
        productService.create(product);
        List<Product> products = productService.findByName("African head");
        assertFalse(products.isEmpty());
        assertEquals("African head", products.get(0).getName());
    }

    @Test
    void findByCategoryId() {
        productService.create(product);
        List<Product> products = productService.findByCategoryId(1L);
        assertFalse(products.isEmpty());
        assertEquals(1, products.get(0).getCategoryId());
    }

    @Test
    void findByPriceBetween() {
        productService.create(product);
        List<Product> products = productService.findByPriceBetween(10.00, 11.00);
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getPrice() >= 10.00 && products.get(0).getPrice() <= 11.00);
    }

    @Test
    void findByStockQuantityGreaterThan() {
        productService.create(product);
        List<Product> products = productService.findByStockQuantityGreaterThan(5); // Adjusted for testing
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getStockQuantity() > 5);
    }

    @Test
    void findByCreatedAtAfter() {
        productService.create(product);
        List<Product> products = productService.findByCreatedAtAfter(LocalDate.now().minusDays(1));
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getCreatedAt().isAfter(LocalDate.now().minusDays(1).atStartOfDay()));
    }

    @Test
    void findByUpdatedAtBefore() {
        productService.create(product);
        List<Product> products = productService.findByUpdatedAtBefore(LocalDate.now().plusDays(1));
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getUpdatedAt().isBefore(LocalDate.now().plusDays(1).atStartOfDay()));
    }
}