package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;

import java.util.List;

/*
 * Order: java
 * Order: Model Class
 * Author: Rethabile Ntsekhe (220455430)
 * Date: 18 May 2024
 */
@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository repository;

    @Autowired
    public CustomerService(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Customer read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }
}
