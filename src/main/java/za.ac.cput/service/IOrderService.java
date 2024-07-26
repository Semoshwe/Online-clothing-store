package za.ac.cput.service;

import za.ac.cput.domain.Orders;

import java.time.LocalDate;
import java.util.List;

/*
 * IOrderService: java
 * Order Service Interface
 * Author: Rethabile Ntsekhe
 * Date: 17 May 2024
 * Student Number: 220455430
 */
public interface IOrderService extends IService<Orders, String >{

    /**
     * Finds orders by customer ID.
     *
     * @param customerID The ID of the customer.
     * @return A list of orders for the specified customer.
     */
    List<Orders> findByCustomerID(String customerID);

    /**
     * Finds orders by status.
     *
     * @param status The status of the orders.
     * @return A list of orders with the specified status.
     */
    List<Orders> findByStatus(String status);

    /**
     * Finds orders within a date range.
     *
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @return A list of orders within the specified date range.
     */
    List<Orders> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Finds orders by address ID.
     *
     * @param addressID The ID of the address.
     * @return A list of orders for the specified address.
     */
    List<Orders> findByAddressID(String addressID);

    /**
     * Finds orders with a total price greater than the specified amount.
     *
     * @param totalPrice The minimum total price.
     * @return A list of orders with a total price greater than the specified amount.
     */
    List<Orders> findByTotalPriceGreaterThan(double totalPrice);

    /**
     * Finds orders by order items ID.
     *
     * @param orderItemsID The ID of the order items.
     * @return A list of orders with the specified order items ID.
     */
    List<Orders> findByOrderItemsID(String orderItemsID);

    /**
     * Deletes an order by its ID.
     *
     * @param orderID The ID of the order to delete.
     */
    void deleteByOrderID( String orderID);

    /**
     * Deletes orders by customer ID.
     *
     * @param customerID The ID of the customer whose orders are to be deleted.
     */
    void deleteByCustomerID( String customerID);
}
