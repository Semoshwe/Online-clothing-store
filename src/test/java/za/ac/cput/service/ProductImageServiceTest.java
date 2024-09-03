package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ProductImage;
import za.ac.cput.factory.ProductImageFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductImageServiceTest {
    @Autowired
    private ProductImageService productImageService;
    private static ProductImage productImage1;
    private static ProductImage productImage2;
    private static ProductImage productImage3;

    @Order(1)
    @Test
    void setUp() {
        byte[] photo = new byte[0];
        productImage1 = ProductImageFactory.createProductImage("1", photo);
        assertNotNull(productImage1);
        System.out.println(productImage1);

        productImage2 = ProductImageFactory.createProductImage("2", photo);
        assertNotNull(productImage2);
        System.out.println(productImage2);

        productImage3 = ProductImageFactory.createProductImage("3", photo);
        assertNotNull(productImage3);
        System.out.println(productImage3);
    }

    @Order(2)
    @Test
    void create() {
        ProductImage created1 = productImageService.create(productImage1);
        assertNotNull(created1);
        System.out.println(created1);

        ProductImage created2 = productImageService.create(productImage2);
        assertNotNull(created2);
        System.out.println(created2);

        ProductImage created3 = productImageService.create(productImage2);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Order(3)
    @Test
    void read() {
        ProductImage read = productImageService.read(productImage1.getProductID());
        assertNotNull(read);
        System.out.println(read);

        ProductImage read1 = productImageService.read(productImage2.getProductID());
        assertNotNull(read1);
        System.out.println(read1);
    }

    @Order(4)
    @Test
    void update() {
        byte[] photo = new byte[0];
        ProductImage newProductImage = new ProductImage.Builder().copy(productImage1)
                .setProductID("3")
                .setImage(photo)
                .build();
        ProductImage update = productImageService.update(newProductImage);
        assertNotNull(update);
        System.out.println(update);
    }

    @Order(6)
    @Test
    void deleteByID(){
        boolean success = productImageService.deleteByID(productImage3.getImageID());
        assertTrue(success);
        System.out.println("Deleted image:" + success);
    }

    @Order(5)
    @Test
    void getAll() {
        System.out.println(productImageService.findAll());
    }


}