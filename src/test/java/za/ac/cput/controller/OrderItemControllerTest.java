package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
 * OrderItem: java
 * OrderItem: Controller Test Class
 * Author: Luke Duffell
 * Date: 26 May 2024
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderItemControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/shopping_store_db/order/orderitem";
    private static OrderItem orderItem;

    @BeforeAll
    public static void setUp() {
        orderItem = OrderItemFactory.buildOrderItem("PC5211", 5, 9.99);
    }

    @Test
    @Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, orderItem, OrderItem.class);
        assertNotNull(postResponse.getBody());
        assertEquals(orderItem.getOrderItemId(), postResponse.getBody().getOrderItemId());
        System.out.println(postResponse.getBody());
    }

    @Test
    @Order(2)
    void read() {
        String url = BASE_URL + "/read" + orderItem.getOrderItemId();
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(url, OrderItem.class);
        assertEquals(orderItem.getOrderItemId(), response.getBody().getOrderItemId());
        System.out.println(response.getBody());
    }

    @Test
    @Order(3)
    void update() {
        String url = BASE_URL + "/update";
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setQuantity(12).setPrice(5.49).build();
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, newOrderItem, OrderItem.class);
        assertNotNull(postResponse.getBody());
        assertEquals(newOrderItem.getOrderItemId(), postResponse.getBody().getOrderItemId());
        System.out.println(postResponse.getBody());
    }

    @Test
    @Order(4)
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,  String.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }
}