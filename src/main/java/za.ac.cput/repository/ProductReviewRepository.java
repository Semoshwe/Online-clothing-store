/**
 * E-Commerce Web Application for selling clothes
 * ProductReviewRepository.java
 * This class provides the interface for the ProductReview entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.ProductReview;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    void deleteByProductReviewID(Long productReviewID);

    void findByProductReviewID(Long productReviewID);
}
