package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserService( UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(String userID) {
        return repository.findById(userID).orElse(null);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public List<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
