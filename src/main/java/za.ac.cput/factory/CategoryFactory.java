/**
 * E-Commerce Web Application for selling clothes
 * CategoryFactory.java
 * This class uses the Factory Pattern to create an instance of the Category entity
 * Author: Mthandeni Mbobo - 218223579
 * Date: 23 March 2024
 * */

package za.ac.cput.factory;

import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;
import za.ac.cput.util.Helper;

public class CategoryFactory {
    public static Category buildCategory(Long categoryId, String categoryName, String subCategoryName) {
       if( Helper.isNullOrEmpty(categoryName) || Helper.isNullOrEmpty(subCategoryName))
           return null;

         return new Category.Builder()
                .setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .setSubCategoryName(subCategoryName)
                .build();
        }

    public static Category buildCategory2(String categoryName, String subCategoryName) {
        if(Helper.isNullOrEmpty(categoryName) || Helper.isNullOrEmpty(subCategoryName))
            return null;

        Long categoryId = Helper.generateIdLong();

        Category category = new Category.Builder()
                .setCategoryId(categoryId)
                .setCategoryName(categoryName)
                .setSubCategoryName(subCategoryName)
                .build();
        return category;
    }
}