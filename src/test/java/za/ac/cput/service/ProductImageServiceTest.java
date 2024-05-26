package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ProductImage;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductImageServiceTest {
    @Autowired
    private ProductImageService productImageService;

    private static ProductImage productImage1;

    private static ProductImage productImage2;
    @Order(1)
    @Test
    void setUp() {

    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }
}