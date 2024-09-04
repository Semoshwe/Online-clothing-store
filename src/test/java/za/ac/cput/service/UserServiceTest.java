package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.OnlineClothingStoreApp;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OnlineClothingStoreApp.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, passwordEncoder);

        user = new User.Builder()
                .setFirstName("Rethabile")
                .setLastName("Ntsekhe")
                .setEmail("rethabile@gmail.com")
                .setPassword("password")
                .setRole(Set.of("USER"))
                .setBirthDate(LocalDate.of(1990, 1, 1))
                .setPhoneNumber("1234567890")
                .build();
    }

   @AfterEach
    void tearDown(){
       userRepository.deleteAll();
   }


    @Test
    @Order(1)
    void testCreateUser() {
        user = UserFactory.createUser(
                "avatar.jpg",
                "Rethabile",
                "Ntsekhe",
                "rethabile@gmail.com",
                LocalDate.parse("1990-01-01"),
                Set.of("USER"),
                "0123456789",
                "password123");

        User createdUser = userService.create(user);
        System.out.println(createdUser);
        assertNotNull(createdUser);
        assertEquals("Rethabile", createdUser.getFirstName());
        assertNotNull(userRepository.findByEmail("rethabile@gmail.com"));

    }

    @Test
    @Order(2)
    void testReadUser() {
        User createdUser = userService.create(user);
        User foundUser = userService.read(user.getUserID());
        System.out.println(foundUser);
        assertNotNull(foundUser);
        assertEquals("Rethabile", foundUser.getFirstName());
    }

    @Test
    @Order(3)
    void testUpdateUser() {
        User createduser = userService.create(user);
        createduser = new User.Builder()
                .copy(createduser)
                .setLastName("Southampton")
                .build();
        User updatedUser = userService.update(createduser);
        System.out.println(updatedUser);
        assertNotNull(updatedUser);
        assertEquals("Southampton", updatedUser.getLastName());
    }

//    @Test
//    @Order(4)
//    void testDeleteUser() {
//        userService.delete(user.getUserID());
//        assertFalse(userRepository.findById(user.getUserID()).isPresent());
//    }

    @Test
    @Order(5)
    void testFindAllUsers() {
        userService.create(user);
        List<User> users = userService.findAll();
        System.out.println("All Users :" + '\n' + users + '\n');
        assertNotNull(users);
        //assertFalse(users.isEmpty());
       // assertEquals(1, users.size());
    }

//    @Test
//    void testLoadUserByUsername() {
//        UserDetails userDetails = userService.loadUserByUsername("rethabile@gmail.com");
//        System.out.println("Found By Username: " + userDetails + '\n');
//        assertNotNull(userDetails);
//        assertEquals("rethabile@gmail.com", userDetails.getUsername());
//    }

    @Test
    @Order(6)
    void testLoadUserByUsernameNotFound() {
        userService.create(user);
        assertThrows(UsernameNotFoundException.class,
                () -> userService.loadUserByUsername("unknown@example.com"));
    }


    @Test
    @Order(7)
    void testFindByEmail() {
        userService.create(user);
        Optional<User> foundUser = userService.findByEmail("rethabile@gmail.com");
        System.out.println("Found By Email: " + '\n' + foundUser);
        assertTrue(foundUser.isPresent());
        assertEquals("Rethabile", foundUser.get().getFirstName());
    }

    @Test
    @Order(8)
    void testFindByFirstName() {
        userService.create(user);
        List<User> users = userService.findByFirstName("Rethabile");
        System.out.println("Found By First Name: " + users);
        assertFalse(users.isEmpty());
        //assertEquals(1, users.size());
    }

    @Test
    @Order(9)
    void testFindByLastName() {
        userService.create(user);
        List<User> users = userService.findByLastName("Ntsekhe");
        System.out.println("Found By Last NAme: " + users);
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
    }

    @Test
    @Order(10)
    void testFindByBirthDate() {
        userService.create(user);
        List<User> users = userService.findByBirthDate(LocalDate.of(1990, 1, 1));
        System.out.println("Found By Birthday: " + users);
        assertFalse(users.isEmpty());
        //assertEquals(1, users.size());
    }

    @Test
    @Order(11)
    void testFindByPhoneNumber() {
        userService.create(user);
        List<User> users = userService.findByPhoneNumber("1234567890");
        System.out.println("Found By Phone Number: " + users);
        assertFalse(users.isEmpty());
       // assertEquals(1, users.size());
    }

    @Test
    @Order(12)
    void testFindByRole() {
        userService.create(user);
        List<User> users = userService.findByRole("USER");
        System.out.println("Found By Roles: " + users);
        assertFalse(users.isEmpty());
        //assertEquals(1, users.size());
    }
}
