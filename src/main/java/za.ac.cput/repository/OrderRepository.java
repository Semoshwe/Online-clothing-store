package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
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
public interface OrderRepository extends JpaRepository<Order, String> {
/*
    List<Order> getall();

    Order save(Order order);

    //List<Order> findById(Long id);
   Optional<Order> findById(String id);

    List<Order> findAll();

 */
}


