/**
 * E-Commerce Web Application for selling clothes
 * CategoryRepository.java
 * This class provides the interface for the Category entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 22 March 2024
 * */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findCategoryByCategoryID(String categoryID);
    Category findCategoryByCategoryName(String categoryName);
    //Category findByIDAndCategoryName(String categoryID, String categoryName);

    boolean deleteCategoryByCategoryName(String categoryName);
}
