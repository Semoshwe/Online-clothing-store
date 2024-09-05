/*
* ProductReviewController.java
* Controller for the ProductReview
* Author: Mthandeni Mbobo (218223579)
* Date: 23 May 2024
* */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    } // create method for ProductReview

    @GetMapping("/read/{id}")
    public ProductReview read(@PathVariable Long id) {
        return productReviewService.read(id);
    }

    @PostMapping("/update")
    public ProductReview update(@RequestBody ProductReview productReview) {
        return productReviewService.update(productReview);
    }

    @GetMapping("/getAll")
    public List<ProductReview> getAll() {
        return productReviewService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productReviewService.delete(id);
    }
}
