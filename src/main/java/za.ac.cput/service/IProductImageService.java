package za.ac.cput.service;
/*
 *Product:java
 *Product: Service interface Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import za.ac.cput.domain.ProductImage;


public interface IProductImageService extends IService<ProductImage, String>{
    void deleteByID(String ID);

    ProductImage findByImageID(String imageID);

    ProductImage findByProductID(String productID);
}
