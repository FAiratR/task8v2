package edu.t1.task5.service;

import edu.t1.task5.entity.User;
import edu.t1.task5.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements edu.t1.task5.service.UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(Long id, String username) throws SQLException {
        User user = new User(id, username);
        userRepo.save(user);
        return user;
    }
    public User getUserByUsername(String username) throws SQLException {
        return userRepo.getUserByUsername(username);
    }

    public User getUserById(Long id) throws SQLException {
        return userRepo.getUserById(id);
    }

    public void updateUser(Long id, String username) throws SQLException {
        User user = userRepo.getUserByUsername(username);
        if (user != null)
            user.setUsername(username);
            userRepo.save(user);
    }
    public void deleteUserByUsername(String username) throws SQLException {
        userRepo.deleteUserByUsername(username);
    }
    public List<User> getAllBy() throws SQLException {
        return userRepo.getAllBy();
    }
}
