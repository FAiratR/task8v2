package edu.t1.task8.repository;

import edu.t1.task8.entity.Pay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface Payable extends CrudRepository<Pay, Integer> {
    //public String payExecute(Long userId, Long productId, Long count) throws SQLException;
    public List<Pay> getAllByUser(Long userId) throws SQLException;
    public List<Pay> getAllByProduct(Long productId) throws SQLException;
}
