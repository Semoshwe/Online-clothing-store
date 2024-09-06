package za.ac.cput.service;
/**
 * E-Commerce Web Application for selling clothes
 * CartItemServiceTest.java
 * Test class for CartItemService
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 18 May 2024
 * */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // Added annotation for ordering
class CartItemServiceTest {

    @Autowired
    private CartItemService cartItemService;

    private static CartItem cartItem;

    @BeforeEach
    @Order(1)
    void setUp() {
        cartItem = CartItemFactory.buildCartItem("9917", "6677", "2245", 46.90);
        assertNotNull(cartItem);
        System.out.println(cartItem);
    }

    @Test
    @Order(2)
    void create() {
        CartItem create = cartItemService.create(cartItem);
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    @Order(3)
    void read() {
        CartItem read = cartItemService.read(cartItem.getCartItemID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void update() {
        CartItem newCartItem = new CartItem.Builder().copy(cartItem).setCartItemID(Long.parseLong("2000")).build();
        CartItem updated = cartItemService.update(newCartItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println(cartItemService.findAll());
    }
}
