package za.ac.cput.service;
/*
 *Product:java
 *Product: Service implementation Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ProductImage;
import za.ac.cput.repository.ProductImageRepository;
import java.util.List;

@Service
public class ProductImageService implements IProductImageService {
    private ProductImageRepository repository;

    private ProductImageService(ProductImageRepository repository){
        this.repository = repository;
    }

    @Override
    public ProductImage create(ProductImage productImage) {
        return repository.save(productImage);
    }

    @Override
    public ProductImage read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public ProductImage update(ProductImage productImage) {
        return repository.save(productImage);
    }

    @Override
    public boolean deleteByID(String productID) {
        if(this.repository.existsById(productID)){
            repository.deleteById(productID);
            return true;
        }
        return false;
    }

    @Override
    public List<ProductImage> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductImage findByImageID(String imageID) {
        return repository.findByImageID(imageID);
    }

    @Override
    public ProductImage findByProductID(String productID) {
        return repository.findByProductID(productID);
    }
}
