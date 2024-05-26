package za.ac.cput.factory;

/*
 *Customer:java
 *Customer: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 17 May 2024
 */

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    /**
     *
     */


    public static Customer createCustomer(String  customerId, String privileges, String  userID) {

        if (Helper.isNullOrEmpty(customerId) ||
                Helper.isNullOrEmpty(privileges) ||
                Helper.isNullOrEmpty(userID)) {
            return null;
        }

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setPrivileges(privileges)
                .setUserID(userID)
                .build();
    }
}
