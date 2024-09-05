package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.ProductService;
import java.util.List;

/*
 *Product:java
 *Product: Controller Class
 * Author: Zachariah Matsimella
 * Date: 19 May 2024
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable Long id){
        return productService.read(id);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return productService.deleteByID(id);
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return productService.findAll();
    }
}
