package edu.t1.task5.service;

import edu.t1.task5.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public User createUser(Long id, String username) throws SQLException;
    public User getUserByUsername(String username) throws SQLException;
    public User getUserById(Long userId) throws SQLException;
    public List<User> getAllBy() throws SQLException;
}
