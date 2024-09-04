package za.ac.cput.service;
/*
 *Product:java
 *Product: Service implementation Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private ProductRepository repository;

    private ProductService(ProductRepository repository){
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product read(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public boolean deleteByID(Long productID) {
        if(this.repository.existsById(productID)){
            repository.deleteById(productID);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }
}
