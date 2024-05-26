package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/create")
    public Cart create(@RequestBody Cart cart){
        return cartService.create(cart);
    }

    @GetMapping("/read/{id}")
    public Cart read(@PathVariable String id){
            return cartService.read(id);
    }

    @PostMapping("/update")
    public Cart update(@RequestBody Cart cart){
            return cartService.update(cart);
    }

    @GetMapping("/getAll")
    public List<Cart> getAll(){
        return cartService.getAll();
    }
}
