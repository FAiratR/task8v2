package edu.t1.task5.repository;

import edu.t1.task5.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    public User getUserByUsername(String username) throws SQLException;
    public User getUserById(Long id) throws SQLException;
    public void deleteUserByUsername(String username) throws SQLException;
    public List<User> getAllBy() throws SQLException;
    public void deleteUserById(Long id) throws SQLException;

}
