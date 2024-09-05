package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.ProductReview;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductReviewFactoryTest {
    Long productReviewID = 121L;
    String productName = "Box Fit Unified T-shirt - UC Saw Dust/Geants De Monaco";
    String customerName = "Siya Mthandeni";
    String review = "Great product!";
    int rating = 4;

    @Test
    @Order(1)
    //This test will pass, all parameters are not null and productReviewID is auto-generated
    void buildProductReview() {
        ProductReview productReview = ProductReviewFactory.buildProductReview(productReviewID,productName, customerName, review, rating);
        assertNotNull(productReview);
        System.out.println(productReview);
    }

    @Test
    @Order(3)
    //This test will fail, as productName is null
    void buildProductReviewWithNullProductName() {
        ProductReview productReview = ProductReviewFactory.buildProductReview(productReviewID,null, customerName, review, rating);
        assertNotNull(productReview);
        System.out.println(productReview);
    }
}