package za.ac.cput.service;

import za.ac.cput.domain.User;

import java.util.List;

public interface IUserService extends IService<User, String>{

    /**
     * Finds users by their email address.
     *
     * @param email the email address to search for
     * @return a list of users with the given email
     */
    List<User> findByEmail(String email);

    /**
     * Finds users by their last name.
     *
     * @param lastName the last name to search for
     * @return a list of users with the given last name
     */
    List<User> findByLastName(String lastName);
}
