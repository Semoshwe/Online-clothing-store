package za.ac.cput.service;
/**
 * E-Commerce Web Application for selling clothes
 * CartService.java
 * Service  class for Cart
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 18 May 2024
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements ICartService {

    private CartRepository repository;

    @Autowired
    CartService(CartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cart create(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public Cart read(String Id) {
        return this.repository.findById(Id).orElse(null);
    }

    @Override
    public Cart update(Cart cart) {
        return repository.save(cart);
    }

    @Override
    public List<Cart> findAll() {
        return repository.findAll();
    }
}
