package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        return userservice.create(user);
    }

    @GetMapping("/read/{employeeNumber}")
    public User read(@PathVariable String userID) {
        return userservice.read(userID);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userservice.update(user);
    }



    @GetMapping("/getall")
    public List<User> getall(){
        return userservice.getAll();
    }


}
