package za.ac.cput.factory;

import za.ac.cput.domain.Order;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

/*
 * OrderFactory: java
 * Order: Factory Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 17 May 2024
 */
public class OrderFactory {

    /**
     * Creates an Order object.
     *
     * @param orderID      The ID of the order.
     * @param customerID   The ID of the customer placing the order.
     * @param orderDate    The date and time when the order was placed.
     * @param orderItemsID   The list of order items included in the order.
     * @param totalPrice   The total price of the order.
     * @param status       The status of the order.
     * @param addressID    The ID of the address where the order should be delivered.
     * @return             The created Order object, or null if any parameter is null or empty.
     */
    public static Order buildOrder(String orderID, String customerID, LocalDateTime orderDate,
                                   String  orderItemsID, double totalPrice, String status,
                                   String addressID) {

        if (Helper.isNullOrEmpty(orderID) ||
                Helper.isNullOrEmpty(customerID) ||
                orderDate == null ||
                orderItemsID == null || orderItemsID.isEmpty() ||
                totalPrice <= 0 ||
                Helper.isNullOrEmpty(status) ||
                Helper.isNullOrEmpty(addressID)) {
            return null;
        }

        return new Order.Builder()
                .setOrderID(orderID)
                .setCustomerID(customerID)
                .setOrderDate(orderDate)
                .setOrderItemsID(orderItemsID)
                .setTotalPrice(totalPrice)
                .setStatus(status)
                .setAddressID(addressID)
                .build();
    }
}
