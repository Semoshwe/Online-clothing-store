package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for handling user-related operations.
 * Implements {@link UserDetailsService} for user authentication.
 * Implements {@link IUserService} for user CRUD operations.
 * <p>
 * Author: Rethabile Ntsekhe
 * Date: 24-Aug-24
 * </p>
 */
@Service
public class UserService implements UserDetailsService, IUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs a UserService with the specified UserRepository, PasswordEncoder, and UserMapper.
     *
     * @param userRepository   the UserRepository for interacting with the database
     * @param passwordEncoder  the PasswordEncoder for encoding passwords
     */
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        if (userRepository.existsById(user.getUserID())) {
            return userRepository.save(user);
        }
        return null;
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*** Loads user-specific data by username.* @param username the username of the user* @return the UserDetails object containing user data* @throws UsernameNotFoundException if no user is found with the given username*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        // Convert roles to SimpleGrantedAuthority
        List<SimpleGrantedAuthority> authorities = user.getRole().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<User> findByBirthDate(LocalDate birthDate) {
        return userRepository.findByBirthDate(birthDate);
    }

    @Override
    public List<User> findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }
}