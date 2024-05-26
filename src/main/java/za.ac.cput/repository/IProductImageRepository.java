package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ProductImage;

import java.util.List;

@Repository
public interface IProductImageRepository extends JpaRepository<ProductImage, String> {
}
