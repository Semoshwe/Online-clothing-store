/*
 * ICategoryService.java
 * Service Interface for the Category
 * Author: Mthandeni Mbobo (218223579)
 * Date: 18 May 2024
 * ---
 * */

package za.ac.cput.service;

import za.ac.cput.domain.Category;

public interface ICategoryService extends IService<Category, Long> {
    void delete(Long categoryId);
}