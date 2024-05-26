package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
 * OrderItem: java
 * OrderItem: Test Class
 * Author: Luke Duffell
 * Date: 26 May 2024
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderItemServiceTest {
    @Autowired
    private OrderItemService service;

    private OrderItem orderItem = OrderItemFactory.buildOrderItem("PC5211", 5, 9.99);

    @Test
    @Order(1)
    void create() {
        OrderItem created = service.create(orderItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        OrderItem read = service.read(orderItem.getId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        OrderItem newOrderItem = new OrderItem.Builder().copy(orderItem).setQuantity(12).setPrice(5.49).build();
        OrderItem updated = service.update(newOrderItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(service.getAll());
    }
}