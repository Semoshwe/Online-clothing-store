package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.CartItem;
import za.ac.cput.factory.CartItemFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/online-clothing-store/cartItem";

    private static CartItem cartItem;

    @BeforeAll
    public static void setUp(){
        cartItem = CartItemFactory.buildCart("9917","6677","2245",46.90);
    }
    @Test
    void a_create() {
        String url = BASE_URL+"/create";
        ResponseEntity<CartItem> postResponse = restTemplate.postForEntity(url, cartItem, CartItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CartItem cartItemSaved = postResponse.getBody();
        assertEquals(cartItem.getCartItemID(), cartItemSaved.getCartItemID());
        System.out.println("Saved data: "+ cartItemSaved);
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + cartItem.getCartItemID();
        System.out.println("Url:" +url);
        ResponseEntity<CartItem> response = restTemplate.getForEntity(url, CartItem.class);
        assertEquals(cartItem.getCartItemID(), response.getBody().getCartItemID());
        System.out.println("Read: "+ response.getBody());
    }

    @Test
    void c_update() {
        String url = BASE_URL+ "/update";
        CartItem newCartItem = new CartItem.Builder().copy(cartItem).setPrice(60.00).build();
        ResponseEntity<CartItem> postResponse = restTemplate.postForEntity(url , newCartItem, CartItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CartItem cartItemUpdated = postResponse.getBody();
        assertEquals(newCartItem.getCartItemID(), cartItemUpdated.getCartItemID());
        System.out.println("Updated data: "+ cartItemUpdated);
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