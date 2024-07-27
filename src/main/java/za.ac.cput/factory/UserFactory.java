package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    /**
     * Creates a User object if all required fields are valid.
     *
     * @param userID      the user ID
     * @param firstName   the user's first name
     * @param lastName    the user's last name
     * @param password    the user's password
     * @param email       the user's email address
     * @param addressID   the address ID
     * @param customerID  the customer ID
     * @return a User object if all validations pass; otherwise, null
     */
    public static User createUser(String userID, String firstName, String lastName,
                                 String password, String email, String addressID, String customerID) {
        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(firstName) ||
            Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password) ||
            Helper.isNullOrEmpty(addressID)) {
            return null;
        }

        String regex = "^(.+)@(\\S+)$";
        if (!Helper.isEmailValid(email, regex)) {
            return null;
        }

        return new User.Builder()
                .setUserID(userID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setAddressID(addressID)
                .setCustomerID(customerID)
                .build();
}
}
