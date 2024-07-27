package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    private User user1;
    private User user2;

    @BeforeEach
    void setup(){
        user1 = UserFactory.createUser("UD005","simple","Dlaini","ssfftteeyy", "Simple12@gmail.com", "102ADD","Long St");
        assertNotNull(user1);
        System.out.println(user1);
    }

    @Test
    @Order(1)
    void create() {
        User created1 = userService.create(user1);
        assertNotNull(created1);
        assertEquals(user1.getUserID(), created1.getUserID());
    }

    @Test
    @Order(2)
    void read() {
        User created = userService.create(user1); // Ensure user is created before reading
        User read = userService.read(created.getUserID());
        assertNotNull(read);
        assertEquals(created.getUserID(), read.getUserID());
    }

    @Test
    @Order(3)
    void update() {
        User created = userService.create(user1); // Ensure user is created before updating
        User updatedUser = new User.Builder()
                .copy(created)
                .setUserID("UD865") // Assuming you want to update the ID
                .build();
        User updated = userService.update(updatedUser);
        assertNotNull(updated);
        assertEquals("UD865", updated.getUserID());
    }

    @Test
    @Order(4)
    void getAll() {
        User created = userService.create(user1); // Ensure user is created before fetching all
        var allUsers = userService.findAll();
        assertTrue(allUsers.size() > 0); // Ensure there are users in the list
        assertTrue(allUsers.contains(created)); // Ensure the created user is in the list
    }
}
