/*
* ProductReviewService.java
* Service for the ProductReview
* Author: Mthandeni Mbobo (218223579)
* Date: 18 May 2024
* */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ProductReview;
import za.ac.cput.repository.ProductReviewRepository;

import java.util.List;

@Service
public class ProductReviewService implements IProductReviewService{

    private  final ProductReviewRepository repository;

    @Autowired
    public ProductReviewService(ProductReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductReview create(ProductReview productReview) {
        return this.repository.save(productReview);
    }

    @Override
    public ProductReview read(Long productReviewID) {
        //return this.repository.findProductReviewByProductReviewID(productReviewID);
        return this.repository.findById(productReviewID).orElse(null);
    }

    @Override
    public ProductReview update(ProductReview productReview) {
        if (repository.existsById(productReview.getProductReviewID())) {
            return repository.save(productReview);  // Save only if the record exists
        } else {
            return null;  // Return null if the record doesn't exist to avoid creating a new one
        }
    }


    @Override
    public List<ProductReview> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(Long productReviewID) {
        //this.repository.deleteProductReviewByProductReviewID(productReviewID);
        this.repository.deleteById(productReviewID);
    }
}
