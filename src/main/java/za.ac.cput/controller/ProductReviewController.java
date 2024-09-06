/*
 * ProductReviewController.java
 * Controller for the ProductReview
 * Author: Mthandeni Mbobo (218223579)
 * Date: 23 May 2024
 * */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ProductReview;
import za.ac.cput.service.ProductReviewService;

import java.util.List;

@RestController
@RequestMapping("/productReview")
public class ProductReviewController {

    @Autowired
    private ProductReviewService productReviewService;

    @PostMapping("/create")
    public ProductReview create(@RequestBody ProductReview productReview) {
        return productReviewService.create(productReview);
    }

    @GetMapping("/read/{productReviewID}")
    public ResponseEntity<ProductReview> read(@PathVariable Long productReviewID) {
        ProductReview productReview = productReviewService.read(productReviewID);
        if (productReview != null) {
            return ResponseEntity.ok(productReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update")
    public ResponseEntity<ProductReview> update(@RequestBody ProductReview productReview) {
        ProductReview updated = productReviewService.update(productReview);
        if (updated != null) {
            return ResponseEntity.ok(updated);  // Return the updated product review
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if the product review wasn't found
        }
    }
    
    @DeleteMapping("/delete/{productReviewID}")
    public ResponseEntity<Void> delete(@PathVariable Long productReviewID) {
        if (productReviewService.read(productReviewID) != null) {
            productReviewService.delete(productReviewID);
            return ResponseEntity.noContent().build();  // Return 204 No Content if successfully deleted
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if the product review wasn't found
        }
    }


    @GetMapping("/getAll")
    public List<ProductReview> getAll() {
        return productReviewService.findAll();
    }
}
