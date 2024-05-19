package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
    public static User buildUser(String userID, String firstName, String lastName,
                                 String password, String email, Address address, String customerID) {
        if (Helper.isNullOrEmpty(userID) || Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password)
                ||  address == null)
            return null;

        String regex = "^(.+)@(\\S+)$";
        if (!Helper.isEmailValid(email, regex) || Helper.isNullOrEmpty(email)) return null;

        return new User.Builder().setUserID(userID).setFirstName(firstName).setLastName(lastName)
                .setEmail(email).setPassword(password).setAddress(address).setCustomerID(customerID)
                .build();
    }
}
