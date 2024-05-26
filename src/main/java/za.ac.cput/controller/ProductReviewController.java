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
@RequestMapping("/productreview")
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @PostMapping("/create")
    public ProductReview create(@RequestBody ProductReview productReview){
        return productReviewService.create(productReview);
    }

    @GetMapping("/read/{id}")
    public ProductReview read(@PathVariable String id){
        return productReviewService.read(id);
    }

    @PostMapping("/update")
    public ProductReview update(@RequestBody ProductReview productReview){
        return productReviewService.update(productReview);
    }

    /*@GetMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return productReviewService.delete(id);
    }
*/ //service must be modified to include delete method

    @GetMapping("/getall")
    public List<ProductReview> getAll(){
        return productReviewService.getAll();
    }
}
