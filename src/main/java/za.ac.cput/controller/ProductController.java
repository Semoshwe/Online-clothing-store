package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Product;
import za.ac.cput.service.IProductService;

import java.time.LocalDate;
import java.util.List;

/*
 *Product:java
 *Product: Controller Class
 * Author: Zachariah Matsimella
 * Date: 19 May 2024
 */

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Endpoint: http://localhost:8080/store/product/create
     */
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("Received product: " + product);
        try {
            Product createdProduct = productService.create(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Endpoint: http://localhost:8080/store/product/{id}
     */
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.read(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/product/update/{id}
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productService.read(id);
        if (existingProduct != null) {
            // Update the fields that can be changed
            Product updatedProduct = new Product.Builder()
                    .copy(existingProduct)
                    .setName(product.getName()) // Update fields
                    .setDescription(product.getDescription())
                    .setPrice(product.getPrice())
                    .setStockQuantity(product.getStockQuantity())
                    .setCategoryId(product.getCategoryId())
                    .setCreatedAt(product.getCreatedAt())
                    .setUpdatedAt(product.getUpdatedAt())
                    .setImagePath(product.getImagePath())
                    .build();
            //product.setProductId(id); // Ensure we are updating the correct product
            Product updatedProductResponse = productService.update(updatedProduct);
            return new ResponseEntity<>(updatedProductResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/product/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product existingProduct = productService.read(id);
        if (existingProduct != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/product/getAll
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Endpoint: http://localhost:8080/store/product/name/{name}
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
        List<Product> products = productService.findByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Endpoint: http://localhost:8080/store/product/category/{categoryId}
     */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable long categoryId) {
        List<Product> products = productService.findByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Endpoint: http://localhost:8080/store/product/price
     */
    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice
    ) {
        List<Product> products = productService.findByPriceBetween(minPrice, maxPrice);
        System.out.println(products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Endpoint: http://localhost:8080/store/product/stock
     */
    @GetMapping("/stock")
    public ResponseEntity<List<Product>> getProductsByStockQuantityGreaterThan(@RequestParam int stockQuantity) {
        List<Product> products = productService.findByStockQuantityGreaterThan(stockQuantity);
        System.out.println(products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Endpoint: http://localhost:8080/store/product/created-after
     */
    @GetMapping("/created-after")
    public ResponseEntity<List<Product>> getProductsCreatedAfter(@RequestParam LocalDate createdAt) {
        List<Product> products = productService.findByCreatedAtAfter(createdAt);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/updated-before")
    public ResponseEntity<List<Product>> getProductsUpdatedBefore(@RequestParam LocalDate updatedAt) {
        List<Product> products = productService.findByUpdatedAtBefore(updatedAt);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}