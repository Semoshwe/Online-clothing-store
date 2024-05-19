package za.ac.cput.service;
/*
 *Product:java
 *Product: Service implementation Class
 * Author: Zachariah Matsimella
 * Date: 18 May 2024
 */
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.IProductRepository;

import java.util.List;

@Service
public class ProductService implements IProductService{
    private static IProductService service = null;
    private IProductRepository repository;

    private ProductService(){

    }

    public static  IProductService getService(){
        if(service == null){
            service = new ProductService();
        }
        return service;
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public Product read(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll()

                ;
    }
}
