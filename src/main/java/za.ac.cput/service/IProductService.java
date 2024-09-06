package za.ac.cput.service;
/*
 *Product:java
 *Product: Service interface Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductService extends IService<Product, Long> {
    void delete(Long id);

    List<Product> findByName(String name);

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByStockQuantityGreaterThan(int stockQuantity);

    List<Product> findByCreatedAtAfter(LocalDate createdAt);

    List<Product> findByUpdatedAtBefore(LocalDate updatedAt);

}
