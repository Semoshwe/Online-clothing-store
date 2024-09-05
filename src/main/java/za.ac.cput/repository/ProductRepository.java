package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    // Find products by category ID
    List<Product> findByCategoryId(Long categoryId);

    // Find products by price range
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Find products by stock quantity greater than
    List<Product> findByStockQuantityGreaterThan(int stockQuantity);

    // Find products created after a certain date
    List<Product> findByCreatedAtAfter(LocalDate createdAt);

    // Find products updated before a certain date
    List<Product> findByUpdatedAtBefore(LocalDate updatedAt);

}