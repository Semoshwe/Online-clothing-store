//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.domain.ProductReview;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class ProductReviewFactoryTest {
//    String productReviewID = "1";
//    String productID = "1";
//    String customerID = "1";
//    String review = "Great product!";
//    int rating = 4;
//
//    @Test
//    //This test will pass, all parameters are not null
//    void a_buildProductReview() {
//        ProductReview productReview = ProductReviewFactory.buildProductReview(productReviewID, productID, customerID, review, rating);
//        assertNotNull(productReview);
//        System.out.println(productReview);
//    }
//
//    @Test
//    //This test will fail, as productReviewID is null
//    void b_buildProductReviewWithProductReviewID() {
//        ProductReview productReview = ProductReviewFactory.buildProductReview(null, productID, customerID, review, rating);
//        assertNotNull(productReview);
//        System.out.println(productReview);
//    }
//
//    @Test
//    //This test will pass, productReviewID is auto-generated, all other parameters are not null
//    void c_buildProductReviewWithGeneratedID() {
//        ProductReview productReview = ProductReviewFactory.buildProductReview(productID, customerID, review, rating); //productReviewID is auto-generated
//        assertNotNull(productReview);
//        System.out.println(productReview);
//    }
//
//    /*@Test
//    //This test will pass
//    void d_buildProductReview() {
//        ProductReview productReview = ProductReviewFactory.buildProductReview("5", "22", "1", "Great product!", 4);
//        assertNotNull(productReview);
//        System.out.println(productReview);
//    }*/
//
//    @Test
//    //This test will fail, as rating is out of range
//    void d_buildProductReviewWithInvalidRating() {
//        ProductReview productReview = ProductReviewFactory.buildProductReview(productReviewID, productID, customerID, review, 6);
//        assertNotNull(productReview);
//        System.out.println(productReview);
//    }
//}