package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartFactory;
import za.ac.cput.factory.CartItemFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http:/localhost:8080/online-clothing-store/cart";

    private static Cart cart;

    private static CartItem cartItem;

    private static List<CartItem> list = new ArrayList<>();

    @BeforeAll
    public static void setUp(){
        cartItem = CartItemFactory.buildCart("9917","6677","2245",46.90);
        list.add(cartItem);
        cart = CartFactory.buildCart("6677","999674",46.90,list);
    }

    @Test
    void a_create() {
        String url = BASE_URL+ "/create";
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url, cart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartSaved = postResponse.getBody();
        assertEquals(cart.getCartID(), cartSaved.getCartID());
        System.out.println("Saved: "+ cartSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + cart.getCartID();
        System.out.println("Url:" +url);
        ResponseEntity<Cart> response = restTemplate.getForEntity(url, Cart.class);
        assertEquals(cart.getCartID(), response.getBody().getCartID());
        System.out.println("Read: "+ response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL+ "/update";
        Cart newCart = new Cart.Builder().copy(cart).setTotalAmount(100.00).build();
        ResponseEntity<Cart> postResponse = restTemplate.postForEntity(url , newCart, Cart.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Cart cartUpdated = postResponse.getBody();
        assertEquals(newCart.getCartID(), cartUpdated.getCartID());
        System.out.println("Updated data: "+ cartUpdated);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url , HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}