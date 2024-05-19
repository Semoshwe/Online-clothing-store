package za.ac.cput.service;
/*
 *Product:java
 *Product: Service implementation Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ProductImage;
import za.ac.cput.repository.IProductImageRepository;

import java.util.List;

@Service
public class ProductImageService implements IProductImageService {

    private static IProductImageService service = null;
    private IProductImageRepository repository;

    private ProductImageService(){

    }

    public static IProductImageService getService(){
        if(service == null){
            service = new ProductImageService();
        }
        return service;
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
    public List<ProductImage> getAll() {
        return repository.findAll();
    }


}
