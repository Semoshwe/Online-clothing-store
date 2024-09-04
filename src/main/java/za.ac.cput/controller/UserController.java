package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

/**
 * UserController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Aug-24
 */

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    /** Handles the creation of a new user.* and returns the created user with a 201 Created status.* @param user the user data transfer object containing user details.\* @return ResponseEntity containing the created UserDTO and HTTP status code.*/
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /*** Retrieves a user by their ID.* This endpoint returns the user with the specified ID if found, or a 404 Not Found status* if the user does not exist.* @param id the ID of the user to retrieve.* @return ResponseEntity containing the UserDTO if found, or 404 status if not.*/
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.read(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*** Retrieves a list of all users.** This endpoint returns a list of all users in the system.* @return ResponseEntity containing the list of UserDTOs and an HTTP OK status.*/
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    /*** Updates a user's password.* This endpoint allows updating the password for a user with the specified ID.* It receives the new password details in the request body and returns a success message.* @param id the ID of the user whose password is to be updated.* @param userPasswordDTO the data transfer object containing the new password details.* @return ResponseEntity containing a success message and HTTP OK status.*/
   /* @PostMapping("/{id}/password")
    public ResponseEntity<String> updateUserPassword(@PathVariable Long id, @RequestBody UserPasswordDTO userPasswordDTO) {
        userService.updateUserPassword(id, userPasswordDTO);
        return ResponseEntity.ok("Password updated successfully");
    }*/
}
