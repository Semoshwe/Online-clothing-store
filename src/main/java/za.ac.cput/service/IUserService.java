package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * IUserService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 25-Aug-24
 */

public interface IUserService extends IService<User, Long>{

    void delete(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    List<User> findByBirthDate(LocalDate birthDate);

    List<User> findByPhoneNumber(String phoneNumber);

    List<User> findByRole(String role);
}
