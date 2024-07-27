package za.ac.cput.factory;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.util.Helper;

/*
 *OrderItemFactory:java
 *OrderItem: Factory Class
 * Author: Luke Duffell
 * Student no: 217061567
 * Date: 17 May 2024
 */

public class OrderItemFactory {
    public static OrderItem buildOrderItem(String id, String orderItemId, int quantity, double price){
        if (Helper.isNullOrEmpty(orderItemId) || Helper.isNullOrEmpty(id))
            return null;

        if (quantity < 0 || price < 0)
            return null;

        return new OrderItem.Builder().setId(id)
                .setOrderItemId(orderItemId)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
