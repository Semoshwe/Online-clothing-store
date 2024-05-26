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
@Configuration
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {
    @Autowired
    private UserService userService;
    private static User user1;
    private static User user2;

    @BeforeEach
    @Order(1)
    @Test
    void setup(){
        user1 = UserFactory.buildingUser("UD005","simple","Dlaini","ssfftteeyy", "Simple12@gmail.com", "102ADD","Long St","Lillies","WesternCape","2356");
        assertNotNull(user1);
        System.out.println(user1);
    }

    @Order(2)
    @Test
    void create() {
        User created1 = userService.create(user1);
        assertNotNull(created1);
        System.out.println(created1);
    }

    @Order(3)
    @Test
    void read() {
        User read = userService.read(user1.getUserID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Order(4)
    @Test
    void update() {
        User newUser = new User.Builder().copy(user1).setUserID("UD865").build();
        User updated = userService.update(newUser);
        assertNotNull(updated);
        System.out.println(updated);
    }
    @Order(5)
    @Test
    void getAll() {
        System.out.println(userService.getAll());
    }
}