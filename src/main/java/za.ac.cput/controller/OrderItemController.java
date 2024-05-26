package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.service.OrderItemService;

import java.util.List;

/*
 * OrderItem: java
 * OrderItem: Controller Class
 * Author: Luke Duffell
 * Date: 26 May 2024
 */

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public OrderItem create(@RequestBody OrderItem orderItem){
        return orderItemService.create(orderItem);
    }

    @GetMapping("/read/{id}")
    public OrderItem read(@PathVariable Long id){
        return orderItemService.read(id);
    }

    @PostMapping("/update")
    public OrderItem update(@RequestBody OrderItem orderItem){
        return orderItemService.update(orderItem);
    }

    @GetMapping("/getAll")
    public List<OrderItem> getAll(){
        return orderItemService.getAll();
    }
}
