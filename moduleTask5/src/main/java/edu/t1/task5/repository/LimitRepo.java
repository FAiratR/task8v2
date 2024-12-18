package edu.t1.task5.repository;

import edu.t1.task5.entity.Limit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface LimitRepo extends CrudRepository<Limit, Integer> {
    public Limit getLimitByUserId(Long id) throws SQLException;
    public List<Limit> getAllBy() throws SQLException;


}
