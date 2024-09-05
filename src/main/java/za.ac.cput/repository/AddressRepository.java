package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

import java.util.List;
import java.util.Optional;

@Repository

public interface AddressRepository extends JpaRepository<Address, Long> {
   //Address findAddressByAddressID(Long AddressID);
   List<Address> findByAddressLine(String addressLine);
   List <Address> findByZipCode(String zipCode);
   List<Address> findByCountry(String country);
   List<Address> findByPhoneNumber(String phoneNumber);
   Optional<Address> findByUserId(Long id);
   List<Address> findByDeletedAtIsNotNull();


   //Address deleteAddressByAddressID(String AddressID);



}
