package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;

import java.util.List;

@Service
public abstract class OrderService implements IOrderService {
    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order create(Order order) {
        return repository.save(order);
    }


    @Override
    public  Order read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return repository.save(order);
    }


    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}
