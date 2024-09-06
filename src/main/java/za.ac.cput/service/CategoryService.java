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
public class CategoryService implements ICategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category category) {
        return this.repository.save(category);
    }

    @Override
    public Category read(Long categoryId) {
        return this.repository.findById(categoryId).orElse(null);
    }

    @Override
    public Category update(Category category) {
        if (repository.existsById(category.getCategoryId())) {
            return repository.save(category);  // Save only if the record exists
        } else {
            return null;  // Return null if the record doesn't exist to avoid creating a new one
        }
    }

    @Override
    public List<Category> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(Long categoryId) {
        this.repository.deleteById(categoryId);
    }

//    @Override
//    public boolean delete(Long categoryId) {
//        this.repository.deleteById(categoryId);
//        return !this.repository.existsById(categoryId);
//    }
}