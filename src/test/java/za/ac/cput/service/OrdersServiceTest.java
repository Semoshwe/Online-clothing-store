package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Orders;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdersServiceTest {

    @Autowired
    private OrderService orderService;

    private Orders orders;

    @BeforeEach
    void setUp() {
        // Creating test data
        String orderID = "1L";
        String customerID = "1001";
        LocalDate orderDate = LocalDate.now();
        String orderItemsID = "1234";
        double totalPrice = 150.0;
        String status = "Pending";
        String addressID = "A100";

        // Corrected variable assignment
        orders = OrderFactory.buildOrder(orderID, customerID, orderDate, orderItemsID, totalPrice, status, addressID);
    }

    @Test
    void create() {
        Orders createdOrders = orderService.create(orders);
        assertNotNull(createdOrders);
        assertEquals(orders.getOrderID(), createdOrders.getOrderID());
    }

    @Test
    void read() {
        Orders createdOrders = orderService.create(orders); // Ensure order is created before reading
        Orders read = orderService.read(createdOrders.getOrderID());
        assertNotNull(read);
        assertEquals(createdOrders.getOrderID(), read.getOrderID());
    }

    @Test
    void update() {
        Orders createdOrders = orderService.create(orders);
        Orders updateOrder = new Orders.Builder()
                .copy(createdOrders)
                .setStatus("Complete")
                .build();
        Orders results = orderService.update(updateOrder);
        assertNotNull(results);
        assertEquals("Complete",results.getStatus());
    }

    @Test
    void getAll() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findAll();
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }

    @Test
    void findByCustomerID() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findByCustomerID("1001");
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }

    @Test
    void findByStatus() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findByStatus("Pending"); // Fixed case sensitivity
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }

    @Test
    void findByOrderDateBetween() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findByOrderDateBetween(LocalDate.of(2023, 6, 9), LocalDate.of(2024, 7, 6));
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }

    @Test
    void findByAddressID() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findByAddressID("A100");
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }

    @Test
    void findByTotalPriceGreaterThan() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findByTotalPriceGreaterThan(100.00);
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }

    @Test
    void findByOrderItemsID() {
        orderService.create(orders);
        List<Orders> ordersList = orderService.findByOrderItemsID("1234");
        assertFalse(ordersList.isEmpty());
        System.out.println(ordersList);
    }
}
