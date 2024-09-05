package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.IOrderRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepository repository;

    @Autowired
    public OrderService(IOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Orders create(Orders orders) {
        return repository.save(orders);
    }

    @Override
    public Orders read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Orders update(Orders orders) {
        return repository.save(orders);
    }

    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Orders> findByCustomerID(String customerID) {
        return repository.findByCustomerID(customerID);
    }

    @Override
    public List<Orders> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public List<Orders> findByOrderDateBetween(LocalDate startDate, LocalDate endDate) {
        return repository.findByOrderDateBetween(startDate,endDate);
    }

    @Override
    public List<Orders> findByAddressID(String addressID) {
        return repository.findByAddressID(addressID);
    }

    @Override
    public List<Orders> findByTotalPriceGreaterThan(double totalPrice) {
        return repository.findByTotalPriceGreaterThan(totalPrice);
    }

    @Override
    public List<Orders> findByOrderItemsID(String orderItemsID) {
        return repository.findByOrderItemsID(orderItemsID);
    }

    @Override
    public void deleteByOrderID(String orderID) {
        repository.deleteByOrderID(orderID);
    }

    @Override
    public void deleteByCustomerID(String customerID) {
        repository.deleteByCustomerID(customerID);
    }
}
