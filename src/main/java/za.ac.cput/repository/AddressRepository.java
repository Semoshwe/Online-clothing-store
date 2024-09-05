package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

import java.util.List;
@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
   Address findAddressByAddressID(String AddressID);

}
