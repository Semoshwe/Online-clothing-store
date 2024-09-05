package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.ProductImage;

import static org.junit.jupiter.api.Assertions.*;

/*
 *Product:java
 *Product: ProductImageFactoryTest Class
 * Author: Zachariah Matsimella
 * Date: 26 March 2024
 */
public class ProductImageFactoryTest {
    private ProductImage productImage1, productImage2, productImage3;

    @BeforeEach
    void setUp(){
        byte[] photo = new byte[0];
        productImage1 = ProductImageFactory.createProductImage(
                1L,
                1L,
                photo);

        productImage2 = ProductImageFactory.createProductImage(
                1L,
                1L,
                photo);

        productImage3 = ProductImageFactory.createProductImage(
                1L,
                1L,
                photo);
    }

    @Test
    @Order(2)
    public void testNotEqual(){
        System.out.println("Assert that productImage1: "+ productImage1+ "is not equal to productImage2: "+productImage2);
        assertNotNull(productImage1);
        assertNotNull(productImage2);
        assertNotEquals(productImage1, productImage2);
    }

    @Test
    @Order(1)
    public void testEquality(){
        System.out.println("Assert that productImage2: "+ productImage2+" is equal to productImage3: "+productImage3);
        assertNotNull(productImage2);
        assertNotNull(productImage3);
        assertEquals(productImage2, productImage3);
    }

    @Test
    @Order(1)
    public void buildProductImage(){
        byte[] photo = new byte[0];
        ProductImage productImage = ProductImageFactory.createProductImage(
                1L,
                1L,
                photo
        );
        System.out.println(productImage.toString());
        assertNotNull(productImage);
    }

    @Test
    @Order(3)
    public void testIdentity(){
        System.out.println("Testing the identity that productImage2: "+productImage2+" is the same as productImage3: "+productImage3);
        assertNotNull(productImage2);
        assertNotNull(productImage3);
        assertSame(productImage2, productImage3);
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
