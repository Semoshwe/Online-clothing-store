package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {

    public static User buildingUser(String userID,String firstName, String lastName, String password, String email,
                                    String addressId,String street, String city, String province, String zipCode ){
        if (Helper.isNullOrEmpty(userID)|| Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(password)||Helper.isEmailValid(email))
            return null;
        if (!Helper.isNullOrEmpty(addressId)||Helper.isNullOrEmpty(street) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(zipCode))
            return null;
        Address address = AddressFactory.buildAddress(addressId, street, city, province, zipCode);
        return  new User.Builder().setUserID(userID).setFirstName(firstName).setLastName(lastName).setPassword(password).setEmail(email).setAddress(address).setAddress(address).build();

    }

}

