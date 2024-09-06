package za.ac.cput.service;

import za.ac.cput.domain.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService extends IService <Address, Long>{

    Optional<Address> findByUserId(Long Id);
    List<Address> findByAddressLine(String addressLine);
    List<Address> findByZipcodes(String zipcode);
    List<Address> findByPhoneNumber(String phoneNumber);

    List<Address> findByCountry(String country);

    List<Address> findByDeletedAtIsNotNull();
    List<Address> getAll();
}
