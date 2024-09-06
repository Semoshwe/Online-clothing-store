package za.ac.cput.factory;

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

/**
 * ProductFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class ProductFactory {

    public static Product buildProduct(Long productId, String name, String description,
                                        double price, int stockQuantity, Long categoryId,
                                        LocalDateTime createdAt, LocalDateTime updatedAt, String imagePath) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isOrderNullorEmpty(price) ||
                Helper.isNullOrEmpty(stockQuantity)
        ) return null;

        return new Product.Builder()
                .setProductId(productId)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setCategoryId(categoryId)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .setImagePath(imagePath)
                .build();
    }
}