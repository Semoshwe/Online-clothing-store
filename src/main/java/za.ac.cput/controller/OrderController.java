package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Orders;
import za.ac.cput.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping(value = "/create")
    public ResponseEntity<Orders> create(@RequestBody Orders orders) {
        Orders createdOrders = orderService.create(orders);
        return new ResponseEntity<>(createdOrders, HttpStatus.CREATED);
    }


    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Orders> read(@PathVariable String id) {
        Orders orders = orderService.read(id);
        if (orders != null) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Orders> update(@RequestBody Orders orders) {
        Orders updatedOrders = orderService.update(orders);
        return new ResponseEntity<>(updatedOrders, HttpStatus.OK);
    }

    // Get all Orders
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Orders>> findAll() {
        List<Orders> orders = orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
