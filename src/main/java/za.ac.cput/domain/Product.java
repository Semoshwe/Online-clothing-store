package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Product.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Long categoryId;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String imagePath;


    public Product() {
    }

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.categoryId = builder.categoryId;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.imagePath = builder.imagePath;
    }

    public Long getProductId() {
        return productId;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (getProductId() != product.getProductId()) return false;
        if (Double.compare(getPrice(), product.getPrice()) != 0) return false;
        if (getStockQuantity() != product.getStockQuantity()) return false;
        if (getCategoryId() != product.getCategoryId()) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getCreatedAt() != null ? !getCreatedAt().equals(product.getCreatedAt()) : product.getCreatedAt() != null)
            return false;
        if (getUpdatedAt() != null ? !getUpdatedAt().equals(product.getUpdatedAt()) : product.getUpdatedAt() != null)
            return false;
        return getImagePath() != null ? getImagePath().equals(product.getImagePath()) : product.getImagePath() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getProductId() ^ (getProductId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getStockQuantity();
        result = 31 * result + (int) (getCategoryId() ^ (getCategoryId() >>> 32));
        result = 31 * result + (getCreatedAt() != null ? getCreatedAt().hashCode() : 0);
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        result = 31 * result + (getImagePath() != null ? getImagePath().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Product ID: " + productId +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", PRICE: " + price +
                ", STOCK QUANTITY: " + stockQuantity +
                ", CATEGORY ID: " + categoryId +
                ", CREATED AT: " + createdAt +
                ", UPDATED AT: " + updatedAt +
                ", IMAGE PATH: '" + imagePath + '\'' +
                '}';
    }

    public static class Builder {
        private Long productId;
        private String name;
        private String description;
        private double price;
        private int stockQuantity;
        private Long categoryId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String imagePath;

        public Builder setProductId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Builder copy(Product product) {
            this.productId = product.getProductId();
            this.name = product.getName();
            this.description = product.getDescription();
            this.price = product.getPrice();
            this.stockQuantity = product.getStockQuantity();
            this.categoryId = product.getCategoryId();
            this.createdAt = product.getCreatedAt();
            this.updatedAt = product.getUpdatedAt();
            this.imagePath = product.getImagePath();
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}