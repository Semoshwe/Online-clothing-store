package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.repository.AdminRepository;

import java.util.List;
@Service
public class AddressService implements IAddressService{
    private AddressRepository repository;

    @Autowired
    AddressService(AddressRepository repository) {this.repository = repository;}

    @Override
    public Address create(Address address) {
        return repository.save(address);
    }

    @Override
    public Address read(String s) {
        return this.repository.findAddressByAddressID(s);
    }

    @Override
    public Address update(Address address) {
        return repository.save(address);
    }

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }


}
