package za.ac.cput.domain;

/*
 *Product:java
 *Product: Model Class
 * Author: Zachariah Matsimella
 * Date: 21 March 2024
 */

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    private String categoryID;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String reviewID;
    private String imageID;

    protected Product() {

    }

    private Product(Builder builder){
        this.productID = builder.productID;
        this.categoryID = builder.categoryID;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock = builder.stock;
        this.reviewID = builder.reviewID;
        this.imageID = builder.imageID;
    }

    public Long getProductID() {
        return productID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getReviewID() {
        return reviewID;
    }

    public String getImageID() {
        return imageID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && productID.equals(product.productID) && Objects.equals(categoryID, product.categoryID) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(reviewID, product.reviewID) && Objects.equals(imageID, product.imageID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, categoryID, name, description, price, stock, reviewID, imageID);
    }

    @Override
    public String toString() {
        return "Product{" +
                ", ProductID: " + productID +
                ", CategoryID: " + categoryID +
                ", Name: '" + name + '\'' +
                ", Description: '" + description + '\'' +
                ", Price: " + price +
                ", Stock: " + stock +
                ", ReviewID: " + reviewID +
                ", ImageID: " + imageID +
                '}';
    }

    public static class Builder{
        private Long productID;
        private String categoryID;
        private String name;
        private String description;
        private double price;
        private int stock;
        private String reviewID;
        private String imageID;

        public Builder setProductID(Long productID){
            this.productID = productID;
            return this;
        }

        public Builder setCategoryID(String categoryID){
            this.categoryID = categoryID;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setDescription(String description){
            this.description = description;
            return this;
        }

        public Builder setPrice(double price){
            this.price = price;
            return this;
        }

        public Builder setStock(int stock){
            this.stock = stock;
            return this;
        }

        public Builder setReviewID(String reviewID){
            this.reviewID = reviewID;
            return this;
        }

        public Builder setImageID(String imageID){
            this.imageID = imageID;
            return this;
        }
        public Builder copy(Product product){
            this.productID = product.productID;
            this.categoryID = product.categoryID;
            this.name = product.name;
            this.description = product.description;
            this.price = product.price;
            this.stock = product.stock;
            this.reviewID = product.reviewID;
            this.imageID = product.imageID;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
