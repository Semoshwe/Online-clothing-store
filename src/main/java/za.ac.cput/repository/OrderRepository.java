package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order;

import java.util.List;
import java.util.Optional;


/*
 *OrderRepository :java
 *IOrder : Model Class
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface OrderRepository extends IRepository<Order, Long> {

    List<Order> getall();

    Order save(Order order);

    //List<Order> findById(Long id);
   Optional<Order> findById(Long id);

    List<Order> findAll();
}


