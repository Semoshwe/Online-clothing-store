package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;
import java.time.LocalDate;


public class AddressFactory {


    public static Address buildAddress(Long addressid,
                                       Long userId,
                                       String addressline,
                                       String city,
                                       String country,
                                       String zipCode,
                                       String phoneNumber,
                                       LocalDate createdAt,
                                       LocalDate deletedAt){

        if (  Helper.isNullOrEmpty(userId) ||
                Helper.isNullOrEmpty(addressline) ||
                Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(country) ||
                Helper.isNullOrEmpty(zipCode) ||
                Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(String.valueOf(createdAt)) ||
                Helper.isNullOrEmpty(String.valueOf(deletedAt))
        ) {
            throw new IllegalArgumentException("Required fields cannot be null in address");
        }





        return new Address.Builder()
                .setAddressID(addressid)
                .setUserId(userId).
                setAddressLine(addressline)
                .setCity(city)
                .setCountry(country)
                .setZipCode(zipCode)
                .setPhoneNumber(phoneNumber).
                setCreatedAt(createdAt)
                .setDeletedAt(deletedAt)
                .build();

    }



}
