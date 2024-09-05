/*
* ProductReviewServiceTest.java
* Test for the ProductReviewService
* Author: Mthandeni Mbobo (218223579)
* Date: 18 May 2024
* */

package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ProductReview;
import za.ac.cput.factory.ProductReviewFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductReviewServiceTest {

    @Autowired
    private ProductReviewService productReviewService;

    private static ProductReview productReview;
    private static ProductReview productReview2;
    private static ProductReview productReview3;

    @Test
    @Order(1)
    void setup(){
        productReview = ProductReviewFactory.buildProductReview(50L, 55L, "I am really impressed with this jean", 5); //id auto generated
        assertNotNull(productReview);
        System.out.println("ProductReview: " + productReview);

        productReview2 = ProductReviewFactory.buildProductReview(120L, 100L, 82L, "Quality on this jean is really not up to standard", 2); //id inserted manually
        assertNotNull(productReview2);
        System.out.println("ProductReview2: " + productReview2);
    }

    @Test
    @Order(2)
    void create() {
        ProductReview created = productReviewService.create(productReview);
        assertEquals(productReview.getProductReviewID(), created.getProductReviewID());
        System.out.println("Created: " + created);

        ProductReview created2 = productReviewService.create(productReview2);
        assertEquals(productReview2.getProductReviewID(), created2.getProductReviewID());
        System.out.println("Created2: " + created2);
    }

    @Test
    @Order(3)
    void read() {
        ProductReview read = productReviewService.read(productReview.getProductReviewID());
        assertNotNull(read);
        System.out.println("Read productReview: " + read);
    }

    @Test
    @Order(4)
    void update() {
        ProductReview newProductReview = new ProductReview.Builder().copy(productReview).setReview("I made a mistake, this thing is awful").setRating(1).build();
        ProductReview updated = productReviewService.update(newProductReview);
        assertEquals(newProductReview.getRating(), updated.getRating());
        System.out.println("Updated productReview: " + updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("All productReviews\n" + productReviewService.findAll());
    }
}