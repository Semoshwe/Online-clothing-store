package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Orders;

import java.time.LocalDate;
import java.util.List;

/*
 *IOrderRepository :java
 * Order Repository Interface
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface IOrderRepository extends JpaRepository<Orders, String> {

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
    @Query("SELECT o FROM Orders o WHERE o.orderItemsID = :orderItemsID")
    List<Orders> findByOrderItemsID(@Param("orderItemsID") String orderItemsID);

    /**
     * Deletes an order by order ID.
     *
     * @param orderID The ID of the order to delete.
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM Orders o WHERE o.orderID = :orderID")
    void deleteByOrderID(@Param("orderID") String  orderID);

    /**
     * Deletes orders by customer ID.
     *
     * @param customerID The ID of the customer whose orders are to be deleted.
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM Orders o WHERE o.customerID = :customerID")
    void deleteByCustomerID(@Param("customerID") String customerID);
}
