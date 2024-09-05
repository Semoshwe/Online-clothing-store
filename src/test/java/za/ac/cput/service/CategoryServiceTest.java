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
    void setup() {
        category = CategoryFactory.buildCategory2("Shoes", "Sneakers"); //id auto generated
        assertNotNull(category);
        System.out.println("Category: " + category);

        category2 = CategoryFactory.buildCategory(22L, "Clothes", "T-Shirts"); //id inserted manually
        assertNotNull(category2);
        System.out.println("Category2: " + category2);
    }

    @Test
    @Order(2)
    void create() {
        Category created = categoryService.create(category);
        assertEquals(category.getCategoryId(), created.getCategoryId());
        System.out.println("Created: " + created);
    }

    @Test
    @Order(3)
    void read() {
        Category read = categoryService.read(category.getCategoryId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(4)
    void update() {
        Category updated = new Category.Builder().copy(category2).setCategoryName("Shoes").build();
        assertNotNull(categoryService.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Display All: " + categoryService.findAll());
    }

//    @Test
//    @Order(6)
//    void delete() {
//        categoryService.delete(category.getCategoryId());
//        System.out.println("Deleted: " + category.getCategoryId());
//    }
}