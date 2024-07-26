package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Orders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class OrdersFactoryTest {

    @Test
    public void testCreateOrder() {
        // Creating test data
        String orderID = "11111113445L";
        String customerID = "1001";
        LocalDate orderDate = LocalDate.now();

        String orderItemsID = "12345";

        double totalPrice = 150.0;
        String status = "Pending";
        String addressID = "A100";

        Orders orders = OrderFactory.buildOrder(orderID, customerID, orderDate, orderItemsID, totalPrice, status, addressID);


        assertNotNull(orders);
        System.out.println(orders);
        assertEquals(orderID, orders.getOrderID());
        assertEquals(customerID, orders.getCustomerID());
        assertEquals(orderDate, orders.getOrderDate());
        assertEquals(orderItemsID, orders.getOrderItemsID());
        assertEquals(totalPrice, orders.getTotalPrice());
    }
}
