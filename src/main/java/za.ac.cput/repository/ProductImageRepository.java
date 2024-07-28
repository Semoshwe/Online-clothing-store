package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String> {
    ProductImage findByImageID(String imageID);

    ProductImage findByProductID(String productID);
}
