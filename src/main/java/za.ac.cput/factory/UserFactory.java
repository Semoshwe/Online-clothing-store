package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.Set;

/**
 * Factory class for creating instances of {@link User}.
 * Provides static methods to create {@link User} objects from various inputs.
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 24-Aug-24
 */
public class UserFactory {

    /**
     * Creates a {@link User} instance from various input parameters.
     *
     * @param avatar      the avatar of the user
     * @param firstName   the first name of the user
     * @param lastName    the last name of the user
     * @param email       the email address of the user
     * @param birthDate   the birth date of the user
     * @param role        the roles of the user
     * @param phoneNumber the phone number of the user
     * @param password    the password of the user
     * @return a new {@link User} object with properties set from the input parameters
     */
    public static User createUser(String avatar, String firstName, String lastName, String email,
                                  LocalDate birthDate, Set<String> role, String phoneNumber, String password) {
        // Validation checks
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("First name, last name, email, and password cannot be null or empty");
        }

        // Create a new User object using the Builder pattern
        return new User.Builder()
                .setAvatar(avatar)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setBirthDate(birthDate)
                .setRole(role) // Set the roles as a Set<String>
                .setPhoneNumber(phoneNumber)
                .setPassword(password)
                .build();
    }

    /**
     * Creates a {@link User} instance for sign-in with only email and password.
     *
     * @param email       the email address of the user
     * @param password    the password of the user
     * @return a new {@link User} object with properties set from the input parameters
     */
    public static User createUserForSignIn(String email, String password) {
        // Validation checks
        if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("Email and password cannot be null or empty");
        }

        // Create a new User object using the Builder pattern with default or null values for other fields
        return new User.Builder()
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}
