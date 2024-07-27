package za.ac.cput.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Customer;

import java.time.LocalDateTime;
import java.util.List;

/*
 * CustomerRepository.java
 * Author: Rethabile Ntsekhe
 * Student number: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    // This is where I can add my own database methods extending from the ones already
    // defined in the JPA Repository. This is an example of abstraction in practice.
    //in Short this is a way of saying you extend the JPARepository that will be implemented/used
    // in the service level
//---------------------------------------------------------------------------------------------------------
    //Suggested custom Methods

    // Find customers by privileges
    List<Customer> findByPrivileges(String privileges);

    // Find customers by user ID
    List<Customer> findByUserID(String userID);

    // Custom query to find customers who have placed orders (assuming there is an Orders table with a customerId field)
    @Query("SELECT c FROM Customer c WHERE c.customerId IN (SELECT o.customerID FROM Orders o)")
    List<Customer> findCustomersWithOrders();

    // Pagination and sorting for customers with specific privileges
    Page<Customer> findByPrivileges(String privileges, Pageable pageable);

    // Custom update operation to update customer privileges
    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.privileges = :privileges WHERE c.customerId = :customerId")
    int updateCustomerPrivileges(@Param("customerId") String customerId, @Param("privileges") String privileges);

    // Custom query to find customers by their order status
    @Query("SELECT c FROM Customer c WHERE c.customerId IN (SELECT o.customerID FROM Orders o WHERE o.status = :status)")
    List<Customer> findCustomersByOrderStatus(@Param("status") String status);

    // Custom query to find customers with orders above a certain total price
    @Query("SELECT c FROM Customer c WHERE c.customerId IN (SELECT o.customerID FROM Orders o WHERE o.totalPrice > :price)")
    List<Customer> findCustomersByOrderTotalPrice(@Param("price") double price);

    // Custom query to find customers who placed orders within a date range
    @Query("SELECT c FROM Customer c WHERE c.customerId IN (SELECT o.customerID FROM Orders o WHERE o.orderDate BETWEEN :startDate AND :endDate)")
    List<Customer> findCustomersByOrderDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);


}
