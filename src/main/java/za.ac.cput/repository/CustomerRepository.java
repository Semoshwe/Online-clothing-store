package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.util.List;

/*
 *CustomerRepo :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface CustomerRepo extends IRepository<Customer, String> {

    Customer create(Customer customer);

    Customer read(String customerId);

    Customer update(Customer customer);

    boolean delete(String customerId);


}
