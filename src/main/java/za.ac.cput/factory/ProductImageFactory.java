package za.ac.cput.factory;
/*
 *Product:java
 *Product: ProductImageFactory Class
 * Author: Zachariah Matsimella
 * Date: 22 March 2024
 */
import za.ac.cput.domain.ProductImage;
import za.ac.cput.util.Helper;

import java.sql.Blob;

public class ProductImageFactory {
    public static ProductImage createProductImage(String productID, byte[] image){
        if(Helper.isNullOrEmpty(productID)){
            return null;
        }

        String imageID = Helper.generateId();

        ProductImage productImage = new ProductImage.Builder().setImageID(imageID)
                .setProductID(productID)
                .setImage(image)
                .build();
        return productImage;
    }
}
