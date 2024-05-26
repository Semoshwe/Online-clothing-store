package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> {
}
