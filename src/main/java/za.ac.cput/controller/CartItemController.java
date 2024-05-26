package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("CartItem")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem){
        return cartItemService.create(cartItem);
    }

    @GetMapping("/read/{id}")
    public CartItem read(@PathVariable String id){
        return cartItemService.read(id);
    }

    @PostMapping("/update")
    public CartItem update(@RequestBody CartItem cartItem){
            return cartItemService.update(cartItem);
    }

    @GetMapping("/getAll")
    public List<CartItem> getAll(){
        return cartItemService.getAll();
    }


}
