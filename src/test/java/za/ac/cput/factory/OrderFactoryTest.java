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
        String  orderID = "11111113445L";
        String customerID = "1001";
        LocalDateTime orderDate = LocalDateTime.now();

        String orderItemsID = "12345";

        double totalPrice = 150.0;
        String status = "Pending";
        String addressID = "A100";

        Order order = OrderFactory.createOrder(orderID, customerID, orderDate, orderItemsID, totalPrice, status, addressID);

        // Asserting that the created order is not null
        assertNotNull(order);
        System.out.println(order);
        // Asserting that the order attributes match the provided values
        assertEquals(orderID, order.getOrderID());
        assertEquals(customerID, order.getCustomerID());
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(orderItemsID, order.getOrderItems());
        assertEquals(totalPrice, order.getTotalPrice());
    }
}
