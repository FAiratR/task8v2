package edu.t1.task5.controller;

import edu.t1.task5.entity.User;
import edu.t1.task5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/readUser/{username}")
    public User getUserByUsername(@PathVariable("username") String username) throws SQLException {
        return userService.getUserByUsername(username);
    }

    @GetMapping(value = "/createUser/{userId}/{username}")
    public User createUser(@PathVariable("userId") Long userId, @PathVariable("username") String username) throws SQLException {
        return userService.createUser(userId, username);
    }

    @GetMapping(value = "/readUserById/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) throws SQLException {
        return userService.getUserById(userId);
    }

    @GetMapping(value = "/readAllUser")
    public List<User> readAllUser() throws SQLException {
        return userService.getAllBy();
    }
}
