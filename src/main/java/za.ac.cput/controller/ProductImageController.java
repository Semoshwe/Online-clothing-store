package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ProductImage;
import za.ac.cput.service.ProductImageService;
import java.util.List;

/*
 *Product:java
 *Product: Controller Class
 * Author: Zachariah Matsimella
 * Date: 19 May 2024
 */

@RestController
@RequestMapping("/productImage")
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @PostMapping("/create")
    public ProductImage create(@RequestBody ProductImage productImage){
        return productImageService.create(productImage);
    }

    @GetMapping("/read/{id}")
    public ProductImage read(@PathVariable String id){
        return productImageService.read(id);
    }

    @PostMapping("/update")
    public ProductImage update(@RequestBody ProductImage productImage){
        return productImageService.update(productImage);
    }

    @GetMapping("/getAll")
    public List<ProductImage> getAll(){
        return productImageService.getAll();
    }
}
