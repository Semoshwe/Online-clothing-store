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
        category = CategoryFactory.buildCategory(null, "Kids", "Shoes"); //id auto generated
        assertNotNull(category);
        System.out.println("Category: " + category);
    }

    @Test
    @Order(2)
    void create() {
        Category created = categoryService.create(category);
        assertEquals(category.getCategoryId(), created.getCategoryId());
        System.out.println("Created category: " + created);
    }

    @Test
    @Order(3)
    void read() {
        Category read = categoryService.read(category.getCategoryId());
        assertNotNull(read);
        System.out.println("Read category: " + read);
    }

    @Test
    @Order(4)
    void update(){
        Category newCategory = new Category.Builder().copy(category).setCategoryName("Women").setSubCategoryName("Tops").build();
        Category updated = categoryService.update(newCategory);
        assertEquals(newCategory.getCategoryName(), updated.getCategoryName());
        System.out.println("Updated category: " + updated);
    }

    @Test
    @Order(5)
    void getAll(){
        System.out.println("Show all categories:\n" + categoryService.findAll());
    }

//    @Test
//    @Order(6)
//    void delete(){
//        boolean deleted = categoryService.delete(category.getCategoryId());
//        assertTrue(deleted);
//        System.out.println("Category deleted: " + deleted);
//    }
}