package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class CartItemServiceTest {
    @Autowired
    private CartItemService cartItemService;

    private CartItem cartItem;
    @Test
    void setUp() {
        cartItem = CartItemFactory.buildCart("9917","6677","2245",46.90);
        assertNotNull(cartItem);
        System.out.println(cartItem);
    }

    @Test
    void create() {
        CartItem create = cartItemService.create(cartItem);
        assertNotNull(create);
        System.out.println(create);
    }
    @Test
    void read() {
        CartItem read = cartItemService.read(cartItem.getCartItemID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        CartItem newCartItem = new CartItem.Builder().copy(cartItem).setCartItemID("2000").build();
        CartItem updated = cartItemService.update(newCartItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void getAll() {
        System.out.println(cartItemService.getAll());
    }
}