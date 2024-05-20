package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Autowired
    private OrderService orderService;


    private Order order;

    @BeforeEach
    void setUp() {
        // Creating test data
        String orderID = "11111113445L";
        String customerID = "1001";
        LocalDateTime orderDate = LocalDateTime.now();
        String orderItemsID = "1234";
        double totalPrice = 150.0;
        String status = "Pending";
        String addressID = "A100";

        Order order = OrderFactory.createOrder(orderID, customerID, orderDate, orderItemsID, totalPrice, status, addressID);

    }

    @Test
    void create() {
        Order createdOrder = orderService.create(order);
        assertNotNull(createdOrder);
        assertEquals(order.getOrderID(), createdOrder.getOrderID());
    }

    @Test
    void read() {
        Order read = OrderService.read(order.getOrderID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }
}