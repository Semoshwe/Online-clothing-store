package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

    @Test
    public void testCreateOrder() {
        // Creating test data
        String orderID = "1";
        String customerID = "1001";
        LocalDateTime orderDate = LocalDateTime.now();

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem.Builder()
                .setOrderItemId("item1")
                .setQuantity(2)
                .setPrice(50.0)
                .build());
        orderItems.add(new OrderItem.Builder()
                .setOrderItemId("item2")
                .setQuantity(1)
                .setPrice(100.0)
                .build());

        double totalPrice = 150.0;
        String status = "Pending";
        String addressID = "A100";

        Order order = OrderFactory.createOrder(orderID, customerID, orderDate, orderItems, totalPrice, status, addressID);

        // Asserting that the created order is not null
        assertNotNull(order);
        System.out.println(order);
        // Asserting that the order attributes match the provided values
        assertEquals(orderID, order.getOrderID());
        assertEquals(customerID, order.getCustomerID());
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(orderItems, order.getOrderItems());
        assertEquals(totalPrice, order.getTotalPrice());
    }
}
