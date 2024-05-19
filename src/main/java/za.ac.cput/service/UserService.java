package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
//@Configuration
public class UserService implements IUserService {
    private UserRepository userrepository;

    @Autowired
    UserService(UserRepository userrepository) {
        this.userrepository = userrepository;
    }

    @Override
    public User create(User user) {
        return userrepository.save(user);
    }

    @Override
    public User read(String id) {
        return userrepository.findUserbyUserId(id);
    }

    @Override
    public User update(User user) {
        return userrepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userrepository.findAll();
    }
}
