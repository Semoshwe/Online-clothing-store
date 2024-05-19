package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.repository.AdminRepository;

import java.util.List;
@Service
public class AddressService implements IAddressService{
    private AddressRepository addressrepository;

    @Autowired
    AddressService(AddressRepository addressrepository) {
        this.addressrepository = addressrepository;
    }

    @Override
    public Address create(Address address) {
        return addressrepository.save(address);
    }

    @Override
    public Address read(String id) {
        return addressrepository.findAddressByAddressID(id);
    }

    @Override
    public Address update(Address address) {
        return addressrepository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return addressrepository.findAll();
    }
}
