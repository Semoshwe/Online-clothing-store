package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.ProductReview;
import za.ac.cput.factory.CategoryFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/shopping_store/category";
    private static Category category;
    private static Category category2;

    @BeforeAll
    public static void setup(){
        category = CategoryFactory.buildCategory(55L, "Women", "T-shirts");
        category2 = CategoryFactory.buildCategory2("Men", "T-shirts");
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Category> postResponse = restTemplate.postForEntity(url, category, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Category categorySaved = postResponse.getBody();
        assertEquals(category.getCategoryId(), categorySaved.getCategoryId());
        System.out.println("Create: " + categorySaved);

        ResponseEntity<Category> postResponse2 = restTemplate.postForEntity(url, category2, Category.class);
        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());
        Category categorySaved2 = postResponse2.getBody();
        assertEquals(category2.getCategoryId(), categorySaved2.getCategoryId());
        System.out.println("\nCreate2: " + categorySaved2);
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read/" + category.getCategoryId();
        System.out.println("URL: " + url);
        ResponseEntity<Category> response = restTemplate.getForEntity(url, Category.class);
        assertEquals(category.getCategoryId(), response.getBody().getCategoryId());
        System.out.println("Read: " + response.getBody());

        String url2 = BASE_URL + "/read/" + category2.getCategoryId();
        System.out.println("\nURL: " + url2);
        ResponseEntity<Category> response2 = restTemplate.getForEntity(url2, Category.class);
        assertEquals(category2.getCategoryId(), response2.getBody().getCategoryId());
        System.out.println("Read2: " + response2.getBody());
    }

    @Test
    @Order(3)
    void update() {
//        String url = BASE_URL + "/update";
//        ProductReview newProductReview = new ProductReview.Builder().copy(productReview).setReview("Bad product").setRating(1).build();
//        ResponseEntity<ProductReview> postResponse = restTemplate.postForEntity(url, newProductReview, ProductReview.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        ProductReview updatedProductReview = postResponse.getBody();
//        assertEquals(productReview.getProductReviewID(), updatedProductReview.getProductReviewID());
//        System.out.println("Update: " + updatedProductReview);

        String url = BASE_URL + "/update";
        Category newCategory = new Category.Builder().copy(category).setCategoryName("Kidsss").build();
        ResponseEntity<Category> postResponse = restTemplate.postForEntity(url, newCategory, Category.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Category updatedCategory = postResponse.getBody();
        assertEquals(category.getCategoryId(), updatedCategory.getCategoryId());
        System.out.println("Update: " + updatedCategory);

        String url2 = BASE_URL + "/update";
        Category newCategory2 = new Category.Builder().copy(category2).setSubCategoryName("Jeans").build();
        ResponseEntity<Category> postResponse2 = restTemplate.postForEntity(url2, newCategory2, Category.class);
        assertNotNull(postResponse2);
        assertNotNull(postResponse2.getBody());
        Category updatedCategory2 = postResponse2.getBody();
        assertEquals(category2.getCategoryId(), updatedCategory2.getCategoryId());
        System.out.println("\nUpdate2: " + updatedCategory2);
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Get all: ");
        System.out.println(response.getBody());
    }
}