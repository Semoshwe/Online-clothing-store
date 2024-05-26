package za.ac.cput.service;
/**
 * E-Commerce Web Application for selling clothes
 * CartServiceTest.java
 * Test class for CartService
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 18 May 2024
 * */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class CartServiceTest {
    @Autowired
    private CartService cartService;
    private static Cart cart;
    private static CartItem cartItem;

    private static List<CartItem> list = new ArrayList<>();
    @Test
    void setUp() {
        cartItem = CartItemFactory.buildCart("9917","6677","2245",46.90);
        list.add(cartItem);
        cart = CartFactory.buildCart("6677","999674",46.90,list);
        assertNotNull(cart);
        System.out.println(cart);
    }

    @Test
    void create() {
        Cart create = cartService.create(cart);
        assertNotNull(create);
        System.out.println(create);
    }

    @Test
    void read() {
        Cart read = cartService.read(cart.getCartID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Cart newCart = new Cart.Builder().copy(cart).setTotalAmount(47.00).build();
        Cart updated = cartService.update(newCart);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(cartService.getAll());
    }
}