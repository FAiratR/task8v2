package edu.t1.task5.repository;

import edu.t1.task5.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    public Product getProductById(Long productId) throws SQLException;
    public List<Product> getAllByUserId(Long userId) throws SQLException;

}
