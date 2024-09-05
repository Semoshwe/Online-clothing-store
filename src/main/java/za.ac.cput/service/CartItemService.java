package za.ac.cput.service;
/**
 * E-Commerce Web Application for selling clothes
 * CartItemService.java
 * Service class for CartItem
 * Author: Kinzonzi Genereux Mukoko - 221477934
 * Date: 18 May 2024
 * */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.CartItemRepository;

import java.util.List;
@Service
public class CartItemService implements ICartItemService{
    private CartItemRepository repository;

    @Autowired
    CartItemService(CartItemRepository repository){this.repository = repository;}

    @Override
    public CartItem create(CartItem cartItem) { return repository.save(cartItem);}

    @Override
    public CartItem read(String Id) {
        return this.repository.findById(Id).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return repository.save(cartItem);
    }

    @Override
    public List<CartItem> findAll() {
        return repository.findAll();
    }
}
