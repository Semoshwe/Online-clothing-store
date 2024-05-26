package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Admin;
import za.ac.cput.factory.AdminFactory;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Admin: java
 * Admin:s Test Class
 * Author: Luke Duffell
 * Date: 26 May 2024
 */

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminServiceTest {
    @Autowired
    private AdminService service;

    private Admin admin = AdminFactory.buildAdmin("9775", "Happiness");

    @Test
    @Order(1)
    void create() {
        Admin created = service.create(admin);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Admin read = service.read(admin.getAdminId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Admin newAdmin = new Admin.Builder().copy(admin).setPrivileges("Sadness").build();
        Admin updated = service.update(newAdmin);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println(service.getAll());
    }
}