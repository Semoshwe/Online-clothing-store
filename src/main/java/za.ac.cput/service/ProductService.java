package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product update(Product products) {
        return productRepository.save(products);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByStockQuantityGreaterThan(int stockQuantity) {
        return productRepository.findByStockQuantityGreaterThan(stockQuantity);
    }

    @Override
    public List<Product> findByCreatedAtAfter(LocalDate createdAt) {
        return productRepository.findByCreatedAtAfter(createdAt);
    }

    @Override
    public List<Product> findByUpdatedAtBefore(LocalDate updatedAt) {
        return productRepository.findByUpdatedAtBefore(updatedAt);
    }

}
