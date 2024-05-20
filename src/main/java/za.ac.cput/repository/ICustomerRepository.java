package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;


/*
 *CustomerRepository :java
 * Author: Rethabile Ntsekhe
 * Student num: 22045540
 * Date: 17 May 2024
 */
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    /* this is where I can Add my own Database methods extending from the ones already
     * defined in the JPA Repository
     * this is abstraction
     */

}
