package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Orders;
import za.ac.cput.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
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

    @GetMapping(value = "/findByCustomerID/{customerID}")
    public ResponseEntity<List<Orders>> findByCustomerID(@PathVariable String customerID) {
        List<Orders> orders = orderService.findByCustomerID(customerID);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/findByStatus/{status}")
    public ResponseEntity<List<Orders>> findByStatus(@PathVariable String status) {
        List<Orders> orders = orderService.findByStatus(status);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/findByOrderDateBetween")
    public ResponseEntity<List<Orders>> findByOrderDateBetween(
            @RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        List<Orders> orders = orderService.findByOrderDateBetween(startDate, endDate);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/findByAddressID/{addressID}")
    public ResponseEntity<List<Orders>> findByAddressID(@PathVariable String addressID) {
        List<Orders> orders = orderService.findByAddressID(addressID);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/findByTotalPriceGreaterThan/{totalPrice}")
    public ResponseEntity<List<Orders>> findByTotalPriceGreaterThan(@PathVariable double totalPrice) {
        List<Orders> orders = orderService.findByTotalPriceGreaterThan(totalPrice);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping(value = "/findByOrderItemsID/{orderItemsID}")
    public ResponseEntity<List<Orders>> findByOrderItemsID(@PathVariable String orderItemsID) {
        List<Orders> orders = orderService.findByOrderItemsID(orderItemsID);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteByOrderID/{orderID}")
    public ResponseEntity<Void> deleteByOrderID(@PathVariable String orderID) {
        orderService.deleteByOrderID(orderID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/deleteByCustomerID/{customerID}")
    public ResponseEntity<Void> deleteByCustomerID(@PathVariable String customerID) {
        orderService.deleteByCustomerID(customerID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
