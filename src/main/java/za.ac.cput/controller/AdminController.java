package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Admin;
import za.ac.cput.service.AdminService;

import java.util.List;

/*
 * Admin: java
 * Admin: Controller Class
 * Author: Luke Duffell
 * Date: 26 May 2024
 */

@RestController
@RequestMapping("/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public Admin create(@RequestBody Admin admin){
        return adminService.create(admin);
    }

    @GetMapping("/read/{id}")
    public Admin read(@PathVariable String id){
        return adminService.read(id);
    }

    @PostMapping("/update")
    public Admin update(@RequestBody Admin admin){
        return adminService.update(admin);
    }

    @GetMapping("/getAll")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
}
