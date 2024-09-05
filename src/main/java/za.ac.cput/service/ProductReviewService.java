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

    private ProductReviewRepository repository;

    @Autowired
    ProductReviewService(ProductReviewRepository repository){
        this.repository = repository;
    }

    @Override
    public ProductReview create(ProductReview productReview){
        return this.repository.save(productReview);
    }

    @Override
    public ProductReview read(String productReviewID){
        return this.repository.findById(productReviewID).orElse(null);
    }

    @Override
    public ProductReview update(ProductReview productReview){
        if (this.repository.existsById(productReview.getProductReviewID()))
            return this.repository.save(productReview);
        return null;
    }

    @Override
    public List<ProductReview> findAll(){
        return this.repository.findAll();
    }

}
