/*
* ICategoryService.java
* Service Interface for the Category
* Author: Mthandeni Mbobo (218223579)
* Date: 18 May 2024
* ---
* */

package za.ac.cput.service;

import za.ac.cput.domain.Category;

import java.util.List;

public interface ICategoryService extends IService<Category, String>{
    List<Category> findAll();
}
