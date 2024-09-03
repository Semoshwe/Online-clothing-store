package za.ac.cput.service;
/*
 *Product:java
 *Product: Service interface Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import za.ac.cput.domain.Product;

import java.util.List;

public interface IProductService extends IService<Product, String>{
    boolean deleteByID(String ID);
    List<Product> findByDescription(String description);

    List<Product> findByName(String name);
}
