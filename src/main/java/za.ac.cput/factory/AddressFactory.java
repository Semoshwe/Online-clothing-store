package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

public class AddressFactory {


    public static Address buildAddress(String addressId,String street, String city, String province, String zipCode){
        if (Helper.isNullOrEmpty(addressId)|| Helper.isNullOrEmpty(street) || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(zipCode))
            return null;

        return new Address.Builder().setAddressID(addressId).setStreet(street).setCity(city).setProvince(province).setZipCode(zipCode).build();


    }



}
