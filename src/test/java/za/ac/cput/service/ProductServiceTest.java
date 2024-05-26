package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    private static Product product1;
    private static Product product2;

    @Order(1)
    @Test
    void setUp() {
        product1 = ProductFactory.createProduct("1", "Hoodie", "White medium Hoodie.", 300, 50, "1","1");
        assertNotNull(product1);
        System.out.println(product1);

        product2 = ProductFactory.createProduct("2", "Jeans", "Black medium skinny jeans.", 350, 40, "2","2");
        assertNotNull(product2);
        System.out.println(product2);
    }

    @Order(2)
    @Test
    void create() {
        Product created1 = productService.create(product1);
        assertNotNull(created1);
        System.out.println(created1);

        Product created2 = productService.create(product2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Order(3)
    @Test
    void read() {
        Product read = productService.read(product2.getProductID());
        assertNotNull(read);
        System.out.println(read);
    }

        @Order(4)
    @Test
    void update() {
        Product newProduct = new Product.Builder().copy(product2)
                .setCategoryID("2")
                .setName("Jeans")
                .setDescription("Blue skinny Jeans. Waist 34cm.")
                .setPrice(250)
                .setStock(50)
                .setReviewID("2")
                .setImageID("2")
                .build();
        Product updated = productService.update(newProduct);
        assertNotNull(updated);
            System.out.println(updated);
    }

    @Order(5)
    @Test
    void getAll() {
        System.out.println(productService.getAll());
    }
}