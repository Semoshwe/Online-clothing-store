/**
 * E-Commerce Web Application for selling clothes
 * ProductReview.java
 * This POJO class for the ProductReview entity. Domain class using Builder Pattern
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 * */

package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProductReview implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productReviewID;
    private String productName;
    private String customerName;
    private String review;
    private int rating;

    // Constructor
    public ProductReview() {
        //
    }

    private ProductReview(Builder builder) {
        this.productReviewID = builder.productReviewID;
        this.productName = builder.productName;
        this.customerName = builder.customerName;
        this.review = builder.review;
        this.rating = builder.rating;
    }

    // Getters
    public Long getProductReviewID() {
        return productReviewID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductReview that = (ProductReview) o;
        return rating == that.rating && Objects.equals(productReviewID, that.productReviewID) && Objects.equals(productName, that.productName) && Objects.equals(customerName, that.customerName) && Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productReviewID, productName, customerName, review, rating);
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "productReviewID='" + productReviewID + '\'' +
                ", productName='" + productName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }

    // Builder Pattern
    public static class Builder {
        private Long productReviewID;
        private String productName;
        private String customerName;
        private String review;
        private int rating;

        public Builder setProductReviewID(Long productReviewID) {
            this.productReviewID = productReviewID;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setReview(String review) {
            this.review = review;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder copy(ProductReview productReview) {
            this.productReviewID = productReview.productReviewID;
            this.productName = productReview.productName;
            this.customerName = productReview.customerName;
            this.review = productReview.review;
            this.rating = productReview.rating;
            return this;
        }

        public ProductReview build() {
            return new ProductReview(this);
        }
    }
}