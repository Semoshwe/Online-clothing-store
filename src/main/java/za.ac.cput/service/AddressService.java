package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

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
    public Address read(Long id) {
    return repository.findById(id).orElse(null);}


//    @Override
//    public List<Address> findZipcodes(String zipCode){
//        return this.repository.findAddressByZipCode(zipCode);
//    }
    @Override
    public Address update(Address address) {
       // Long addressId = address.getAddressID();
        //Optional<Address> existsById = repository.findById(addressId);
        if(address.getUserId() == null  ){
            throw new IllegalArgumentException("Address with the given UserID does not exist.");
        }
        Address updatedAddress = new Address.Builder()
                .setUserId(address.getUserId())
                .setAddressLine(address.getAddressLine())
                .setCity(address.getCity())
                .setCountry(address.getCountry())
                .setZipCode(address.getZipCode())
                .setPhoneNumber(address.getPhoneNumber())
                .setCreatedAt(address.getCreatedAt())
                .setDeletedAt(address.getDeletedAt())
                .build();
        return repository.save(updatedAddress);
    }

    @Override
    public Optional<Address> findByUserId(Long Id) {
        return repository.findByUserId(Id);
    }

    @Override
    public List<Address> findByAddressLine(String addressLine) {
        return repository.findByAddressLine(addressLine);
    }

    @Override
    public List<Address> findByZipcodes(String zipcode) {
        return repository.findByZipCode(zipcode);
    }

    @Override
    public List<Address> findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);

    }




    @Override
    public List<Address> findByCountry(String country){
        return repository.findByCountry(country);
    }

    @Override
    public List<Address> findByDeletedAtIsNotNull() {
        return repository.findByDeletedAtIsNotNull();
    }

    @Override
    public List<Address> getAll() {
        return repository.findAll();
    }


}
