/*
* IProductReviewService.java
* Service Interface for the ProductReview
 * Author: Mthandeni Mbobo (218223579)
 * Date: 18 May 2024
 * --
* */

package za.ac.cput.service;

import za.ac.cput.domain.ProductReview;

import java.util.List;

public interface IProductReviewService extends IService<ProductReview, String>{
    List<ProductReview> findAll();
}
