/*
* CategoryService.java
* Service for the Category
* Author: Mthandeni Mbobo (218223579)
* Date: 18 May 2024
* */

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    private CategoryRepository repository;

    @Autowired
    CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    @Override
    public Category create(Category category){
        return this.repository.save(category);
    }

    @Override
    public Category read(String categoryID){
        return this.repository.findById(categoryID).orElse(null);
    }

    @Override
    public Category update(Category category){
        if (this.repository.existsById(category.getCategoryID()))
            return this.repository.save(category);
        return null;
    }

    @Override
    public List<Category> getAll(){
        return this.repository.findAll();
    }
}
