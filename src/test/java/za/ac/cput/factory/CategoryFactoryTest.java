///**
// * E-Commerce Web Application for selling clothes
// * CategoryFactoryTest.java
// * Test for the CategoryFactory
// * Author: Mthandeni Mbobo - 218223579
// * Date: 25 March 2024
// * */
//
//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.domain.Category;
//import za.ac.cput.domain.Product;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//class CategoryFactoryTest {
//    String categoryID = "1";
//    String categoryName = "Men";
//
//    @Test
//    //This test will pass, categoryID and categoryName are not null
//    void a_buildCategory() {
//        Category category = CategoryFactory.buildCategory(categoryID, categoryName);
//        assertNotNull(category);
//        System.out.println(category);
//    }
//
//    @Test
//        //This test will fail, as both categoryID and categoryName are null
//    void b_buildCategoryWithNull() {
//        Category category = CategoryFactory.buildCategory(null,null);
//        assertNotNull(category);
//        System.out.println(category);
//    }
//
//    @Test
//    //This test will pass, categoryID is auto-generated, categoryName is not null
//    void c_buildCategoryWithGeneratedID() {
//        Category category = CategoryFactory.buildCategory(categoryName); //categoryID is auto-generated
//        assertNotNull(category);
//        System.out.println(category);
//    }
//
//    @Test
//    //This test will fail, as categoryID is null
//    void d_buildCategoryWithNullID() {
//        Category category = CategoryFactory.buildCategory(null , categoryName);
//        assertNotNull(category);
//        System.out.println(category);
//    }
//
//
//}