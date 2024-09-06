/**
 * E-Commerce Web Application for selling clothes
 * ProductReviewFactory.java
 * This class uses the Factory Pattern to create an instance of the ProductReview entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 23 March 2024
 */

package za.ac.cput.factory;

import za.ac.cput.domain.ProductReview;
import za.ac.cput.util.Helper;

public class ProductReviewFactory {
    public static ProductReview buildProductReview(Long productReviewID, String productName, String customerName, String review, int rating) {
        if (Helper.isNullOrEmpty(productName) || Helper.isNullOrEmpty(customerName) || Helper.isNullOrEmpty(review) || !Helper.isValidRange(rating))
            return null;

        return new ProductReview.Builder()
                .setProductReviewID(productReviewID)
                .setProductName(productName)
                .setCustomerName(customerName)
                .setReview(review)
                .setRating(rating)
                .build();
    }
}