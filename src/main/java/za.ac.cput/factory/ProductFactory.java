package za.ac.cput.factory;
/*
 *Product:java
 *Product: ProductFactory Class
 * Author: Zachariah Matsimella
 * Date: 22 March 2024
 */

import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

public class ProductFactory {
    public static Product createProduct(Long productID, String categoryID, String name, String description, double price, int stock, String reviewID, String imageID){
        if(Helper.isNullOrEmpty(categoryID)
        ||Helper.isNullOrEmpty(name)
        ||Helper.isNullOrEmpty(description)
        ||Helper.isNullOrEmpty(reviewID)
        ||Helper.isNullOrEmpty(imageID)){
            return null;
        }

        Product product = new Product.Builder()
                .setProductID(productID)
                .setCategoryID(categoryID)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock(stock)
                .setReviewID(reviewID)
                .setImageID(imageID)
                .build();
        return product;
    }
}