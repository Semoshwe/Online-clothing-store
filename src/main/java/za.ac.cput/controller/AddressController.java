package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.service.AddressService;

import java.util.List;
/**
 * AddressController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 08-Aug-24
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/create")
    public ResponseEntity<Address> create(@RequestBody Address address) {
        Address createdAddress = addressService.create(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }


//    @PostMapping(path = "/add")
//    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
//        Address newAddress = addressService.create(address);
//        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
//    }


    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Address> read(@PathVariable Long id) {
        Address address = addressService.read(id);
        if (address != null) {
            return new ResponseEntity<>(address, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping(value = "/delete/{id}")
//    public void delete (@PathVariable String id){
//
//    }

    @PostMapping(value = "/update")
    public ResponseEntity<Address> update(@RequestBody Address address) {
        Address updatedAddress = addressService.update(address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Address>> findAll() {
        List<Address> addresses = addressService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

}
