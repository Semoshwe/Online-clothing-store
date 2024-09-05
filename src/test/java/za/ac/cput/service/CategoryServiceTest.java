/*
* CategoryServiceTest.java
* Test for the CategoryService
* Author: Mthandeni Mbobo (218223579)
* Date: 18 May 2024
*
* */

package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Category;
import za.ac.cput.factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    private static Category category;
    private static Category category2;

    @Test
    @Order(1)
    void setup(){
        category = CategoryFactory.buildCategory("Men"); //id auto generated
        assertNotNull(category);
        System.out.println("Category: " + category);

        category2 = CategoryFactory.buildCategory("3","Kids"); //id inserted manually
        assertNotNull(category2);
        System.out.println("Category2: " + category2);
    }

    @Test
    @Order(2)
    void create() {
        Category created = categoryService.create(category);
        assertEquals(category.getCategoryID(), created.getCategoryID());
        System.out.println("Created: " + created);

        Category created2 = categoryService.create(category2);
        assertEquals(category2.getCategoryID(), created2.getCategoryID());
        System.out.println("Created2: " + created2);
    }

    @Test
    @Order(3)
    void read() {
        Category read = categoryService.read(category.getCategoryID());
        assertNotNull(read);
        System.out.println("Read category: " + read);
    }

    @Test
    @Order(4)
    void update() {
        Category newCategory = new Category.Builder().copy(category).setCategoryName("Mens").build();
        Category updated = categoryService.update(newCategory);
        assertEquals(newCategory.getCategoryName(), updated.getCategoryName());
        System.out.println("Updated category: " + updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("All categories" + categoryService.findAll());
    }
}