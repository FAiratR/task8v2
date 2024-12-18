package edu.t1.task5.service;

import edu.t1.task5.entity.Limit;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;

public interface LimitService {
    public Limit getLimitByUserId(Long id) throws SQLException;

    public Limit createLimitByUserId(Long userId) throws SQLException;

    public Limit setLimitByUserId(Long id, Long sumLimit) throws SQLException;

    public Limit upLimitByUserId(Long id, Long sumLimit) throws SQLException;

    public Limit downLimitByUserId(Long id, Long sumLimit) throws SQLException;

    public List<Limit> getAllBy() throws SQLException;
}
