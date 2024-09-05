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
    //Attributes
    @Id
    private Long productReviewID;
    private Long customerID;
    private Long productID;

    private String review;
    private int rating;

    //Constructor
    public ProductReview(){
        //
    }

    private ProductReview(Builder builder){
        this.productReviewID = builder.productReviewID;
        this.productID = builder.productID;
        this.customerID = builder.customerID;
        this.review = builder.review;
        this.rating = builder.rating;
    }

    //Getters
    public Long getProductReviewID() {
        return productReviewID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public Long getProductID() {
        return productID;
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
        return rating == that.rating && Objects.equals(productReviewID, that.productReviewID) && Objects.equals(customerID, that.customerID) && Objects.equals(productID, that.productID) && Objects.equals(review, that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productReviewID, customerID, productID, review, rating);
    }

    @Override
    public String toString() {
        return "ProductReview{" +
                "productReviewID='" + productReviewID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", productID='" + productID + '\'' +
                ", review='" + review + '\'' +
                ", rating=" + rating +
                '}';
    }

    //Builder Pattern
    public static class Builder{
        private Long productReviewID;
        private Long productID;
        private Long customerID;
        private String review;
        private int rating;

        public Builder setProductReviewID(Long productReviewID){
            this.productReviewID = productReviewID;
            return this;
        }

        public Builder setProductID(Long product){
            this.productID = product;
            return this;
        }

        public Builder setCustomerID(Long customer){
            this.customerID = customer;
            return this;
        }

        public Builder setReview(String review){
            this.review = review;
            return this;
        }

        public Builder setRating(int rating){
            this.rating = rating;
            return this;
        }

        public Builder copy(ProductReview productReview){
            this.productReviewID = productReview.productReviewID;
            this.productID = productReview.productID;
            this.customerID = productReview.customerID;
            this.review = productReview.review;
            this.rating = productReview.rating;
            return this;
        }

        public ProductReview build(){
            return new ProductReview(this);
        }
    }
}
