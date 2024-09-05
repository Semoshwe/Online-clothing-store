/*
 * CategoryController.java
 * Controller for the Category
 * Author: Mthandeni Mbobo (218223579)
 * Date: 23 May 2024
 * */

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    } // create method for Category

    @GetMapping("/read/{id}")
    public Category read(@PathVariable Long id) {
        return categoryService.read(id);
    }

    @PostMapping("/update")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}