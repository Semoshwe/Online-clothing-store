package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

/*
 *Product:java
 *Product: ProductFactoryTest Class
 * Author: Zachariah Matsimella
 * Date: 26 March 2024
 */
public class ProductFactoryTest {
    Product product1;
    Product product2;
    Product product3;


    @BeforeEach
    void setUp(){
        product1 = new Product.Builder()
                .setCategoryID("1")
                .setName("Hoodie")
                .setDescription("White medium Hoodie.")
                .setPrice(300)
                .setStock(50)
                .setReviewID("1")
                .setImageID("1")
                .build();

        product2 = new Product.Builder()
                .setCategoryID("2")
                .setName("Jeans")
                .setDescription("Blue skinny Jeans. Waist 34cm.")
                .setPrice(250)
                .setStock(50)
                .setReviewID("2")
                .setImageID("2")
                .build();

        product3 = new Product.Builder()
                .setCategoryID("3")
                .setName("T-shirt")
                .setDescription("White medium T-shirt.")
                .setPrice(150)
                .setStock(50)
                .setReviewID("3")
                .setImageID("3")
                .build();
    }

    @Test
    @Order(2)
    public void testNotEqual(){
        System.out.println("Assert that product1: "+ product1+ "is not equal to product2: "+product2);
        assertNotNull(product1);
        assertNotNull(product2);
        assertNotEquals(product1, product2);
    }

    @Test
    @Order(1)
    public void testEquality(){
        System.out.println("Assert that product2: "+ product2+" is equal to pub3: "+product3);
        assertNotNull(product2);
        assertNotNull(product3);
        assertEquals(product2, product3);
    }

    @Test
    @Order(1)
    public void buildProduct(){
        Product product = ProductFactory.createProduct(
                1L,
                "4",
                "T-shirt",
                "Black V-neck.",
                300,
                50,
                "4",
                "4");
        System.out.println(product.toString());
        assertNotNull(product);
    }

    @Test
    @Order(3)
    public void testIdentity(){
        System.out.println("Testing the identity that product2: "+product2+" is the same as product3: "+product3);
        assertNotNull(product2);
        assertNotNull(product3);
        assertSame(product2, product3);
    }

    @Test
    @Disabled
    @Timeout(200)
    public void disabled(){
        System.out.println("This test should be disabled. If not then a timout should occur in 2 seconds.");
    }

    @Test
    @Timeout(5)
    public void timeout() throws InterruptedException{
        Thread.sleep(2000);
    }
}
