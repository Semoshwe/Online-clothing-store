package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Order;
import za.ac.cput.service.OrderService;

import java.util.List;


    @RestController
    @RequestMapping("/order")
    public class OrderController {

        @Autowired
        private OrderService orderService;

        @PostMapping("/create")
        public Order create(@RequestBody Order order){
            return orderService.create(order);
        }

        @GetMapping("/read/{id}")
        public Order read(@PathVariable String  id){
            return orderService.read(id);
        }

        @PostMapping("/update")
        public Order update(@RequestBody Order order){
            return orderService.update(order);
        }

        @GetMapping("/getAll")
        public List<Order> getAll(){
            return orderService.getAll();
        }
    }

