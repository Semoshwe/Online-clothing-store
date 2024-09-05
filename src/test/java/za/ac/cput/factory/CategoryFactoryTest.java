package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryFactoryTest {
    Long categoryId = 1L;
    String categoryName = "Shoes";
    String subCategoryName = "Sneakers";

    @Test
    @Order(1)
    //This test will pass, all parameters are not null
    void buildCategory() {
        Category category = CategoryFactory.buildCategory(categoryId, categoryName, subCategoryName);
        assertNotNull(category);
        System.out.println(category);
    }

    @Test
    @Order(2)
    //This test will pass, all parameters are not null
    void buildCategory2() {
        Category category = CategoryFactory.buildCategory2(categoryName, subCategoryName);
        assertNotNull(category);
        System.out.println(category);
    }

    @Test
    @Order(3)
    //failing test
    void buildCategoryWithNullCategoryName() {
        Category category = CategoryFactory.buildCategory(categoryId, null, subCategoryName);
        assertNotNull(category);
        System.out.println(category);

    }

}