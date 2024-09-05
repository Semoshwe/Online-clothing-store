package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Orders;


/*
 *OrderRepository :java
 *IOrder : Model Class
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {
/*
    List<Orders> getall();

    Orders save(Orders order);

    //List<Orders> findById(Long id);
   Optional<Orders> findById(String id);

    List<Orders> findAll();

 */
}


