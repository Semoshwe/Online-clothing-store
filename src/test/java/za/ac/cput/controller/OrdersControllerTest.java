package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Orders;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.OrderService;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrdersControllerTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/shopping_store/order"; // Base URL for the controller

    private static Orders orders;
    private static Orders orders1;

    @BeforeAll
    public static void setUp() {
        orders = new Orders.Builder()
                .setOrderID("11111113445L")
                .setCustomerID("1001")
                .setAddressID("A100")
                .setOrderDate(LocalDate.now())
                .setTotalPrice(150.0)
                .setStatus("Pending")
                .setOrderItemsID("1234")
                .build();
        orders1 = OrderFactory.buildOrder("11111113445L", "1001", LocalDate.now(), "1234", 150.0, "Pending", "A100");
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Orders> response = restTemplate.postForEntity(url, orders1, Orders.class);

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(orders.getOrderID(), Objects.requireNonNull(response.getBody()).getOrderID());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void read() {
        String createUrl = BASE_URL + "/create";
        restTemplate.postForEntity(createUrl, orders, Orders.class);

        String url = BASE_URL + "/read/" + orders.getOrderID();
        ResponseEntity<Orders> response = restTemplate.getForEntity(url, Orders.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(orders.getOrderID(), Objects.requireNonNull(response.getBody()).getOrderID());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void update() {
        String createUrl = BASE_URL + "/create";
        restTemplate.postForEntity(createUrl, orders, Orders.class);

        orders.setStatus("Updated Status");
        String updateUrl = BASE_URL + "/update";
        ResponseEntity<Orders> response = restTemplate.postForEntity(updateUrl, orders, Orders.class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Status", Objects.requireNonNull(response.getBody()).getStatus());
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void getAll() {
        String createUrl = BASE_URL + "/create";
        restTemplate.postForEntity(createUrl, orders, Orders.class);

        String url = BASE_URL + "/findAll";
        ResponseEntity<Orders[]> response = restTemplate.getForEntity(url, Orders[].class);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
