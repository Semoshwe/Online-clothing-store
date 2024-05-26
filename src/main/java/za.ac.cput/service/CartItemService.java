package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.CartItemRepository;

import java.util.List;
@Service
public class CartItemService implements ICartItemService{
    private CartItemRepository repository;

    @Autowired
    CartItemService(CartItemRepository cartItemRepository){this.repository = repository;}

    @Override
    public CartItem create(CartItem cartItem) {
        return this.repository.save(cartItem);
    }

    @Override
    public CartItem read(String Id) {
        return this.repository.findById(Id).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return this.repository.save(cartItem);
    }

    @Override
    public List<CartItem> getAll() {
        return this.repository.findAll();
    }
}
