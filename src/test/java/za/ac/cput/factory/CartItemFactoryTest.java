package za.ac.cput.factory;
/**
 * E-Commerce Web Application for selling clothes
 * CartItemFactoryTest.java
 * Test for the CartItemFactory
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 16 May 2024
 * */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.class)
public class CartItemFactoryTest {
    @Test
    void testBuildCart(){
        CartItem cItem = CartItemFactory.buildCartItem("1202","#1432","000100",14.50);
        assertNotNull(cItem);
        System.out.println(cItem.toString());
    }

    @Test
    void testBuildCartWithFail(){
        CartItem cItem = CartItemFactory.buildCartItem("1202","","000100",14.50);
        assertNotNull(cItem);
        System.out.println(cItem.toString());
    }
}