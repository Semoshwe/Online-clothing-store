package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    @Autowired
    private UserService userService;
    private static User user1;
    private static User user2;


    @Test
    @Order(1)
    void setUp() {
        user1 = UserFactory.buildUser("E001", "Kelly", "Simon", "timbler", "Someone@gmail.com", user1.getAddress(), "122Cus");
        assertNotNull(user1);
        System.out.println(user1);

        user2 = UserFactory.buildUser("E002", "Nelly", "Candice", "thisisthis", "People@gmail.com", user2.getAddress(), "123Cus");
        assertNotNull(user2);
        System.out.println(user2);
    }

    @org.junit.jupiter.api.Order(2)
    @Test
    void create(){
        User created1 = userService.create(user1);
        assertNotNull(created1);
        System.out.println(created1);

        User created2 = userService.create(user2);
        assertNotNull(created2);
        System.out.println(created2);

    }

    @org.junit.jupiter.api.Order(3)
    @Test
    void read(){

        User read = userService.read(user2.getUserID());
        assertNotNull(read);
        System.out.println(read);
    }

    @org.junit.jupiter.api.Order(4)
    @Test
    void update(){
        User newEmployee = new User.Builder().copy(user2).setFirstName("Moshwe").build();
        User updated = userService.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);

    }

    @org.junit.jupiter.api.Order(5)
    @Test
    void getall(){
        System.out.println(userService.getAll());
    }
}

