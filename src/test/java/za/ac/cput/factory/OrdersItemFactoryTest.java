package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

/*
 *OrderItemFactoryTest:java
 *OrderItem: Factory Class Test
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
 */

class OrderItemFactoryTest {

    @Test
    void buildOrderItem() {
        OrderItem orderItem = OrderItemFactory.buildOrderItem("PC9775", 5, 9.99);

        assertNotNull(orderItem);
        System.out.println(orderItem);
    }
}